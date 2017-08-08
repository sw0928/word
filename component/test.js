/**
 * Created by Administrator on 2017/5/11.
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
var ListViewComponent=require("./../../widget/ListViewComponent");

var Widget=require("./../../widget/WidgetComponent");
class Test extends BaseComponent{
    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'order_id'},
                {name:"订单号",flex:1,key:'order_no'},
                {name:"订单总价",flex:1,key:"order_total_price"},
                {name:"实际支付价",flex:1,key:"order_actual_price"},
                {name:"姓名",flex:1,key:"name"},
                {name:"手机号",flex:1,key:'mobile'},
                {name:"地址",flex:1,key:'detailed_address'},
                {name:"状态",flex:1,key:'order_state_show'},
                {name:"订单类型",flex:1,key:'order_type_show'},
                {name:"备注",flex:1,key:'remark'},
                {name:"下单时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getDataByPost(1,homeurl+"merchantsController.api?getOrderGoodsList",{});
    }


    doSuccess(index,data) {
        switch (index) {
            case 1:
                console.log(data);
                break;
        }
    }
}
module.exports=Test;
