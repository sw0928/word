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

var HomeLabelComponent=require('./HomeLabelComponent');
var HomeActivityComponent=require('./HomeActivityComponent');
var HomeGoodsComponent=require('./HomeGoodsComponent');//首页编辑
var HomeOthersComponent=require('./HomeOthersComponent');//首页编辑

class HomeComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            moudleBeans:[],
            index:0,
        };
    }

    componentDidMount() {
        this.setState({
            moudleBeans:[
                {"name":"标签设置",component:this.renderLabel()},
            ]
        })
    }

    render(){
        return(
            <div>
                <Toolbar title="首页设置" history={this.props.history}></Toolbar>
                <TabBar saveIndex="homeIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}></TabBar>
            </div>
        );
    }

    renderOthers(){
        return(
            <HomeOthersComponent
                history={this.props.history}>
                
            </HomeOthersComponent>
        )
    }


    renderLabel(){
        return(
            <HomeLabelComponent history={this.props.history}>

            </HomeLabelComponent>
        )
    }

    renderActivity(){
        return(
            <HomeActivityComponent history={this.props.history}>

            </HomeActivityComponent>
        )
    }

    renderGoods(){
        return(
            <HomeGoodsComponent history={this.props.history}>

            </HomeGoodsComponent>
        )
    }
}

module.exports=HomeComponent;