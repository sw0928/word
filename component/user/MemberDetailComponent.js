/**
 * Created by shenjiabo on 16/10/21.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import Upload from 'rc-upload';
var Toolbar=require("./../../widget/Toolbar");

var TabBar=require('./../../widget/TabBar');

var TextComponent=require('./../../widget/TextComponent');
var EditorComponent=require('./../../widget/EditorComponent');
var CheckComponent=require('./../../widget/CheckComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var SelectComponent=require('./../../widget/SelectComponent');
var ImgComponent=require('./../../widget/ImgComponent');
var SearchBar=require("./../../widget/SearchBar");
var ViewComponent=require("./../../widget/ViewComponent");

var Widget=require('./../../widget/WidgetComponent');

import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'

var MemberShopCarComponent=require("./MemberShopCarComponent");
var MemberOrderComponent=require("./MemberOrderComponent");


class  MemberDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            member_id:this.props.params.member_id,
            moudleBeans:[],
        };
    }

    componentDidMount() {
        this.setState({
            moudleBeans:[{"name":"基本信息",component:this.renderBase()},
                {"name":"购物车",component:this.renderCar()},
                {"name":"订单",component:this.renderOrder()},
            ]
        })
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchantsNopage",{});
    }

    render(){
        return(
            <div>
                <Toolbar title="用户详情" history={this.props.history}></Toolbar>
                <TabBar saveIndex="memberIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}></TabBar>
            </div>
        )
    }

    renderBase(){
        return(
            <BaseDetailComponent member_id={this.state.member_id}></BaseDetailComponent>
        )
    }

    renderCar(){
        return(
            <MemberShopCarComponent member_id={this.state.member_id}>

            </MemberShopCarComponent>
        )
    }

    renderOrder(){
        return(
            <MemberOrderComponent member_id={this.state.member_id}></MemberOrderComponent>
        )
    }
}


import {RadioGroup, Radio} from 'react-radio-group'

class BaseDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            member_id:this.props.member_id,
            memberBean:{},
            uploaderProps :{
                action: homeurl+'memberController.api?updateMemberImg',
                data: {},
                headers: {
                    Authorization: 'xxxxxxx',
                },
                multiple: false,
                beforeUpload(file) {
                    console.log('beforeUpload', file.name);
                },
                onStart: (file) => {
                    console.log('onStart', file.name);
                },
                onProgress(step, file) {
                    console.log('onProgress', Math.round(step.percent), file.name);
                },
                onError(err) {
                    console.log('onError', err);
                    toast.show("上传失败");
                },
            },

            allMerchantsBeans:[],
            selectBean:{},
            merchants_name:'',


            allMerchantsAccountBeans:[],
            merchantsAccountBeans:[],
            selectAccountBean:{},
            merchants_account_name:'',

            detailBean:{},
            password:"",
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"memberController.api?getOneMemberDetail",{member_id:this.state.member_id});
        this.getDataByPost(4,homeurl+"systemController.api?getSystemDetailShows",{detail_type:"member_detail"});
    }

    doSuccess(index,data){
        switch (index){
            case 4:
                this.setState({
                    detailBean:JSON.parse(data),
                })
                break;
            case 1:
                this.setState({
                    memberBean:data,
                    merchants_id:data.business_id,
                    merchants_account_id:data.merchants_account_id
                })
                this.getDataByPost(3,homeurl+"merchantsController.api?getAllMerchantsNopage",{merchants_type:'3'});
                break;
            case 2:
                toast.show("保存成功");
                break;
            case 3:
                this.setState({
                    allMerchantsBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["merchants_id"]+""===this.state.merchants_id+"";
                    }.bind(this));

                    if(d.length>0){
                        this.setState({
                            selectBean: d[0],
                            merchants_name:d[0].merchants_name,
                        })
                    }
                }
                this.getDataByPost(5,homeurl+"merchantsController.api?getAllMerchantsAccountNopage",{merchants_type:'3'});
                break;
            case 5:
                var merchantsAccountBeans=data.filter(function(item){
                        return item["merchants_id"]+""===this.state.selectBean.merchants_id+"";
                    }.bind(this));
                this.setState({
                    allMerchantsAccountBeans:data,
                    merchantsAccountBeans:merchantsAccountBeans
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["merchants_account_id"]+""===this.state.merchants_account_id+"";
                    }.bind(this));

                    if(d.length>0){
                        this.setState({
                            selectAccountBean: d[0],
                            merchants_account_name:d[0].merchants_name,
                        })
                    }
                }
                break;
            case 6:
                this.showTip("解绑成功");
                this.state.memberBean.stored_code='';
                this.setState({
                    memberBean:this.state.memberBean
                })
                break;
            case 7:
                this.showTip("绑定成功");
                break;
            case 8:
                this.showTip("更改成功");
                break;
        }
    }
    deleteMemberStored(){
        this.getDataByPost(6,homeurl+"memberController.api?deleteMemberStored",{member_id:this.state.memberBean.member_id,});
    }

    bindMemberStored(){
        if(this.isNull(this.state.memberBean.stored_code)){
            this.showTip("请先填写储值卡号");
        }
        if(this.isNull(this.state.password)){
            this.showTip("请先填写密码");
        }
        this.getDataByPost(7,homeurl+"memberController.api?bindMemberStored",
            {member_id:this.state.memberBean.member_id,
                stored_code:this.state.memberBean.stored_code,
            password:this.state.password});
    }


    updateMemberDetail(){
        this.getDataByPost(2,homeurl+"memberController.api?updateMemberDetail",
                                            {member_id:this.state.member_id,
                                            nick_name:this.state.memberBean.nick_name,
                                            phone:this.state.memberBean.phone,
                                            integral:this.state.memberBean.integral,
                                            position:this.state.memberBean.position,
                                            hobby:this.state.memberBean.hobby,
                                            age:this.state.memberBean.age,
                                            sex:this.state.memberBean.sex,
                                            merchants_no:this.state.memberBean.merchants_no,
                                            head_path:this.state.memberBean.head_path,
                                            backgroup_img:this.state.memberBean.backgroup_img,
                                            business_id:this.state.selectBean.merchants_id?this.state.selectBean.merchants_id:"-1",
                                            merchants_account_id:this.state.selectAccountBean.merchants_account_id?this.state.selectAccountBean.merchants_account_id:"-1",
                                            member_level:this.state.memberBean.member_level,
                                            trust_balance:this.state.memberBean.trust_balance,
                                            balance:this.state.memberBean.balance});
    }

    render(){
        return(
            <div>
                <ButtonComponent value="保存"
                                 width={80}
                                 marginLeft={100}
                                 marginTop={20}
                                 onClick={()=>{
                                            this.updateMemberDetail();
                                         }}>
                </ButtonComponent>
                <div style={{display:'flex',marginTop:20}}>
                    <TextComponent title="用户ID"
                                value={this.state.member_id}>

                    </TextComponent>
                    <TextComponent title="用户账号"
                                   value={this.state.memberBean.member_account}>

                    </TextComponent>
                    <CheckComponent
                        title="禁用"
                        value={this.state.memberBean.is_delete}
                        onClick={(value)=>{
                                this.state.memberBean.is_delete=value;
                                this.setState({
                                    memberBean:this.state.memberBean
                                })
                        }}/>
                </div>

                <div style={{display:'flex',alignItems:'center',height:120}}>
                    <ImgComponent
                        title="用户头像"
                        src={imgurl+this.state.memberBean.head_path}
                        url={homeurl+'memberController.api?updateMemberImg'}
                        onSuccess={(data)=>{
                                this.state.memberBean.head_path=data;
                                this.setState({
                                    memberBean:this.state.memberBean
                                })
                        }}/>
                    <ImgComponent
                        title="个人中心背景图"
                        src={imgurl+this.state.memberBean.backgroup_img}
                        url={homeurl+'memberController.api?updateMemberImg'}
                        onSuccess={(data)=>{
                                this.state.memberBean.backgroup_img=data;
                                this.setState({
                                    memberBean:this.state.memberBean
                                })
                        }}/>
                </div>

                <div style={{display:'flex',marginTop:20}}>
                    <EditorComponent
                        title="用户昵称"
                        value={this.state.memberBean.nick_name}
                        onChange={(value)=>{
                            this.state.memberBean.nick_name=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        title="手机号"
                        value={this.state.memberBean.phone}
                        onChange={(value)=>{
                            this.state.memberBean.phone=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}>

                    </EditorComponent>

                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="用户积分"
                        value={this.state.memberBean.integral}
                        onChange={(value)=>{
                            this.state.memberBean.integral=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}/>
                    <EditorComponent
                        title="用户余额"
                        value={this.state.memberBean.balance}
                        onChange={(value)=>{
                            this.state.memberBean.balance=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}/>
                    <EditorComponent
                        title="信用额度"
                        value={this.state.memberBean.trust_balance}
                        onChange={(value)=>{
                            this.state.memberBean.trust_balance=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="位置"
                        value={this.state.memberBean.position}
                        onChange={(value)=>{
                            this.state.memberBean.position=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })

                        }}>
                    </EditorComponent>

                    <EditorComponent
                        title="兴趣爱好"
                        value={this.state.memberBean.hobby}
                        onChange={(value)=>{
                            this.state.memberBean.hobby=value;
                            this.setState({
                                memberBean:this.state.memberBean
                            })
                        }}>

                    </EditorComponent>

                    <TextComponent
                        title="注册时间"
                        value={this.state.memberBean.create_time}>
                    </TextComponent>
                </div>

                <div style={{display:'flex',height:50,alignItems:'center',marginTop:20}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>性别</p1>
                    </div>
                    <RadioGroup
                                style={{marginLeft:10}}
                                name="fruit"
                                selectedValue={this.state.memberBean.sex}
                                onChange={(value)=>{
                                    console.log(this.state.memberBean.age);
                                    this.state.memberBean.sex=value;
                                    this.setState({
                                        memberBean:this.state.memberBean
                                    })
                                }}>
                        <Radio value="m" />男
                        <Radio value="w" />女
                    </RadioGroup>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>年龄</p1>
                    </div>
                    <DateField
                        style={{marginLeft:10}}
                        dateFormat="YYYY-MM-DD HH:mm:ss"
                        value={this.state.memberBean.age}
                        onChange={(dateString, { dateMoment, timestamp })=>{
                                    this.state.memberBean.age=dateString;
                                    this.setState({
                                        memberBean:this.state.memberBean
                                    })
                                }}
                    />
                </div>

            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        height:50,
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
        fontSize:15,
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    },
}

module.exports=MemberDetailComponent;