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
var ListViewComponent=require("./../../widget/ListViewComponent");

var Widget=require("./../../widget/WidgetComponent");

class GoodsSalesListComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            goodsBeans:[],
            total:0,
            baseData:[],
            page:1,
        };
    }

    componentDidMount() {
        this.getGoods(this.state.page)
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    goodsBeans:data.data,
                    total:data.total
                })
                break;
        }
    }

    getGoods(page){
        this.getDataByPost(1,homeurl+'goodsController2.api?getGoodsSales',
            {page:page,},{type:2});
    }


    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="销量排行" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={[{name:"商品名称",flex:3,key:'goods_name'},
                            {name:"SKU",flex:1,key:'goods_sku'},
                            {name:"销量",flex:1,key:'goods_num'},
                            {name:"金额",flex:1,key:'total_price'}]}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getGoods(page)
                    }}/>
            </div>
        )
    }
}

module.exports=GoodsSalesListComponent;
