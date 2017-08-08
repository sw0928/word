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
var PageComponent=require("./../../widget/PageComponent");


var SearchBar=require("./../../widget/SearchBar");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var ListViewComponent=require("./../../widget/ListViewComponent");

class MerchantsAccountComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchantsBean:this.props.merchantsBean,
            baseData:[],
            merchantsAccountBeans:[],
            merchants_account_index:-1,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'merchants_account_id'},
                {name:"账号",flex:1,key:'merchants_account'},
                {name:"名字",flex:1,key:"merchants_name"},
                {name:"头像",flex:1,key:'contact_img'},
                {name:"是否推广员",flex:1,key:'is_extension_show'},
                {name:"二维码",flex:1,key:'qrcode_img',type:'img'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getMerchantsAccounts();
    }

    getMerchantsAccounts(){
        this.getDataByPost(1,homeurl+"merchantsController.api?getMerchantsAccounts",
            {merchants_id:this.state.merchantsBean.merchants_id})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    merchantsAccountBeans:data,
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMerchantsAccounts();
                break;
        }
    }

    deleteMerchantsAccount(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"merchantsController.api?deleteMerchantsAccount",
            {merchants_account_id:this.state.merchantsAccountBeans[this.state.merchants_account_index].merchants_account_id,
                merchants_relation_account_id:this.state.merchantsAccountBeans[this.state.merchants_account_index].merchants_relation_account_id});
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
                                  this.setState({
                                        visible:false
                                  })
                                  this.deleteMerchantsAccount();
                              }}></TipComponent>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsAccountBeans}
                    renderAdd={()=>{
                        return(
                            <Link to={"/merchants_account_editor/"+this.props.merchants_type+"/"+
                                            encodeURIComponent(JSON.stringify({merchants_id:this.state.merchantsBean.merchants_id,
                                                                                merchants_name:this.state.merchantsBean.merchants_name,
                                                                                merchants_img:this.state.merchantsBean.merchants_img}))+"/0"}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    operationData={[{title:"编辑",type:1},{title:"修改密码",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/merchants_account_editor/"+this.props.merchants_type+"/"
                                    +encodeURIComponent(JSON.stringify(this.state.merchantsAccountBeans[rowID]))+"/1");

                            break;
                            case 1:
                                this.props.history.push("/merchants_account_editor/"+this.props.merchants_type+"/"
                                    +encodeURIComponent(JSON.stringify(this.state.merchantsAccountBeans[rowID]))+"/2");
                            break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    merchants_account_index:rowID
                                })
                            break;
                        }
                    }}>
                </ListViewComponent>
            </div>
        );
    }
}

const styles = {
    tab:{
        display:'flex',
        height:50,
        alignItems:'center',
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    input:{
        width:200,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    },
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
        fontSize:13,
        wordBreak:'break-all'
    }
};

module.exports=MerchantsAccountComponent;
