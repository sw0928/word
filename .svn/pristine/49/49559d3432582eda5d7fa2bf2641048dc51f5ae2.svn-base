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

class PromotionComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            promotionBeans:[],
            total:0,
            selectVisible:false,
            page:1,
            promotion_index:0,
        };
    }

    componentDidMount() {
        this.getPromotions(this.state.page);
    }

    getPromotions(page){
        this.getDataByPost(2,homeurl+"activityController.api?getPromotions",{page:page},{type:2})
    }

    doSuccess(index,data){
        switch(index){
            case 2:
                this.setState({
                    promotionBeans:data.data,
                    total:data.total
                })
                break;
            case 4:
                toast.show("删除成功");
                this.getBusinessGoods(this.state.page)
                break;
        }
    }

    deleteBusinessGoods(){
        this.setState({
            visible:false
        })
        this.getDataByPost(4,homeurl+"activityController.api?deletePromotion",
            {promotion_id:this.state.promotionBeans[this.state.promotion_index].promotion_id})
    }

    render(){
        return(
            <div style={{display:'flex',flexDirection:'column'}}>
                <Toolbar title="限时促销" history={this.props.history}></Toolbar>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteBusinessGoods();
                              }}></TipComponent>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/activity_promotion_editor/"+encodeURIComponent(JSON.stringify({})));
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={[{name:"活动ID",flex:1,key:'promotion_id'},
                            {name:"活动名称",flex:1,key:'promotion_name'},
                            {name:"图片",flex:1,key:'promotion_img',type:'img'},
                            {name:"开始时间",flex:1,key:'start_time'},
                            {name:"结束时间",flex:1,key:'end_time'},
                            {name:"操作",flex:1,key:"-1"}]}
                    dataSource={this.state.promotionBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/activity_promotion_editor/"+encodeURIComponent(JSON.stringify(this.state.promotionBeans[rowID])));
                            break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    promotion_index:rowID
                                })
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getBusinessGoods(page)
                    }}/>

            </div>
        );
    }

}

module.exports=PromotionComponent;