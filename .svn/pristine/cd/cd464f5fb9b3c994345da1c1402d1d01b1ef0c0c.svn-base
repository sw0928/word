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

class ServiceComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            serviceBeans:[],
            visible:false,
            service_id:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'service_id'},
                {name:"服务名称",flex:1,key:'service_name'},
                {name:"价格",flex:1,key:"service_price"},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getServices();
    }

    getServices(){
        this.getDataByPost(1,homeurl+"/goodsController.api?getAllServices",
            {goods_id:this.props.goods_id})
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    serviceBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getServices();
                break;
        }
    }

    deleteService(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"goodsController.api?deleteService",
            {service_id:this.state.service_id})
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
                                  this.deleteService();
                              }}></TipComponent>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.serviceBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/goods_service_editor/"+
                                                encodeURIComponent(JSON.stringify({goods_id:this.props.goods_id,parent_id:"-1",
                                                service_type:'1'}))}
                                                style={{textDecoration:'none'}}>
                                <p1>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={'/goods_service_editor/'+
                                                encodeURIComponent(JSON.stringify({goods_id:this.props.goods_id,parent_id:this.state.serviceBeans[rowID].service_id,service_type:'2'}))}
                                                    style={{textDecoration:'none'}}>
                                        <p1 style={{fontSize:15,color:'blue'}}>[添加子分类]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={'/goods_service_editor/'+
                                                    encodeURIComponent(JSON.stringify(this.state.serviceBeans[rowID]))}
                                                    style={{textDecoration:'none'}}>
                                        <p1 style={{fontSize:15,color:'blue',marginLeft:10}}>[编辑]</p1>
                                    </Link>
                                </div>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    service_id:this.state.serviceBeans[rowID].service_id,
                                                })
                                            }}>
                                    <p1 style={{fontSize:15,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}
                    renderChild={(rowID)=>{
                        return(
                            <ListViewComponent
                                hideVisible="true"
                                marginLeft={0.1}
                                marginRight={0.1}
                                marginTop={0.1}
                                background="#f5f5f5"
                                data={this.state.baseData}
                                dataSource={this.state.serviceBeans[rowID].goodsServiceBeans}
                                renderOperation={(index)=>{
                                    return(
                                        <div style={{display:'flex',flex:1}}>
                                            <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                                <Link to={'/goods_service_editor/'+
                                                                encodeURIComponent(JSON.stringify(this.state.serviceBeans[rowID].goodsServiceBeans[index]))}
                                                                style={{textDecoration:'none'}}>
                                                    <p1 style={{fontSize:15,color:'blue',marginLeft:10}}>[编辑]</p1>
                                                </Link>
                                            </div>
                                            <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                                        onClick={()=>{
                                                            this.setState({
                                                                visible:true,
                                                                service_id:this.state.serviceBeans[rowID].goodsServiceBeans[index].service_id
                                                            })
                                                        }}>
                                                <p1 style={{fontSize:15,color:'blue'}}>[删除]</p1>
                                            </div>

                                        </div>
                                    )
                                }}/>
                                )
                    }}/>

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
module.exports=ServiceComponent;