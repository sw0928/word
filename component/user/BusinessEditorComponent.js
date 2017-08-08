/**
 * Created by shenjiabo on 16/8/24.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var TabBar=require('./../../widget/TabBar');
var Toolbar=require("./../../widget/Toolbar");
import Upload from 'rc-upload';

var TextComponent=require("./../../widget/TextComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var SelectComponent=require("./../../widget/SelectComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");

var MerchantsAccountComponent=require("./MerchantsAccountComponent");
var BusinessMemberComponent=require("./BusinessMemberComponent");

class MerchantsEditorComponent extends BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsBean=JSON.parse(decodeURIComponent(this.props.params.merchantsBean));
        this.state = {
            merchantsBean:merchantsBean,
            moudleBeans:[],
            index:0,
        }
    }

    componentDidMount() {
        this.setState({
            moudleBeans:[
                {"name":"基本信息",component:this.renderBase()},
                {"name":"账号分配",component:this.renderMerchantsAccount()},
                {"name":"顾客列表",component:this.renderMember()},
            ]
        })
    }
    render(){
        return(
            <div>
                <Toolbar title="店铺详情管理" history={this.props.history}></Toolbar>
                <TabBar saveIndex="merchantsIndex"
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
            <MerchantsBaseDetailComponent
                history={this.props.history}
                merchants_type="3"
                merchantsBean={this.state.merchantsBean}>

            </MerchantsBaseDetailComponent>
        );
    }

    renderMember(){
        return(
            <BusinessMemberComponent
                merchants_id={this.state.merchantsBean.merchants_id}/>
        )
    }

    renderMerchantsAccount(){
        return(
            <MerchantsAccountComponent
                merchants_type="3"
                merchantsBean={this.state.merchantsBean}
                history={this.props.history}>

            </MerchantsAccountComponent>
        );
    }
}

var province_index=-1;
var state_index=-1;

class MerchantsBaseDetailComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsBean=this.props.merchantsBean;
        this.state = {
            stateBeans: [{state_id: "0", name: "关闭"}, {state_id: "1", name: "开启"}],
            state_id:0,
            provinceBeans: [{provice_id: "0", name: "上海"}, {provice_id: "1", name: "北京"}],
            provice_id:0,
            merchantsBean:merchantsBean,
            merchants_name:merchantsBean.merchants_name,
            merchants_address:merchantsBean.merchants_address,
            merchants_province:merchantsBean.merchants_province,
            contact_name:merchantsBean.contact_name,
            contact_mobile:merchantsBean.contact_mobile,
            merchants_state:merchantsBean.merchants_state?merchantsBean.merchants_state:"0",
            express_full_price:100,
            uploaderProps :{
                action: homeurl+'merchantsController.api?uploadMerchantsImg',
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

            click_index:0,
        }
    }

    insertMerchants(){
        if(this.state.merchants_name===''){
            toast.show("商家名称不可为空");
            return;
        }
        if(province_index===-1){
            toast.show("请选择所属地");
            return;
        }
        if(this.state.merchants_address===''){
            toast.show("请填写详细地址");
            return;
        }
        if(this.state.contact_name===''){
            toast.show("请填写联系人");
            return;
        }
        if(this.state.contact_mobile===''){
            toast.show("请填写联系电话");
            return;
        }
        if(state_index===-1){
            toast.show("请选择状态");
            return;
        }
        if(this.state.merchantsBean.merchants_img===''){
            toast.show("请先上传展示图片");
            return;
        }

        if(!this.state.merchantsBean.merchants_id){
            this.getDataByPost(1,homeurl+"merchantsController.api?insertMerchantDetail",
                {merchants_name:this.state.merchants_name,
                    merchants_province:this.state.provinceBeans[province_index].name,
                    merchants_address:this.state.merchants_address,contact_name:this.state.contact_name,
                    contact_mobile:this.state.contact_mobile,
                    merchants_state:this.state.stateBeans[state_index].state_id,
                    merchants_type:"3",express_full_price:this.state.express_full_price,
                    merchants_img:this.state.merchantsBean.merchants_img,
                    apply_state:'1'});
        }else{
            this.getDataByPost(2,homeurl+"merchantsController.api?updateMerchantDetail",
                {merchants_id:this.state.merchantsBean.merchants_id,merchants_name:this.state.merchants_name,
                    merchants_province:this.state.provinceBeans[province_index].name,
                    merchants_address:this.state.merchants_address,contact_name:this.state.contact_name,
                    contact_mobile:this.state.contact_mobile,
                    merchants_state:this.state.stateBeans[state_index].state_id,
                    merchants_type:"3",express_full_price:this.state.express_full_price,
                    merchants_img:this.state.merchantsBean.merchants_img,
                    apply_state:'1'});
        }
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
            case 3:
                toast.show("操作成功");
                this.state.merchantsBean.apply_state=this.state.click_index===0?"1":"2";
                this.setState({
                    merchantsBean:this.state.merchantsBean
                })
                break;
        }
    }

    auditingApplyMerchants(){
        this.getDataByPost(3,homeurl+"merchantsController.api?auditingApplyMerchants",
            {merchants_id:this.state.merchantsBean.merchants_id,
                apply_state:this.state.click_index===0?"1":"2"});
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <TipComponent visible={this.state.visible} msg={this.state.click_index===0?"确认通过?":"确认拒绝?"}
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.setState({
                                        visible:false
                                  })
                                  this.auditingApplyMerchants();
                              }}></TipComponent>
                <ButtonComponent
                    value="保存"
                    width={100}
                    marginTop={20}
                    marginLeft={100}
                    onClick={()=>{
                        this.insertMerchants();
                    }}/>
                <div style={{display:'flex',alignItems:'center'}}>
                    <EditorComponent title="供应商名称"
                                     value={this.state.merchants_name}
                                     onChange={(value)=>{
                                    this.setState({
                                        merchants_name:value,
                                    })
                                }}></EditorComponent>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>图片展示</p1>
                    </div>
                    <Upload {...this.state.uploaderProps} ref="inner" style={{outline:'none'}}
                                                          onSuccess={(data)=>{
                                                if(data.status==='ok'){
                                                    this.state.merchantsBean.merchants_img=data.data;
                                                    this.setState({
                                                        merchantsBean:this.state.merchantsBean,
                                                    })
                                                }else{
                                                    toast.show(data.error);
                                                }
                                            }}>
                        <div style={{width:80,height:80,marginLeft:10}}>
                            <img src={this.state.merchantsBean.merchants_img?(imgurl+this.state.merchantsBean.merchants_img):"'./images/add.jpg'"}
                                 style={{width:80,height:80}}/>
                        </div>
                    </Upload>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <TextComponent
                        title="申请状态"
                        value={this.state.merchantsBean.apply_state==='0'?"待审核":
                                (this.state.merchantsBean.apply_state==='1'?"已通过":"已拒绝")}>
                    </TextComponent>
                    <ButtonComponent
                        visible={this.state.merchantsBean.apply_state==='0'?"true":"false"}
                        value="接受"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                click_index:0,
                                visible:true,
                            })
                        }}>
                    </ButtonComponent>
                    <ButtonComponent
                        visible={this.state.merchantsBean.apply_state==='0'?"true":"false"}
                        value="拒绝"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                click_index:1,
                                visible:true,
                            })
                        }}>
                    </ButtonComponent>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <SelectComponent
                        dataSource={this.state.provinceBeans}
                        title="所在区域"
                        init_value={this.state.merchants_province}
                        select_value="name"
                        show_value="name"
                        onChange={(rowID)=>{
                                        province_index=rowID
                                     }}>
                    </SelectComponent>
                    <EditorComponent title="具体地址"
                                     value={this.state.merchants_address}
                                     onChange={(value)=>{
                                    this.setState({
                                        merchants_address:value,
                                    })
                                }}></EditorComponent>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent title="联系人"
                                     value={this.state.contact_name}
                                     onChange={(value)=>{
                                    this.setState({
                                        contact_name:value,
                                    })
                                }}></EditorComponent>
                    <EditorComponent title="联系电话"
                                     value={this.state.contact_mobile}
                                     onChange={(value)=>{
                                    this.setState({
                                        contact_mobile:value,
                                    })
                                }}></EditorComponent>
                </div>
                <SelectComponent
                    marginTop={20}
                    dataSource={this.state.stateBeans}
                    title="上货状态"
                    init_value={this.state.merchants_state}
                    select_value="state_id"
                    show_value="name"
                    onChange={(rowID)=>{
                                        state_index=rowID
                                     }}>
                </SelectComponent>
            </div>
        )
    }
}

var styles = {
    div:{
        marginLeft:10,
        height:40,
        display:'flex',
        alignItems:'center'
    },
    div1:{
        display:'flex',
        width:150,
        alignItems:'center',
        justifyContent:'flex-end'
    },
    input:{
        width:300,
        marginLeft:20,
        borderRadius:10,
        height:25
    }, button:{
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

module.exports=MerchantsEditorComponent;


