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
var TabBar=require('./../../widget/TabBar');

var ActivityEditorComponent=require('./ActivityEditorComponent');
var ActivityGoodsComponent=require('./ActivityGoodsComponent');

class HomeComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            activityBean:JSON.parse(decodeURIComponent(this.props.params.activityBean)),
            moudleBeans:[],
            index:0,
        };
    }

    componentDidMount() {
        this.setState({
            moudleBeans:[
                {"name":"详情",component:this.renderDetail()},
                {"name":"商品列表",component:this.renderGoods()},
            ]
        })
    }

    render(){
        return(
            <div>
                <Toolbar title="首页设置" history={this.props.history}></Toolbar>
                <TabBar saveIndex="activityIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                            this.setState({
                                index:rowID
                            })
                        }}/>
            </div>
        );
    }
    renderGoods(){
        return(
            <ActivityGoodsComponent
                activity_type={this.state.activityBean.activity_type}
                history={this.props.history}
                activity_id={this.state.activityBean.activity_id}>

            </ActivityGoodsComponent>
        )
    }
    renderDetail(){
        return(
            <ActivityEditorComponent  history={this.props.history} activity_id={this.state.activityBean.activity_id}>

            </ActivityEditorComponent>
        )
    }

}

module.exports=HomeComponent;