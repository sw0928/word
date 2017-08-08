/**
 * Created by shenjiabo on 16/10/21.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import Upload from 'rc-upload';
var Toolbar=require("./../../widget/Toolbar");

var TabBar=require('./../../widget/TabBar');

var TextComponent=require('./../../widget/TextComponent');
var EditorComponent=require('./../../widget/EditorComponent');
var CheckComponent=require('./../../widget/CheckComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var SelectComponent=require('./../../widget/SelectComponent');
var ImgComponent=require('./../../widget/ImgComponent');

var DistributionTakeComponent=require('./DistributionTakeComponent');
var DistributionUntakeComponent=require('./DistributionUntakeComponent');

class  DistributionDetail1Component extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            member_id:this.props.params.member_id,
            moudleBeans:[],
            count:this.props.params.count,
            distribution_relation:this.props.params.distribution_relation,
        };
    }

    componentDidMount() {
        this.setState({
            moudleBeans:[{"name":"已获得",component:this.renderTake()},
                {"name":"未获得",component:this.renderUnTake()},
            ]
        })
    }

    render(){
        return(
            <div>
                <Toolbar title={this.state.distribution_relation==='vip1'?"一级详情":"二级详情"} history={this.props.history}></Toolbar>
                <TabBar saveIndex="memberIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}></TabBar>
            </div>
        )
    }

    renderTake(){
        return(
            <DistributionTakeComponent distribution_relation={this.state.distribution_relation} member_id={this.state.member_id}/>
        )
    }

    renderUnTake(){
        return(
            <DistributionUntakeComponent type={this.props.params.distribution_relation==='vip1'?"1":"2"} member_id={this.state.member_id}/>
        )
    }
}


const styles = {
    tab:{
        display:'flex',
        height:50,
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
        fontSize:15,
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
    },
}

module.exports=DistributionDetail1Component;