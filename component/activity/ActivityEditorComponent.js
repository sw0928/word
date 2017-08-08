/**
 * Created by shenjiabo on 16/8/26.
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

var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var ImgComponent=require('./../../widget/ImgComponent');
var TextareaComponent=require('./../../widget/TextareaComponent');
var SearchBar=require("./../../widget/SearchBar");
var SelectComponent=require("./../../widget/SelectComponent");

var Widget=require("./../../widget/WidgetComponent");

class ActivityEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            activity_id: this.props.activity_id,
            activityBean: {
                activity_type: 'give',
                giveBean: {},
                reduceBean: {},
                giftBean: {},
                halfBean: {},
                exemptBean: {}
            },
            typeBeans: [{name: "满送活动", id: 'give'},
                {name: "满减活动", id: 'reduce'},
                {name: '送礼物', id: 'gift'},
                {name: '半价活动', id: 'half'},
                {name: '减免活动', id: 'exempt'}],
            stateBeans: [{name: "关闭", id: '0'}, {name: "开启", id: '1'}],
        }
        ;
    }

    componentDidMount() {
        if(this.state.activity_id){
            this.getActivityDetail();
        }
    }

    getActivityDetail(){
        this.getDataByPost(1,homeurl+"activityController.api?getActivityDetail"
            ,{activity_id:this.state.activity_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    activityBean:data
                })
                break;
            case 2:
                this.showTip("修改成功");
                break;
            case 3:
                this.showTip("修改成功");
                this.props.history.goBack();
                break;
        }
    }


    insertActivityDetail(){
        if(this.isNull(this.state.activityBean.activity_name)){
            toast.show("名称不可空");
            return;
        }
        if(this.state.activityBean.activity_type===""){
            toast.show("请先选择类型");
            return;
        }

        if(this.state.activityBean.activity_type==='give'){
            if(isNaN(this.state.activityBean.giveBean.give_need_count)){
                this.showTip("需要件数非法");
                return;
            }
            if(isNaN(this.state.activityBean.giveBean.give_count)){
                this.showTip("赠送件数非法");
                return;
            }
        }else  if(this.state.activityBean.activity_type==='reduce'){
            if(isNaN(this.state.activityBean.reduceBean.reduce_need_price)){
                this.showTip("需要金额非法");
                return;
            }
            if(isNaN(this.state.activityBean.reduceBean.reduce_price)){
                this.showTip("减免金额非法");
                return;
            }
        }else if(this.state.activityBean.activity_type==='gift'){
            if(isNaN(this.state.activityBean.giftBean.gift_need_price)){
                this.showTip("需要金额非法");
                return;
            }
        }else if(this.state.activityBean.activity_type==='half'){
            if(isNaN(this.state.activityBean.halfBean.half_count)){
                this.showTip("半价件数非法");
                return;
            }
        }

        if(this.state.activity_id){
            this.getDataByPost(2,homeurl+"activityController.api?updateActivityDetail",
                {activity_id:this.state.activityBean.activity_id,
                    activity_name:this.state.activityBean.activity_name,
                    activity_desc:this.state.activityBean.activity_desc,
                    activity_img:this.state.activityBean.activity_img,
                    sort:this.state.activityBean.sort,
                    give_id:this.state.activityBean.giveBean.give_id,
                    give_need_count:this.state.activityBean.giveBean.give_need_count,
                    give_count:this.state.activityBean.giveBean.give_count,
                    activity_type:this.state.activityBean.activity_type,
                    reduce_need_price:this.state.activityBean.reduceBean.reduce_need_price,
                    reduce_price:this.state.activityBean.reduceBean.reduce_price,
                    reduce_id:this.state.activityBean.reduceBean.reduce_id,
                    gift_need_price:this.state.activityBean.giftBean.gift_need_price,
                    gift_desc:this.state.activityBean.giftBean.gift_desc,
                    gift_id:this.state.activityBean.giftBean.gift_id,
                    half_id:this.state.activityBean.halfBean.half_id,
                    half_count:this.state.activityBean.halfBean.half_count,
                    exempt_id:this.state.activityBean.exemptBean.exempt_id,
                    exempt_need_count:this.state.activityBean.exemptBean.exempt_need_count,
                    exempt_count:this.state.activityBean.exemptBean.exempt_count,
                    activity_state:this.state.activityBean.activity_state,
                    is_add:this.state.activityBean.activity_type==="reduce"?
                        this.state.activityBean.reduceBean.is_add:(this.state.activityBean.activity_type==="give"?
                        this.state.activityBean.giveBean.is_add:(this.state.activityBean.activity_type==="half"?
                        this.state.activityBean.halfBean.is_add:"0"))});
        }else{
            this.getDataByPost(3,homeurl+"activityController.api?insertActivityDetail",
                {activity_name:this.state.activityBean.activity_name,
                    activity_desc:this.state.activityBean.activity_desc,
                    activity_img:this.state.activityBean.activity_img,
                    sort:this.state.activityBean.sort,
                    give_id:this.state.activityBean.giveBean.give_id,
                    give_need_count:this.state.activityBean.giveBean.give_need_count,
                    give_count:this.state.activityBean.giveBean.give_count,
                    is_give_add:this.state.activityBean.giveBean.is_add,
                    activity_type:this.state.activityBean.activity_type,
                    reduce_need_price:this.state.activityBean.reduceBean.reduce_need_price,
                    reduce_price:this.state.activityBean.reduceBean.reduce_price,
                    reduce_id:this.state.activityBean.reduceBean.reduce_id,
                    gift_need_price:this.state.activityBean.giftBean.gift_need_price,
                    gift_desc:this.state.activityBean.giftBean.gift_desc,
                    gift_id:this.state.activityBean.giftBean.gift_id,
                    half_id:this.state.activityBean.halfBean.half_id,
                    half_count:this.state.activityBean.halfBean.half_count,
                    exempt_id:this.state.activityBean.exemptBean.exempt_id,
                    exempt_need_count:this.state.activityBean.exemptBean.exempt_need_count,
                    exempt_count:this.state.activityBean.exemptBean.exempt_count,
                    activity_state:this.state.activityBean.activity_state,
                    is_add:this.state.activityBean.activity_type==="reduce"?
                        this.state.activityBean.reduceBean.is_add:(this.state.activityBean.activity_type==="give"?
                        this.state.activityBean.giveBean.is_add:(this.state.activityBean.activity_type==="half"?
                        this.state.activityBean.halfBean.is_add:"0"))});
        }
    }

    render(){
        return(
            <div>
                <div style={{flex:1,display:'flex',alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="名称"
                        value={this.state.activityBean.activity_name}
                        onChange={(value)=>{
                        this.state.activityBean.activity_name=value;
                        this.setState({
                            activityBean:this.state.activityBean,
                        })
                    }}/>
                    <Widget.SelectV2
                        visible={this.state.activity_id?"false":"true"}
                        title="活动类型"
                        show_value="name"
                        init_value={this.state.activityBean.activity_type}
                        select_value="id"
                        dataSource={this.state.typeBeans}
                        onChange={(rowID)=>{
                            this.state.activityBean.activity_type=this.state.typeBeans[rowID].id
                            this.setState({
                                activityBean:this.state.activityBean,
                            })
                        }}/>
                </div>
                <div style={{display:this.state.activityBean.activity_type==="exempt"?'flex':"none",alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="需要件数"
                        value={this.state.activityBean.exemptBean.exempt_need_count}
                        onChange={(value)=>{
                            this.state.activityBean.exemptBean.exempt_need_count=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <EditorComponent
                        title="减免件数"
                        value={this.state.activityBean.exemptBean.exempt_count}
                        onChange={(value)=>{
                            this.state.activityBean.exemptBean.exempt_count=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>

                </div>
                <div style={{display:this.state.activityBean.activity_type==="half"?'flex':"none",alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="第几件半价"
                        value={this.state.activityBean.halfBean.half_count}
                        onChange={(value)=>{
                            this.state.activityBean.halfBean.half_count=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <Widget.Check
                        title="是否递增"
                        checked={this.state.activityBean.halfBean.is_add}
                        onClick={(checked)=>{
                              this.state.activityBean.halfBean.is_add=checked;
                              this.setState({
                                  activityBean:this.state.activityBean
                              })
                        }}/>
                </div>
                <div style={{display:this.state.activityBean.activity_type==="give"?'flex':"none",alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="需要件数"
                        value={this.state.activityBean.giveBean.give_need_count}
                        onChange={(value)=>{
                            this.state.activityBean.giveBean.give_need_count=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <EditorComponent
                        title="赠送件数"
                        value={this.state.activityBean.giveBean.give_count}
                        onChange={(value)=>{
                            this.state.activityBean.giveBean.give_count=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <Widget.Check
                        title="是否递增"
                        checked={this.state.activityBean.giveBean.is_add}
                        onClick={(checked)=>{
                              this.state.activityBean.giveBean.is_add=checked;
                              this.setState({
                                  activityBean:this.state.activityBean
                              })
                        }}/>
                </div>
                <div style={{display:this.state.activityBean.activity_type==="reduce"?'flex':"none",alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="需要金额"
                        value={this.state.activityBean.reduceBean.reduce_need_price}
                        onChange={(value)=>{
                            this.state.activityBean.reduceBean.reduce_need_price=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <EditorComponent
                        title="减免金额"
                        value={this.state.activityBean.reduceBean.reduce_price}
                        onChange={(value)=>{
                            this.state.activityBean.reduceBean.reduce_price=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <Widget.Check
                        title="是否递增"
                        checked={this.state.activityBean.reduceBean.is_add}
                        onClick={(checked)=>{
                              this.state.activityBean.reduceBean.is_add=checked;
                              this.setState({
                                  activityBean:this.state.activityBean
                              })
                        }}/>
                </div>
                <div style={{display:this.state.activityBean.activity_type==="gift"?'flex':"none",alignItems:'center',marginTop:20}}>
                    <EditorComponent
                        title="需要金额"
                        value={this.state.activityBean.giftBean.gift_need_price}
                        onChange={(value)=>{
                            this.state.activityBean.giftBean.gift_need_price=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                    <EditorComponent
                        title="礼物内容"
                        value={this.state.activityBean.giftBean.gift_desc}
                        onChange={(value)=>{
                            this.state.activityBean.giftBean.gift_desc=value;
                            this.setState({
                                activityBean:this.state.activityBean
                            })
                        }}/>
                </div>
                <TextareaComponent
                    marginTop={20}
                    height={80}
                    title="描述"
                    value={this.state.activityBean.activity_desc}
                    onChange={(value)=>{
                        this.state.activityBean.activity_desc=value;
                        this.setState({
                            activityBean:this.state.activityBean,
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="图片"
                    src={!this.state.activityBean.activity_img||this.state.activityBean.activity_img===''?"./images/add.jpg":imgurl+this.state.activityBean.activity_img}
                    url={homeurl+'activityController.api?uploadHomeActivityImg'}
                    onSuccess={(data)=>{
                        this.state.activityBean.activity_img=data;
                        this.setState({
                            activityBean:this.state.activityBean,
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.activityBean.sort}
                    onChange={(value)=>{
                        this.state.activityBean.sort=value;
                        this.setState({
                            activityBean:this.state.activityBean,
                        })
                    }}/>
                <Widget.SelectV2
                    title="状态"
                    show_value="name"
                    init_value={this.state.activityBean.activity_state}
                    select_value="id"
                    dataSource={this.state.stateBeans}
                    onChange={(rowID)=>{
                            this.state.activityBean.activity_state=this.state.stateBeans[rowID].id
                            this.setState({
                                activityBean:this.state.activityBean,
                            })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertActivityDetail();
                    }}/>
            </div>
        )
    }
}
const styles = {
    input:{
        width:300,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
        width:100
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
    }
}
module.exports=ActivityEditorComponent;