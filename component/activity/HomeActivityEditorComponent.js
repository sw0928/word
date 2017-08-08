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
var Widget=require("./../../widget/WidgetComponent");

class HomeLabelEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var activityBean=JSON.parse(decodeURIComponent(this.props.params.activityBean));
        this.state = {
            activityBean:activityBean,
            allGoodsBeans:[],
            selectGoodsBean:{},
            goods_name:"",

            activityBeans:[],

            selectActivityBean:{},
            activity_name:"",
            typeBeans:[{name:"活动",id:'activity'},
                {name:"商品",id:'goods'},
                {name:'分类',id:'class'}],

            allClassBeans:[],
            selectClassBean:{},
            class_name:""
        };
    }

    componentDidMount() {
            this.getGoods();
            this.getActivitys();
            this.getGoodsClass();
    }
    getActivitys(){
        this.getDataByPost(4,homeurl+"activityController.api?getActivitysNoPage",{})
    }
    getGoodsClass(){
        this.getDataByPost(5,homeurl+"goodsController2.api?getGoodsClasssNoPage",{})
    }
    getGoods(){
        this.getDataByPost(3,homeurl+"goodsController.api?getAllGoodsDetailNoPage",{})
    }

    updateLabel(){
        if(!this.state.activityBean.activity_name||this.state.activityBean.activity_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(!this.state.activityBean.activity_img||this.state.activityBean.activity_img===''){
            toast.show("请先选择图片");
            return;
        }

        if(this.state.activityBean.activity_type==='goods'){
            if(!this.state.selectGoodsBean.goods_id){
                toast.show("请先选择商品");
                return;
            }
        }else if(this.state.activityBean.activity_type==='activity'){
            if(!this.state.selectActivityBean.activity_id){
                toast.show("请先选择活动");
                return;
            }
        }else if(this.state.activityBean.activity_type==='class'){
            if(!this.state.selectClassBean.class_id){
                toast.show("请先选择分类");
                return;
            }
        }


        if(this.state.activityBean.activity_id){
            this.getDataByPost(1,homeurl+"activityController.api?updateHomeActivity",
                {activity_id:this.state.activityBean.activity_id,
                    activity_img:this.state.activityBean.activity_img,
                    sort:this.state.activityBean.sort,
                    activity_name:this.state.activityBean.activity_name,
                    activity_type:this.state.activityBean.activity_type,
                    relation_id:this.state.activityBean.activity_type==='goods'?this.state.selectGoodsBean.goods_id:
                        (this.state.activityBean.activity_type==="class"?this.state.selectClassBean.class_uuid:this.state.selectActivityBean.activity_id)});
        }else{
            this.getDataByPost(2,homeurl+"activityController.api?insertHomeActivity",
                    {parent_id:this.state.activityBean.parent_id,
                    activity_type:this.state.activityBean.activity_type,
                    activity_img:this.state.activityBean.activity_img,
                    sort:this.state.activityBean.sort,
                    activity_name:this.state.activityBean.activity_name,
                    relation_id:this.state.activityBean.activity_type==='goods'?this.state.selectGoodsBean.goods_id:
                            (this.state.activityBean.activity_type==="class"?this.state.selectClassBean.class_uuid:this.state.selectActivityBean.activity_id)});
        }

    }

    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
            case 2:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 3:
                this.setState({
                    allGoodsBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["goods_id"]+""===this.state.activityBean.relation_id+"";
                    }.bind(this))
                    if(d.length>0){
                        this.setState({
                            selectGoodsBean: d[0],
                            goods_name:d[0].goods_name,
                        })
                    }else{
                        this.setState({
                            selectGoodsBean: data[0],
                            goods_name:data[0].goods_name,
                        })
                    }
                }
                break;
            case 4:
                this.setState({
                    activityBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["activity_id"]+""===this.state.activityBean.relation_id+"";
                    }.bind(this))
                    if(d.length>0){
                        this.setState({
                            selectActivityBean: d[0],
                            activity_name:d[0].activity_name,
                        })
                    }else{
                        this.setState({
                            selectActivityBean: data[0],
                            activity_name:data[0].activity_name,
                        })
                    }
                }
                break;
            case 5:
                this.setState({
                    allClassBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["class_uuid"]+""===this.state.activityBean.relation_id+"";
                    }.bind(this))
                    if(d.length>0){
                        this.setState({
                            selectClassBean: d[0],
                            class_name:d[0].class_name,
                        })
                    }else{
                        this.setState({
                            selectClassBean: data[0],
                            class_name:data[0].class_name,
                        })
                    }
                }
                break;
        }
    }


    render(){
        return(
            <div>
                <Toolbar title="活动编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="名称"
                    value={this.state.activityBean.activity_name}
                    onChange={(value)=>{
                        this.state.activityBean.activity_name=value;
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
                <div style={{display:this.state.activityBean.activity_type==='goods'?"flex":"none",
                                alignItems:'center',marginTop:20}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商品名</p1>
                    </div>
                    <SearchBar
                        marginLeft={10}
                        item_name="goods_name"
                        dataSource={this.state.allGoodsBeans}
                        name={this.state.goods_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectGoodsBean:data,
                                goods_name:value,
                            })
                        }}/>
                </div>
                <div style={{display:this.state.activityBean.activity_type==='class'?"flex":"none",
                                alignItems:'center',marginTop:20}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>分类名</p1>
                    </div>
                    <SearchBar
                        marginLeft={10}
                        item_name="class_name"
                        dataSource={this.state.allClassBeans}
                        name={this.state.class_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectClassBean:data,
                                class_name:value,
                            })
                        }}>
                    </SearchBar>
                </div>
                <div style={{display:this.state.activityBean.activity_type==='activity'?"flex":"none",
                                alignItems:'center',marginTop:20}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>活动名称</p1>
                    </div>
                    <SearchBar
                        marginLeft={10}
                        item_name="activity_name"
                        dataSource={this.state.activityBeans}
                        name={this.state.activity_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectActivityBean:data,
                                activity_name:value,
                            })
                        }}>
                    </SearchBar>
                </div>

                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.updateLabel();
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
module.exports=HomeLabelEditorComponent;