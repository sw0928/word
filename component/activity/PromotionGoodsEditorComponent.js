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

import { DateField, Calendar } from 'react-date-picker'
var Toolbar=require("./../../widget/Toolbar");
var SearchBar=require("./../../widget/SearchBar");

var Widget=require("./../../widget/WidgetComponent");

class PromotionGoodsEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var promotionGoodsBean=JSON.parse(decodeURIComponent(this.props.params.promotionGoodsBean));
        var myDate = new Date();
        this.state = {
            promotionGoodsBean:promotionGoodsBean,
            allGoodsBeans:[],
            selectBean:{},
            goods_name:promotionGoodsBean.goodsBean?promotionGoodsBean.goodsBean.goods_name:"",
            promotion_price:promotionGoodsBean.promotion_price?promotionGoodsBean.promotion_price:'1',
            sort:promotionGoodsBean.sort,
        };
    }

    componentDidMount() {
        if(!this.state.promotionGoodsBean.goodsBean){
            this.getGoods();
        }
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    allGoodsBeans:data
                })
                break;
            case 2:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 3:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
        }
    }

    getGoods(goods_name){
        this.getDataByPost(1,homeurl+"goodsController2.api?searchGoods",{goods_name:goods_name})
    }


    insertPromotionGoods(){
        if(!this.state.promotionGoodsBean.goodsBean) {
            if (!this.state.selectBean.goods_id) {
                toast.show("请先选择商品");
                return;
            }
            if (isNaN(this.state.promotion_price)) {
                toast.show("促销价含有非法数字");
                return;
            }
            this.getDataByPost(2, homeurl + "activityController.api?insertPromotionGoods",
                {
                    goods_id: this.state.selectBean.goods_id,
                    sort: this.state.sort,
                    promotion_price: this.state.promotion_price,
                    promotion_id:this.state.promotionGoodsBean.promotion_id,
                })
        }else{
            if (isNaN(this.state.promotion_price)) {
                toast.show("促销价含有非法数字");
                return;
            }
            this.getDataByPost(3, homeurl + "activityController.api?updatePromotionGoods",
                {promotion_goods_id:this.state.promotionGoodsBean.promotion_goods_id,
                    sort: this.state.sort,
                    promotion_price: this.state.promotion_price
                })
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="促销商品编辑" history={this.props.history}></Toolbar>
                <div style={{display:(!this.state.promotionGoodsBean.goodsBean?'flex':"none"),alignItems:'center',marginTop:20}}>
                    <div style={{width:this.props.width?this.props.width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商品名</p1>
                    </div>
                    <Widget.SearchBarV2
                        marginLeft={20}
                        item_name="goods_name"
                        dataSource={this.state.allGoodsBeans}
                        name={this.state.goods_name}
                        onPress={(data,value)=>{
                            this.setState({
                                goods_name:value,
                                allGoodsBeans:[],
                                selectBean:data,
                            })
                            if(!this.isNull(value)&&this.isNull(data.goods_name)){
                                this.getGoods(value);
                            }
                        }}/>
                </div>
                <div style={{display:(this.state.promotionGoodsBean.goodsBean?'flex':"none"),flex:1,marginTop:20,alignItems:'center'}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商品名</p1>
                    </div>
                    <p1 style={{fontSize:13,marginLeft:10}}>{this.state.goods_name}</p1>
                    <p1 style={{fontSize:13,color:'red',marginLeft:10}}>*</p1>
                </div>
                <Widget.Editor
                    marginTop={20}
                    title="促销价"
                    value={this.state.promotion_price}
                    onChange={(value)=>{
                        this.setState({
                            promotion_price:value
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    value={this.state.sort}
                    title="权重"
                    onChange={(value)=>{
                        this.setState({
                            sort:value
                        })
                    }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertPromotionGoods();
                    }}/>
            </div>
        )
    }
}


module.exports=PromotionGoodsEditorComponent;
