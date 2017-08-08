/**
 * Created by shenjiabo on 16/8/17.
 * 美食分类编辑
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
var PageComponent=require("./../../widget/PageComponent");

var SearchBar=require("./../../widget/SearchBar");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var ListViewComponent=require("./../../widget/ListViewComponent");

class MerchantsAccountComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            baseData:[],
            sspClassBeans:[],
            class_index:-1,
            page:1,
            total:0,
            dataSource:[
                {name:"预售商品",type:"is_pre_sale"},
                {name:"限时促销",type:"ssp_promotion"},
                {name:"礼品",type:"ssp_gift"},
                {name:"生鲜",type:"ssp_fresh"},
                {name:"母婴",type:"ssp_baby"},
                {name:"女士",type:"ssp_lady"},
                {name:"特色推荐",type:"ssp_feature"},
                {name:"进口",type:"ssp_import"},
            ],
            itemCurIndex:parseInt(storage.get("sspIndex")?storage.get("sspIndex"):"0"),
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'class_id'},
                {name:"分类名称",flex:1,key:'class_name'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getSSPClasss(this.state.itemCurIndex);
    }

    getSSPClasss(rowID){
        this.getDataByPost(1,homeurl+"goodsController.api?getSSPHomeClasss",
            {class_type:this.state.dataSource[rowID].type})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    sspClassBeans:data
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getSSPClasss(this.state.itemCurIndex);
                break;
        }
    }

    deleteMerchantsAccount(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"goodsController.api?deleteSSPHomeClass",
            {class_id:this.state.sspClassBeans[this.state.class_index].class_id});
    }

    render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.setState({
                                        visible:false
                                  })
                                  this.deleteMerchantsAccount();
                              }}></TipComponent>
                <Toolbar title="分类列表" history={this.props.history}></Toolbar>
                <ListView
                    style={{display:'flex',flex:1,flexWrap:'wrap',height:40,background:'#323232'}}
                    dataSource={this.state.dataSource}
                    renderRow={(rowID)=>{
                        return(
                             <div style={{width:100,display:'flex',
                                                alignItems:'center',justifyContent:'center',
                                                background:this.state.itemCurIndex===rowID?"#efefef":"#323232"}}
                                        onClick={()=>{
                                            storage.set("sspIndex",rowID);
                                            this.setState({
                                                itemCurIndex:rowID
                                            })
                                            this.getSSPClasss(rowID);
                                        }}>
                                        <p1 style={{fontSize:15,color:this.state.itemCurIndex===rowID?"#000000":"#ffffff"}}>
                                            {this.state.dataSource[rowID].name}
                                        </p1>
                                    </div>
                        )
                    }}>
                    
                </ListView>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.sspClassBeans}
                    renderAdd={()=>{
                        return(
                            <Link to={"/ssp_class_editor/"+encodeURIComponent(JSON.stringify({class_type:this.state.dataSource[this.state.itemCurIndex].type}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/ssp_class_editor/"+encodeURIComponent(JSON.stringify(this.state.sspClassBeans[rowID]))}
                                          style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[编辑]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                                onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    class_index:rowID
                                                })
                                                }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}>
                </ListViewComponent>
            </div>
        );
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
    item:{
        flex:1,
        display:'flex',
        borderLeftWidth:1,
        borderTopWidth:1,
        borderLeftColor:'#efefef',
        borderTopColor:'#efefef',
        borderLeftStyle:'solid',
        borderTopStyle:'solid',
        flexDirection:'column',
        marginLeft:10,
        marginRight:10,
        marginTop:10
    },
    tabColumn: {
        flex: 1,
        display:'flex',
        flexDirection: 'column',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabRow: {
        flex: 1,
        display:'flex',
        flexWrap:'wrap',
        flexDirection: 'row',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabP1:{
        fontSize:13,
        wordBreak:'break-all'
    }
};

module.exports=MerchantsAccountComponent;
