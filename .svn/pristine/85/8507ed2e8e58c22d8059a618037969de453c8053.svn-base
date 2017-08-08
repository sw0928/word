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

var EditorComponent=require("./../../widget/EditorComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");

class AssessmentComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            assessmentBeans:[],
            page:1,
            total:0,
            baseData:[],
            assessment_index:-1,
            goods_name:"",
            goods_id:"",
            merchants_id:"",
            merchants_name:'',
            member_id:"",
            nick_name:"",
            assessment_type:[]
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'assessment_id'},
                {name:"用户ID",flex:1,key:'member_id'},
                {name:"用户昵称",flex:1,key:'nick_name'},
                {name:"订单ID",flex:1,key:"order_id"},
                {name:"商品/商家ID",flex:1,key:"relation_id"},
                {name:"商品/店铺名称",flex:2,key:'name'},

                {name:"评价内容",flex:2,key:'assessment_desc'},
                {name:"评价类型",flex:1,key:"assessment_type_show"},
                {name:"星级1",flex:1,key:"assessment_star1"},
                {name:"星级2",flex:1,key:"assessment_star2"},
                {name:"星级3",flex:1,key:"assessment_star3"},
                {name:"评价时间",flex:1,key:"create_time"},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getAssessments(this.state.page);
    }

    getAssessments(page){
        this.getDataByPost(1,homeurl+"assessmentController.api?getAssessments",
            {page:page,
            merchants_id:this.state.merchants_id,
            merchants_name:this.state.merchants_name,
            goods_id:this.state.goods_id,
            goods_name:this.state.goods_name,
            nick_name:this.state.nick_name,
            member_id:this.state.member_id,
                assessment_type:this.state.assessment_type.toString()},{type:2});
    }

    deleteAssessment(){
        this.getDataByPost(2,homeurl+"assessmentController.api?deleteAssessment",
            {assessment_id:this.state.assessmentBeans[this.state.assessment_index].assessment_id});
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    assessmentBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getAssessments(this.state.page);
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
                                  this.deleteAssessment();
                              }}></TipComponent>
                <Toolbar title="评价管理" history={this.props.history}></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="商品id"
                        value={this.state.goods_id}
                        onChange={(value)=>{
                            this.setState({
                               goods_id:value
                            })
                        }}/>
                    <EditorComponent
                        title="商品名称"
                        value={this.state.goods_name}
                        onChange={(value)=>{
                            this.setState({
                               goods_name:value
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1,
                            })
                            this.getAssessments(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="商家id"
                        value={this.state.merchants_id}
                        onChange={(value)=>{
                                this.setState({
                                   merchants_id:value
                                })
                            }}/>
                    <EditorComponent
                        title="商家名称"
                        value={this.state.merchants_name}
                        onChange={(value)=>{
                                this.setState({
                                   merchants_name:value
                                })
                            }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="用户id"
                        value={this.state.member_id}
                        onChange={(value)=>{
                                this.setState({
                                   member_id:value
                                })
                            }}/>
                    <EditorComponent
                        title="用户昵称"
                        value={this.state.nick_name}
                        onChange={(value)=>{
                                this.setState({
                                   nick_name:value
                                })
                            }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>评价类型</p1>
                    </div>
                    <CheckComponent title="商品评价" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.assessment_type.push("goods");
                                }else{
                                    var index=this.state.assessment_type.indexOf("goods");
                                    this.state.assessment_type.splice(index,1);
                                }

                                this.setState({
                                    assessment_type:this.state.assessment_type,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="商家评价" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.assessment_type.push("merchants");
                                }else{
                                    var index=this.state.assessment_type.indexOf("merchants");
                                    this.state.assessment_type.splice(index,1);
                                }

                                this.setState({
                                    assessment_type:this.state.assessment_type,
                                })
                            }}></CheckComponent>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.assessmentBeans}
                    total={this.state.total}
                    page={this.state.page}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/assessment_detail/"+encodeURIComponent(this.state.assessmentBeans[rowID].assessment_id)}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[详情]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                assessment_index:rowID
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
                        })
                        this.getAssessments(page);
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

module.exports=AssessmentComponent;