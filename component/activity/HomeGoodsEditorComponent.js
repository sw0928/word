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

class HomeLabelEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var homeGoodsBean=JSON.parse(decodeURIComponent(this.props.params.homeGoodsBean));
        this.state = {
            homeGoodsBean:homeGoodsBean,
            allGoodsBeans:[],
            selectBean:{},
            goods_name:"",
        };
    }

    componentDidMount() {
        if(this.state.homeGoodsBean.goods_type==='goods'){
            this.getGoods();
        }
    }

    getGoods(){
        this.getDataByPost(3,homeurl+"goodsController.api?getAllGoodsDetailNoPage",{})
    }

    updateLabel(){
        if(!this.state.homeGoodsBean.goods_name||this.state.homeGoodsBean.goods_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(!this.state.homeGoodsBean.goods_img||this.state.homeGoodsBean.goods_img===''){
            toast.show("请先选择图片");
            return;
        }

        if(this.state.homeGoodsBean.goods_type==='goods'){
            if(!this.state.selectBean.goods_id){
                toast.show("请先选择商品");
                return;
            }
        }


        if(this.state.homeGoodsBean.home_goods_id){
            this.getDataByPost(1,homeurl+"activityController.api?updateHomeGoods",
                {home_goods_id:this.state.homeGoodsBean.home_goods_id,
                    goods_type:this.state.homeGoodsBean.goods_type,
                    goods_img:this.state.homeGoodsBean.goods_img,
                    sort:this.state.homeGoodsBean.sort,
                    goods_name:this.state.homeGoodsBean.goods_name,
                    goods_id:this.state.selectBean.goods_id});
        }else{
            this.getDataByPost(2,homeurl+"activityController.api?insertHomeGoods",
                {parent_id:this.state.homeGoodsBean.parent_id,
                    goods_type:this.state.homeGoodsBean.goods_type,
                    goods_img:this.state.homeGoodsBean.goods_img,
                    sort:this.state.homeGoodsBean.sort,
                    goods_name:this.state.homeGoodsBean.goods_name,
                    goods_id:this.state.selectBean.goods_id});
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
                        return item["goods_id"]+""===this.state.homeGoodsBean.goods_id+"";
                    }.bind(this))
                    if(d.length>0){
                        this.setState({
                            selectBean: d[0],
                            goods_name:d[0].goods_name,
                        })
                    }else{
                        this.setState({
                            selectBean: data[0],
                            goods_name:data[0].goods_name,
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
                    value={this.state.homeGoodsBean.goods_name}
                    onChange={(value)=>{
                        this.state.homeGoodsBean.goods_name=value;
                        this.setState({
                            homeGoodsBean:this.state.homeGoodsBean,
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="图片"
                    src={!this.state.homeGoodsBean.goods_img||this.state.homeGoodsBean.goods_img===''?"./images/add.jpg":imgurl+this.state.homeGoodsBean.goods_img}
                    url={homeurl+'activityController.api?uploadHomeActivityImg'}
                    onSuccess={(data)=>{
                        this.state.homeGoodsBean.goods_img=data;
                        this.setState({
                            homeGoodsBean:this.state.homeGoodsBean,
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.homeGoodsBean.sort}
                    onChange={(value)=>{
                        this.state.homeGoodsBean.sort=value;
                        this.setState({
                            homeGoodsBean:this.state.homeGoodsBean,
                        })
                    }}/>
                <div style={{display:this.state.homeGoodsBean.goods_type==='goods'?"flex":"none",
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
                                selectBean:data,
                                goods_name:value,
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