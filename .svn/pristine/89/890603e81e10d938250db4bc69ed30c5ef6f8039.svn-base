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
var SelectComponent=require('./../../widget/SelectComponent');

var role_index=-1;
class MerchantsEditorPasswrod extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsBean=JSON.parse(decodeURIComponent(this.props.params.merchantsBean));

        this.state = {
            merchantsBean:merchantsBean,
            password:"",
            new_password:"",
        };
    }


    insertMerchants(){
        this.getDataByPost(1,homeurl+"systemController.api?updateMerchantsAccount",
                {merchants_account_id:this.state.merchantsBean.merchants_account_id,
                    password:this.state.password,
                    new_password:this.state.new_password,
                    is_no_origin_password:"1"});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="修改密码" history={this.props.history}></Toolbar>
                <EditorComponent
                    visible="false"
                    marginTop={20}
                    title="原密码"
                    type="password"
                    value={this.state.password}
                    onChange={(value)=>{
                        this.setState({
                            password:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="密码"
                    type="password"
                    value={this.state.new_password}
                    onChange={(value)=>{
                        this.setState({
                            new_password:value
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMerchants();
                    }}/>
            </div>
        )
    }


}

const styles = {
    div:{
        display:'flex',
        flex:1,
        height:50,
        alignItems:'center',
        marginLeft:300
    },
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

module.exports=MerchantsEditorPasswrod;
