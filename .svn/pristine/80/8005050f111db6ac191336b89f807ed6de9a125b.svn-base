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

class SystemMoudleTestComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            moduleBeans:[],
            visible:false,
            moudle_index:1,
            level:this.props.params.level,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'moudle_id'},
                {name:"名称",flex:1,key:'moudle_name'},
                {name:"路由",flex:1,key:"moudle_url"},
                {name:"权重",flex:1,key:'sort'},
                {name:"备注",flex:1,key:'moudle_remark'},
                {name:"操作",flex:3,key:"-1"}
            ]
        })
        this.getMoudle();
    }

    getMoudle(){
        this.getDataByPost(1,homeurl+"systemController.api?getAllMoudleByParentId",{parent_id:this.props.params.parent_id})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    moduleBeans:data
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getMoudle();
                break;
        }
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
                                  this.deleteMoudle();
                              }}></TipComponent>
                <Toolbar title={this.state.level+"级分类"} history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.moduleBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/moudle_editor/"+encodeURIComponent(JSON.stringify({parent_id:this.props.params.parent_id}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/system_moudle/"+this.state.moduleBeans[rowID].moudle_id+"/"+(parseInt(this.state.level)+1)}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[子分类]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/moudle_editor/"+encodeURIComponent(JSON.stringify(this.state.moduleBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[编辑]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                moudle_index:rowID
                                            })
                                            }}>
                                        <div>
                                            <p1 style={{ fontSize:15,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                        </div>
                                    </div>
                            </div>
                        )
                    }}>
                </ListViewComponent>
            </div>
        );
    }

    deleteMoudle(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"systemController.api?deleteMoudle",
            {moudle_uuid:this.state.moduleBeans[this.state.moudle_index].moudle_uuid});
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

module.exports=SystemMoudleTestComponent;
