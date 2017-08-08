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

class RefundReasonEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            refundReasonBean:JSON.parse(this.props.params.refundReasonBean)
        };
    }

    insertReason(){
        if(this.state.refundReasonBean.reason_name===''){
            toast.show("内容不可为空");
            return;
        }

        if(this.state.refundReasonBean.refund_reason_id){
            this.getDataByPost(2,homeurl+"orderController.api?updateRefundReason",
                {refund_reason_id:this.state.refundReasonBean.refund_reason_id,
                 reason_name:this.state.refundReasonBean.reason_name,
                sort:this.state.refundReasonBean.sort});
        }else{
            this.getDataByPost(1,homeurl+"orderController.api?insertRefundReason",
                {reason_name:this.state.refundReasonBean.reason_name,
                    sort:this.state.refundReasonBean.sort});
        }
    }

    doSuccess(index,data){
       switch (index){
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
    render(){
        return(
            <div>
                <Toolbar title="原因编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="原因内容"
                    value={this.state.refundReasonBean.reason_name}
                    onChange={(value)=>{
                        this.state.refundReasonBean.reason_name=value;
                        this.setState({
                            refundReasonBean:this.state.refundReasonBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.refundReasonBean.sort}
                    onChange={(value)=>{
                        this.state.refundReasonBean.sort=value;
                        this.setState({
                            refundReasonBean:this.state.refundReasonBean
                        })
                    }}/>
                <ButtonComponent
                    marginLeft={100}
                    marginTop={20}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertReason();
                    }}/>
            </div>
        )
    }
}

module.exports=RefundReasonEditorComponent;