/**
 * Created by shenjiabo on 16/8/17.
 * 1级分销用户
 *
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
            page:1,

            member_id:"0",
            member_account:"",
            baseData:[],
            count:this.props.count
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'member_id'},
                {name:"账号",flex:1,key:'member_account'},
                {name:"昵称",flex:1,key:'nick_name'},
                {name:"手机号",flex:1,key:'mobile'},
                {name:"头像",flex:1,key:"head_path",type:'img'},
                {name:"vip开始时间",flex:1,key:'vip_start_time'},
                {name:"vip截止时间",flex:1,key:'vip_end_time'},
                {name:"注册时间",flex:1,key:'create_time'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getMembers(this.state.page);
    }

    getMembers(page){
        if(isNaN(this.state.member_id)){
            toast.show("用户id非法");
            return;
        }
        this.getDataByPost(1,homeurl+"memberController.api?getDistributionMembers",
            {
                user_id:this.props.member_id,
                page:page,member_id:this.state.member_id===''?"0":this.state.member_id,
                member_account:this.state.member_account},{type:2})
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
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="用户ID"
                        onChange={(value)=>{
                            this.setState({
                                member_id:value
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        title="用户账号"
                        onChange={(value)=>{
                            this.setState({
                                member_account:value
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
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.memberBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/distribution_member_detail2/"+encodeURIComponent(JSON.stringify(this.state.memberBeans[rowID].member_id))+"/"+(parseInt(this.state.count)+1)}
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
