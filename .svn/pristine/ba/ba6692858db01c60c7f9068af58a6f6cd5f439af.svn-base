/**
 * Created by shenjiabo on 16/10/30.
 *
 * 个人信息
 */


import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");

var ButtonComponent=require("./../../widget/ButtonComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var TextComponent=require("./../../widget/TextComponent");
var ImgComponent=require("./../../widget/ImgComponent");

class UserDetailComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            recipeBean:JSON.parse(this.props.params.recipeBean),
        };
    }

    saveDetail(){
        if(this.state.recipeBean.recipe_name===''){
            toast.show("名称不可为空");
            return;
        }

        if(!this.state.recipeBean.recipe_id){
            this.getDataByPost(1,homeurl+"recipeController.api?insertRecipe",
                {recipe_name:this.state.recipeBean.recipe_name,
                    sort:this.state.recipeBean.sort,
                    parent_id:"-1"})
        }else{
            this.getDataByPost(2,homeurl+"recipeController.api?updateRecipe",
                {recipe_name:this.state.recipeBean.recipe_name,
                    sort:this.state.recipeBean.sort,
                    recipe_id:this.state.recipeBean.recipe_id})
        }

    }


    doSuccess(index,data){
        switch (index){
            case 1:
                toast.show("保存成功");
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
                    <Toolbar title="美食分类编辑" history={this.props.history}></Toolbar>
                    <EditorComponent
                        marginTop={20}
                        title="名称"
                        value={this.state.recipeBean.recipe_name}
                        onChange={(value)=>{
                        this.state.recipeBean.recipe_name=value;
                        this.setState({
                            recipeBean:this.state.recipeBean
                        })
                    }}>
                    </EditorComponent>
                    <EditorComponent
                        marginTop={20}
                        title="权重"
                        value={this.state.recipeBean.sort}
                        onChange={(value)=>{
                        this.state.recipeBean.sort=value;
                        this.setState({
                            recipeBean:this.state.recipeBean
                        })
                    }}>
                    </EditorComponent>
                    <ButtonComponent
                        marginTop={20}
                        marginLeft={100}
                        width={100}
                        value="保存"
                        onClick={()=>{
                            this.saveDetail();
                        }}>
                    </ButtonComponent>
            </div>
        )
    }
}


module.exports=UserDetailComponent;