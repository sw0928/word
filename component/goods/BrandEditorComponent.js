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

var Widget=require('./../../widget/WidgetComponent');

class BrandEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var brandBean=JSON.parse(decodeURIComponent(this.props.params.brandBean));
        this.state = {
            brandBean:brandBean,
            brand_name:brandBean.brand_name?brandBean.brand_name:"",
            brand_img:brandBean.brand_img?brandBean.brand_img:"",
            sort:brandBean.sort?brandBean.sort:"1",
        };
    }


    render(){
        return(
            <div>
                <Toolbar title="品牌编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    marginTop={20}
                    title="品牌名称"
                    value={this.state.brand_name}
                    onChange={(value)=>{
                        this.setState({
                            brand_name:value
                        })
                    }}/>
                <Widget.Textarea
                    marginTop={20}
                    height={200}
                    title="品牌描述"
                    value={this.state.brandBean.brand_desc}
                    onChange={(value)=>{
                        this.state.brandBean.brand_desc=value;
                        this.setState({
                            brandBean:this.state.brandBean
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="图片(130*60)"
                    src={this.state.brand_img===''?"./images/add.jpg":imgurl+this.state.brand_img}
                    url={homeurl+'goodsController.api?uploadBrandImg'}
                    onSuccess={(data)=>{
                        this.setState({
                            brand_img:data,
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
        if(this.state.brand_name===''){
            toast.show("品牌名称不可为空");
            return;
        }

        if(!this.state.brandBean.brand_id){
            this.getDataByPost(1,homeurl+"goodsController.api?insertBrand",
                {brand_name:this.state.brand_name,brand_img:this.state.brand_img,
                    sort:this.state.sort,
                    brand_desc:this.state.brandBean.brand_desc});
        }else{
            this.getDataByPost(2,homeurl+"goodsController.api?updateBrand",
                {brand_id:this.state.brandBean.brand_id,brand_name:this.state.brand_name,brand_img:this.state.brand_img,
                    sort:this.state.sort,
                    brand_desc:this.state.brandBean.brand_desc});
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
module.exports=BrandEditorComponent;