/**
 * Created by shenjiabo on 16/9/1.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import 'react-date-picker/index.css'
var Toolbar=require("./../../widget/Toolbar");

class RecipeFoodComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            recipeFoodBeans:[],
            visible:false,
            recipe_food_id:0,
        };
    }

    componentDidMount() {
        this.getRecipes();
    }

    getRecipes(){
        this.getDataByPost(1,homeurl+"/recipeController.api?getRecipeFoods",
            {recipe_id:this.props.recipe_id})
    }
    
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    recipeFoodBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getRecipes();
                break;
        }
    }

    deleteParameter(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"recipeController.api?deleteRecipeFood",
            {recipe_food_id:this.state.recipe_food_id})
    }
    render(){
        return(
            <div style={{display:'flex',flexDirection:'column'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteParameter();
                              }}></TipComponent>
                <ListView
                    style={styles.item}
                    dataSource={this.state.recipeFoodBeans}
                    renderHeader={()=>{
                        return(
                            <div style={{flex:1,display:'flex'}}>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>ID</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>名称</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>份量</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>图片</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>操作</p1>
                                        <Link to={"/goods_recipe_food/"+
                                                encodeURIComponent(JSON.stringify({recipe_id:this.props.recipe_id,parent_id:"-1",
                                                parameter_type:'1'}))}
                                                style={{textDecoration:'none'}}>
                                            <p1>+</p1>
                                        </Link>
                                    </div>
                            </div>
                        )
                    }}
                    renderRow={(rowID)=>{
                        return(
                            <div>
                                <div style={{flex:1,display:'flex',background:'#efefef'}}>
                                        <div style={styles.tabColumn}>
                                            <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].recipe_id}</p1>
                                        </div>
                                        <div style={styles.tabColumn}>
                                            <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].food_name}</p1>
                                        </div>
                                        <div style={styles.tabColumn}>
                                            <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].food_count}</p1>
                                        </div>
                                         <div style={styles.tabColumn}>
                                            <img src={imgurl+this.state.recipeFoodBeans[rowID].food_img}
                                                    style={{width:40,height:40}}/>
                                        </div>
                                        <div style={styles.tabRow}>
                                            <Link to={'/goods_recipe_food/'+
                                                encodeURIComponent(JSON.stringify({recipe_id:this.props.recipe_id,
                                                parent_id:this.state.recipeFoodBeans[rowID].recipe_food_id}))}
                                                style={{textDecoration:'none'}}>
                                                <p1 style={{fontSize:15,color:'blue'}}>[添加子分类]</p1>
                                            </Link>
                                            <Link to={'/goods_recipe_food/'+
                                                encodeURIComponent(JSON.stringify(this.state.recipeFoodBeans[rowID]))}
                                                style={{textDecoration:'none'}}>
                                                <p1 style={{fontSize:15,color:'blue',marginLeft:10}}>[编辑]</p1>
                                            </Link>
                                            <div style={{marginLeft:10}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    recipe_food_id:this.state.recipeFoodBeans[rowID].recipe_food_id,
                                                })
                                            }}>
                                                <p1 style={{fontSize:15,color:'blue'}}>[删除]</p1>
                                            </div>
                                        </div>
                                </div>
                                <ListView
                                    dataSource={this.state.recipeFoodBeans[rowID].recipeFoodBeans}
                                    renderRow={(index)=>{
                                        return(
                                            <div style={{flex:1,display:'flex'}}>
                                                    <div style={styles.tabColumn}>
                                                        <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].recipeFoodBeans[index].recipe_id}</p1>
                                                    </div>
                                                    <div style={styles.tabColumn}>
                                                        <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].recipeFoodBeans[index].food_name}</p1>
                                                    </div>
                                                    <div style={styles.tabColumn}>
                                                        <p1 style={styles.tabP1}>{this.state.recipeFoodBeans[rowID].recipeFoodBeans[index].recipe_count}</p1>
                                                    </div>
                                                    <div style={styles.tabColumn}>
                                                        <img src={imgurl+this.state.recipeFoodBeans[rowID].recipeFoodBeans[index].food_img}
                                                                style={{width:40,height:40}}/>
                                                    </div>

                                                    <div style={styles.tabRow}>
                                                        <Link to={'/goods_recipe_food/'+
                                                            encodeURIComponent(JSON.stringify(this.state.recipeFoodBeans[rowID].recipeFoodBeans[index]))}
                                                            style={{textDecoration:'none'}}>
                                                            <p1 style={{fontSize:15,color:'blue',marginLeft:10}}>[编辑]</p1>
                                                        </Link>
                                                        <div style={{marginLeft:10}}
                                                        onClick={()=>{
                                                            this.setState({
                                                                visible:true,
                                                                recipe_food_id:this.state.recipeFoodBeans[rowID].recipeFoodBeans[index].recipe_food_id
                                                            })
                                                        }}>
                                                            <p1 style={{fontSize:15,color:'blue'}}>[删除]</p1>
                                                        </div>
                                                    </div>
                                            </div>
                                        );
                                    }}>

                                </ListView>
                            </div>
                        );
                    }}>

                </ListView>
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
module.exports=RecipeFoodComponent;