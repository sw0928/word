/**
 * Created by shenjiabo on 16/8/22.
 */
/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

import { DateField, Calendar } from 'react-date-picker'
var Toolbar=require("./../../widget/Toolbar");
import Upload from 'rc-upload';
var PromotionGoodsComponent=require("./PromotionGoodsComponent");
var Widget=require("./../../widget/WidgetComponent");


class PromotionGoodsEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var promotionBean=JSON.parse(decodeURIComponent(this.props.params.promotionBean));
        var myDate = new Date();
        this.state = {
            promotionBean:promotionBean,
            moudleBeans:[],
            itemCurIndex:storage.get("promotionIndex")?parseInt(storage.get("promotionIndex")):0,
        };
    }

    componentDidMount() {
        if(this.state.promotionBean.promotion_id){
            this.setState({
                moudleBeans:[
                    {"name":"基本信息",component:this.renderBase()},
                    {"name":"商品列表",component:this.renderPromotionGoods()},
                ]
            })
        }else {
            this.setState({
                moudleBeans:[{"name":"基本信息",component:this.renderBase()}]
            })
        }
    }

    render(){
        return(
            <div>
                <Widget.Toolbar title="促销活动编辑" history={this.props.history}/>
                <Widget.TabBar saveIndex="promotionIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.itemCurIndex?this.state.itemCurIndex:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            itemCurIndex:rowID
                        })
                    }}/>
            </div>
        )
    }

    renderBase(){
        return(
            <RenderBase promotionBean={this.state.promotionBean} history={this.props.history}>

            </RenderBase>
        )
    }

    renderPromotionGoods(){
        return(
            <PromotionGoodsComponent promotion_id={this.state.promotionBean.promotion_id} history={this.props.history}>

            </PromotionGoodsComponent>
        )
    }
}


class  RenderBase extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var promotionBean=this.props.promotionBean;
        var myDate = new Date();
        this.state = {
            promotionBean:promotionBean.promotion_id?promotionBean:{promotion_type:'time_limit'},
            promotion_name:promotionBean.promotion_name?promotionBean.promotion_name:'',
            promotion_img:promotionBean.promotion_img,
            start_time:promotionBean.start_time?promotionBean.start_time.substring(0,promotionBean.start_time.length-2).replace(/[\r\n]/g,""):
            myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate()+" "+myDate.getHours()+":"+myDate.getMinutes()+":"+myDate.getSeconds(),
            end_time:promotionBean.end_time?promotionBean.end_time.replace(/[\r\n]/g,""):
            myDate.getFullYear()+"-"+(myDate.getMonth()+1)+"-"+myDate.getDate()+" "+myDate.getHours()+":"+myDate.getMinutes()+":"+myDate.getSeconds(),
            sort:promotionBean.sort,
            moudleBeans:[],
            typeBeans:[{id:'time_limit',name:'限时抢购'},{id:'flash',name:'闪购'}],
        };
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
        }
    }

    insertPromotion(){
        if(this.state.promotion_name===''){
            toast.show("名称不可为空");
            this.props.history.goBack();
        }

        if(this.state.promotion_img===''){
            toast.show("请先上传张图片");
            this.props.history.goBack();
        }

        if(!this.state.promotionBean.promotion_id) {
            this.getDataByPost(1, homeurl + "activityController.api?insertPromotion",
                {
                    start_time: this.state.start_time,
                    end_time: this.state.end_time,
                    sort:this.state.sort,
                    promotion_name:this.state.promotion_name,
                    promotion_img:this.state.promotion_img,
                    promotion_type:this.state.promotionBean.promotion_type
                })
        }else{
            this.getDataByPost(2, homeurl + "activityController.api?updatePromotion",
                {
                    promotion_id: this.state.promotionBean.promotion_id,
                    start_time: this.state.start_time,
                    end_time: this.state.end_time,
                    sort:this.state.sort,
                    promotion_name:this.state.promotion_name,
                    promotion_img:this.state.promotion_img
                })
        }
    }

    render(){
        return(
            <div>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.promotion_name}
                    onChange={(value)=>{
                        this.setState({
                            promotion_name:value
                        })
                    }}/>
                <Widget.Img
                    marginTop={20}
                    title="图片"
                    url={homeurl+"activityController.api?uploadPromotionImg"}
                    src={this.state.promotion_img?imgurl+this.state.promotion_img:'./images/add.jpg'}
                    onSuccess={(value)=>{
                        this.setState({
                            promotion_img:value,
                        })
                    }}/>
                <Widget.SelectV2 dataSource={this.state.typeBeans}
                                 title="类型"
                                 init_value={this.state.promotionBean.promotion_type}
                                 select_value="id"
                                 show_value="name"
                                 onChange={(rowID)=>{
                                    this.state.promotionBean.promotion_type=this.state.typeBeans[rowID].id;
                                    this.setState({
                                        promotionBean:this.state.promotionBean
                                    })
                                 }}/>
                <Widget.Date
                    marginTop={20}
                    title="开始时间"
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.state.start_time}
                    onChange={(value)=>{
                            this.setState({
                                start_time:value,
                            })
                    }}/>
                <Widget.Date
                    marginTop={20}
                    title="结束时间"
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.state.end_time}
                    onChange={(value)=>{
                            this.setState({
                                end_time:value,
                            })
                    }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertPromotion();
                    }}/>
            </div>
        )
    }
}

const styles = {
    input:{
        width:300,
        height:30,
    },
    font:{
        fontSize:15,
        width:100,
        marginLeft:20,
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
    }
}

module.exports=PromotionGoodsEditorComponent;
