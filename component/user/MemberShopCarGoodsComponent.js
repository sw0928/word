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
var Toolbar=require("./../../widget/Toolbar");
var PageComponent=require("./../../widget/PageComponent");

var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var TextComponent=require('./../../widget/TextComponent');

class MemberShopCarGoodsComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            member_id:this.props.params.member_id,
            merchants_id:this.props.params.merchants_id,
            shopCarGoodsBeans:[],
            total:0,
            page:1,
        };
    }

    componentDidMount() {
        this.getMemberShopCars(this.state.page);
    }
    

    getMemberShopCars(page){
        this.getDataByPost(1,homeurl+"shoppingController.api?getShoppingCarsByMerchants",
            {member_id:this.state.member_id,
                merchants_id:this.state.merchants_id,page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    shopCarGoodsBeans:data.data,
                    total:data.total,
                })
                break;
        }
    }

    render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <Toolbar title="购物车商品" history={this.props.history}></Toolbar>
                <ListView
                    style={styles.item}
                    dataSource={this.state.shopCarGoodsBeans}
                    renderHeader={()=>{
                        return(
                                <div style={{flex:1,display:'flex'}}>
                                    <div style={styles.tabColumn}>
                                        <input type="checkbox"
                                            onClick={()=>{

                                            }}/>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>商品ID</p1>
                                    </div>
                                     <div style={{flex: 2,
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
                                        padding:10,}}>
                                        <p1 style={styles.tabP1}>商品名称</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>商品编码</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>组合编码</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>原价</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>现价</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>总销量</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>库存</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>关税</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>消费税</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>跨境</p1>
                                    </div>
                                     <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>状态</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>仓库</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>操作</p1>
                                    </div>
                                </div>
                            )
                    }}
                    renderRow={(rowID)=>{
                        return(
                            <div style={{flex:1,display:'flex'}}>
                                <div style={styles.tabColumn}>
                                        <input type="checkbox"
                                            onClick={()=>{

                                            }}/>
                                </div>
                                 <div style={styles.tabColumn}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_id}</p1>
                                </div>
                                <div style={{flex: 2,
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
                                        padding:10,}}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_name}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_sku}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_skus}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_origin_price}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_now_price}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.year_sales}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_stock}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.cross_border_tax}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_excise_tax}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.is_cross_border==='1'?"是":"否"}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_state==='1'?"上架中":"下架中"}</p1>
                                </div>
                                 <div style={styles.tabRow}>
                                    <p1 style={styles.tabP1}>{this.state.shopCarGoodsBeans[rowID].goodsBean.goods_storehouse}</p1>
                                </div>
                                <div style={styles.tabRow}>
                                    
                                </div>
                            </div>
                        )
                    }}/>
                <PageComponent count={this.state.total}
                               curIndex={this.state.page}
                               onPage={(page)=>{
                                            this.setState({
                                                page:page
                                            });
                                            this.getMemberShopCars(page)
                                       }}></PageComponent>
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
        fontSize:13,
        wordBreak:'break-all'
    }
};

module.exports=MemberShopCarGoodsComponent;
