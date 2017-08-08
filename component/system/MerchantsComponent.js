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
class MerchantsComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchantsBeans:[],
            visible:false,
            merchants_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'merchants_account_id'},
                {name:"账号",flex:1,key:'merchants_account'},
                {name:"昵称",flex:1,key:"merchants_name"},
                {name:"角色",flex:1,key:'role_id'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getMerchants();
    }

    getMerchants(){
        this.getDataByPost(1,homeurl+"systemController.api?getMerchantsAccountSystem",{merchants_type:'1'})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    merchantsBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMerchants();
                break;
        }
    }

    deleteMerchants(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"systemController.api?deleteMerchantsAccount",
            {merchants_account_id:this.state.merchantsBeans[this.state.merchants_index].merchants_account_id});
    }

    render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteMerchants();
                              }}></TipComponent>
                <Toolbar title="系统账号" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/merchants_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/merchants_editor/"+encodeURIComponent(JSON.stringify(this.state.merchantsBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[编辑]</p1>
                                        </Link>
                                </div>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/merchants_editor_password/"+encodeURIComponent(JSON.stringify(this.state.merchantsBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[修改密码]</p1>
                                        </Link>
                                </div>
                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                merchants_index:rowID
                                            })
                                            }}>
                                        <div>
                                            <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                        </div>
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

module.exports=MerchantsComponent;
