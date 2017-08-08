/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");
var PageComponent=require("./../../widget/PageComponent");


var SearchBar=require("./../../widget/SearchBar");
var ButtonComponent=require("./../../widget/ButtonComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var EditorComponent=require("./../../widget/EditorComponent");
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
            express_full_price:100,
            page:1,
            total:0,
            apply_states:[],
            merchants_states:[],
            merchants_name:"",

            baseData:[],
        };
    }
    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'merchants_id'},
                {name:"店铺名称",flex:2,key:'merchants_name'},
                {name:"详细地址",flex:2,key:"merchants_address"},
                {name:"联系人",flex:1,key:'contact_name'},
                {name:"乱系电话",flex:2,key:'contact_mobile'},
                {name:"商家类型",flex:1,key:'merchants_type'},
                {name:"二维码",flex:2,key:'qrcode_img',type:'img1'},
                {name:"审核状态",flex:1,key:'apply_state'},
                {name:"供应状态",flex:2,key:'merchants_state'},
                {name:"创建时间",flex:2,key:'create_time'},
                {name:"操作",flex:4,key:"-1"}
            ]
        })
        this.getMerchants(this.state.page);
    }

    getMerchants(page){
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchants",
            {merchants_type:'3',page:page, apply_states:this.state.apply_states.toString()
                ,merchants_states:this.state.merchants_states.toString(),
                merchants_name:this.state.merchants_name},
            {type:2})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    merchantsBeans:data.data,
                    total:data.total,
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getMerchants();
                break;
            case 3:
                toast.show("导出已准备好");
                window.location.href=imgurl+data;
                break;
        }
    }

    deleteMerchants(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"merchantsController.api?deleteMerchantDetail",
            {merchants_id:this.state.merchantsBeans[this.state.merchants_index].merchants_id});
    }

    downloadMerchantsQrCode(){
        this.getDataByPost(3,homeurl+"merchantsController.api?downloadMerchantsQrCode",
            {merchants_type:'3'})
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
                <Toolbar title="供应商管理" history={this.props.history}></Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:10}}>
                    <EditorComponent
                        title="商家名"
                        value={this.state.merchants_name}
                        onChange={(value)=>{
                            this.setState({
                                merchants_name:value
                            })
                        }}>
                    </EditorComponent>
                    <ButtonComponent
                        width={100}
                        marginLeft={10}
                        value="搜索"
                        onClick={()=>{
                        this.getMerchants(this.state.page);
                    }}>
                    </ButtonComponent>
                </div>
                <div style={{display:'flex',height:40,alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>供货状态</p1>
                    </div>
                    <CheckComponent title="关闭" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.merchants_states.push("0");
                                }else{
                                    var index=this.state.merchants_states.indexOf("0");
                                    this.state.merchants_states.splice(index,1);
                                }

                                this.setState({
                                    merchants_states:this.state.merchants_states,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="开启" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.merchants_states.push("1");
                                }else{
                                    var index=this.state.merchants_states.indexOf("1");
                                    this.state.merchants_states.splice(index,1);
                                }

                                this.setState({
                                    merchants_states:this.state.merchants_states,
                                })
                            }}></CheckComponent>
                </div>
                <div style={{display:'flex',justifyContent:'flex-end'}}>
                    <ButtonComponent
                        marginRight={20}
                        value="导出二维码"
                        onClick={()=>{
                            this.downloadMerchantsQrCode();
                        }}/>
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/user_business_editor/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:"flex",flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/user_business_editor/"+encodeURIComponent(JSON.stringify(this.state.merchantsBeans[rowID]))}
                                          style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[编辑]</p1>
                                    </Link>
                                </div>

                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <Link to={"/user_business_goods/"+encodeURIComponent(this.state.merchantsBeans[rowID].merchants_id)}
                                          style={{textDecoration:'none'}}>
                                        <p1 style={styles.tabP1}>[商品管理]</p1>
                                    </Link>
                                </div>

                                <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                                onClick={()=>{
                                                    this.setState({
                                                        visible:true,
                                                        merchants_index:rowID
                                                    })
                                                }}>
                                    <p1 style={{ fontSize:13,color:'blue'}}>[删除]</p1>
                                </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getMerchants(page)
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
        fontSize:13,
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

module.exports=MerchantsComponent;
