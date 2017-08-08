/**
 * Created by shenjiabo on 16/9/5.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var Toolbar=require("./../../widget/Toolbar");

class IntegralRuleComponent extends BaseComponent{
    render(){
        return(
            <div style={{display:'flex',flexDirection:'column',overflow:'hidden'}}>
                <Toolbar title={"积分规则"} history={this.props.history}></Toolbar>
                <iframe src={htmlurl+"/integral_rule_editor.html?url="+decodeURIComponent("/html/others/integral_rule.html")}
                        style={{display:'flex',alignItems:'center',justifyContent:'center',
                        height:1000,marginLeft:10,marginRight:10,flex:1}}></iframe>
            </div>
        )
    }
}

module.exports=IntegralRuleComponent;