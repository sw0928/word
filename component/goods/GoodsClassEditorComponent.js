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
var SelectComponent=require('./../../widget/SelectComponent');

var goods_state_index=-1;
var goods_recommend_index=-1;
class GoodsClassEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var goodsBean=JSON.parse(decodeURIComponent(this.props.params.goodsBean));
        this.state = {
            level:this.props.params.level,
            goodsBean:goodsBean,
            goods_name:goodsBean.goods_name?goodsBean.goods_name:"",
            goods_img:goodsBean.goods_img?goodsBean.goods_img:"",
            sort:goodsBean.sort?goodsBean.sort:"1",
            goodsStateBeans:[{id:'0',name:'下架中'},{id:'1',name:'上架中'}],
            goods_state:goodsBean.goods_state?goodsBean.goods_state:"0",
            goodsRecommendBeans:[{id:'0',name:'不推荐'},{id:'1',name:'推荐'}],
            is_recommend:goodsBean.is_recommend?goodsBean.is_recommend:"0"
        };
    }
    
    render(){
        return(
            <div>
                <Toolbar title={this.state.level+"级分类编辑"} history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="分类名称"
                    value={this.state.goods_name}
                    onChange={(value)=>{
                        this.setState({
                            goods_name:value
                        })
                    }}/>
                <SelectComponent
                    marginTop={20}
                    dataSource={this.state.goodsStateBeans}
                                 title="商品状态"
                                 init_value={this.state.goods_state}
                                 select_value="id"
                                 show_value="name"
                                 onChange={(rowID)=>{
                                goods_state_index=rowID
                             }}>
                </SelectComponent>
                <SelectComponent
                    marginTop={20}
                    dataSource={this.state.goodsRecommendBeans}
                    title="是否推荐"
                    init_value={this.state.is_recommend}
                    select_value="id"
                    show_value="name"
                    onChange={(rowID)=>{
                                goods_recommend_index=rowID
                             }}>
                </SelectComponent>
                <ImgComponent
                    marginTop={20}
                    title="图片"
                    src={this.state.goods_img===''?"./images/add.jpg":imgurl+this.state.goods_img}
                    url={homeurl+'goodsController.api?uploadGoodsImg'}
                    onSuccess={(data)=>{
                        this.setState({
                            goods_img:data,
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.sort}
                    onChange={(value)=>{
                        this.setState({
                            sort:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="标题"
                    value={this.state.goodsBean.goods_title}
                    onChange={(value)=>{
                        this.state.goodsBean.goods_title=value;
                        this.setState({
                            goodsBean: this.state.goodsBean
                        })
                    }}/>
                <TextareaComponent
                    marginTop={20}
                    height={100}
                    title="简介"
                    value={this.state.goodsBean.goods_desc}
                    onChange={(value)=>{
                        this.state.goodsBean.goods_desc=value;
                        this.setState({
                            goodsBean: this.state.goodsBean
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMoudle();
                    }}/>
            </div>
        )
    }


    insertMoudle(){
        if(this.state.goods_name===''){
            toast.show("分类名称不可为空");
            return;
        }

        if(!this.state.goodsBean.goods_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertGoodsClass",
                {goods_name:this.state.goods_name,goods_img:this.state.goods_img,
                    parent_id:this.state.goodsBean.parent_id,goods_type:"1",
                    sort:this.state.sort,
                    goods_title:this.state.goodsBean.goods_title,
                    goods_desc:this.state.goodsBean.goods_desc,
                    goods_state:this.state.goodsStateBeans[goods_state_index].id,
                    is_recommend:this.state.goodsRecommendBeans[goods_recommend_index].id});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateGoodsClass",
                {goods_name:this.state.goods_name,goods_img:this.state.goods_img,
                    parent_id:this.state.goodsBean.parent_id,goods_type:"1",
                    sort:this.state.sort,goods_id:this.state.goodsBean.goods_id,
                    goods_title:this.state.goodsBean.goods_title,
                    goods_desc:this.state.goodsBean.goods_desc,
                    goods_state:this.state.goodsStateBeans[goods_state_index].id,
                    is_recommend:this.state.goodsRecommendBeans[goods_recommend_index].id});
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
        }
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
module.exports=GoodsClassEditorComponent;