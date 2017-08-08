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
            integral_percent:"",
            order_percent:"",
            merchants1:"",
            merchants2:"",
            extand:"",
            profit:"",
            sign:"",
            max_integral:"",
            register:"",
            detailBean:{},
            member:"",
            distribution1:"",
            distribution2:"",
        };
    }
    componentDidMount() {
        this.getPercents();
    }

    getPercents(){
        this.getDataByPost(1,homeurl+"othersController.api?getPercents",{});
        this.getDataByPost(3,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'percent_detail'});
    }

    updatePercents(){
        if(isNaN(this.state.integral_percent)){
            toast.show("抵扣积分比例非法");
            return;
        }

        if(isNaN(this.state.order_percent)){
            toast.show("订单结算比例非法");
            return;
        }

        if(isNaN(this.state.merchants1)){
            toast.show("一级比例非法");
            return;
        }

        if(isNaN(this.state.merchants2)){
            toast.show("二级结算比例非法");
            return;
        }

        if(isNaN(this.state.extand)){
            toast.show("推广员比例非法");
            return;
        }

        if(isNaN(this.state.profit)){
            toast.show("收益天数非法");
            return;
        }

        if(isNaN(this.state.max_integral)){
            toast.show("最大积分非法");
            return;
        }

        if(isNaN(this.state.register)){
            toast.show("注册积分非法");
            return;
        }

        if(isNaN(this.state.sign)){
            toast.show("签到积分非法");
            return;
        }

        this.getDataByPost(2,homeurl+"othersController.api?updatePercents",
            {json:"[{'percent_type':'integral','percent_value':"+this.state.integral_percent+"}," +
            "{'percent_type':'order','percent_value':"+this.state.order_percent+"}," +
            "{'percent_type':'merchants1','percent_value':"+this.state.merchants1+"}," +
            "{'percent_type':'merchants2','percent_value':"+this.state.merchants2+"}," +
            "{'percent_type':'profit','percent_value':"+this.state.profit+"}," +
            "{'percent_type':'max_integral','percent_value':"+this.state.max_integral+"}," +
            "{'percent_type':'register','percent_value':"+this.state.register+"}," +
            "{'percent_type':'sign','percent_value':"+this.state.sign+"}," +
            "{'percent_type':'member','percent_value':"+this.state.member+"}," +
            "{'percent_type':'distribution1','percent_value':"+this.state.distribution1+"}," +
            "{'percent_type':'distribution2','percent_value':"+this.state.distribution2+"}," +
            "{'percent_type':'extand','percent_value':"+this.state.extand+"}" +
            "]"});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                var integral_percent="";
                var order_percent="";
                var merchants1="";
                var merchants2="";
                var extand="";
                var profit="";
                var sign="";
                var max_integral="";
                var register="";
                var member="";
                var distribution1="";
                var distribution2="";

                if(data!=null){
                    for(let i=0;i<data.length;i++){
                        if(data[i].percent_type==='integral'){
                            integral_percent=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='order'){
                            order_percent=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='merchants1'){
                            merchants1=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='merchants2'){
                            merchants2=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='extand'){
                            extand=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='profit'){
                            profit=data[i].percent_value?data[i].percent_value:"0";
                        }

                        if(data[i].percent_type==='sign'){
                            sign=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='max_integral'){
                            max_integral=data[i].percent_value?data[i].percent_value:"0";
                        }
                        if(data[i].percent_type==='register'){
                            register=data[i].percent_value?data[i].percent_value:"0";
                        }

                        if(data[i].percent_type==='member'){
                            member=data[i].percent_value?data[i].percent_value:"0";
                        }

                        if(data[i].percent_type==='distribution1'){
                            distribution1=data[i].percent_value?data[i].percent_value:"0";
                        }

                        if(data[i].percent_type==='distribution2'){
                            distribution2=data[i].percent_value?data[i].percent_value:"0";
                        }
                    }
                }
                this.setState({
                    percentBeans:data,
                    integral_percent:integral_percent,
                    order_percent:order_percent,
                    merchants1:merchants1,
                    merchants2:merchants2,
                    extand:extand,
                    profit:profit,
                    register:register,
                    max_integral:max_integral,
                    sign:sign,
                    member:member,
                    distribution1:distribution1,
                    distribution2:distribution2,
                });
                break;
            case 2:
                toast.show("设置成功");
                break;
            case 3:
                this.setState({
                    detailBean:JSON.parse(data)
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <Toolbar title="汇率设置" history={this.props.history}></Toolbar>
                <EditorComponent
                    visible={this.state.detailBean.integral_percent}
                    marginTop={20}
                    title="积分抵扣比例(%)"
                    value={this.state.integral_percent}
                    onChange={(value)=>{
                                this.setState({
                                    integral_percent:value
                                })
                            }}/>
                <EditorComponent
                    visible={this.state.detailBean.order_percent}
                    marginTop={20}
                    title="订单结算比例(%)"
                    value={this.state.order_percent}
                    onChange={(value)=>{
                                this.setState({
                                    order_percent:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.merchants1}
                    marginTop={20}
                    title="一级比例(%)"
                    value={this.state.merchants1}
                    onChange={(value)=>{
                                this.setState({
                                    merchants1:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.merchants2}
                    marginTop={20}
                    title="二级比例(%)"
                    value={this.state.merchants2}
                    onChange={(value)=>{
                                this.setState({
                                    merchants2:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.distribution1}
                    marginTop={20}
                    title="分销一级比例(%)"
                    value={this.state.distribution1}
                    onChange={(value)=>{
                                this.setState({
                                    distribution1:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.distribution2}
                    marginTop={20}
                    title="分销二级比例(%)"
                    value={this.state.distribution2}
                    onChange={(value)=>{
                                this.setState({
                                    distribution2:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.member}
                    marginTop={20}
                    title="会员折扣"
                    value={this.state.member}
                    onChange={(value)=>{
                                this.setState({
                                    member:value
                                })
                             }}/>
                <EditorComponent
                    visible={this.state.detailBean.extand}
                    marginTop={20}
                    title="推广员比例(%)"
                    value={this.state.extand}
                    onChange={(value)=>{
                                this.setState({
                                    extand:value
                                })
                             }}/>
                <EditorComponent
                visible={this.state.detailBean.profit}
                marginTop={20}
                title="收益结账天数"
                value={this.state.profit}
                onChange={(value)=>{
                                this.setState({
                                    profit:value
                                })
                             }}/>

                <EditorComponent
                    visible={this.state.detailBean.sign}
                    marginTop={20}
                    title="签到基础分"
                    value={this.state.sign}
                    onChange={(value)=>{
                                this.setState({
                                    sign:value
                                })
                             }}/>

                <EditorComponent
                    visible={this.state.detailBean.register}
                    marginTop={20}
                    title="注册积分"
                    value={this.state.register}
                    onChange={(value)=>{
                                this.setState({
                                    register:value
                                })
                             }}/>

                <EditorComponent
                    visible={this.state.detailBean.max_integral}
                    marginTop={20}
                    title="最大积分"
                    value={this.state.max_integral}
                    onChange={(value)=>{
                                this.setState({
                                    max_integral:value
                                })
                             }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.updatePercents();
                    }}/>
            </div>
        )
    }
}

module.exports=PercentComponent;