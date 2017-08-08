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
class MoudleEditerComponent extends BaseComponent{
    // 构造
      constructor(props) {
        super(props);
        // 初始状态
        var moudleBean=JSON.parse(decodeURIComponent(this.props.params.moudleBean));
        this.state = {
            moudleBean:moudleBean,
            moudle_name:moudleBean.moudle_name?moudleBean.moudle_name:"",
            moudle_url:moudleBean.moudle_url?moudleBean.moudle_url:"",
            moudle_remark:moudleBean.moudle_remark?moudleBean.moudle_remark:"",
            sort:moudleBean.sort?moudleBean.sort:"1",
        };
      }

    render(){
        return(
            <div>
                <Toolbar title="模块编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="模块名称"
                    value={this.state.moudle_name}
                    onChange={(value)=>{
                        this.setState({
                            moudle_name:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="路由"
                    value={this.state.moudle_url}
                    onChange={(value)=>{
                        this.setState({
                            moudle_url:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="备注"
                    value={this.state.moudle_remark}
                    onChange={(value)=>{
                        this.setState({
                            moudle_remark:value
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

module.exports=MoudleEditerComponent;
