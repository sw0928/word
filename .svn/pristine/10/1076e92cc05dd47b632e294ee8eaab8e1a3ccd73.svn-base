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

class HomeLabelEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var labelBean=JSON.parse(decodeURIComponent(this.props.params.labelBean));
        this.state = {
            labelBean:labelBean,
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="标签编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="名称"
                    value={this.state.labelBean.label_name}
                    onChange={(value)=>{
                        this.state.labelBean.label_name=value;
                        this.setState({
                            labelBean:this.state.labelBean,
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="图片"
                    src={this.state.labelBean.label_img===''?"./images/add.jpg":imgurl+this.state.labelBean.label_img}
                    url={homeurl+'activityController.api?uploadHomeLabelImg'}
                    onSuccess={(data)=>{
                        this.state.labelBean.label_img=data;
                        this.setState({
                            labelBean:this.state.labelBean,
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="背景大图"
                    src={this.state.labelBean.label_desc_img===''?"./images/add.jpg":imgurl+this.state.labelBean.label_desc_img}
                    url={homeurl+'activityController.api?uploadHomeLabelImg'}
                    onSuccess={(data)=>{
                        this.state.labelBean.label_desc_img=data;
                        this.setState({
                            labelBean:this.state.labelBean,
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.labelBean.sort}
                    onChange={(value)=>{
                        this.state.labelBean.sort=value;
                        this.setState({
                            labelBean:this.state.labelBean,
                        })
                    }}/>
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


    updateLabel(){
        if(this.state.label_name===''){
            toast.show("名称不可为空");
            return;
        }
        if(this.state.label_img===''){
            toast.show("请先选择图片");
            return;
        }


        this.getDataByPost(1,homeurl+"activityController.api?updateHomeLabel",
                {label_id:this.state.labelBean.label_id,
                    label_img:this.state.labelBean.label_img,
                    label_desc_img:this.state.labelBean.label_desc_img,
                    sort:this.state.labelBean.sort,
                    label_name:this.state.labelBean.label_name});

    }

    doSuccess(index,data){
        switch (index){
            case 1:
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
module.exports=HomeLabelEditorComponent;