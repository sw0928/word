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

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");
var PageComponent=require("./../../widget/PageComponent");
var ListViewComponent=require("./../../widget/ListViewComponent");

class RecipeComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            recipeBeans:[],
            visible:false,
            recipe_index:1,
            page:1,
            total:0,
            parent_id:this.props.params.recipe_id,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'recipe_id'},
                {name:"食谱名",flex:1,key:'recipe_name'},
                {name:"创建时间",flex:1,key:'create_time'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getRecipes(this.state.page);
    }

    getRecipes(page){
        this.getDataByPost(1,homeurl+"recipeController.api?getRecipes",
            {parent_id:this.state.parent_id,page:page},{type:2})
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

    deleteRecipe(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"recipeController.api?deleteRecipe",
            {recipe_id:this.state.recipeBeans[this.state.recipe_index].recipe_id});
    }


    render(){
        return(
            <div style={{background:'#ffffff',display:'flex',flexDirection:'column'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteRecipe();
                              }}></TipComponent>
                <Toolbar title="食谱管理" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.recipeBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/goods_detail_recipe/"+encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/goods_detail_recipe/"+encodeURIComponent(JSON.stringify(this.state.recipeBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[详情]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                recipe_index:rowID
                                            })
                                            }}>
                                        <div>
                                            <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                        </div>
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
        fontSize:15,
        wordBreak:'break-all'
    }
};

module.exports=RecipeComponent;
