/**
 * Created by shenjiabo on 16/11/7.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");
import Upload from 'rc-upload';

var EditorComponent=require("./../../widget/EditorComponent");
var ImgComponent=require("./../../widget/ImgComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");


class PercentComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            percentBeans:[],
        };
    }
    componentDidMount() {
        this.getPercents();
    }

    getPercents(){
        this.getDataByPost(1,homeurl+"othersController.api?getPercents",{});
    }

    updatePercents(){

    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    percentBeans:data
                })
                break;
            case 2:
                toast.show("设置成功");
                break;
        }
    }

    updatePercents(){
        this.getDataByPost(2,homeurl+"othersController.api?updatePercents",
            {json:JSON.stringify(this.state.percentBeans)});
    }
    render(){
        return(
            <div>
                <Toolbar title="汇率设置" history={this.props.history}></Toolbar>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.updatePercents();
                    }}/>
                <ListView
                    style={{flex:1,display:'flex',flexDirection:'row',flexWrap:'wrap'}}
                    dataSource={this.state.percentBeans}
                    renderRow={(rowID)=>{
                        return(
                            <EditorComponent
                                marginTop={20}
                                title={this.state.percentBeans[rowID].percent_name}
                                value={this.state.percentBeans[rowID].percent_value}
                                onChange={(value)=>{
                                    this.state.percentBeans[rowID].percent_value=value;
                                    this.setState({
                                        percentBeans:this.state.percentBeans
                                    })
                                }}/>
                         )
                    }}>
                </ListView>
            </div>
        )
    }
}

module.exports=PercentComponent;