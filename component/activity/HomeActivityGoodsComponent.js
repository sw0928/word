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
var Toolbar=require("./../../widget/Toolbar");
var Widget=require('./../../widget/WidgetComponent');

class HomeLabelComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            activityBeans:[],
            visible:false,
            activity_index:-1,
        };
    }

    componentDidMount() {
        this.getActivitys();
    }

    getActivitys(){
        this.getDataByPost(1,homeurl+"activityController.api?getHomeActivitys",{parent_id:this.props.params.parent_id});
    }
    
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    activityBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getActivitys();
                break;
        }
    }

    deleteActivity(){
        this.getDataByPost(2,homeurl+"activityController.api?deleteHomeActivity",
            {activity_id:this.state.activityBeans[this.state.activity_index].activity_id});
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
                                  this.setState({
                                    visible:false
                                  })
                                  this.deleteActivity();
                              }}></TipComponent>
                <Toolbar title="活动列表" history={this.props.history}></Toolbar>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20,alignItems:'center'}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/activity_home_activity_editor/"+
                                encodeURIComponent(JSON.stringify({activity_type:"goods",parent_id:this.props.params.parent_id,})));
                        }}>

                    </Widget.Button>
                </div>
                <ListViewComponent
                    data={[{name:"ID",flex:1,key:'activity_id'},
                    {name:"名称",flex:1,key:'activity_name'},
                    {name:"图片",flex:1,key:"activity_img",type:'img'},
                    {name:"权重",flex:1,key:"sort"},
                    {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.activityBeans}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <LinkComponent
                                    to={"/activity_home_activity_editor/"+
                                encodeURIComponent(JSON.stringify(this.state.activityBeans[rowID]))}
                                value="编辑"/>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                activity_index:rowID
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