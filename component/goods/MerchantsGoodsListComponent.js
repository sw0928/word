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
var ListViewComponent=require("./../../widget/ListViewComponent");

class MerchantsGoodsListComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var info=storage.get("merchantsAccountBean");
        this.state = {
            shopSelects:[{id:"0",name:"商品ID"},{id:"0",name:"商品名称"}],
            start_time:'',
            end_time:"",

            goodsBeans:[],
            merchantsBeans:[],
            allMerchantsBeans:[],
            selectBean:{},
            selectVisible:false,
            total:0,
            goods_index:0,
            page:1,
            merchants_name:"",
            baseData:[],
            merchants_id:JSON.parse((info===null?"{}":info)).merchants_id,
        };
    }

    componentDidMount() {
        this.getDataByPost(4,homeurl+"systemController.api?getSystemListShows",{list_type:'goods'});
        this.getGoods(this.state.merchants_id,this.state.page)
    }

    doSuccess(index,data){
        switch (index){
            case 4:
                this.setState({
                    baseData:data
                })
                break;
            case 2:
                this.setState({
                    goodsBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                toast.show("删除成功");
                this.getGoods(this.state.merchants_id,this.state.page);
                break;
        }
    }

    getGoods(merchants_id,page){
        this.getDataByPost(2,homeurl+'goodsController.api?getAllGoodsDetail',
            {merchants_id:merchants_id,page:page,
                start_time:this.state.start_time,end_time:this.state.end_time},{type:2})
    }

    deleteGoods(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(3,homeurl+"goodsController.api?deleteGoodsDetail",
            {goods_id:this.state.goodsBeans[this.state.goods_index].goods_id})
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="商品列表" history={this.props.history}></Toolbar>
                <div style={{display:'flex',height:60,alignItems:'center'}}>
                    <p1 style={{fontSize:15,marginLeft:10}}>添加时间</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD"
                        value={this.state.start_time}
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
                        value={this.state.end_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                                   this.setState({
                                       end_time:dateString,
                                   })
                                }}
                    />

                    <ButtonComponent
                        marginLeft={10}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1,
                            })
                            this.getGoods(this.state.merchants_id,1);
                        }}>

                    </ButtonComponent>
                </div>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteGoods();
                              }}></TipComponent>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/merchants_goods_editor/"+encodeURIComponent(JSON.stringify({merchants_id:this.state.merchants_id}))}
                                            style={{display:'flex',textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/merchants_goods_editor/"+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[编辑]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                goods_index:rowID
                                            })
                                            }}>
                                    <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getGoods(this.state.merchants_id,page)
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
module.exports=MerchantsGoodsListComponent;
