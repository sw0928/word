/**
 * Created by shenjiabo on 16/8/23.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../widget/ListView');
var BaseComponent=require('./BaseComponent');

class MainComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsAccountBean=JSON.parse(storage.get("merchantsAccountBean"));
        this.state = {
            moudleBeans:[],
            itemCurIndex:0,
            menuCurIndex:0,
            merchantsAccountBean:merchantsAccountBean,
            visible:false,
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"systemController.api?getAllMoudle",
            {role_id:this.state.merchantsAccountBean.role_id,parent_id:"-1"});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    moudleBeans:data,
                });
                storage.set("titleInfo","[]");
                this.props.history.push(data[0].menuBeans[0].moudle_url);
                break;
        }
    }

    render(){
        return(
            <div style={{display:'flex',height:'100%',width:'100%',flex:1,flexDirection:'column'}}>
                <div style={{background:'#000000',height:40,display:'flex',alignItems:'center'}}>
                    <p1 style={{marginLeft:20,color:'#ffffff'}}>管理后台</p1>
                    <div style={{display:'flex',justifyContent:'flex-end',alignItems:'center',flex:1}}
                        onMouseOver={()=>{
                            this.setState({
                                visible:true,
                            })
                        }}
                        onMouseLeave={()=>{
                            this.setState({
                                visible:false,
                            })
                        }}>
                        <div style={{height:40,}}>
                            <div style={{marginRight:20,height:40,display:'flex',alignItems:'center'}}>
                                <p1 style={{color:'#ffffff'}}>{this.state.merchantsAccountBean.merchants_name}</p1>
                                <img src={'./images/shang.png'}
                                     style={{width:12,height:8,marginLeft:10}}/>
                            </div>
                            <div style={{display:this.state.visible?'flex':"none",flexDirection:'column'
                                ,position:'relative',left:0,right:0,top:0,
                                borderWidth:1,borderColor:'#efefef',borderStyle:'solid'}}>
                                <div style={{background:'#ffffff',display:'flex',width:100,height:30,
                                            alignItems:"center",justifyContent:'center'}}
                                     onClick={()=>{
                                        this.props.history.push("/user_detail_component/1");
                                    }}>
                                    <p1 style={{fontSize:13}}>个人信息</p1>
                                </div>
                                <div style={{background:'#efefef',height:1}}></div>
                                <div style={{background:'#ffffff',display:'flex',width:100,height:30,
                                    alignItems:"center",justifyContent:'center'}}
                                     onClick={()=>{
                                        this.props.history.push("/user_detail_component/2");
                                    }}>
                                    <p1 style={{fontSize:13}}>修改密码</p1>
                                </div>
                                <div style={{background:'#efefef',height:1}}></div>
                                <div style={{background:'#ffffff',display:'flex',width:100,height:30,
                                                alignItems:"center",justifyContent:'center'}}
                                                onClick={()=>{
                                                    storage.set("merchantsAccountBean",JSON.stringify({}));
                                                    window.location.href= htmlurl+"index.html";
                                                }}>
                                    <p1 style={{fontSize:13}}>退出登录</p1>
                                </div>
                                <div style={{background:'#efefef',height:1}}></div>
                            </div>
                        </div>
                        <img src={imgurl+this.state.merchantsAccountBean.merchants_img}
                             style={{marginRight:20,width:30,height:30,borderRadius:30}}></img>
                    </div>
                </div>
                <div style={{display:'flex',flex:1}}>
                    <ListView
                        style={{width:160,background:'#c8c8c8',display:'flex',flexDirection:'column'}}
                        dataSource={this.state.moudleBeans}
                        renderRow={(rowID)=>{
                        return(
                            <div>
                                <div style={{background:'#cdcdcd',height:1,flex:1}}></div>
                                <div style={{height:38,width:160,background:'#c8c8c8',display:'flex',alignItems:'center'}}
                                    onClick={()=>{
                                        storage.set("itemCurIndex",rowID);
                                        storage.set("menuCurIndex",0);
                                        storage.set("titleInfo","[]");
                                        this.setState({
                                            itemCurIndex:rowID,
                                            menuCurIndex:0,
                                        });
                                        this.props.history.push(this.state.moudleBeans[rowID].menuBeans[0].moudle_url);
                                    }}>
                                    <p1 style={{fontSize:13,marginLeft:20}}>{this.state.moudleBeans[rowID].moudle_name}</p1>
                                    <div style={{display:'flex',flex:1,justifyContent:'flex-end'}}>
                                        <img src={this.state.itemCurIndex===rowID?"./images/xia.png":'./images/shang.png'}
                                        style={{width:12,height:8,marginRight:20}}/>
                                    </div>
                                </div>
                                <div style={{background:'#cdcdcd',height:1,flex:1}}></div>
                                <ListView
                                    style={{display:this.state.itemCurIndex===rowID?'flex':"none",
                                            flexDirection:'column',}}
                                    dataSource={this.state.moudleBeans[rowID].menuBeans}
                                    renderRow={(index)=>{
                                        return(
                                            <Link to={this.state.moudleBeans[rowID].menuBeans[index].moudle_url}
                                                    style={{textDecoration:'none',color:'#000000'}}
                                                     onClick={()=>{
                                                        storage.set("menuCurIndex",rowID);
                                                        storage.set("titleInfo","[]");
                                                        this.setState({
                                                            menuCurIndex:index
                                                        });
                                                      }}>
                                                <div style={{height:38,width:160,alignItems:'center',display:'flex',
                                                        background:this.state.menuCurIndex===index?"#ffffff":"#e6e6e6"}}>
                                                        <p1 style={{fontSize:13,marginLeft:30}}>{this.state.moudleBeans[rowID].menuBeans[index].moudle_name}</p1>
                                                </div>
                                            </Link>
                                        )
                                    }}>
                                </ListView>
                            </div>
                        )
                    }}>
                    </ListView>
                    <div style={{flex:1,background:'#ffffff',overflow:'scroll'}}>
                        {this.props.children}
                    </div>
                </div>

            </div>
        );
    }
}

module.exports=MainComponent;