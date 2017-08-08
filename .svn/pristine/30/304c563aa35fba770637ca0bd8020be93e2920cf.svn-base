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

class MerchantsOrderlistComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var info=storage.get("merchantsAccountBean");
        this.state = {
            shopSelects:[{id:"0",name:"商品ID"},{id:"0",name:"商品名称"}],
            start_time:"",
            end_time:"",
            orderBeans:[],
            total:0,
            page:1,
            merchants_name:"",
            order_states:[],
            order_no:"",
            baseData:[],
            merchants_id:JSON.parse((info===null?"{}":info)).merchants_id,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'order_id'},
                {name:"订单号",flex:1,key:'order_no'},
                {name:"订单总价",flex:1,key:"order_total_price"},
                {name:"姓名",flex:1,key:"name"},
                {name:"手机号",flex:1,key:'mobile'},
                {name:"地址",flex:1,key:'address'},
                {name:"状态",flex:1,key:'order_state_show'},
                {name:"订单类型",flex:1,key:'order_type_show'},
                {name:"备注",flex:1,key:'remark'},
                {name:"下单时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getOrderList(this.state.merchants_id,this.state.page)
    }


    doSuccess(index,data){
        switch (index){
            case 2:
                this.setState({
                    orderBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                toast.show("删除成功");
                this.getGoods(this.state.selectBean.merchants_id,this.state.page);
                break;
        }
    }

    getOrderList(merchants_id,page){
        this.getDataByPost(2,homeurl+'orderController.api?getOrderList',
            {merchants_id:merchants_id,
                start_time:this.state.start_time,
                end_time:this.state.end_time,page:page,
                order_states:this.state.order_states.toString(),
                order_no:this.state.order_no},{type:2})
    }

    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="订单列表" history={this.props.history}></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>下单时间</p1>
                    </div>
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
                    <p1 style={{fontSize:13,marginLeft:10}}>~</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD"
                        defaultValue={this.state.end_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                                   this.setState({
                                       end_time:dateString,
                                   })
                                }}/>
                    <ButtonComponent
                        value="搜索"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                page:1
                            });
                            this.getOrderList(this.state.selectBean.merchants_id,1)
                        }}></ButtonComponent>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="订单号"
                        onChange={(value)=>{
                            this.setState({
                                order_no:value,
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>订单状态</p1>
                    </div>
                    <CheckComponent title="取消" checked={this.state.order1}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("cancel");
                                }else{
                                    var index=this.state.order_states.indexOf("cancel");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order1:checked,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="待付款" checked={this.state.order2}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("wait_pay");
                                }else{
                                    var index=this.state.order_states.indexOf("wait_pay");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order2:checked,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="待发货" checked={this.state.order3}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("wait_send");
                                }else{
                                    var index=this.state.order_states.indexOf("wait_send");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order3:checked,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="待确认收货" checked={this.state.order4}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("wait_receive");
                                }else{
                                    var index=this.state.order_states.indexOf("wait_receive");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order4:checked,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="待评价" checked={this.state.order5}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("wait_assessment");
                                }else{
                                    var index=this.state.order_states.indexOf("wait_assessment");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order5:checked,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="已完成" checked={this.state.order6}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.order_states.push("end");
                                }else{
                                    var index=this.state.order_states.indexOf("end");
                                    this.state.order_states.splice(index,1);
                                }

                                this.setState({
                                    order_states:this.state.order_states,
                                    order6:checked,
                                })
                            }}></CheckComponent>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.orderBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                <Link to={"/order_detail/"+this.state.orderBeans[rowID].order_id}
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
                        this.getOrderList(this.state.merchants_id,page)
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
module.exports=MerchantsOrderlistComponent;
