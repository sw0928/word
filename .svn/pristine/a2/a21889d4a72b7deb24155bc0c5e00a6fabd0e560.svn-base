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
class ServiceEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var serviceBean=JSON.parse(decodeURIComponent(this.props.params.serviceBean));
        this.state = {
            serviceBean:serviceBean,
            service_name:serviceBean.service_name?serviceBean.service_name:"",
            service_price:serviceBean.service_price?serviceBean.service_price:"",
            sort:serviceBean.sort?serviceBean.sort:"1",
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="编辑服务" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="服务名称"
                    value={this.state.service_name}
                    onChange={(value)=>{
                        this.setState({
                            service_name:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="价格"
                    value={this.state.service_price}
                    onChange={(value)=>{
                        this.setState({
                            service_price:value
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
        if(this.state.service_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(isNaN(this.state.service_price)){
            toast.show("价格不合法");
            return;
        }

        if(!this.state.serviceBean.service_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertService",
                {service_name:this.state.service_name,service_price:this.state.service_price,
                    parent_id:this.state.serviceBean.parent_id,goods_id:this.state.serviceBean.goods_id,
                    service_type:this.state.serviceBean.service_type,
                    sort:this.state.sort,});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateService",
                {service_id:this.state.serviceBean.service_id,service_name:this.state.service_name,service_price:this.state.service_price,
                    parent_id:this.state.serviceBean.parent_id,goods_id:this.state.serviceBean.goods_id,
                    service_type:this.state.serviceBean.service_type,
                    sort:this.state.sort});
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

module.exports=ServiceEditorComponent;
