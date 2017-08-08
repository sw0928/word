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
var Toolbar=require("./../../widget/Toolbar");
var PageComponent=require("./../../widget/PageComponent");

var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var TextComponent=require('./../../widget/TextComponent');
var ListViewComponent=require("./../../widget/ListViewComponent");

class MemberComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            memberBeans:[],
            visible:false,
            member_index:0,
            total:0,
            page:storage.get("distribution_page")?storage.get("distribution_page"):1,
            member_id:storage.get("distribution_member_id")?storage.get("distribution_member_id"):"0",
            member_account:storage.get("distribution_member_account")?storage.get("distribution_member_account"):"",
            nick_name:storage.get("distribution_nick_name")?storage.get("distribution_nick_name"):"",
            baseData:[],
            unTotalDistributionBean:{},
            totalDistributionBean:{},
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'member_id'},
                {name:"账号",flex:1,key:'member_account'},
                {name:"昵称",flex:1,key:'nick_name'},
                {name:"vip开始时间",flex:1,key:'vip_start_time'},
                {name:"vip截止时间",flex:1,key:'vip_end_time'},
                {name:"注册时间",flex:1,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getMembers(this.state.page);
        // this.getTotalUnDistributionsCount();
        // this.getTotalDistributionsCount();
    }

    getTotalDistributionsCount(){
        this.getDataByPost(4,homeurl+"distributionController.api?getTotalDistributionsCount",{});
    }

    getTotalUnDistributionsCount(){
        this.getDataByPost(3,homeurl+"distributionController.api?getTotalUnDistributionsCount",{});
    }

    getMembers(page){
        if(isNaN(this.state.member_id)){
            toast.show("用户id非法");
            return;
        }

        storage.set("distribution_page",page);
        storage.set("distribution_member_id",this.state.member_id);
        storage.set("distribution_member_account",this.state.member_account);
        storage.set("distribution_nick_name",this.state.nick_name);

        this.getDataByPost(1,homeurl+"memberController.api?getAllMembersZSSG",
            {page:page,member_id:this.state.member_id===''?"0":this.state.member_id,
                member_account:this.state.member_account,
                nick_name:this.state.nick_name},{type:2})
    }
    exportDistributions(rowID){
        this.getDataByPost(5,homeurl+"distributionController.api?exportUnDistributions",
            {type:this.state.type,member_id:this.state.memberBeans[rowID].member_id});
    }

    exportAllDistributions(){
        this.getDataByPost(6,homeurl+"distributionController.api?exportAllDistributon",
            {});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    memberBeans:data.data,
                    total:data.total,
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMembers();
                break;
            case 3:
                this.setState({
                    unTotalDistributionBean:data
                })
                break;
            case 4:
                this.setState({
                    totalDistributionBean:data
                })
                break;
            case 5:
                toast.show("导出已准备好");
                window.location.href=homeurl+data;
                break;
            case 6:
                toast.show("导出已准备好");
                window.location.href=homeurl+data;
                break;
        }
    }
    // <div style={{display:'flex',alignItems:'center',marginTop:20}}>
    // <TextComponent
    // title="非vip用户数"
    // value={this.state.unTotalDistributionBean.total_count}/>
    // <TextComponent
    // title="待收益总金额"
    // value={this.state.unTotalDistributionBean.total_price}/>
    //
    // </div>
    // <div style={{display:'flex',alignItems:'center',marginTop:20}}>
    // <TextComponent
    // title="svip用户"
    // value={this.state.totalDistributionBean.total_count}/>
    // <TextComponent
    // title="收益金额"
    // value={this.state.totalDistributionBean.total_price}/>
    // </div>
    // <div style={{display:'flex',alignItems:'center',marginTop:20}}>
    // <TextComponent
    // title="使用激活卡人数"
    // value={this.state.totalDistributionBean.total_card_count}/>
    // </div>
     render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <Toolbar title="分销详情" history={this.props.history}></Toolbar>

                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="用户ID"
                        value={this.state.member_id}
                        onChange={(value)=>{
                            this.setState({
                                member_id:value
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        title="用户账号"
                        value={this.state.member_account}
                        onChange={(value)=>{
                            this.setState({
                                member_account:value
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        title="昵称"
                        value={this.state.nick_name}
                        onChange={(value)=>{
                            this.setState({
                                nick_name:value
                            })
                        }}>

                    </EditorComponent>
                    <ButtonComponent
                        marginLeft={10}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getMembers(1);
                        }}>

                    </ButtonComponent>
                </div>
                <div style={{display:'flex',alignItems:'center',justifyContent:'flex-end',marginTop:20}}>
                    <ButtonComponent
                        marginLeft={10}
                        value="统计导出"
                        onClick={()=>{
                            this.exportAllDistributions();
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.memberBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.exportDistributions(rowID);
                                            }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[统计导出]</p1>
                                    </div>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/distribution_detail1/"+this.state.memberBeans[rowID].member_id+"/vip1"}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[一级详情]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/distribution_detail1/"+this.state.memberBeans[rowID].member_id+"/vip2"}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[二级详情]</p1>
                                        </Link>
                                    </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getMembers(page)
                    }}/>
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
    }
};

module.exports=MemberComponent;
