/**
 * Created by shenjiabo on 16/11/2.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'
var PageComponent=require("./../../widget/PageComponent");
var Toolbar=require("./../../widget/Toolbar");

var TabBar=require("./../../widget/TabBar");
var EditorComponent=require("./../../widget/EditorComponent");
var TextComponent=require("./../../widget/TextComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");

var Widget=require("./../../widget/WidgetComponent");

class RefundDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            refund_id:this.props.params.refund_id,
            refundBean:{},
            click_index:1,
            visible:false,
        };
    }

    componentDidMount() {
       this.getOrderRefund();
    }

    getOrderRefund(){
        this.getDataByPost(1,homeurl+"orderController.api?getOrderRefundDetail",{refund_id:this.state.refund_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    refundBean:data,
                })
                break;
            case 2:
                toast.show("操作成功");
                this.getOrderRefund();
                break;
            case 3:
                toast.show("保存成功");
                this.getOrderRefund();
                break;
        }
    }

   updateRefundDetail(){
       if(isNaN(this.state.refundBean.refund_price)){
           this.showTip("退款金额非法");
       }

       if(isNaN(this.state.refundBean.refund_integral_value)){
           this.showTip("退款积分非法");
       }
       this.getDataByPost(3,homeurl+"orderController.api?updateRefundDetail",
            {refund_id:this.state.refund_id,
                refund_price:this.state.refundBean.refund_price,
                refund_integral_value:this.state.refundBean.refund_integral_value,
                custom_remark:this.state.refundBean.custom_remark});
    }

    updateApplyState(){
        this.getDataByPost(2,homeurl+"orderController.api?updateRefundStateV2",
            {refund_id:this.state.refund_id,
                refund_state:this.state.click_index===1?"accept":(this.state.click_index===2?"refuse":"end"),
                type:company_name,refuse_desc:this.state.refundBean.refuse_desc});
    }
    render(){
        return(
            <div>
                <Toolbar title="退款详情" history={this.props.history}></Toolbar>
                <TipComponent visible={this.state.visible} msg={this.state.click_index===1?"确定接受?":
                                (this.state.click_index===2?"确认拒绝?":"确认退款?")}
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                   this.setState({
                                        visible:false
                                   })
                                  this.updateApplyState();
                              }}/>
                <ButtonComponent
                    width={100}
                    marginLeft={100}
                    marginTop={20}
                    value="保存"
                    onClick={()=>{
                        this.updateRefundDetail();
                    }}/>
                <div style={styles.div}>
                    <TextComponent
                        title="ID"
                        value={this.state.refundBean.refund_id}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="用户ID"
                        value={this.state.refundBean.member_id}/>
                    <TextComponent
                        title="用户昵称"
                        value={this.state.refundBean.member_name}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="订单id"
                        value={this.state.refundBean.order_id}/>
                    <TextComponent
                        title="收货人"
                        value={this.state.refundBean.name}/>
                    <TextComponent
                        title="收货电话"
                        value={this.state.refundBean.mobile}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="订单关联商品id"
                        value={this.state.refundBean.order_goods_id}/>
                    <TextComponent
                        title="商品id"
                        value={this.state.refundBean.goods_id}/>
                    <TextComponent
                        title="商品名称"
                        value={this.state.refundBean.goods_name}/>
                </div>
                <Widget.Textarea
                    value={this.state.refundBean.custom_remark}
                    height={200}
                    widthContent={400}
                    title="备注"
                    onChange={(value)=>{
                        this.state.refundBean.custom_remark=value;
                        this.setState({
                            refundBean:this.state.refundBean
                        });
                    }}/>

                <div style={styles.div}>
                    <TextComponent
                        title="申请状态"
                        value={this.state.refundBean.refund_state_show}/>

                    <ButtonComponent
                        visible={this.state.refundBean.refund_state==='wait_review'?"true":"false"}
                        marginLeft={20}
                        value="接受"
                        onClick={()=>{
                            this.setState({
                                visible:true,
                                click_index:1,
                            })
                        }}/>

                    <ButtonComponent
                        marginLeft={20}
                        visible={this.state.refundBean.refund_state==='wait_review'?"true":"false"}
                        value="拒绝"
                        onClick={()=>{
                            this.setState({
                                visible:true,
                                click_index:2,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        visible={this.state.refundBean.refund_state==='accept'?"true":"false"}
                        value="退款"
                        onClick={()=>{
                            this.setState({
                                visible:true,
                                click_index:3,
                            })
                        }}/>
                    <TextComponent
                        visible={this.state.refundBean.refund_state==='refuse'?"true":"false"}
                        title="拒绝原因"
                        value={this.state.refundBean.refuse_desc}/>
                    <EditorComponent
                        visible={this.state.refundBean.refund_state==='wait_review'?"true":"false"}
                        title="拒绝原因"
                        value={this.state.refundBean.refuse_desc}
                        onChange={(value)=>{
                            this.state.refundBean.refuse_desc=value;
                            this.setState({
                                refundBean:this.state.refundBean
                            })
                        }}/>
                </div>
                <div style={{display:'flex',marginTop:20,alignItems:'center'}}>
                    <TextComponent
                        title="退款数量"
                        value={this.state.refundBean.refund_count}/>
                    <TextComponent
                        visible={this.state.refundBean.refund_state!=="wait_review"?"true":"false"}
                        title="退款金额"
                        value={this.state.refundBean.refund_price}/>
                    <TextComponent
                        visible={this.state.refundBean.refund_state!=="wait_review"?"true":"false"}
                        title="退款积分"
                        value={this.state.refundBean.refund_integral_value}/>
                    <EditorComponent
                        visible={this.state.refundBean.refund_state==="wait_review"?"true":"false"}
                        title="退款金额"
                        value={this.state.refundBean.refund_price}
                        onChange={(value)=>{
                            this.state.refundBean.refund_price=value;
                            this.setState({
                                refundBean:this.state.refundBean
                            })
                        }}/>
                    <EditorComponent
                        visible={this.state.refundBean.refund_state==="wait_review"?"true":"false"}
                        title="退款积分"
                        value={this.state.refundBean.refund_integral_value}
                        onChange={(value)=>{
                            this.state.refundBean.refund_integral_value=value;
                            this.setState({
                                refundBean:this.state.refundBean
                            })
                        }}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="退款理由"
                        value={this.state.refundBean.refund_desc}/>
                    <TextComponent
                        title="退款原因"
                        value={this.state.refundBean.reason_name}/>
                </div>
                <div style={styles.div}>
                    <TextComponent
                        title="退款单号"
                        value={this.state.refundBean.refund_order_no}/>
                    <TextComponent
                        title="申请时间"
                        value={this.state.refundBean.create_time}/>
                </div>
                <div style={{width:100,display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <p1 style={{fontSize:13,}}>图片展示</p1>
                </div>
                <ListView
                    style={{display:'flex',flexDirection:'row',marginLeft:100}}
                    dataSource={this.state.refundBean.refundImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <img src={imgurl+this.state.refundBean.refundImgBeans[rowID].refund_img}
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
        marginTop:20,
        alignItems:'center'
    }
}
module.exports=RefundDetailComponent;
