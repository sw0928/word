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
class RoleEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态

        var roleBean=JSON.parse(decodeURIComponent(this.props.params.roleBean));
        this.state = {
            roleBean:roleBean,
            role_name:roleBean.role_name?roleBean.role_name:"",
        };
    }


    render(){
        return(
            <div>
                <Toolbar title="角色编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="角色名称"
                    value={this.state.role_name}
                    onChange={(value)=>{
                        this.setState({
                            role_name:value
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertRole();
                    }}/>
            </div>
        )
    }

    insertRole(){
        if(this.state.role_name===''){
            toast.show("模块名称不可为空");
            return;
        }

        if(!this.state.roleBean.role_id){
            this.getDataByPost(1,homeurl+"systemController.api?insertRole",
                {role_name:this.state.role_name});
        }else{
            this.getDataByPost(2,homeurl+"systemController.api?updateRole",
                {role_name:this.state.role_name,role_id:this.state.roleBean.role_id});
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

module.exports=RoleEditorComponent;
