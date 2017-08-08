/**
 * Created by shenjiabo on 16/10/31.
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
var PageComponent=require("./../../widget/PageComponent");


var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var ImgComponent=require("./../../widget/ImgComponent");

class MerchantsAccoutEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchantsAccoutBean:JSON.parse(decodeURIComponent(this.props.params.merchantsAccoutBean)),
        };
    }

    saveAccount(){
        if(this.state.merchantsAccoutBean.merchants_relation_account_id){
            if(this.props.params.type==='1'){
                this.getDataByPost(3,homeurl+"merchantsController.api?updateMerchantsAccountDetail",
                    {
                        merchants_account_id:this.state.merchantsAccoutBean.merchants_account_id,
                        merchants_name:this.state.merchantsAccoutBean.merchants_name,
                        merchants_img:this.state.merchantsAccoutBean.merchants_img,
                    });
            }else if(this.props.params.type==='2'){
                if(this.state.merchantsAccoutBean.password===''){
                    toast.show("密码不可为空");
                    return;
                }
                this.getDataByPost(2,homeurl+"merchantsController.api?updateMerchantsAccount",
                    {
                        merchants_account_id:this.state.merchantsAccoutBean.merchants_account_id,
                        password:this.state.merchantsAccoutBean.password,
                    });
            }


        }else{
            if(this.state.merchantsAccoutBean.merchants_account===''){
                toast.show("账号不可为空");
                return;
            }
            if(this.state.merchantsAccoutBean.password===''){
                toast.show("密码不可为空");
                return;
            }
            this.getDataByPost(1,homeurl+"merchantsController.api?insertMerchantsAccount",
                { merchants_id:this.state.merchantsAccoutBean.merchants_id,
                    merchants_account:this.state.merchantsAccoutBean.merchants_account,
                    password:this.state.merchantsAccoutBean.password,
                    merchants_type:this.props.params.merchants_type,
                    role_id:this.props.params.merchants_type==='2'?"2":"3",
                    merchants_name:this.state.merchantsAccoutBean.merchants_name,
                    merchants_img:this.state.merchantsAccoutBean.merchants_img,
                    is_extension:this.state.merchantsAccoutBean.is_extension,
                });
        }
    }

    doSuccess(index,data){
       switch(index){
           case 1:
               toast.show("保存成功");
               this.props.history.goBack();
               break;
           case 2:
               toast.show("保存成功");
               this.props.history.goBack();
               break;
           case 3:
               toast.show("修改成功");
               this.props.history.goBack();
               break;
       }
    }

    render(){
        return(
            <div>
                <Toolbar history={this.props.history} title="分配账号"></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        visible={!this.state.merchantsAccoutBean.merchants_relation_account_id?"true":"false"}
                        title="账号"
                        value={this.state.merchantsAccoutBean.merchants_account}
                        onChange={(value)=>{
                        this.state.merchantsAccoutBean.merchants_account=value;
                        this.setState({
                            merchantsAccoutBean:this.state.merchantsAccoutBean
                        })
                    }}/>
                    <CheckComponent
                        visible={!this.state.merchantsAccoutBean.merchants_relation_account_id&&this.props.params.merchants_type==="3"?"true":"false"}
                        title="是否导购"
                        checked={this.state.merchantsAccoutBean.is_extension}
                        onClick={(checked)=>{
                            this.state.merchantsAccoutBean.is_extension=checked;
                            this.setState({
                                merchantsAccoutBean:this.state.merchantsAccoutBean
                            })
                        }}/>
                </div>
                <EditorComponent
                    marginTop={20}
                    visible={this.props.params.type+""==='1'||this.props.params.type+""==='0'?"true":"false"}
                    title="昵称"
                    value={this.state.merchantsAccoutBean.merchants_name}
                    onChange={(value)=>{
                            this.state.merchantsAccoutBean.merchants_name=value;
                            this.setState({
                                merchantsAccoutBean:this.state.merchantsAccoutBean
                            })
                    }}/>
                <ImgComponent
                    visible={this.props.params.type+""==='1'||this.props.params.type+""==='0'?"true":"false"}
                    marginTop={20}
                    title="头像"
                    src={this.isNull(this.state.merchantsAccoutBean.merchants_img)?"./images/add.jpg":imgurl+this.state.merchantsAccoutBean.merchants_img}
                    url={homeurl+'merchantsController.api?uploadMerchantsImg'}
                    onSuccess={(data)=>{
                        this.state.merchantsAccoutBean.merchants_img=data;
                        this.setState({
                            merchantsAccoutBean:this.state.merchantsAccoutBean,
                        })
                    }}
                    />
                <EditorComponent
                    visible={this.props.params.type+""==='2'||this.props.params.type+""==='0'?"true":"false"}
                    type="password"
                    title="密码"
                    marginTop={20}
                    value={this.state.merchantsAccoutBean.password}
                    onChange={(value)=>{
                        this.state.merchantsAccoutBean.password=value;
                        this.setState({
                            merchantsAccoutBean:this.state.merchantsAccoutBean
                        })
                    }}>
                </EditorComponent>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    value="保存"
                    width={100}
                    onClick={()=>{
                        this.saveAccount();
                    }}>
                </ButtonComponent>
            </div>
        )
    }
}

module.exports=MerchantsAccoutEditorComponent;