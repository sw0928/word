/**
 * Created by shenjiabo on 16/9/1.
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
var Toolbar=require("./../../widget/Toolbar");
var ListViewComponent=require("./../../widget/ListViewComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");

class GroupBuyComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            goodsBean:this.props.goodsBean,
            goodsGroupBuyBeans:[],
            group_buy_index:0,
            is_group_buy:this.props.goodsBean.is_group_buy,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'goods_group_buy_id'},
                {name:"团购名称",flex:1,key:'group_buy_name'},
                {name:"团购价格",flex:1,key:"group_buy_price"},
                {name:"团购时间(分钟)",flex:1,key:"group_buy_need_time"},
                {name:"团购人数",flex:1,key:"group_buy_need_people"},
                {name:"操作",flex:2,key:"-1"}
            ]
        });
        this.getData();
    }

    getData(){
        this.getDataByPost(1,homeurl+"goodsController.api?getGoodsGroupBuys",{goods_id:this.state.goodsBean.goods_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    goodsGroupBuyBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getData();
                break;
            case 3:
                toast.show("保存成功");
                this.state.goodsBean.is_group_buy=this.state.is_group_buy;
                this.props.updateMoudle(this.state.goodsBean);
                break;
        }
    }

    deleteGroupBuy(){
        this.setState({
            visible:false
        })
        this.getDataByPost(2,homeurl+"goodsController.api?deleteGoodsGroupBuy",
            {goods_group_buy_id:this.state.goodsGroupBuyBeans[this.state.group_buy_index].goods_group_buy_id});
    }

    updateGoodsDetail(){
        this.getDataByPost(3,homeurl+"goodsController.api?updateGoodsDetail",
            {goods_id:this.state.goodsBean.goods_id,is_group_buy:this.state.is_group_buy});
    }
    render(){
        return(
            <div style={{display:'flex',flexDirection:'column',marginTop:10,marginLeft:20}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteGroupBuy();
                              }}></TipComponent>
                <div style={{display:'flex',alignItems:"center"}}>
                    <CheckComponent
                        title="是否加入团购"
                        checked={this.state.is_group_buy}
                        onClick={(value)=>{
                            this.setState({
                                is_group_buy:value
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="保存"
                        onClick={()=>{
                            this.updateGoodsDetail();
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsGroupBuyBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/group_buy_editor/"+
                                                encodeURIComponent(JSON.stringify({goods_id:this.props.goodsBean.goods_id}))}
                                                style={{textDecoration:'none'}}>
                                <p1>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/group_buy_editor/"+
                                                    encodeURIComponent(JSON.stringify(this.state.goodsGroupBuyBeans[rowID]))}
                                                    style={{textDecoration:'none'}}>
                                        <p1 style={{fontSize:13}}>编辑</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    group_buy_index:rowID
                                                })
                                            }}>
                                    <div>
                                        <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                    </div>
                                </div>
                            </div>
                        )
                    }}>

                </ListViewComponent>
            </div>
        );
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
        fontSize:15,
        wordBreak:'break-all'
    }
};
module.exports=GroupBuyComponent;