/**
 * Created by shenjiabo on 16/11/17.
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
var PageComponent=require("./../../widget/PageComponent");
var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var TextComponent=require('./../../widget/TextComponent');
var ListViewComponent=require("./../../widget/ListViewComponent");
var CheckComponent=require("./../../widget/CheckComponent");
class ProfitComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            page:1,
            total:0,
            profitBeans:[],
            member_id:"",
            user_id:"",
            distribution_relation:[]
        };
    }
    componentDidMount() {
        this.getProfits(this.state.page);
    }

    getProfits(page){
        this.getDataByPost(1,homeurl+"distributionController.api?getProfits"
            ,{page:page,
              member_id:this.state.member_id,
              user_id:this.state.user_id,
              distribution_relation:this.state.distribution_relation.toString()},{type:2});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    profitBeans:data.data,
                    total:data.total
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <Toolbar title="收益管理" history={this.props.history}></Toolbar>
                <div style={{marginTop:20,display:'flex'}}>
                    <EditorComponent
                        title="用户ID"
                        onChange={(value)=>{
                            this.setState({
                                member_id:value,
                            })
                        }}/>
                    <EditorComponent
                        title="消费者ID"
                        onChange={(value)=>{
                            this.setState({
                                user_id:value,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getProfits(1);
                        }}/>
                </div>

                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>关系类型</p1>
                    </div>
                    <CheckComponent title="1级分销" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.distribution_relation.push("vip1");
                                }else{
                                    var index=this.state.distribution_relation.indexOf("vip1");
                                    this.state.distribution_relation.splice(index,1);
                                }

                                this.setState({
                                    distribution_relation:this.state.distribution_relation,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="2级分销" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.distribution_relation.push("vip2");
                                }else{
                                    var index=this.state.distribution_relation.indexOf("vip2");
                                    this.state.distribution_relation.splice(index,1);
                                }

                                this.setState({
                                    distribution_relation:this.state.distribution_relation,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="平台" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.distribution_relation.push("-1");
                                }else{
                                    var index=this.state.distribution_relation.indexOf("-1");
                                    this.state.distribution_relation.splice(index,1);
                                }

                                this.setState({
                                    distribution_relation:this.state.distribution_relation,
                                })
                            }}></CheckComponent>
                </div>
                <ListViewComponent
                    data={[
                            {name:"ID",flex:1,key:'distribution_id'},
                            {name:"用户ID",flex:1,key:'member_id'},
                            {name:"订单号",flex:2,key:'order_id'},
                            {name:"分销关系",flex:1,key:'distribution_relation_show'},
                            {name:"所得佣金",flex:1,key:'distribution_price'},
                            {name:"佣金百分比",flex:1,key:'distribution_percent'},
                            {name:"订单类型",flex:2,key:'distribution_type_show'},
                            {name:"获得时间",flex:1,key:'create_time'},
                            {name:"消费用户ID",flex:1,key:'user_id'},
                            {name:"操作",flex:2,key:"-1"}
                        ]}
                    dataSource={this.state.profitBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    card_index:rowID
                                                })
                                            }}>
                                        <div>
                                            <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                        </div>
                                    </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getProfits(page)
                    }}>
                </ListViewComponent>
            </div>
        )
    }
}
const styles = {
    item:{
        flex:1,
        display:'flex',
        borderLeftWidth:1,
        borderTopWidth:1,
        borderLeftColor:'#efefef',
        borderTopColor:'#efefef',
        borderLeftStyle:'solid',
        borderTopStyle:'solid',
        flexDirection:'column',
        marginLeft:10,
        marginRight:10,
        marginTop:10
    },
    tabColumn: {
        flex: 1,
        display:'flex',
        flexDirection: 'column',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabRow: {
        flex: 1,
        display:'flex',
        flexWrap:'wrap',
        flexDirection: 'row',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabP1:{
        fontSize:15,
        wordBreak:'break-all'
    },
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
};
module.exports=ProfitComponent;