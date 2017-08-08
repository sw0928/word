/**
 * Created by shenjiabo on 16/10/30.
 *
 * 个人信息
 */


import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./BaseComponent');
var TipComponent=require('./../widget/TipComponent');

var ButtonComponent=require("./../widget/ButtonComponent");
var EditorComponent=require("./../widget/EditorComponent");
var TextComponent=require("./../widget/TextComponent");
var ImgComponent=require("./../widget/ImgComponent");

class UserDetailComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsAccountBean=JSON.parse(storage.get("merchantsAccountBean"));
        this.state = {
            merchantsAccountBean:merchantsAccountBean
        };
    }

    saveDetail(){
        if(this.state.merchantsAccountBean.merchants_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(this.state.merchantsAccountBean.merchants_img===''){
            toast.show("头像不可为空");
            return;
        }

        this.getDataByPost(1,homeurl+"systemController.api?updateMerchantsAccountDetail",
            {merchants_account_id:this.state.merchantsAccountBean.merchants_account_id,
                merchants_name:this.state.merchantsAccountBean.merchants_name,
                merchants_img:this.state.merchantsAccountBean.merchants_img})
    }

    updatePassword(){
        if(this.state.merchantsAccountBean.password===''){
            toast.show("原密码不可为空");
            return;
        }

        if(this.state.merchantsAccountBean.new_password===''){
            toast.show("新密码不可为空");
            return;
        }

        this.getDataByPost(2,homeurl+"systemController.api?updateMerchantsAccount",
            {merchants_account_id:this.state.merchantsAccountBean.merchants_account_id,
                new_password:this.state.merchantsAccountBean.new_password,
                password:this.state.merchantsAccountBean.password})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("修改成功");
                storage.set("merchantsAccountBean",JSON.stringify(this.state.merchantsAccountBean));
                break;
            case 2:
                toast.show("修改成功");
                storage.set("merchantsAccountBean",JSON.stringify({}));
                window.location.href= htmlurl+"index.html";
                break;
        }
    }
    
    render(){
        return(
            <div style={{display:'flex'}}>
                <div style={{flex:1,display:this.props.params.type==='1'?'flex':"none",
                justifyContent:'center',flexDirection:'column'}}>
                    <TextComponent
                        marginTop={20}
                        title="账号"
                        value={this.state.merchantsAccountBean.merchants_account}>

                    </TextComponent>
                    <EditorComponent
                        marginTop={20}
                        title="名称"
                        value={this.state.merchantsAccountBean.merchants_name}
                        onChange={(value)=>{
                        this.state.merchantsAccountBean.merchants_name=value;
                        this.setState({
                            merchantsAccountBean:this.state.merchantsAccountBean
                        })
                    }}>
                    </EditorComponent>
                    <ImgComponent
                        marginTop={20}
                        title="头像"
                        url={homeurl+"merchantsController.api?uploadMerchantsImg"}
                        src={imgurl+this.state.merchantsAccountBean.merchants_img}
                        onSuccess={(data)=>{
                            this.state.merchantsAccountBean.merchants_img=data;
                            this.setState({
                                merchantsAccountBean:this.state.merchantsAccountBean,
                            })
                        }}>
                    </ImgComponent>
                    <ButtonComponent
                        marginTop={20}
                        marginLeft={100}
                        width={100}
                        value="保存"
                        onClick={()=>{
                            this.saveDetail();
                        }}>
                    </ButtonComponent>
                </div>
                <div style={{flex:1,display:this.props.params.type==='2'?'flex':"none",justifyContent:'center',flexDirection:'column'}}>
                    <EditorComponent
                        marginTop={20}
                        title="原密码"
                        type="password"
                        onChange={(value)=>{
                        this.state.merchantsAccountBean.password=value;
                        this.setState({
                            merchantsAccountBean:this.state.merchantsAccountBean
                        })
                    }}>
                    </EditorComponent>
                    <EditorComponent
                        marginTop={20}
                        title="新密码"
                        type="password"
                        onChange={(value)=>{
                        this.state.merchantsAccountBean.new_password=value;
                        this.setState({
                            merchantsAccountBean:this.state.merchantsAccountBean
                        })
                    }}>
                    </EditorComponent>
                    <ButtonComponent
                        marginTop={20}
                        marginLeft={100}
                        width={100}
                        value="修改密码"
                        onClick={()=>{
                            this.updatePassword();
                        }}>

                    </ButtonComponent>
                </div>
            </div>
        )
    }
}


module.exports=UserDetailComponent;