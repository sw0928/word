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

var TipComponent=require('./../../widget/TipComponent');
import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'
var PageComponent=require("./../../widget/PageComponent");
var Toolbar=require("./../../widget/Toolbar");
var SearchBar=require("./../../widget/SearchBar");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var ListViewComponent=require("./../../widget/ListViewComponent");

class RefundComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            refundReasonBeans:[],
            baseData:[],
            total:0,
            page:1,
            visible:false,
            reason_index:-1,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'refund_reason_id'},
                {name:"原因内容",flex:1,key:'reason_name'},
                {name:"权重",flex:1,key:"sort"},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getRefundReasons(this.state.page);
    }

    getRefundReasons(page){
        this.getDataByPost(1,homeurl+"orderController.api?getRefundReasons",
            {page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    refundReasonBeans:data.data,
                    total:data.total,
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getRefundReasons(this.state.page);
                break;
        }
    }

    deleteRefundReason(){
        this.getDataByPost(2,homeurl+"orderController.api?deleteRefundReason",{refund_reason_id:this.state.refundReasonBeans[this.state.reason_index].refund_reason_id});
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="退款原因" history={this.props.history}></Toolbar>
                <TipComponent visible={this.state.visible} msg="确定删除"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                   this.setState({
                                    visible:false
                                   })
                                  this.deleteRefundReason();
                              }}></TipComponent>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.refundReasonBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/refund_reason_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{display:'flex',textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/refund_reason_editor/"+encodeURIComponent(JSON.stringify(this.state.refundReasonBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                        <p1 style={{fontSize:13}}>[编辑]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                reason_index:rowID
                                            })
                                            }}>
                                    <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getRefundReasons(page)
                    }}>

                </ListViewComponent>
            </div>
        )
    }
}
const styles = {
    tab:{
        display:'flex',
        height:30,
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
        fontSize:13,
    },
}
module.exports=RefundComponent;
