/**
 * Created by shenjiabo on 16/11/8.
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
var ListViewComponent=require("./../../widget/ListViewComponent");
var TextComponent=require("./../../widget/TextComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");

class AssessmentDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            assessment_id:this.props.params.assessment_id,
            assessmentBean:{memberBean:{},goodsBean:{},merchantsBean:{}},
        };
    }

    componentDidMount() {
        this.getAssessmentDetail();
    }

    getAssessmentDetail(){
        this.getDataByPost(1,homeurl+"assessmentController.api?getAssessmentDetail",{assessment_id:this.state.assessment_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    assessmentBean:data
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <Toolbar title="评价详情" history={this.props.history}></Toolbar>
                <div style={styles.div}>
                    <TextComponent
                        title="ID"
                        value={this.state.assessmentBean.assessment_id}/>
                    <TextComponent
                        title="订单ID"
                        value={this.state.assessmentBean.order_id}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="用户ID"
                        value={this.state.assessmentBean.member_id}/>
                    <TextComponent
                        title="用户昵称"
                        value={this.state.assessmentBean.memberBean.nick_name}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="商品/商家ID"
                        value={this.state.assessmentBean.relation_id}/>
                    <TextComponent
                        title="商品/店铺名称"
                        value={this.state.assessmentBean.assessment_type==='goods'?
                        this.state.assessmentBean.goodsBean.goods_name:this.state.assessmentBean.merchantsBean.merchants_name}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="评价内容"
                        value={this.state.assessmentBean.assessment_desc}/>
                    <TextComponent
                        title="评价类型"
                        value={this.state.assessmentBean.assessment_type_show}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="星级1"
                        value={this.state.assessmentBean.assessment_star1}/>
                    <TextComponent
                        title="星级2"
                        value={this.state.assessmentBean.assessment_star2}/>
                    <TextComponent
                        title="星级3"
                        value={this.state.assessmentBean.assessment_star3}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="评价时间"
                        value={this.state.assessmentBean.create_time}/>
                </div>
                <div style={{width:100,display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <p1 style={{fontSize:13,}}>图片展示</p1>
                </div>
                <ListView
                    style={{display:'flex',flexDirection:'row',marginLeft:100}}
                    dataSource={this.state.assessmentBean.assessmentImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <img src={imgurl+this.state.assessmentBean.assessmentImgBeans[rowID].assessment_img}
                                style={{marginLeft:10,width:100,height:100}}/>
                        )
                    }}>

                </ListView>

            </div>
        )
    }

}

const styles = {
    div:{
        display:'flex',
        alignItems:'center',
        marginTop:20,
    }
}
module.exports=AssessmentDetailComponent;