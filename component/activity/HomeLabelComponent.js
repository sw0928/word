/**
 * Created by shenjiabo on 16/11/29.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListViewComponent=require('./../../widget/ListViewComponent');
var BaseComponent=require('./../BaseComponent');


class HomeLabelComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            labelBeans:[],
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"activityController.api?getHomeLabels",{});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    labelBeans:data
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <ListViewComponent
                    data={[{name:"ID",flex:1,key:'label_id'},
                {name:"名称",flex:1,key:'label_name'},
                {name:"图片",flex:1,key:"label_img",type:'img'},
                {name:"权重",flex:1,key:"sort"},
                {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.labelBeans}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/activity_home_label_editor/"+encodeURIComponent(JSON.stringify(this.state.labelBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                        <p1 style={{fontSize:13}}>[编辑]</p1>
                                    </Link>
                                </div>
                            </div>
                        )
                    }}/>
            </div>
        )
    }
}

module.exports=HomeLabelComponent;