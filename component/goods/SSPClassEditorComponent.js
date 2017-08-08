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
class SSPClassEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var sspClassBean=JSON.parse(decodeURIComponent(this.props.params.sspClassBean));
        this.state = {
            sspClassBean:sspClassBean,
        };
    }

    render(){
        return(
            <div>
                <Toolbar title="分类编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="分类名称"
                    value={this.state.sspClassBean.class_name}
                    onChange={(value)=>{
                        this.state.sspClassBean.class_name=value;
                        this.setState({
                            sspClassBean:this.state.sspClassBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.sspClassBean.sort}
                    onChange={(value)=>{
                        this.state.sspClassBean.sort=value;
                        this.setState({
                            sspClassBean:this.state.sspClassBean
                        })
                    }}/>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertStandard();
                    }}/>
            </div>
        )
    }

    insertStandard(){

        if(this.state.sspClassBean.class_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(!this.state.sspClassBean.class_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertSSPHomeClass",
                {class_name:this.state.sspClassBean.class_name,
                    class_type:this.state.sspClassBean.class_type,
                    sort:this.state.sspClassBean.sort,});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateSSPHomeClass",
                {class_id:this.state.sspClassBean.class_id,
                    class_type:this.state.sspClassBean.class_type,
                    class_name:this.state.sspClassBean.class_name,
                    sort:this.state.sspClassBean.sort});
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

module.exports=SSPClassEditorComponent;
