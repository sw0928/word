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
        var info=storage.get("merchantsAccountBean");
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
            merchants_id:JSON.parse((info===null?"{}":info)).merchants_id,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'cash_id'},
                {name:"商家ID",flex:1,key:'merchants_id'},
                {name:"商家名称",flex:1,key:"merchants_name"},
                {name:"提现时间",flex:1,key:'cash_time'},
                {name:"提现金额",flex:1,key:'cash_price'},
                {name:"银行名称",flex:1,key:'brank_name'},
                {name:"银行卡号",flex:1,key:'brank_code'},
                {name:"开户行",flex:1,key:'brank_open_name'},
                {name:"开户人",flex:1,key:'brank_open_usr'},
                {name:"开户手机",flex:1,key:'brank_open_mobile'},
                {name:"提现状态",flex:1,key:'apply_state_show'},
                {name:"申请时间",flex:1,key:'create_time'}
            ]
        })
        this.getCashApplys(this.state.page);
    }

    getCashApplys(page){
        this.getDataByPost(1,homeurl+"financeController.api?getAllCashApplys",
            {merchants_id:this.state.merchants_id
                ,page:page},{type:2});
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
                <div style={{display:'flex',marginTop:20,alignItems:'center',justifyContent:'flex-end'}}>
                    <ButtonComponent
                        marginRight={20}
                        value="申请提现"
                        onClick={()=>{
                            this.props.history.push("/finance_merchants_apply_cash")
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.cashBeans}
                    page={this.state.page}
                    total={this.state.total}
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
