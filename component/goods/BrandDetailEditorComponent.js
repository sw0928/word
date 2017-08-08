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

class BannerDetailEditorComponent extends BaseComponent{
    render(){
        return(
            <div style={{display:'flex',flexDirection:'column',overflow:'hidden'}}>
                <Toolbar title={"品牌详情编辑"} history={this.props.history}></Toolbar>
                <iframe src={htmlurl+"/brand_editor.html?brand_url="+decodeURIComponent(this.props.params.brand_url)}
                        style={{display:'flex',alignItems:'center',justifyContent:'center',
                         height:1000,marginLeft:10,marginRight:10,flex:1}}>

                </iframe>
            </div>
        )
    }
}

module.exports=BannerDetailEditorComponent;