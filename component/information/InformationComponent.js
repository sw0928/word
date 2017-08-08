/**
 * Created by shenjiabo on 16/12/2.
 */

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
var ListViewComponent=require("./../../widget/ListViewComponent");
var LinkComponent=require("./../../widget/LinkComponent");

class InformationComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            parent_id:this.props.params.parent_id,
            informationBeans:[],
            visible:false,
            information_index:1,
            baseData:[],
            total:0,
            page:1,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'information_id'},
                {name:"标题",flex:1,key:'information_title'},
                {name:"图标",flex:1,key:"information_img",type:'img'},
                {name:"是否推荐",flex:1,key:'is_recommend_show'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:3,key:"-1"}
            ]
        });
        this.getInformations(this.state.page);
    }

    getInformations(page){
        this.getDataByPost(1,homeurl+"informationController.api?getInformations"
            ,{parent_id:this.state.parent_id,information_type:'2',page:page},{type:2})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    informationBeans:data.data,
                    total:data.total
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getInformations(this.state.page);
                break;
        }
    }

    deleteGoods(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"informationController.api?deleteInformation",
            {information_id:this.state.informationBeans[this.state.information_index].information_id});
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
                                  this.deleteGoods();
                              }}></TipComponent>
                <Toolbar title="知识列表" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.informationBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <LinkComponent
                                    history={this.props.history}
                                    to={"/information_editor/"+encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id,information_type:'2'}))}
                                    value="添加"/>

                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <LinkComponent
                                    to={"/information_editor/"+encodeURIComponent(JSON.stringify(this.state.informationBeans[rowID]))}
                                    value="编辑"/>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                information_index:rowID
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

module.exports=InformationComponent;
