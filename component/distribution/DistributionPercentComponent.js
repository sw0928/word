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


class DistributionPercentComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            percentBeans:[],
            integral_percent:"",
            order_percent:"",
            svip_percent:"",
            svip_day_percent:"",
        };
    }
    componentDidMount() {
        this.getPercents();
    }
    getPercents(){
        this.getDataByPost(1,homeurl+"othersController.api?getPercents",{});
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

        this.getDataByPost(2,homeurl+"othersController.api?updatePercents",
            {json:"[{'percent_type':'svip','percent_value':"+this.state.svip_percent+"},{'percent_type':'svip_day','percent_value':"+this.state.svip_day_percent+"}," +
            "{'percent_type':'vip1','percent_value':"+this.state.integral_percent+"},{'percent_type':'vip2','percent_value':"+this.state.order_percent+"}]"});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                var integral_percent="";
                var order_percent="";
                var svip_percent="";
                var svip_day_percent="";
                if(data!=null){
                    for(let i=0;i<data.length;i++){
                        if(data[i].percent_type==='vip1'){
                            integral_percent=data[i].percent_value;
                        }
                        if(data[i].percent_type==='vip2'){
                            order_percent=data[i].percent_value;
                        }
                        if(data[i].percent_type==='svip'){
                            svip_percent=data[i].percent_value;
                        }
                        if(data[i].percent_type==='svip_day'){
                            svip_day_percent=data[i].percent_value;
                        }
                    }
                }
                this.setState({
                    percentBeans:data,
                    integral_percent:integral_percent,
                    order_percent:order_percent,
                    svip_day_percent:svip_day_percent,
                    svip_percent:svip_percent,
                });
                break;
            case 2:
                toast.show("设置成功");
                break;
        }
    }
    render(){
        return(
            <div>
                <Toolbar title="汇率设置" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="1级分销比例(%)"
                    value={this.state.integral_percent}
                    onChange={(value)=>{
                                this.setState({
                                    integral_percent:value
                                })
                            }}/>
                <EditorComponent
                    marginTop={20}
                    title="2级分销比例(%)"
                    value={this.state.order_percent}
                    onChange={(value)=>{
                                this.setState({
                                    order_percent:value
                                })
                             }}/>
                <EditorComponent
                    marginTop={20}
                    title="svip金额(¥)"
                    value={this.state.svip_percent}
                    onChange={(value)=>{
                                this.setState({
                                    svip_percent:value
                                })
                             }}/>
                <EditorComponent
                    marginTop={20}
                    title="svip有效时间(天)"
                    value={this.state.svip_day_percent}
                    onChange={(value)=>{
                                this.setState({
                                    svip_day_percent:value
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

module.exports=DistributionPercentComponent;