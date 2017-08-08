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

class AuthorityComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            roleBeans:[],
            visible:false,
            role_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'role_id'},
                {name:"名称",flex:1,key:'role_name'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getRoles();
    }

    getRoles(){
        this.getDataByPost(1,homeurl+"systemController.api?getAllRole",{})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    roleBeans:data
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <Toolbar title="角色列表" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.roleBeans}
                    renderOperation={(rowID)=>{
                        return(
                            <Link to={"/authority_editor/"+this.state.roleBeans[rowID].role_id}
                                            style={{textDecoration:'none'}}>
                                <p1 style={{fontSize:13}}>[查看权限]</p1>
                            </Link>
                        )
                    }}/>
            </div>
        );
    }
}

module.exports=AuthorityComponent;
