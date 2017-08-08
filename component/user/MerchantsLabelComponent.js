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

class MerchantsLabelComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchantsLabelBeans:[],
            visible:false,
            label_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'label_id'},
                {name:"标签名称",flex:1,key:'label_name'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:3,key:"-1"}
            ]
        })
        this.getMerchantsLabels();
    }

    getMerchantsLabels(){
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchantsLabel",{})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    merchantsLabelBeans:data
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMerchantsLabels();
                break;
        }
    }

    deleteMerchantsLabel(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"merchantsController.api?deleteMerchantsLabel",
            {label_id:this.state.merchantsLabelBeans[this.state.label_index].label_id});
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
                                  this.deleteMerchantsLabel();
                              }}></TipComponent>
                <Toolbar title="商家标签列表" history={this.props.history}></Toolbar>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsLabelBeans}
                    renderAdd={()=>{
                        return(
                             <Link to={"/user_merchants_label_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                             </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/user_merchants_label_editor/"+encodeURIComponent(JSON.stringify(this.state.merchantsLabelBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[编辑]</p1>
                                        </Link>

                                    </div>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/merchants_label_qualification/"+this.state.merchantsLabelBeans[rowID].label_id}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={{fontSize:13}}>[资质管理]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                label_index:rowID
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

module.exports=MerchantsLabelComponent;
