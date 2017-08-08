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
var SelectComponent=require('./../../widget/SelectComponent');

var Widget=require('./../../widget/WidgetComponent');

var goods_state_index=-1;
var information_recommend_index=-1;
class InformationEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var informationBean=JSON.parse(decodeURIComponent(this.props.params.informationBean));
        this.state = {
            informationBean:informationBean,
            informationImgBeans:informationBean.informationImgBeans?informationBean.informationImgBeans:[],
            goodsRecommendBeans:[{id:'0',name:'不推荐'},{id:'1',name:'推荐'}],

            allGoodsBeans:[],
            selectBean:{},
            goods_name:"",
        };
    }

    componentDidMount() {
        this.getGoods();
    }

    getGoods(){
        this.getDataByPost(3,homeurl+"goodsController.api?getAllGoodsDetailNoPage",{})
    }

    insertMoudle(){
        if(this.isNull(this.state.informationBean.information_title)){
            toast.show("标题不可为空");
            return;
        }

        console.log(JSON.stringify(this.state.informationImgBeans));

        if(!this.state.informationBean.information_id){
            this.getDataByPost(1,homeurl+"informationController.api?insertInformation",
                {information_title:this.state.informationBean.information_title,
                    information_img:this.state.informationBean.information_img,
                    parent_id:this.state.informationBean.parent_id,
                    sort:this.state.informationBean.sort,
                    information_type:this.state.informationBean.information_type,
                    information_desc:this.state.informationBean.information_desc,
                    is_recommend:this.state.goodsRecommendBeans[information_recommend_index].id,
                    information_imgs:JSON.stringify(this.state.informationImgBeans)});
        }else{
            this.getDataByPost(2,homeurl+"informationController.api?updateInformation",
                {
                    information_id:this.state.informationBean.information_id,
                    information_title:this.state.informationBean.information_title,
                    information_img:this.state.informationBean.information_img,
                    parent_id:this.state.informationBean.parent_id,
                    information_type:this.state.informationBean.information_type,
                    sort:this.state.informationBean.sort,
                    information_desc:this.state.informationBean.information_desc,
                    is_recommend:this.state.goodsRecommendBeans[information_recommend_index].id,
                    information_imgs:JSON.stringify(this.state.informationImgBeans)});
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
            case 3:
                this.setState({
                    allGoodsBeans:data
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="知识编辑" history={this.props.history}></Toolbar>
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMoudle();
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="标题"
                    value={this.state.informationBean.information_title}
                    onChange={(value)=>{
                        this.state.informationBean.information_title=value;
                        this.setState({
                            informationBean:this.state.informationBean
                        })
                    }}/>
                <TextareaComponent
                    height={100}
                    marginTop={20}
                    title="描述"
                    value={this.state.informationBean.information_desc}
                    onChange={(value)=>{
                        this.state.informationBean.information_desc=value;
                        this.setState({
                            informationBean:this.state.informationBean
                        })
                    }}/>
                <ImgComponent
                    marginTop={20}
                    title="图片"
                    src={this.state.informationBean.information_img===''?"./images/add.jpg":imgurl+this.state.informationBean.information_img}
                    url={homeurl+'goodsController.api?uploadGoodsImg'}
                    onSuccess={(data)=>{
                        this.state.informationBean.information_img=data;
                        this.setState({
                            informationBean:this.state.informationBean,
                        })
                    }}/>
                <SelectComponent
                    marginTop={20}
                    dataSource={this.state.goodsRecommendBeans}
                    title="是否推荐"
                    init_value={this.state.informationBean.is_recommend}
                    select_value="id"
                    show_value="name"
                    onChange={(rowID)=>{
                                information_recommend_index=rowID
                             }}>
                </SelectComponent>

                <EditorComponent
                    marginTop={20}
                    title="权重"
                    value={this.state.informationBean.sort}
                    onChange={(value)=>{
                        this.state.informationBean.sort=value;
                        this.setState({
                            informationBean:this.state.informationBean
                        })
                    }}/>
                <div style={{width:this.props.width?this.props.width:100,display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <p1 style={{fontSize:13}}>图片列表</p1>
                </div>
                <Widget.ListView
                    dataSource={this.state.informationImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                                <ImgComponent
                                    marginTop={20}
                                    title="图片"
                                    src={this.isNull(this.state.informationImgBeans[rowID].information_img)?"./images/add.jpg":imgurl+this.state.informationImgBeans[rowID].information_img}
                                    url={homeurl+'goodsController.api?uploadGoodsImg'}
                                    onSuccess={(data)=>{
                                        this.state.informationImgBeans[rowID].information_img=data;
                                        this.setState({
                                            informationImgBeans:this.state.informationImgBeans,
                                        })}
                                    }/>
                                <Widget.SearchBar
                                    marginLeft={20}
                                    item_name="goods_name"
                                    dataSource={this.state.allGoodsBeans}
                                    name={this.state.informationImgBeans[rowID].goods_name}
                                    onPress={(data,value)=>{
                                        this.state.informationImgBeans[rowID].goods_id=data.goods_id;
                                        this.state.informationImgBeans[rowID].goods_name=value;
                                        this.setState({
                                            informationImgBeans:this.state.informationImgBeans
                                        })
                                    }}/>
                                    <Widget.Button
                                        marginLeft={20}
                                        value="删除"
                                        onClick={()=>{
                                            this.state.informationImgBeans.splice(rowID,1);
                                            this.setState({
                                                informationImgBeans:this.state.informationImgBeans
                                            })
                                        }}/>
                            </div>
                        )
                    }}/>
                <Widget.Button
                    marginTop={20}
                    width={100}
                    marginLeft={200}
                    value="添加"
                    onClick={()=>{
                        this.state.informationImgBeans.push({information_id:this.state.informationBean.information_id});
                        this.setState({
                            informationImgBeans:this.state.informationImgBeans
                        })
                    }}/>

            </div>
        )
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
module.exports=InformationEditorComponent;