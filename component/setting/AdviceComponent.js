/**
 * Created by shenjiabo on 16/11/9.
 */

import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');

var Toolbar=require("./../../widget/Toolbar");
var PageComponent=require("./../../widget/PageComponent");
var ListViewComponent=require("./../../widget/ListViewComponent");

var ButtonComponent=require("./../../widget/ButtonComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var CheckComponent=require("./../../widget/CheckComponent");


class AdviceComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            adviceBeans:[],
            page:1,
            total:0,
            baseData:[],
            advice_type:[],
            advice_id:"0",
            advice_index:0,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'advice_id'},
                {name:"用户ID",flex:1,key:'member_id'},
                {name:"用户昵称",flex:1,key:'nick_name'},
                {name:"标题",flex:2,key:'advice_title'},
                {name:"内容",flex:3,key:'advice_desc'},
                {name:"意见类型",flex:1,key:'advice_type_show'},
                {name:"反馈时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getAdvices(this.state.page)
    }

    getAdvices(page){
        this.getDataByPost(1,homeurl+"othersController.api?getAdvices",
            {page:page,
             advice_type:this.state.advice_type.toString(),
                advice_id:this.state.advice_id},{type:2});
    }

    deleteAdvice(){
        this.getDataByPost(2,homeurl+"othersController.api?deleteAdvice",
            {advice_id:this.state.adviceBeans[this.state.advice_index].advice_id});
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    adviceBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getAdvices(this.state.page)
                break;
        }
    }
    render(){
        return(
            <div>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.setState({
                                    visible:false
                                  })
                                  this.deleteAdvice();
                              }}></TipComponent>
                <Toolbar title="意见反馈" history={this.props.history}></Toolbar>
                <div style={{marginTop:20,display:'flex'}}>
                    <EditorComponent
                        title="ID"
                        onChange={(value)=>{
                            this.setState({
                                advice_id:value===''||isNaN(value)?"0":value,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getAdvices(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>意见类型</p1>
                    </div>
                    <CheckComponent title="意见反馈" checked={this.state.advice1}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.advice_type.push("advice");
                                }else{
                                    var index=this.state.advice_type.indexOf("advice");
                                    this.state.advice_type.splice(index,1);
                                }

                                this.setState({
                                    advice_type:this.state.advice_type,
                                    advice1:checked
                                })
                            }}/>
                    <CheckComponent title="投诉" checked={this.state.advice2}
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.advice_type.push("complaint");
                                }else{
                                    var index=this.state.advice_type.indexOf("complaint");
                                    this.state.advice_type.splice(index,1);
                                }

                                this.setState({
                                    advice_type:this.state.advice_type,
                                    advice2:checked
                                })
                            }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.adviceBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/setting_advice_detail/"+encodeURIComponent(JSON.stringify(this.state.adviceBeans[rowID].advice_id))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[详情]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    advice_index:rowID
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
                        this.getAdvices(page)
                    }}>
                </ListViewComponent>
            </div>
        );
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
module.exports=AdviceComponent;