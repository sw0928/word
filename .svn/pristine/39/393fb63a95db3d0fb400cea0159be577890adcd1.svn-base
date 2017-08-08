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
var Widget=require("./../../widget/WidgetComponent");

class PromotionGoodsComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            promotionGoodsBeans:[],
            total:0,
            selectVisible:false,
            page:1,
            promotion_index:0,
            allGoodsClassBeans:[],
            selectClassBean:{},
            goods_class_name:""
        };
    }

    componentDidMount() {
        this.getPromotionGoods(this.state.page);
    }

    getPromotionGoods(page){
        this.getDataByPost(2,homeurl+"activityController.api?getPromotionGoodss",
            {page:page,promotion_id:this.props.promotion_id},{type:2})
        this.getDataByPost(1,homeurl+"goodsController.api?getAllGoodsClassNoPage",{})
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    allGoodsClassBeans:data
                })
                break;
            case 2:
                this.setState({
                    promotionGoodsBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                toast.show("添加成功");
                this.setState({
                    page:1
                })
                this.getPromotionGoods(1)
                break;
            case 4:
                toast.show("删除成功");
                this.getPromotionGoods(this.state.page)
                break;
        }
    }

    deletePromotionGoods(){
        this.setState({
            visible:false
        })
        this.getDataByPost(4,homeurl+"activityController.api?deletePromotionGoods",
            {promotion_id:this.props.promotion_id,
                goods_uuid:this.state.selectClassBean.goods_uuid})
    }

    insertAllPromotionGoods() {
        this.getDataByPost(3,homeurl+"activityController.api?insertAllPromotionGoods",
            {promotion_price:this.state.promotion_price,
             promotion_id:this.props.promotion_id,
            goods_uuid:this.state.selectClassBean.goods_uuid,
                promotion_stock:this.state.promotion_stock})
    }

    render(){
        return(
            <div style={{display:'flex',flexDirection:'column'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deletePromotionGoods();
                              }}></TipComponent>
                <TipComponent visible={this.state.allVisible} msg="确定添加?"
                              onClose={()=>{
                                  this.setState({
                                      allVisible:false
                                  })
                              }}
                              onPress={()=>{
                                  this.setState({
                                      allVisible:false
                                  })
                                  this.insertAllPromotionGoods();
                              }}></TipComponent>
                <div style={{display:'flex',alignItems:'center',justifyContent:'flex-end',marginTop:20}}>
                    <p1 style={{fontSize:13,marginLeft:20,marginRight:20}}>商品分类名</p1>
                    <Widget.SearchBar
                        item_name="goods_name"
                        dataSource={this.state.allGoodsClassBeans}
                        name={this.state.goods_class_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectClassBean:data,
                                goods_class_name:value,
                            })
                        }}/>
                    <Widget.Editor
                        value={this.state.promotion_price}
                        title="折扣"
                        onChange={(value)=>{
                            this.setState({
                                promotion_price:value
                            })
                        }}/>
                    <Widget.Editor
                        value={this.state.promotion_stock}
                        title="库存"
                        onChange={(value)=>{
                            this.setState({
                                promotion_stock:value
                            })
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.setState({
                                allVisible:true
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加单个商品"
                        onClick={()=>{
                            this.props.history.push("/activity_promotion_goods_editor/"+
                                encodeURIComponent(JSON.stringify({promotion_id:this.props.promotion_id})));
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="删除"
                        onClick={()=>{
                            {/*let promotion_goods_ids="";*/}
                            {/*for(let i=0;i<this.state.promotionGoodsBeans.length;i++){*/}
                                {/*if(this.state.promotionGoodsBeans[i].is_select==="1"){*/}
                                    {/*promotion_goods_ids+=this.state.promotionGoodsBeans[i].promotion_goods_id;*/}
                                    {/*if(i<this.state.promotionGoodsBeans.length-1){*/}
                                        {/*promotion_goods_ids+=",";*/}
                                    {/*}*/}
                                {/*}*/}
                            {/*}*/}
                            {/*if(promotion_goods_ids.length<=0){*/}
                                {/*this.showTip("未选择任何商品");*/}
                                {/*return;*/}
                            {/*}*/}
                            this.setState({
                                visible:true,
                            })
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={[{name:"",flex:1,key:"-2"},
                            {name:"商品ID",flex:1,keys:['goodsBean','goods_id']},
                            {name:"商品名",flex:1,keys:['goodsBean','goods_name']},
                            {name:"促销价",flex:1,key:'promotion_price'},
                            {name:"操作",flex:1,key:"-1"}]}
                    dataSource={this.state.promotionGoodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    checked={this.state.checked}
                    onChecked={(i,checked)=>{
                        if(i===-1){
                            for(let j=0;j<this.state.promotionGoodsBeans.length;j++){
                                this.state.promotionGoodsBeans[j].is_select=checked;
                            }
                            this.setState({
                                checked:checked
                            })
                        }else{
                            this.state.promotionGoodsBeans[i].is_select=checked;
                            this.setState({
                                promotionGoodsBeans:this.state.promotionGoodsBeans,
                                checked:checked==="0"?checked:this.state.checked,
                            });
                        }
                    }}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/activity_promotion_goods_editor/"+
                                        encodeURIComponent(JSON.stringify(this.state.promotionGoodsBeans[rowID])));
                            break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    promotion_goods_ids:this.state.promotionGoodsBeans[rowID].promotion_goods_id
                                })
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getPromotionGoods(page)
                    }}/>
               
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
module.exports=PromotionGoodsComponent;