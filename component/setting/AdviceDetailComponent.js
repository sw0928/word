/**
 * Created by shenjiabo on 16/11/9.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var BaseComponent=require('./../BaseComponent');

var Toolbar=require("./../../widget/Toolbar");
var ListView=require('./../../widget/ListView');

var TextComponent=require("./../../widget/TextComponent");


class AdviceDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            advice_id:this.props.params.advice_id,
            adviceBean:{},
        };
    }

    componentDidMount() {
        this.getAdviceDetail();
    }

    getAdviceDetail(){
        this.getDataByPost(1,homeurl+"othersController.api?getAdviceDetail",{advice_id:this.state.advice_id});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    adviceBean:data
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="意见详情" history={this.props.history}></Toolbar>
                <div style={styles.div}>
                    <TextComponent
                        title="ID"
                        value={this.state.adviceBean.advice_id}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="用户ID"
                        value={this.state.adviceBean.member_id}/>
                    <TextComponent
                        title="用户昵称"
                        value={this.state.adviceBean.nick_name}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="标题"
                        value={this.state.adviceBean.advice_title}/>
                    <TextComponent
                        title="内容"
                        value={this.state.adviceBean.advice_desc}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="反馈类型"
                        value={this.state.adviceBean.advice_type_show}/>
                    <TextComponent
                        title="反馈时间"
                        value={this.state.adviceBean.create_time}/>
                </div>
                
                <div style={{width:100,display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <p1 style={{fontSize:13,}}>图片展示</p1>
                </div>
                <ListView
                    style={{display:'flex',flexDirection:'row',marginLeft:100}}
                    dataSource={this.state.adviceBean.adviceImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <img src={imgurl+this.state.adviceBean.adviceImgBeans[rowID].advice_img}
                                style={{marginLeft:10,width:100,height:100}}/>
                        )
                    }}>

                </ListView>
            </div>
        )
    }
}

const styles={
    div:{
        display:'flex',
        alignItems:'center',
        marginTop:20
    }
}

module.exports=AdviceDetailComponent;