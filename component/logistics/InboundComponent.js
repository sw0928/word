/**
 * Created by lenovo on 2017-05-02.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");

var EditorComponent=require('./../../widget/EditorComponent');
var UnEditorComponent=require('./../../widget/UnEditorComponent');
var DoubleButtonComponent=require('./../../widget/DoubleButtonComponent');
var ImgComponent=require('./../../widget/ImgComponent');

var Widget=require('./../../widget/WidgetComponent');

class InboundComponent extends BaseComponent{
    constructor(props) {
        super(props);

        // 初始状态
        this.state={
            logistics_no:"",name:"",mobile:"",province:"",city:"",country:"",detailed_address:"",
            province:"",city:"",country:"",detailed_address:""
        }

    }
    render(){
        return(
            <div>
                <Toolbar title="入库登记" ></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="物流单号"
                    value={this.state.logistics_no}
                    onChange={(value)=>{
                        this.state.logistics_no=value;
                        this.forceUpdate();
                        this.getOrderDetail();
                    }}/>
                <UnEditorComponent
                    marginTop={20}
                    title="产品名"
                />
                <UnEditorComponent
                    marginTop={20}
                    title="收货人"
                    value={this.state.name}
                />
                <UnEditorComponent
                    marginTop={20}
                    title="手机号"
                    value={this.state.mobile}
                />
                <UnEditorComponent
                    marginTop={20}
                    title="收货地址"
                    value={this.state.province+this.state.city+this.state.country+this.state.detailed_address}
                    disabled
                />
                <DoubleButtonComponent
                    marginTop={20}
                    marginLeft={50}
                    width={100}
                    leftValue="确认入库"
                    rightValue="取消"
                    onLeftClick={()=>{
                        this.addLogistics();
                    }}
                    onRightClick={()=>{
                        this.setState({
                            name:"",mobile:"",province:"",city:"",country:"",detailed_address:"",
                            province:"",city:"",country:"",detailed_address:"",logistics_no:""
                        });
                    }}/>
    </div>

    )
    }
    getOrderDetail(){
        if(this.state.logistics_no==""){
            return;
        }
        this.getDataByPost(1,homeurl+"orderController.api?getOneBusinessOrderDetail",
            {logistics_no:this.state.logistics_no});
    }
    addLogistics(){
        var info=storage.get("merchantsAccountBean");
        var merchantsAccountBean=JSON.parse((info===null?"{}":info));
console.log(merchantsAccountBean);
        if(this.state.logistics_no==""||this.state.logistics_no==""){
            toast.show("请先扫描物流单号");
            return;
        }
        this.getDataByPost(2,homeurl+"orderController.api?insertLogisticsInfo",
            {logistics_no:this.state.logistics_no,city:merchantsAccountBean.city,storehouse_name:merchantsAccountBean.storehouse_name,storehouse_id:merchantsAccountBean.storehouse_id,type:'inbound'});
    }
    doSuccess(index,data) {
        switch (index) {
            case 1:
                if(JSON.stringify(data)=='{}'){
                    return;
                }
console.log(data);
                this.setState({
                    name:data.name,mobile:data.mobile,province:data.province,
                    city:data.city,country:data.country,detailed_address:data.detailed_address,
                    logistics_no:data.logistics_no
                });
                break;
            case 2:
                toast.show(data);
                this.setState({
                    name:"",mobile:"",province:"",city:"",country:"",detailed_address:"",
                    province:"",city:"",country:"",detailed_address:"",logistics_no:""
                });
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
module.exports=InboundComponent;