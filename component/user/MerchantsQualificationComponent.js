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

class MerchantsQualificationComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchantsQualificationBeans:[],
            visible:false,
            qualification_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'qualification_id'},
                {name:"资质名称",flex:1,key:'qualification_name'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getMerchantsQualifications();
    }

    getMerchantsQualifications(){
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchantsQualification",{})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    merchantsQualificationBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMerchantsQualifications();
                break;
        }
    }

    deleteMerchantsQualifications(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"merchantsController.api?deleteMerchantsQualification",
            {qualification_id:this.state.merchantsQualificationBeans[this.state.qualification_index].qualification_id});
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
                                  this.deleteMerchantsQualifications();
                              }}></TipComponent>
                <Toolbar title="商家资质列表" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsQualificationBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/merchants_qualification_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                        <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}>
                                            <Link to={"/merchants_qualification_editor/"+encodeURIComponent(JSON.stringify(this.state.merchantsQualificationBeans[rowID]))}
                                                style={{textDecoration:'none'}}>
                                                <p1 style={{fontSize:13}}>[编辑]</p1>
                                            </Link>
                                        </div>
                                        <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                qualification_index:rowID
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

module.exports=MerchantsQualificationComponent;
