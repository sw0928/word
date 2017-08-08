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

class HeadlinesHotMerchants extends BaseComponent{
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
                {name:"商家类型",flex:2,key:'merchants_type'},
                {name:"审核状态",flex:2,key:'apply_state'},
                {name:"供应状态",flex:2,key:'merchants_state'},
                {name:"创建时间",flex:2,key:'create_time'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getMerchants(this.state.page);
    }

    getMerchants(page){
        this.getDataByPost(1,homeurl+"merchantsController.api?getAllMerchants",
            {merchants_type:'2,4',page:page,apply_states:this.state.apply_states.toString()
                ,merchants_states:this.state.merchants_states.toString(),
                merchants_name:this.state.merchants_name,is_hot:"1"},
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
        }
    }

    deleteMerchants(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"systemController.api?deleteMerchants",
            {merchants_id:this.state.merchantsBeans[this.state.merchants_index].merchants_id});
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
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.merchantsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                <Link to={"/user_merchants_editor/"+encodeURIComponent(JSON.stringify(this.state.merchantsBeans[rowID]))}
                                      style={{textDecoration:'none'}}>
                                    <p1 style={{fontSize:13}}>[编辑]</p1>
                                </Link>
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


module.exports=HeadlinesHotMerchants;
