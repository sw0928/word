/**
 * Created by Administrator on 2017/5/18.
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
var ListViewComponent=require("./../../widget/ListViewComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
class StorehousePrintList extends BaseComponent{
    constructor(props){
        super(props);
        this.state={
            orderBeans:[],
            baseData:[],
            allMerchantsBeans:[],
            page:1,
            total:"",
        }
    }
    componentDidMount(){
        this.state.baseData=[
            {name:"物流单号",flex:1,key:'logistics_no'},
            {name:"姓名",flex:1,key:"name"},
            {name:"手机号",flex:1,key:'mobile'},
            {name:"地址",flex:1,key:'detailed_address'},
            {name:"备注",flex:1,key:'remark'},
            {name:"下单时间",flex:1,key:'create_time'},
            {name:"订单状态",flex:1,key:'order_state'},
            {name:"操作",flex:2,key:"-1"}
        ];
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchantsNopage",{});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    allMerchantsBeans:data,
                });
                this.getOrderList(this.state.page)
                break;
            case 2:
                this.setState({
                    orderBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                toast.show(data);
                if(data=="删除成功"){
                    this.getOrderList(this.state.page);
                }
                break;
        }
    }
    getOrderList(page){
        var info=storage.get("merchantsAccountBean");
        var merchantsAccountBean=JSON.parse((info===null?"{}":info));
        this.getDataByPost(2,homeurl+'orderController.api?getAllPrintList',
            {  storehouse_id:merchantsAccountBean.storehouse_id,
                page:page},{type:2});
    }
    deletePrintList(logistics_no){
        var info=storage.get("merchantsAccountBean");
        var merchantsAccountBean=JSON.parse((info===null?"{}":info));
        this.getDataByPost(3,homeurl+'orderController.api?deletePrintList',
            {storehouse_id:merchantsAccountBean.storehouse_id,
                logistics_no:logistics_no});
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="打印列表" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.orderBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div>
                                <ButtonComponent
                                    value="从打印列表中移除"
                                    marginLeft={0}
                                    onClick={()=>{
                                        this.deletePrintList(this.state.orderBeans[rowID].logistics_no)
                                    }}></ButtonComponent>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getOrderList(page)
                    }}>

                </ListViewComponent>
                <ButtonComponent
                    value="清空打印列表"
                    marginLeft={400}
                    width={200}
                    onClick={()=>{
                        this.deletePrintList("")
                    }}></ButtonComponent>
            </div>)
    }
}
const styles = {
    tab:{
        display:'flex',
        height:30,
        alignItems:'center',
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    input:{
        width:200,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:13,
    },
}
module.exports=StorehousePrintList;