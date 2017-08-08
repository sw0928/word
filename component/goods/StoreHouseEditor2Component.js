/**
 * Created by shenjiabo on 16/11/30.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');


var EditorComponent=require("./../../widget/EditorComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
var ImgComponent=require("./../../widget/ImgComponent");

var Toolbar=require("./../../widget/Toolbar");

class StoreHouseEditor2Component extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var storehouseBean=JSON.parse(decodeURIComponent(this.props.params.storehouseBean));

        this.state = {
            storehouseBean: storehouseBean
        }

    }

    insertStoreHouse(){
        if(this.isNull(this.state.storehouseBean.storehouse_name)){
            toast.show("网点名称不可为空");
            return;
        }
        if(this.isNull(this.state.storehouseBean.storehouse_province)||this.isNull(this.state.storehouseBean.storehouse_city||
                this.isNull(this.state.storehouseBean.storehouse_area)))
        {
            toast.show("地址信息不可为空");
            return;
        }
        if(this.isNull(this.state.storehouseBean.contact_name)||this.isNull(this.state.storehouseBean.contact_mobile)){
            toast.show("联系人信息不可为空");
            return;
        }
        if(this.state.storehouseBean.storehouse_id){
            this.getDataByPost(2,homeurl+"goodsController.api?updateStorehouse",
                {storehouse_id:this.state.storehouseBean.storehouse_id,
                    storehouse_name:this.state.storehouseBean.storehouse_name,
                    storehouse_province:this.state.storehouseBean.storehouse_province,
                    storehouse_city:this.state.storehouseBean.storehouse_city,
                    storehouse_area:this.state.storehouseBean.storehouse_area,
                    contact_name:this.state.storehouseBean.contact_name,
                    contact_mobile:this.state.storehouseBean.contact_mobile,
                });
        }else{
            this.getDataByPost(1,homeurl+"goodsController.api?insertStorehouse",
                {storehouse_name:this.state.storehouseBean.storehouse_name,
                    storehouse_province:this.state.storehouseBean.storehouse_province,
                    storehouse_city:this.state.storehouseBean.storehouse_city,
                    storehouse_area:this.state.storehouseBean.storehouse_area,
                    contact_name:this.state.storehouseBean.contact_name,
                    contact_mobile:this.state.storehouseBean.contact_mobile,
                    is_lastDeliveryAddress:1
                });
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
    render(){
        return(
            <div>
                <Toolbar title="材料编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="网点名称"
                    value={this.state.storehouseBean.storehouse_name}
                    onChange={(value)=>{
                        this.state.storehouseBean.storehouse_name=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="省/直辖市"
                    value={this.state.storehouseBean.storehouse_province}
                    onChange={(value)=>{
                        this.state.storehouseBean.storehouse_province=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="市/区"
                    value={this.state.storehouseBean.storehouse_city}
                    onChange={(value)=>{
                        this.state.storehouseBean.storehouse_city=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="详细地址"
                    value={this.state.storehouseBean.storehouse_area}
                    onChange={(value)=>{
                        this.state.storehouseBean.storehouse_area=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="联系人姓名"
                    value={this.state.storehouseBean.contact_name}
                    onChange={(value)=>{
                        this.state.storehouseBean.contact_name=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="联系电话"
                    value={this.state.storehouseBean.contact_mobile}
                    onChange={(value)=>{
                        this.state.storehouseBean.contact_mobile=value;
                        this.setState({
                            storehouseBean:this.state.storehouseBean
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    width={100}
                    marginLeft={100}
                    value="保存"
                    onClick={()=>{
                        this.insertStoreHouse();
                    }}/>
            </div>
        )
    }
}

module.exports=StoreHouseEditor2Component;