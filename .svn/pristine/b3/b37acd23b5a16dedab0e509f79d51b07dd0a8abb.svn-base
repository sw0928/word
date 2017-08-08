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
var ListViewComponent=require("./../../widget/ListViewComponent");

class OrderGoodsListComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            orderGoodsBeans:[],
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"商品ID",flex:1,key:'goods_id'},
                {name:"商品名",flex:1,key:'goods_name'},
                {name:"商品价格",flex:1,key:"goods_price"},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getDataByPost(1,homeurl+"orderController.api?getOrderGoodss",{order_id:this.props.order_id});
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    orderGoodsBeans:data,
                })
                break;
        }
    }


    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.orderGoodsBeans}
                    renderOperation={(rowID)=>{
                        let view=[];
                        if(this.state.orderGoodsBeans[rowID].is_refund==='1'){
                            view.push(<Link to={"/order_refund_detail/"+this.state.orderGoodsBeans[rowID].refund_id}
                                                style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[退款详情]</p1>
                                      </Link>
                                    );
                        }
                        return(
                            <div>
                                <Link to={"/order_goods_detail/"+this.state.orderGoodsBeans[rowID].order_goods_id}
                                                style={{textDecoration:'none'}}>
                                    <p1 style={styles.tabP1}>[详情]</p1>
                                </Link>
                                {view}
                            </div>
                        )
                    }}>
                </ListViewComponent>
            </div>
        )
    }
}
const styles = {
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
        fontSize:13,
        wordBreak:'break-all'
    }
};
module.exports=OrderGoodsListComponent;
