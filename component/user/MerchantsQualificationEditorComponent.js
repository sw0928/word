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


var EditorComponent=require("./../../widget/EditorComponent");
var ButtonComponent=require("./../../widget/ButtonComponent");
import Upload from 'rc-upload';

var Toolbar=require("./../../widget/Toolbar");

class MerchantsLabelEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsQualificationBean=JSON.parse(decodeURIComponent(this.props.params.merchantsQualificationBean));
        this.state = {
            merchantsQualificationBean:merchantsQualificationBean,
        };
    }

    insertLabel(){
        if(this.state.merchantsQualificationBean.qualification_name===''){
            toast.show("标签不可为空");
            return;
        }

        if(this.state.merchantsQualificationBean.qualification_id){
            this.getDataByPost(2,homeurl+"merchantsController.api?updateMerchantsQualification",
                {qualification_id:this.state.merchantsQualificationBean.qualification_id,
                    sort:this.state.merchantsQualificationBean.sort,
                    qualification_name:this.state.merchantsQualificationBean.qualification_name});
        }else{
            this.getDataByPost(1,homeurl+"merchantsController.api?insertMerchantsQualification",
                {sort:this.state.merchantsQualificationBean.sort,
                    qualification_name:this.state.merchantsQualificationBean.qualification_name});
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
                <Toolbar title="资质编辑" history={this.props.history}></Toolbar>

                <EditorComponent
                    marginTop={20}
                    title="标签名"
                    value={this.state.merchantsQualificationBean.qualification_name}
                    onChange={(value)=>{
                            this.state.merchantsQualificationBean.qualification_name=value;
                            this.setState({
                                merchantsQualificationBean:this.state.merchantsQualificationBean,
                            })
                        }}>
                </EditorComponent>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.merchantsQualificationBean.sort}
                    onChange={(value)=>{
                            this.state.merchantsQualificationBean.sort=value;
                            this.setState({
                                merchantsQualificationBean:this.state.merchantsQualificationBean,
                            })
                        }}>
                </EditorComponent>
                <ButtonComponent
                    width={100}
                    marginLeft={100}
                    marginTop={20}
                    value="保存"
                    onClick={()=>{
                        this.insertLabel();
                    }}>

                </ButtonComponent>
            </div>
        )
    }

    insertMoudle(){
        if(this.state.moudle_name===''){
            toast.show("模块名称不可为空");
            return;
        }

        if(!this.state.moudleBean.moudle_id){
            this.getDataByPost(1,homeurl+"systemController.api?insertMoudle",
                {moudle_name:this.state.moudle_name,moudle_url:this.state.moudle_url,
                    moudle_url:this.state.moudle_url,moudle_remark:this.state.moudle_remark,
                    parent_id:this.state.moudleBean.parent_id,
                    sort:this.state.sort,});
        }else{
            this.getDataByPost(2,homeurl+"systemController.api?updateMoudle",
                {moudle_name:this.state.moudle_name,moudle_url:this.state.moudle_url,
                    moudle_url:this.state.moudle_url,moudle_remark:this.state.moudle_remark,
                    moudle_id:this.state.moudleBean.moudle_id,
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
        width:300,
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
    }
}

module.exports=MerchantsLabelEditorComponent;
