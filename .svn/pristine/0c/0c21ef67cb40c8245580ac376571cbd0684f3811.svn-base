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
            recipeBeans:[],
            recipe_index:-1,
            page:1,
            total:0,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'recipe_id'},
                {name:"分类名称",flex:1,key:'recipe_name'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getRecipes(this.state.page);
    }

    getRecipes(page){
        this.getDataByPost(1,homeurl+"recipeController.api?getRecipes",
            {parent_id:"-1",page:page},{type:2})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    recipeBeans:data.data,
                    total:data.total
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getRecipes(this.state.page);
                break;
        }
    }

    deleteMerchantsAccount(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"recipeController.api?deleteRecipe",
            {recipe_id:this.state.recipeBeans[this.state.recipe_index].recipe_id});
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
                <Toolbar title="美食分类" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.recipeBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/goods_recipe_class_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/goods_recipe_class_editor/"+encodeURIComponent(JSON.stringify(this.state.recipeBeans[rowID]))}
                                          style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[编辑]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/goods_recipe/"+this.state.recipeBeans[rowID].recipe_id}
                                          style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[美食管理]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                                onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    recipe_index:rowID
                                                })
                                                }}>
                                        <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getRecipes(page)
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
