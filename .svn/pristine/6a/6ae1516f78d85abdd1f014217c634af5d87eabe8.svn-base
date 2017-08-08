/**
 * Created by shenjiabo on 16/8/25.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import Upload from 'rc-upload';
var Toolbar=require("./../../widget/Toolbar");

var parent_id="";

var RecipeFoodComponent=require("./RecipeFoodComponent");

var TabBar=require('./../../widget/TabBar');

var TextComponent=require('./../../widget/TextComponent');
var EditorComponent=require('./../../widget/EditorComponent');
var CheckComponent=require('./../../widget/CheckComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var SelectComponent=require('./../../widget/SelectComponent');

class GoodsEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var recipeBean=JSON.parse(this.props.params.recipeBean);
        if(!recipeBean.recipe_id){
            storage.set("recipeIndex",0);
        }
        this.state = {
            recipeBean:recipeBean,
            recipeImgBeans:recipeBean.recipeImgBeans?recipeBean.recipeImgBeans:[],
            moudleBeans:[],
            index:0,
        };
    }

    componentDidMount() {
        this.updateMoudle(this.state.recipeBean);
    }

    updateMoudle(recipeBean) {
        if(recipeBean.recipe_id){
            this.setState({
                recipeBean:recipeBean,
            });

            this.setState({
                moudleBeans:[
                    {"name":"基本信息",component:this.renderBase()},
                    {"name":"图片编辑",component:this.renderPicture()},
                    {"name":"详情编辑",component:this.renderDetail()},
                    {"name":"食谱",component:this.renderFood()},
                ]
            })
        }else {
            this.setState({
                moudleBeans:[{"name":"基本信息",component:this.renderBase()}]
            })
        }
    }


    render(){
        return(
            <div>
                <Toolbar title="食谱详情" history={this.props.history}></Toolbar>
                <TabBar saveIndex="recipeIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}></TabBar>
            </div>
        )
    }

    renderBase(){
        return(
            <BaseDetail updateMoudle={this.updateMoudle.bind(this)} recipeBean={this.state.recipeBean}></BaseDetail>
        )
    }

    renderPicture(){
        return(
            <RenderPicture recipeBean={this.state.recipeBean}></RenderPicture>
        )
    }

    renderDetail(){
        return(
            <RenderDetail recipeBean={this.state.recipeBean}></RenderDetail>
        )
    }

    renderFood(){
        return(
            <RecipeFoodComponent recipe_id={this.state.recipeBean.recipe_id}>

            </RecipeFoodComponent>
        )
    }
}

class BaseDetail extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            recipeBean:this.props.recipeBean,
        };
    }

    componentDidMount() {

    }

    insertRecipeDetail(){
        if(this.state.recipeBean.recipe_name===''){
            toast.show("名称不可为空");
            return;
        }
        if(this.state.recipeBean.recipe_id){
            this.getDataByPost(2,homeurl+"recipeController.api?updateRecipe",
                {recipe_id:this.state.recipeBean.recipe_id,
                    recipe_name:this.state.recipeBean.recipe_name,
                    sort:this.state.recipeBean.sort});
        }else{
            this.getDataByPost(1,homeurl+"recipeController.api?insertRecipe",
                {parent_id:this.state.recipeBean.parent_id,
                    recipe_name:this.state.recipeBean.recipe_name,
                    sort:this.state.recipeBean.sort});
        }

    }

    doSuccess(index,data){
        switch(index){
            case 1:
                toast.show("保存成功");
                this.setState({
                    recipeBean:data
                });
                this.props.updateMoudle(data);
                break;
            case 2:
                toast.show("保存成功");
                this.setState({
                    recipeBean:data
                });
                this.props.updateMoudle(data);
                break;
        }
    }
    render(){
        return(
            <div>
                <EditorComponent
                    marginTop={20}
                    title="食谱名称"
                    value={this.state.recipeBean.recipe_name}
                    onChange={(value)=>{
                    this.state.recipeBean.recipe_name=value;
                    this.setState({
                        recipeBean:this.state.recipeBean,
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
                        recipeBean:this.state.recipeBean,
                    })
                }}>

                </EditorComponent>
                <ButtonComponent value="保存"
                                 width={80}
                                 marginLeft={100}
                                 marginTop={20}
                                 background='blue'
                                 onClick={()=>{
                                    this.insertRecipeDetail();
                                 }}>
                </ButtonComponent>
            </div>
        )
    }
}

class RenderDetail extends  BaseComponent{
    render(){
        return(
            <div style={{display:this.props.recipeBean.recipe_id?'flex':"none"}}>
                <iframe src={htmlurl+"/recipe_editor.html?recipe_url="+this.props.recipeBean.recipe_url}
                        style={{display:'flex',width:1000,height:800}}>
                </iframe>
            </div>
        )
    }
}

class RenderPicture extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态

        this.state = {
            recipeBean:this.props.recipeBean,
            recipeImgBeans:[],
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
            visible:false,
            recipe_index:-1,
        };
    }

    componentDidMount() {
        this.getImgs();
    }

    getImgs(){
        this.getDataByPost(1,homeurl+"recipeController.api?getRecipeImgs",{recipe_id:this.state.recipeBean.recipe_id})
    }
    deleteRecipeImg(){
        this.setState({
            visible:false
        })
        this.getDataByPost(2,homeurl+"recipeController.api?deleteRecipeImg",
            {recipe_img_id:this.state.recipeImgBeans[this.state.recipe_index].recipe_img_id})
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    recipeImgBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getImgs();
                break;
        }
    }
    render(){
        return(
            <div>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteRecipeImg();
                              }}></TipComponent>
                <div style={{display:'flex',flex:1,alignItems:'center',marginLeft:20,marginTop:20}}>
                    <p1 style={{marginLeft:20,fontSize:15}}>展示图片</p1>
                    <ListView
                            style={{display:'flex',flexDirection:'row',
                            flexWrap:'wrap',alignItems:'center',justifyContent:'center'}}
                            dataSource={this.state.recipeImgBeans}
                            renderRow={(rowID)=>{
                                return(
                                    <div style={{display:'flex',flexDirection:'column',justifyContent:'center'}}>
                                      <Upload {...this.state.uploaderProps}
                                        ref="inner"
                                        style={{outline:'none'}}
                                        name="recipe_img"
                                        action={homeurl+'recipeController.api?updateRecipeImg'}
                                        data={{recipe_img_id:this.state.recipeImgBeans[rowID].recipe_img_id,
                                            sort:1,}}
                                        onSuccess={(data)=>{
                                                        if(data.status==='ok'){
                                                            this.state.recipeImgBeans[rowID]=data.data;
                                                            this.setState({
                                                                recipeImgBeans:this.state.recipeImgBeans
                                                            })
                                                        }else{
                                                            toast.show(data.error);
                                                        }
                                                    }}>
                                            <img src={imgurl+this.state.recipeImgBeans[rowID].recipe_img} style={{marginLeft:10,width:80,height:80}}/>
                                      </Upload>
                                      <div style={{height:40,width:80,display:'flex',
                                            justifyContent:'center',alignItems:'center'}}
                                            onClick={()=>{
                                                    this.setState({
                                                        visible:true,
                                                        recipe_index:rowID,
                                                    });
                                            }}>
                                            <p1 style={{fontSize:15}}>删除</p1>
                                      </div>
                                    </div>
                                );
                            }}>
                        </ListView>
                        <Upload {...this.state.uploaderProps}
                                ref="inner"
                                style={{outline:'none'}}
                                name="recipe_img"
                                action={homeurl+'recipeController.api?uploadRecipeImg'}
                                data={{recipe_id:this.state.recipeBean.recipe_id,
                                    sort:1,}}
                                onSuccess={(data)=>{
                                                if(data.status==='ok'){
                                                    this.setState({
                                                        recipeImgBeans:[data.data].concat(this.state.recipeImgBeans),
                                                    })
                                                }else{
                                                    toast.show(data.error);
                                                }
                                            }}>
                                    <img src='./images/add.jpg' style={{width:80,height:80,marginLeft:10}}/>
                        </Upload>
                    </div>
            </div>

        )
    }
}

const styles = {
    tab:{
        display:'flex',
        flex:1,
        height:50,
        alignItems:'center',
        marginLeft:100,
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    input:{
        width:200,
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
    },
}
module.exports=GoodsEditorComponent;

