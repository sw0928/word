/**
 * Created by shenjiabo on 16/8/22.
 */
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

var Toolbar=require("./../../widget/Toolbar");
var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
class GroupBuyEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var groupBuyGoodsBean=JSON.parse(decodeURIComponent(this.props.params.groupBuyGoodsBean));
        this.state = {
            groupBuyGoodsBean:groupBuyGoodsBean,
            group_buy_name:groupBuyGoodsBean.group_buy_name?groupBuyGoodsBean.group_buy_name:"",
            group_buy_price:groupBuyGoodsBean.group_buy_price?groupBuyGoodsBean.group_buy_price:"",
            group_buy_need_time:groupBuyGoodsBean.group_buy_need_time?groupBuyGoodsBean.group_buy_need_time:"1",
            group_buy_need_people:groupBuyGoodsBean.group_buy_need_people?groupBuyGoodsBean.group_buy_need_people:"",
            sort:groupBuyGoodsBean.sort?groupBuyGoodsBean.sort:"1",
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="团购编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    width={150}
                    title="团购名"
                    value={this.state.group_buy_name}
                    onChange={(value)=>{
                        this.setState({
                            group_buy_name:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    width={150}
                    title="团购价"
                    value={this.state.group_buy_price}
                    onChange={(value)=>{
                        this.setState({
                            group_buy_price:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    width={150}
                    title="需要人数"
                    value={this.state.group_buy_need_people}
                    onChange={(value)=>{
                        this.setState({
                            group_buy_need_people:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    width={150}
                    title="最长等待时间(分钟)"
                    value={this.state.group_buy_need_time}
                    onChange={(value)=>{
                        this.setState({
                            group_buy_need_time:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    width={150}
                    title="权重"
                    value={this.state.sort}
                    onChange={(value)=>{
                        this.setState({
                            sort:value
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={150}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMoudle();
                    }}/>
            </div>
        )
    }

    insertMoudle(){
        if(this.state.group_buy_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(isNaN(this.state.group_buy_price)){
            toast.show("价格不合法");
            return;
        }

        if(isNaN(this.state.group_buy_need_time)){
            toast.show("最长等待时间不合法");
            return;
        }

        if(isNaN(this.state.group_buy_need_people)){
            toast.show("需要人数不合法");
            return;
        }
        if(!this.state.groupBuyGoodsBean.goods_group_buy_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertGoodsGroupBuy",
                {group_buy_name:this.state.group_buy_name,group_buy_price:this.state.group_buy_price,
                    group_buy_need_time:this.state.group_buy_need_time,goods_id:this.state.groupBuyGoodsBean.goods_id,
                    group_buy_need_people:this.state.group_buy_need_people,
                    sort:this.state.sort,});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateGoodsGroupBuy",
                {goods_group_buy_id:this.state.groupBuyGoodsBean.goods_group_buy_id,group_buy_name:this.state.group_buy_name,group_buy_price:this.state.group_buy_price,
                    group_buy_need_time:this.state.group_buy_need_time,goods_id:this.state.groupBuyGoodsBean.goods_id,
                    group_buy_need_people:this.state.group_buy_need_people,
                    sort:this.state.sort,});
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

module.exports=GroupBuyEditorComponent;
