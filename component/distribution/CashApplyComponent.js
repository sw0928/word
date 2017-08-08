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

class CashApplyComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            cashBeans:[],
            baseData:[],
            total:0,
            page:1,
            click_index:1,
            visible:false,
            apply_index:0,
            merchants_name:"",
            apply_state:[],
            start_time:"",
            end_time:"",
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'cash_id'},
                {name:"用户ID",flex:1,key:'merchants_id'},
                {name:"用户昵称",flex:1,key:"merchants_name"},
                {name:"提现时间",flex:1,key:'cash_time'},
                {name:"提现金额",flex:1,key:'cash_price'},
                {name:"银行名称",flex:1,key:'brank_name'},
                {name:"银行卡号",flex:1,key:'brank_code'},
                {name:"开户行",flex:1,key:'brank_open_name'},
                {name:"开户人",flex:1,key:'brank_open_usr'},
                {name:"开户手机",flex:1,key:'brank_open_mobile'},
                {name:"申请状态",flex:1,key:'apply_state_show'},
                {name:"申请时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getCashApplys(this.state.page);
    }

    getCashApplys(page){
        this.getDataByPost(1,homeurl+"financeController.api?getAllCashApplysMemberZSSG",
            {merchants_name:this.state.merchants_name,
                apply_state:this.state.apply_state.toString(),
                start_time:this.state.start_time,
                end_time:this.state.end_time,
                page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    cashBeans:data.data,
                    total:data.total,
                });
                break;
            case 2:
                toast.show("操作成功");
                this.getCashApplys(this.state.page)
                break;
        }
    }

    updateApplyState(){
        this.getDataByPost(2,homeurl+"financeController.api?updateApplyState",
            {cash_id:this.state.cashBeans[this.state.apply_index].cash_id,
                apply_state:this.state.click_index===1?"accept":(this.state.click_index===2?"refuse":"end")});
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Toolbar title="提现申请" history={this.props.history}></Toolbar>
                <TipComponent visible={this.state.visible} msg={this.state.click_index===1?"确定通过?":(this.state.click_index===2?"确认不通过?":"确认打款了?")}
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
                              }}></TipComponent>
                <div style={{display:'flex',marginTop:20,alignItems:'center'}}>
                    <EditorComponent
                        title="关键词"
                        placeholder="用户昵称"
                        value={this.state.merchants_name}
                        onChange={(value)=>{
                            this.setState({
                                merchants_name:value,
                            })
                        }}/>
                    <p1 style={{fontSize:13,marginLeft:10}}>申请时间</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD HH:mm:ss"
                        defaultValue={this.state.start_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                                   this.setState({
                                       start_time:dateString,
                                   })
                                }}
                    />
                    <p1 style={{fontSize:13,marginLeft:10}}>~</p1>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD HH:mm:ss"
                        defaultValue={this.state.end_time}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                                   this.setState({
                                       end_time:dateString,
                                   })
                                }}
                    />
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.getCashApplys(this.state.page);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:"center"}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>审核状态</p1>
                    </div>
                    <CheckComponent title="待审核" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.apply_state.push("wait_review");
                                }else{
                                    var index=this.state.apply_state.indexOf("wait_review");
                                    this.state.apply_state.splice(index,1);
                                }

                                this.setState({
                                    apply_state:this.state.apply_state,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="审核通过" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.apply_state.push("accept");
                                }else{
                                    var index=this.state.apply_state.indexOf("accept");
                                    this.state.apply_state.splice(index,1);
                                }

                                this.setState({
                                    apply_state:this.state.apply_state,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="审核拒绝" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.apply_state.push("refuse");
                                }else{
                                    var index=this.state.apply_state.indexOf("refuse");
                                    this.state.apply_state.splice(index,1);
                                }

                                this.setState({
                                    apply_state:this.state.apply_state,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="已打款" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.apply_state.push("end");
                                }else{
                                    var index=this.state.apply_state.indexOf("end");
                                    this.state.apply_state.splice(index,1);
                                }

                                this.setState({
                                    apply_state:this.state.apply_state,
                                })
                            }}></CheckComponent>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.cashBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        let view=[];
                        if(this.state.cashBeans[rowID].apply_state==="wait_review"){
                           view.push(<div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                apply_index:rowID,
                                                click_index:1,
                                            })
                                            }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[通过]</p1>
                                    </div>);
                           view.push(<div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                apply_index:rowID,
                                                click_index:2,
                                            })
                                            }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[不通过]</p1>
                                    </div>);
                        }else if(this.state.cashBeans[rowID].apply_state==="accept"){
                           view.push(<div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                apply_index:rowID,
                                                click_index:3,
                                            })
                                            }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[确认打款]</p1>
                                    </div>);
                        }
                        return(
                            <div style={{display:'flex',flex:1}}>
                                {view}
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getCashApplys(page)
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
module.exports=CashApplyComponent;
