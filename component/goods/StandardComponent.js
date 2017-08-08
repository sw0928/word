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
var ListViewComponent=require("./../../widget/ListViewComponent");

class StandardComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            standardBeans:[],
            standard_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'standard_id'},
                {name:"名称",flex:1,key:'standard_name'},
                {name:"内容",flex:1,key:"standard_desc"},
                {name:"操作",flex:2,key:"-1"}
            ]
        });
        this.getStandards();
    }

    getStandards(){
        this.getDataByPost(1,homeurl+"/goodsController.api?getGoodsStandard",
            {goods_id:this.props.goods_id,standard_type:this.props.standard_type})
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    standardBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getStandards();
                break;
        }
    }

    deleteStandard(){
        this.setState({
            visible:false,
        });
        this.getDataByPost(2,homeurl+"goodsController.api?deleteStandard",
            {standard_id:this.state.standardBeans[this.state.standard_index].standard_id});
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
                                  this.deleteStandard();
                              }}></TipComponent>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.standardBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/goods_standard_editor/"+
                                                encodeURIComponent(JSON.stringify({goods_id:this.props.goods_id}))}
                                                style={{textDecoration:'none'}}>
                                <p1>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                               var param=this.state.standardBeans[rowID];
                                               param["goods_id"]=this.props.goods_id;
                                               this.props.history.push("/goods_standard_editor/"+encodeURIComponent(JSON.stringify(param)));
                                            }}>
                                    <p1 style={{fontSize:13,color:'blue'}}>[编辑]</p1>
                                </div>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    standard_index:rowID,
                                                })
                                            }}>
                                    <p1 style={{fontSize:13,color:'blue'}}>[删除]</p1>
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
module.exports=StandardComponent;