/**
 * Created by shenjiabo on 16/9/6.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");
import Upload from 'rc-upload';
var PageComponent=require("./../../widget/PageComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
var SearchBar=require("./../../widget/SearchBar");
var ListViewComponent=require("./../../widget/ListViewComponent");

class BusinessGoodsComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchants_id:this.props.params.merchants_id,
            allGoodsBeans:[],
            businessGoodsBeans:[],
            selectBean:{},
            total:0,
            selectVisible:false,
            goods_name:'',
            page:1,
            business_index:0,
        };
    }

    componentDidMount() {
        this.getGoods();
        this.getBusinessGoods(this.state.page);
    }
    
    getGoods(){
        this.getDataByPost(1,homeurl+"goodsController.api?getAllGoodsDetailNoPage",{})
    }

    getBusinessGoods(page){
        this.getDataByPost(2,homeurl+"goodsController.api?getBusinessGoods",
            {merchants_id:this.state.merchants_id,page:page},{type:2})
    }
    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    allGoodsBeans:data
                })
                if(data.length>0) {
                    this.setState({
                        selectBean: data[0],
                        goods_name:data[0].goods_name
                    })
                }
                break;
            case 2:
                this.setState({
                    businessGoodsBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                toast.show("添加成功");
                this.getBusinessGoods(this.state.page)
                break;
            case 4:
                toast.show("删除成功");
                this.getBusinessGoods(this.state.page)
                break;
            case 5:
                toast.show("导出已准备好");
                window.location.href=imgurl+data;
                break;
        }
    }
    insertBusinessGoods(){
        if(!this.state.selectBean.goods_id){
            toast.show("请先选择商品");
            return;
        }
        this.getDataByPost(3,homeurl+"goodsController.api?insertBusinessGoods",
            {merchants_id:this.state.merchants_id,goods_id:this.state.selectBean.goods_id})
    }

    deleteBusinessGoods(){
        this.setState({
            visible:false
        })
        this.getDataByPost(4,homeurl+"goodsController.api?deleteBusinessGoods",
            {business_goods_id:this.state.businessGoodsBeans[this.state.business_index].business_goods_id})
    }

    dowmloadBusinessGoods(){
        this.getDataByPost(5,homeurl+"goodsController.api?dowmloadBusinessGoods",
            {merchants_id:this.state.merchants_id})
    }
    render(){
        return(
            <div>
                <Toolbar title="商家商品管理" history={this.props.history}></Toolbar>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteBusinessGoods();
                              }}></TipComponent>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商品名</p1>
                    </div>
                    <SearchBar
                        marginLeft={10}
                        item_name="goods_name"
                        name={this.state.goods_name}
                        dataSource={this.state.allGoodsBeans}
                        onPress={(data,value)=>{
                            this.setState({
                                selectBean:data,
                                goods_name:value,
                            })
                        }}>
                    </SearchBar>
                    <ButtonComponent
                        marginLeft={20}
                        value="添加"
                        onClick={()=>{
                            this.insertBusinessGoods();
                        }}/>
                </div>
                <div style={{display:'flex',justifyContent:'flex-end'}}>
                    <ButtonComponent
                        marginRight={20}
                        value="导出二维码"
                        onClick={()=>{
                            this.dowmloadBusinessGoods();
                        }}/>
                </div>
                <ListViewComponent
                    data={[
                            {name:"商品ID",flex:1,keys:["goodsBean",'goods_id']},
                            {name:"商品名",flex:2,keys:["goodsBean",'goods_name']},
                            {name:"原价",flex:1,keys:["goodsBean","goods_origin_price"]},
                            {name:"现价",flex:1,keys:["goodsBean",'goods_now_price']},
                            {name:"二维码",flex:1,key:'qrcode_img',type:'img1'},
                            {name:"操作",flex:1,key:"-1"}
                        ]}
                    dataSource={this.state.businessGoodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    business_index:rowID
                                                })
                                            }}>
                                    <div>
                                        <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                    </div>
                                </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getBusinessGoods(page)
                    }}>

                </ListViewComponent>
            </div>
        );
    }

}
const styles = {
    input:{
        width:200,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
        width:100
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    },item:{
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
}
module.exports=BusinessGoodsComponent;