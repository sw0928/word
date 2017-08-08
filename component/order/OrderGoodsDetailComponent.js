/**
 * Created by shenjiabo on 16/10/19.
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

var EditorComponent=require("./../../widget/EditorComponent");
var TextComponent=require("./../../widget/TextComponent");
var CheckComponent=require("./../../widget/CheckComponent");

var ListViewComponent=require("./../../widget/ListViewComponent");

class OrderGoodsDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            order_goods_id:this.props.params.order_goods_id,
            orderGoodsBean:{},
            pBaseData:[],
            sBaseData:[],

            activity_desc:""
        };
    }

    componentDidMount() {
        this.setState({
            pBaseData:[
                {name:"参数id",flex:1,key:'parameter_id'},
                {name:"参数名",flex:1,key:'parameter_name'},
                {name:"参数价格",flex:1,key:"parameter_price"},
                {name:"操作",flex:2,key:"-1"}
            ],
            sBaseData:[
                {name:"服务id",flex:1,key:'service_id'},
                {name:"服务名",flex:1,key:'service_name'},
                {name:"服务价格",flex:1,key:"service_price"},
                {name:"操作",flex:2,key:"-1"}
            ]
        })

        this.getDataByPost(1,homeurl+"orderController.api?getOrderGoodsDetail",{order_goods_id:this.state.order_goods_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                let activity_desc="";
                switch(data.activity_type){
                    case "give":
                        activity_desc="买"+this.state.orderGoodsBean.orderActivityBean.give_need_count
                                    +"送"+this.state.orderGoodsBean.orderActivityBean.give_count;
                        break;
                    case "reduce":
                        activity_desc="满"+this.state.orderGoodsBean.orderActivityBean.reduce_need_price+
                                        "减"+this.state.orderGoodsBean.orderActivityBean.reduce_price;
                        break;
                    case "half":
                        activity_desc="第"+this.state.orderGoodsBean.orderActivityBean.half_count+"半价";
                        break
                    case "exempt":
                        activity_desc="满"+this.state.orderGoodsBean.orderActivityBean.exempt_need_count+
                            "免"+this.state.orderGoodsBean.orderActivityBean.exempt_count;
                        break
                }
                this.setState({
                    orderGoodsBean:data,
                    activity_desc:activity_desc
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="订单商品详情" history={this.props.history}></Toolbar>
                <div style={styles.div}>
                    <TextComponent title="商品id" value={this.state.orderGoodsBean.goods_id}></TextComponent>
                    <TextComponent title="商品名" value={this.state.orderGoodsBean.goods_name}></TextComponent>
                </div>
                <div style={styles.div}>
                    <TextComponent title="购买数量" value={this.state.orderGoodsBean.goods_num}></TextComponent>
                    <TextComponent title="商品价格" value={this.state.orderGoodsBean.goods_price}></TextComponent>
                </div>
                <div style={styles.div}>
                    <TextComponent title="是否包邮" value={this.state.orderGoodsBean.is_express==='1'?"是":"否"}></TextComponent>
                    <TextComponent title="邮费" value={this.state.orderGoodsBean.express_price}></TextComponent>
                </div>
                <div style={styles.div}>
                    <TextComponent title="是否赠送积分" value={this.state.orderGoodsBean.is_give_integral==='1'?"是":"否"}></TextComponent>
                    <TextComponent title="增送积分" value={this.state.orderGoodsBean.give_integral_value}></TextComponent>
                </div>
                <div style={styles.div}>
                    <TextComponent title="是否预售" value={this.state.orderGoodsBean.is_pre_sale==='1'?"是":"否"}></TextComponent>
                    <TextComponent title="发货时间" value={this.state.orderGoodsBean.send_goods_time}></TextComponent>
                </div>
                <div style={styles.div}>
                    <TextComponent title="所属地" value={this.state.orderGoodsBean.goods_address}></TextComponent>
                    <TextComponent title="团购价" value={this.state.orderGoodsBean.group_buy_price}></TextComponent>
                    <TextComponent title="促销价" value={this.state.orderGoodsBean.promotion_price}></TextComponent>
                </div>

                <div style={styles.div}>
                    <TextComponent title="活动类型"
                                   value={this.state.activity_desc}>

                    </TextComponent>
                </div>

                <div style={{marginLeft:10,marginTop:20,}}>
                    <p1 style={{fontSize:13}}>商品参数</p1>
                </div>
                <ListViewComponent
                    data={this.state.pBaseData}
                    dataSource={this.state.orderGoodsBean.orderParameterBeans}
                    renderOperation={(rowID)=>{

                    }}>
                </ListViewComponent>
                <div style={{marginLeft:10,marginTop:20,}}>
                    <p1 style={{fontSize:13}}>商品服务</p1>
                </div>
                <ListViewComponent
                    data={this.state.sBaseData}
                    dataSource={this.state.orderGoodsBean.orderServiceBeans}
                    renderOperation={(rowID)=>{

                    }}>
                </ListViewComponent>
            </div>
        )
    }
}
const styles = {
    div:{
        display:'flex',
        marginTop:20,
        alignItems:'center'
    },
    item:{
        flex:1,
        display:'flex',
        borderLeftWidth:1,
        borderTopWidth:1,
        borderLeftColor:'#efefef',
        borderTopColor:'#efefef',
        borderLeftStyle:'solid',
        borderTopStyle:'solid',
        flexDirection:'column',
        marginLeft:10,
        marginRight:10,
        marginTop:10
    },
    tabColumn: {
        flex: 1,
        display:'flex',
        flexDirection: 'column',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabRow: {
        flex: 1,
        display:'flex',
        flexWrap:'wrap',
        flexDirection: 'row',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabP1:{
        fontSize:15,
        wordBreak:'break-all'
    }
};

module.exports=OrderGoodsDetailComponent;