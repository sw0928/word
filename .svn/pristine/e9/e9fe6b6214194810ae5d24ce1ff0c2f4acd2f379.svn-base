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

var TipComponent=require('./../../widget/TipComponent');
import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'
var PageComponent=require("./../../widget/PageComponent");
var Toolbar=require("./../../widget/Toolbar");
var SearchBar=require("./../../widget/SearchBar");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");


class MerchantsProfitComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        var info=storage.get("merchantsAccountBean");
        // 初始状态
        this.state = {
            percentBean:{},
            allMerchantsBeans:[],
            selectBean:{},
            merchants_name:"",
            profitBean:{},
            merchants_id:JSON.parse((info===null?"{}":info)).merchants_id,
        };
    }

    componentDidMount() {
        this.getOrderProfits(this.state.merchants_id)
    }

    getOrderProfits(merchants_id){
        console.log(merchants_id);
        this.getDataByPost(1,homeurl+"orderController.api?getOrderProfits",
            {merchants_id:merchants_id});
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    profitBean:data
                })
                break;
        }
    }


    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="收益预览" history={this.props.history}></Toolbar>
                <div style={{borderWidth:1,borderColor:'#c8c8c8',display:'flex',
                        borderStyle:'solid',marginLeft:20,marginRight:20,marginTop:20,display:'flex',alignItems:'center',}}>
                    <div style={{display:'flex',alignItems:'center',justifyContent:'center',
                                borderRightStyle:'solid',borderRightWidth:1,borderRightColor:"#c8c8c8",height:50,
                                width:200}}>
                        <p1 style={{fontSize:15}}>总收益</p1>
                    </div>
                    <p1 style={{marginLeft:10,fontSize:15}}>¥{this.isNull(this.state.profitBean.merchants_total_profit)?"0":this.state.profitBean.merchants_total_profit.toFixed(2)}</p1>
                    <p1 style={{marginLeft:10,fontSize:15,color:'red'}}>(商家历史总收益)</p1>
                </div>

                <div style={{borderWidth:1,borderColor:'#c8c8c8',display:'flex',alignItems:'center',
                        borderStyle:'solid',marginLeft:20,marginRight:20,marginTop:20}}>
                    <div style={{display:'flex',alignItems:'center',justifyContent:'center',
                                borderRightStyle:'solid',borderRightWidth:1,borderRightColor:"#c8c8c8",height:50,
                                width:200}}>
                        <p1 style={{fontSize:15}}>账户余额</p1>
                    </div>
                    <p1 style={{marginLeft:10,fontSize:15}}>¥{this.isNull(this.state.profitBean.merchants_balance)?"0":this.state.profitBean.merchants_balance.toFixed(2)}</p1>
                    <p1 style={{marginLeft:10,fontSize:15,color:'red'}}>(总收益 - 历史总提现金额)</p1>
                </div>
                <div style={{borderWidth:1,borderColor:'#c8c8c8',display:'flex',alignItems:'center',
                        borderStyle:'solid',marginLeft:20,marginRight:20,marginTop:20}}>
                    <div style={{display:'flex',alignItems:'center',justifyContent:'center',
                                borderRightStyle:'solid',borderRightWidth:1,borderRightColor:"#c8c8c8",height:50,
                                width:200}}>
                        <p1 style={{fontSize:15}}>期款</p1>
                    </div>
                    <p1 style={{marginLeft:10,fontSize:15}}>¥{this.isNull(this.state.profitBean.merchants_no_can_balance)?"0":this.state.profitBean.merchants_no_can_balance.toFixed(2)}</p1>
                    <p1 style={{marginLeft:10,fontSize:15,color:'red'}}>(未完成订单的钱)</p1>
                </div>
                <div style={{borderWidth:1,borderColor:'#c8c8c8',
                        borderStyle:'solid',marginLeft:20,marginRight:20,display:'flex',alignItems:'center',}}>
                    <div style={{display:'flex',alignItems:'center',justifyContent:'center',
                                borderRightStyle:'solid',borderRightWidth:1,borderRightColor:"#c8c8c8",height:50,
                                width:200}}>
                        <p1 style={{fontSize:15}}>已提现金额</p1>
                    </div>
                    <p1 style={{marginLeft:10,fontSize:15}}>¥{this.isNull(this.state.profitBean.merchants_used_balance)?"0":this.state.profitBean.merchants_used_balance.toFixed(2)}</p1>
                    <p1 style={{marginLeft:10,fontSize:15,color:'red'}}>(已提现的金额)</p1>
                </div>
                <div style={{borderWidth:1,borderColor:'#c8c8c8',
                        borderStyle:'solid',marginLeft:20,marginRight:20,display:'flex',alignItems:'center',}}>
                    <div style={{display:'flex',alignItems:'center',justifyContent:'center',
                                borderRightStyle:'solid',borderRightWidth:1,borderRightColor:"#c8c8c8",height:50,
                                width:200}}>
                        <p1 style={{fontSize:15}}>可提现余额</p1>
                    </div>
                    <p1 style={{marginLeft:10,fontSize:15}}>¥{this.isNull(this.state.profitBean.merchants_can_balance)?"0":this.state.profitBean.merchants_can_balance.toFixed(2)}</p1>
                    <p1 style={{marginLeft:10,fontSize:15,color:'red'}}>(所有完成订单(7天之后)的金额总和 * 平台汇率-已提现金额)</p1>
                </div>
            </div>
        )
    }
}

const styles={
    div:{
        display:"flex",
        flex:1,
        alignItems:'center',
        marginTop:20
    },
}
module.exports=MerchantsProfitComponent;
