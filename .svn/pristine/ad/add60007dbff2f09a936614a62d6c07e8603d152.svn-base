/**
 * Created by shenjiabo on 16/11/29.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListViewComponent=require('./../../widget/ListViewComponent');
var BaseComponent=require('./../BaseComponent');

var LinkComponent=require('./../../widget/LinkComponent');
var TipComponent=require('./../../widget/TipComponent');
var Widget=require('./../../widget/WidgetComponent');

class HomeLabelComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            homeGoodsBeans:[],
            visible:false,
            home_index:-1,
        };
    }

    componentDidMount() {
        this.getHomeGoods();
    }

    getHomeGoods(){
        this.getDataByPost(1,homeurl+"activityController.api?getHomeGoods",{parent_id:"-1"});
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    homeGoodsBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getHomeGoods();
                break;
        }
    }

    deleteActivity(){
        this.getDataByPost(2,homeurl+"activityController.api?deleteHomeGoods",
            {home_goods_id:this.state.homeGoodsBeans[this.state.home_index].home_goods_id});
    }
    render(){
        return(
            <div>
                <TipComponent visible={this.state.visible}
                              msg="确定删除?"
                              onClose={()=>{
                                  this.setState({
                                    visible:false
                                  })
                              }}
                              onPress={()=>{
                                  this.setState({
                                    visible:false
                                  })
                                  this.deleteActivity();
                              }}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20,alignItems:'center'}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/activity_home_goods_editor/"+
                            encodeURIComponent(JSON.stringify({goods_type:"class",parent_id:"-1",})));
                        }}/>
                </div>
                <ListViewComponent
                    data={[{name:"ID",flex:1,key:'home_goods_id'},
                    {name:"名称",flex:1,key:'goods_name'},
                    {name:"图片",flex:1,key:"goods_img",type:'img'},
                    {name:"权重",flex:1,key:"sort"},
                    {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.homeGoodsBeans}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <LinkComponent
                                to={"/activity_home_goods_editor/"+
                                encodeURIComponent(JSON.stringify(this.state.homeGoodsBeans[rowID]))}
                                value="编辑"/>
                                <LinkComponent
                                    to={"/activity_home_goods_goods/"+this.state.homeGoodsBeans[rowID].home_goods_id}
                                value="子类"/>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                home_index:rowID
                                            })
                                            }}>
                                    <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}/>
            </div>
        )
    }
}

module.exports=HomeLabelComponent;