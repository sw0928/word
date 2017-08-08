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
import Upload from 'rc-upload';
var Widget = require('./../../widget/WidgetComponent');

class GoodsListComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            shopSelects:[{id:"0",name:"商品ID"},{id:"0",name:"商品名称"}],
            start_time:'',
            end_time:"",
            goodsBeans:[],
            merchantsBeans:[],
            selectVisible:false,
            total:0,
            goods_index:0,
            page:storage.get("goods_page")?storage.get("goods_page"):1,
            merchants_name:"",
            baseData:[],
            goods_id:storage.get("goods_goods_id")?storage.get("goods_goods_id"):"",
            goods_name:storage.get("goods_goods_name")?storage.get("goods_goods_name"):"",
            goods_sku:storage.get("goods_sku")?storage.get("goods_sku"):"",
            detailBean:{},
        };
    }

    componentDidMount() {
        this.getDataByPost(4,homeurl+"systemController.api?getSystemListShows",{list_type:'goods'});
        this.getGoods("",this.state.page);
        this.getDataByPost(6,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'goods_list_detail'});
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
                this.getGoods("",this.state.page);
                break;
        }
    }

    getGoods(merchants_id,page){
        storage.set("goods_page",page);
        storage.set("goods_start_time",this.state.start_time);
        storage.set("goods_end_time",this.state.end_time);
        storage.set("goods_goods_name",this.state.goods_name);
        storage.set("goods_goods_id",this.state.goods_id);
        storage.set("goods_sku",this.state.goods_sku);

        this.getDataByPost(2,homeurl+'goodsController.api?getAllGoodsDetail',
            {merchants_id:merchants_id,page:page,
                start_time:this.state.start_time,end_time:this.state.end_time,
                goods_id:this.isNull(this.state.goods_id)?"0":this.state.goods_id,goods_name:this.state.goods_name,
                goods_sku:this.state.goods_sku},
            {type:2});
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
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title='商品id'
                        value={this.state.goods_id}
                        onChange={(value)=>{
                            this.setState({
                                goods_id:isNaN(value)?"":value
                            })
                        }}/>
                    <EditorComponent
                        visible={this.state.detailBean.goods_sku}
                        title='商品sku'
                        value={this.state.goods_sku}
                        onChange={(value)=>{
                            this.setState({
                                goods_sku:value
                            })
                        }}/>
                    <EditorComponent
                        title='商品名称'
                        value={this.state.goods_name}
                        onChange={(value)=>{
                            this.setState({
                                goods_name:value
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={10}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1,
                            })
                            this.getGoods("",1);
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
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/goods_detail/"
                            +encodeURIComponent(JSON.stringify({})));
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/goods_detail/"+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID]))}
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
                        this.getGoods("",page)
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
    },
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
};
module.exports=GoodsListComponent;
