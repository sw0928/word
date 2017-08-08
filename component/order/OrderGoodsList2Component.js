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
var storage = require('key-storage');
class OrderGoodsList2Component extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            shopSelects:[{id:"0",name:"商品ID"},{id:"0",name:"商品名称"}],
            start_time:"",
            end_time:"",
            orderGoodsBeans:[],
            selectBean:{},
            total:0,
            page:1,
            merchants_name:"",
            merchants_id:"",
            order_goods_state:[],
            order_no:"",
            baseData:[],
            merchants_type:"",
            merchants_info: new Map(),
        };
    }

    componentDidMount() {
        var info=storage.get("merchantsAccountBean");
        var merchantsAccountBean=JSON.parse((info===null?"{}":info));
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'order_goods_id'},
                {name:"订单号",flex:1,key:'order_no'},
                {name:"货号",flex:1,key:'goods_sku'},
                {name:"商品名称",flex:1,key:'goods_name'},
                {name:"商品数量",flex:1,key:'goods_num'},
                {name:"商品总价",flex:1,key:'total_price'},
                {name:"状态",flex:1,key:'order_gooods_state_show'},
                {name:"网点名称",flex:1,key:'storehouse_name'},
                {name:"姓名",flex:1,key:"name"},
                {name:"手机号",flex:1,key:'mobile'},
                {name:"地址",flex:1,key:'detailed_address'},
                {name:"供货方名称",flex:1,key:'merchants_name'},
                {name:"供货方类型",flex:1,key:'merchants_type'},
                {name:"下单时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
    })
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchantsNopage",{});


    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    allMerchantsBeans:data,
                });
                for(let merchant of data){
                    this.state.merchants_info.set(merchant.merchants_id,merchant.merchants_type)
                }
                this.getGoodsOrderList("",this.state.page);
                break;
            case 2:
               this.state.orderGoodsBeans=data.data.orderGoodsBeans;
               this.state.total=data.total;
               this.forceUpdate();
               break;
        }
    }

    exportOrderExcel(merchants_id){
        this.getDataByPost(4,homeurl+'orderController.api?exportOrderExcel',
            {merchants_id:merchants_id?merchants_id:"",
                start_time:this.state.start_time,
                end_time:this.state.end_time,
                order_goods_states:this.state.order_goods_states.toString(),
                order_no:this.state.order_no})
    }
    getGoodsOrderList(merchants_id,page){
        this.getDataByPost(2,homeurl+"orderController.api?getOrderGoodsList2",{merchants_id:merchants_id?merchants_id:"",page:page,start_time:this.state.start_time,
            end_time:this.state.end_time,order_state:this.state.order_goods_state.toString(),merchants_type:this.state.merchants_info.get(merchants_id)
            },{type:2});
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="订单商品列表" history={this.props.history}></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>商家</p1>
                    </div>
                    <SearchBar
                        marginLeft={10}
                        item_name="merchants_name"
                        dataSource={this.state.allMerchantsBeans}
                        name={this.state.merchants_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectBean:data,
                                merchants_name:value,
                            });
                        }}>
                    </SearchBar>
                    <p1 style={{fontSize:15,marginLeft:10}}>下单时间</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD"
                        defaultValue={this.state.start_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                            this.setState({
                                start_time:dateString,
                            })
                        }}
                    />
                    <p1 style={{fontSize:15,marginLeft:10}}>~</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD"
                        defaultValue={this.state.end_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                            this.setState({
                                end_time:dateString,
                            })
                        }}
                    />
                    <ButtonComponent
                        value="搜索"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                page:1
                            });
                            this.getGoodsOrderList(this.state.selectBean.merchants_id,1)
                        }}></ButtonComponent>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="订单号"
                        value={this.state.order_no}
                        onChange={(value)=>{
                            this.setState({
                                order_no:value,
                            })
                        }}>

                    </EditorComponent>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>订单状态</p1>
                    </div>
                    <CheckComponent title="取消" checked={this.state.order1}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("cancel");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("cancel");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order1:checked,
                                        })
                                    }}/>
                    <CheckComponent title="待付款" checked={this.state.order2}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("wait_pay");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("wait_pay");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order2:checked,
                                        })
                                    }}/>
                    <CheckComponent title="待发货" checked={this.state.order3}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("wait_send");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("wait_send");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order3:checked,
                                        })
                                    }}/>
                    <CheckComponent title="待确认收货" checked={this.state.order4}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("wait_receive");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("wait_receive");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order4:checked,
                                        })
                                    }}/>
                    <CheckComponent title="待评价" checked={this.state.order5}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("wait_assessment");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("wait_assessment");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order5:checked,
                                        })
                                    }}/>
                    <CheckComponent title="已完成" checked={this.state.order6}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_goods_state.push("end");
                                        }else{
                                            var index=this.state.order_goods_state.indexOf("end");
                                            this.state.order_goods_state.splice(index,1);
                                        }

                                        this.setState({
                                            order_goods_state:this.state.order_goods_state,
                                            order6:checked,
                                        })
                                    }}/>
                </div>
                <div style={{marginTop:20,display:'flex',justifyContent:'flex-end',flex:1,alignItems:'center'}}>
                    <Widget.Button
                        marginRight={20}
                        value="导出"
                        onClick={()=>{
                            this.exportOrderExcel(this.state.selectBean.merchants_id,1);
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.orderGoodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                <Link to={"/order_goods_detail/"}
                                      style={{textDecoration:'none'}}>
                                    <p1 style={{fontSize:13,wordBreak:'break-all'}}>[详情]</p1>
                                </Link>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getGoodsOrderList(page);
                    }}>

                </ListViewComponent>

            </div>
        )
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
module.exports=OrderGoodsList2Component;
