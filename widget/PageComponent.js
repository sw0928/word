/**
 * Created by shenjiabo on 16/8/31.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./../component/BaseComponent');

var limit=10;//一页多少数据
var pageCount=8;//页面展示最大页数
class PageComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            curIndex:1,
        };
    }

    render(){
        let pageView=[];
        if(this.props.count>limit){
            pageView.push(
                <div
                    onClick={()=>{
                        if(this.props.curIndex===1){
                            toast.show("已是首页");
                        }else{
                            this.props.onPage(parseInt(this.props.curIndex)-1);
                        }
                    }}>
                    <p1 style={{fontSize:15,marginRight:20}}>上一页</p1>
                </div>
            )
            let totalCount=parseInt(this.props.count%limit===0?this.props.count/limit:this.props.count/limit+1);//总共多少页

            let maxPage=totalCount>pageCount?pageCount:totalCount;//页面最大显示8页

            let start=0;//开始页

            start=this.props.curIndex>totalCount-6?totalCount-6:this.props.curIndex;//如果已经达到页面上限 则使用最大起始页

            start=totalCount>pageCount?start:1;//如果总页数 小于最大页面 则一直从1开始

            start=start<=1?1:start-1;//保证前一页可点 则减一 为1时不减

            for(let i=start;i<maxPage+start;i++){
                pageView.push(
                    <div style={{width:30,height:30,borderWidth:1,
                        background:this.props.curIndex===i?"#efefef":"#ffffff",
                        borderColor:'#000000',borderStyle:'solid',marginLeft:limit,
                        display:'flex',alignItems:'center',justifyContent:'center'}}
                         onClick={()=>{
                             this.props.onPage(i);
                         }}>
                        <p1 style={{fontSize:15}}>{i}</p1>
                    </div>
                );
            }
            pageView.push(
                <div
                    onClick={()=>{
                        if(this.props.curIndex>=this.props.count/limit){
                            toast.show("已是尾页");
                        }else{
                            this.props.onPage(parseInt(this.props.curIndex)+1);
                        }
                    }}>
                    <p1 style={{fontSize:15,marginRight:20,marginLeft:20}}>下一页</p1>
                </div>
            )
        }
        return(
            <div style={{display:'flex',flexDirection:'row',
                alignItems:'center',justifyContent:'flex-end',flex:1,
                height:50}}>
                <p1 style={{fontSize:15,marginRight:20}}>共{this.props.count}条记录</p1>
                {pageView}
            </div>
        )
    }
}

module.exports=PageComponent;