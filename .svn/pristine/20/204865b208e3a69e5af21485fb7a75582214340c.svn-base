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
var Widget=require("./../../widget/WidgetComponent");

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
            page:1,
            
            member_id:"0",
            member_account:"",
            baseData:[],

            totalBeans:{}
        };
    }

    componentDidMount() {
        this.getDataByPost(3,homeurl+"systemController.api?getSystemListShows",{list_type:'member'});
        this.getMembers(this.state.page);
        this.getAllMembersCount();
    }
    getAllMembersCount(){
      
        this.getDataByPost(4,homeurl+"memberController.api?getAllMembersCount",{});
    }
    getMembers(page){
        this.getDataByPost(1,homeurl+"memberController.api?getAllMembers",
            {page:page,member_id:this.isNull(this.state.member_id)?"0":this.state.member_id,
                member_account:this.state.member_account},{type:2})
    }

    exportMemberExcel(){
        this.getDataByPost(5,homeurl+"memberController.api?exportMemberExcel",
            {member_id:this.isNull(this.state.member_id)?"0":this.state.member_id,
                member_account:this.state.member_account})
    }
    doSuccess(index,data){
        switch (index){
            case 5:
                toast.show("下载中...");
                window.location.href=homeurl+data;
                break;
            case 4:
                this.setState({
                    totalBeans:data,
                })
                break;
            case 3:
                this.setState({
                    baseData:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMembers();
                break;
            case 1:
                this.setState({
                    memberBeans:data.data,
                    total:data.total,
                })
                break;
        }
    }

    render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteMerchants();
                              }}></TipComponent>
                <Toolbar title="普通用户管理" history={this.props.history}></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="用户ID"
                        value={this.state.member_id}
                        onChange={(value)=>{
                            this.setState({
                                member_id:value
                            })
                        }}/>
                    <EditorComponent
                        title="用户账号"
                        value={this.state.member_account}
                        onChange={(value)=>{
                            this.setState({
                                member_account:value
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={10}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getMembers(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <TextComponent
                        title="会员数"
                        value={this.state.totalBeans.member_count}/>
                </div>
                <div style={{marginTop:20,display:'flex',justifyContent:'flex-end',flex:1,alignItems:'center'}}>
                    <Widget.Button
                        marginRight={20}
                        value="导出"
                        onClick={()=>{
                            this.exportMemberExcel();
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
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/user_member_detail/"+encodeURIComponent(JSON.stringify(this.state.memberBeans[rowID].member_id))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[详情]</p1>
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
