/**
 * Created by Administrator on 2017/5/25.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');
var Widget = require("./../../widget/WidgetComponent");
var TipComponent=require('./../../widget/TipComponent');
import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'
var PageComponent=require("./../../widget/PageComponent");
var Toolbar=require("./../../widget/Toolbar");
var ListViewComponent=require("./../../widget/ListViewComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
class OrderDivideComponnet extends  BaseComponent{
    constructor(props){
        super(props);
        this.state={
            orderGoodsBeans:[],
            total:"",
            page:1,
            dividedOrder_goods_ids:"",
            orderBean:{},
        }
    }
    componentDidMount(){
        this.getOrderDetail();
        this.getOrderGoodss();
    }
    getOrderDetail(){
        this.getDataByPost(1,homeurl+"orderController.api?getOrderDetail",{order_id:this.props.order_id});
    }
    getOrderGoodss(){
        this.getDataByPost(2,homeurl+"orderController.api?getOrderGoodssByPage",{order_id:this.props.order_id,page:this.state.page},{type:2});
    }
    divideOrder() {
        if(this.state.orderBean=={}||this.state.orderBean.order_no==null||this.state.orderBean.order_no==""){
            return;
        }
        if(this.state.dividedOrder_goods_ids==""){
            toast.show("请选择第一个订单的商品");
            return;
        }
        if(this.state.total==1||this.state.total==0){
            toast.show("订单已无法再拆分");
            return;
        }
        this.getDataByPost(3,homeurl+"orderController.api?divideOrder",{order_no:this.state.orderBean.order_no,dividedOrder_goods_ids:this.state.dividedOrder_goods_ids},{type:2});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    orderBean:data
                })
                break;
            case 2:
                this.setState({
                    orderGoodsBeans:data.data,
                    total:data.total,
                })
                break;
            case 3:
                toast.show("拆分成功");
                this.props.history.goBack();
                break;
        }
    }
    render(){
        return(
            <div>
                <TipComponent visible={this.state.allVisible} msg="确定拆分订单吗?"
                              onClose={()=>{
                                  this.setState({
                                      allVisible:false
                                  })
                              }}
                              onPress={()=>{
                                  this.setState({
                                      allVisible:false
                                  })
                                  this.divideOrder();
                              }}/>
            <Widget.CheckList
                checklist_id = 'lista1'
                marginLeft="40"
                title="订单一分为二"
                sectitle="第一条订单的商品："
                flex="2"
                dataSource={this.state.orderGoodsBeans}
                dataSourceHad={""}
                save_value="order_goods_id"
                show_value="goods_name"
                total={this.state.total}
                page={this.state.page}
                onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                }}
                onSelectChange={(value)=>{
                    this.state.dividedOrder_goods_ids=value;
                }}/>
                <ButtonComponent
                    value="一键拆单"
                    marginLeft={150}
                    marginTop={40}
                    width={200}
                    onClick={()=>{
                        this.setState({
                            allVisible:true
                        })
                    }}></ButtonComponent>
            </div>
        );
    }

}
module.exports=OrderDivideComponnet;