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
class StandardEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var standardBean=JSON.parse(this.props.params.standardBean);
        this.state = {
            standardBean:standardBean,
            standard_name:standardBean.standard_name?standardBean.standard_name:"",
            standard_desc:standardBean.standard_desc?standardBean.standard_desc:"",
            sort:standardBean.sort?standardBean.sort:"1",
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="编辑规格" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="规格名称"
                    value={this.state.standard_name}
                    onChange={(value)=>{
                        this.setState({
                            standard_name:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="内容描述"
                    value={this.state.standard_desc}
                    onChange={(value)=>{
                        this.setState({
                            standard_desc:value
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
                        this.insertStandard();
                    }}/>
            </div>
        )
    }

    insertStandard(){
        
        if(this.state.standard_name===''){
            toast.show("名称不可为空");
            return;
        }
        if(this.state.standard_desc===''){
            toast.show("内容不可为空");
            return;
        }

        if(!this.state.standardBean.standard_id||!this.isNull(this.state.standardBean.standard_type)){
            this.getDataByPost(1,homeurl+"goodsController.api?insertStandard",
                {standard_name:this.state.standard_name,
                    standard_desc:this.state.standard_desc,
                    goods_id:this.state.standardBean.goods_id,
                    sort:this.state.sort,
                    parent_id:this.state.standardBean.standard_id});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateStandard",
                {standard_id:this.state.standardBean.standard_id,
                    standard_name:this.state.standard_name,
                    standard_desc:this.state.standard_desc,
                    goods_id:this.state.standardBean.goods_id,
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

module.exports=StandardEditorComponent;
