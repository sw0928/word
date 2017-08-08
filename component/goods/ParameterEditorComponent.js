/**
 * Created by shenjiabo on 16/8/22.
 */
/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var Toolbar=require("./../../widget/Toolbar");
var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
class ParameterEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var parameterBean=JSON.parse(decodeURIComponent(this.props.params.parameterBean));
        this.state = {
            parameterBean:parameterBean,
            parameter_name:parameterBean.parameter_name?parameterBean.parameter_name:"",
            parameter_price:parameterBean.parameter_price?parameterBean.parameter_price:"",
            sort:parameterBean.sort?parameterBean.sort:"1",
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="编辑参数" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="参数名"
                    value={this.state.parameter_name}
                    onChange={(value)=>{
                        this.setState({
                            parameter_name:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="价格"
                    value={this.state.parameter_price}
                    onChange={(value)=>{
                        this.setState({
                            parameter_price:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.sort}
                    onChange={(value)=>{
                        this.setState({
                            sort:value
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMoudle();
                    }}/>
            </div>
        )
    }

    insertMoudle(){
        if(this.state.parameter_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(isNaN(this.state.parameter_price)){
            toast.show("价格不合法");
            return;
        }

        if(!this.state.parameterBean.parameter_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertParameter",
                {parameter_name:this.state.parameter_name,parameter_price:this.state.parameter_price,
                    parent_id:this.state.parameterBean.parent_id,goods_id:this.state.parameterBean.goods_id,
                    parameter_type:this.state.parameterBean.parameter_type,
                    sort:this.state.sort,});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateParameter",
                {parameter_id:this.state.parameterBean.parameter_id,parameter_name:this.state.parameter_name,parameter_price:this.state.parameter_price,
                    parent_id:this.state.parameterBean.parent_id,goods_id:this.state.parameterBean.goods_id,
                    parameter_type:this.state.parameterBean.parameter_type,
                    sort:this.state.sort});
        }
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
        }
    }
}

const styles = {
    input:{
        width:300,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
        width:100
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    }
}

module.exports=ParameterEditorComponent;
