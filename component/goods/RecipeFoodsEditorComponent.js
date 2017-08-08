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
var ImgComponent=require("./../../widget/ImgComponent");

import Upload from 'rc-upload';

var Toolbar=require("./../../widget/Toolbar");

class RecipeFoodsEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var recipeFoodBean=JSON.parse(decodeURIComponent(this.props.params.recipeFoodBean));
        this.state = {
            recipeFoodBean:recipeFoodBean,
            uploaderProps :{
                headers: {
                    Authorization: 'xxxxxxx',
                },
                multiple: false,
                beforeUpload(file) {
                    console.log('beforeUpload', file.name);
                },
                onStart: (file) => {
                    console.log('onStart', file.name);
                },
                onProgress(step, file) {
                    console.log('onProgress', Math.round(step.percent), file.name);
                },
                onError(err) {
                    console.log('onError', err);
                    toast.show("上传失败");
                },
            },
        };
    }

    insertRecipeFood(){
        if(this.state.recipeFoodBean.food_name===''){
            toast.show("材料名称不可为空");
            return;
        }

        if(this.state.recipeFoodBean.food_img===''){
            toast.show("图片不可为空");
            return;
        }

        if(this.state.recipeFoodBean.food_count===''){
            toast.show("份量不可为空");
            return;
        }

        if(this.state.recipeFoodBean.recipe_food_id){
            this.getDataByPost(2,homeurl+"recipeController.api?updateRecipeFood",
                {recipe_food_id:this.state.recipeFoodBean.recipe_food_id,
                recipe_id:this.state.recipeFoodBean.recipe_id,
                food_name:this.state.recipeFoodBean.food_name,
                food_count:this.state.recipeFoodBean.food_count,
                food_img:this.state.recipeFoodBean.food_img,
                parent_id:this.state.recipeFoodBean.parent_id});
        }else{
            this.getDataByPost(1,homeurl+"recipeController.api?insertRecipeFood",
                {food_name:this.state.recipeFoodBean.food_name,
                    recipe_id:this.state.recipeFoodBean.recipe_id,
                food_count:this.state.recipeFoodBean.food_count,
                food_img:this.state.recipeFoodBean.food_img,
                parent_id:this.state.recipeFoodBean.parent_id});
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
                        title="材料名称"
                        marginTop={20}
                        value={this.state.recipeFoodBean.food_name}
                        onChange={(value)=>{
                            this.state.recipeFoodBean.food_name=value;
                            this.setState({
                                recipeFoodBean:this.state.recipeFoodBean,
                            })
                        }}>
                </EditorComponent>
                <EditorComponent
                    title="份量"
                    marginTop={20}
                    value={this.state.recipeFoodBean.food_count}
                    onChange={(value)=>{
                            this.state.recipeFoodBean.food_count=value;
                            this.setState({
                                recipeFoodBean:this.state.recipeFoodBean,
                            })
                        }}>
                </EditorComponent>
                <ImgComponent
                    title="图片"
                    marginTop={20}
                    src={imgurl+this.state.recipeFoodBean.food_img}
                    url={homeurl+'recipeController.api?uploadRecipeFoodImg'}
                    onSuccess={(data)=>{
                        this.state.recipeFoodBean.food_img=data;
                        this.setState({
                            recipeFoodBean:this.state.recipeFoodBean
                        })
                    }}>
                </ImgComponent>
                <ButtonComponent
                    width={100}
                    marginLeft={100}
                    marginTop={10}
                    background="blue"
                    value="保存"
                    onClick={()=>{
                        this.insertRecipeFood();
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

module.exports=RecipeFoodsEditorComponent;
