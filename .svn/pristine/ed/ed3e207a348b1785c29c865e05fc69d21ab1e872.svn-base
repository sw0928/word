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
var ListViewComponent=require("./../../widget/ListViewComponent");

var ButtonComponent=require("./../../widget/ButtonComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var CheckComponent=require("./../../widget/CheckComponent");


class BannerComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            bannerBeans:[],
            visible:false,
            banner_index:1,
            page:1,
            baseData:[],
            total:0,
            banner_title:"",
            banner_types:[],
            banner_positions:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'banner_id'},
                {name:"标题",flex:2,key:'banner_title'},
                {name:"图标",flex:2,key:'banner_img',type:'img'},
                {name:"广告类型",flex:2,key:'banner_type_show'},
                {name:"展示位置",flex:2,key:'banner_position_show'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:4,key:"-1"}
            ]
        })
        this.getBeannrs(this.state.page);
    }

    getBeannrs(page){
        this.getDataByPost(1,homeurl+"bannerController.api?getAllBanners",
            {page:page,banner_type:this.state.banner_types.toString(),
                banner_position:this.state.banner_positions.toString(),
                banner_title:this.state.banner_title},{type:2})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    bannerBeans:data.data,
                    total:data.total
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getBeannrs();
                break;
        }
    }

    deleteBanner(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"bannerController.api?deleteBanner",
            {banner_id:this.state.bannerBeans[this.state.banner_index].banner_id});
    }

    render(){
        let view=[];
        if(company_name==='ssp'){
            view.push(this.renderSSP());
        }else{

        }
        return(
            <div style={{background:'#ffffff',display:'flex',flexDirection:'column'}}>
                <TipComponent visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteBanner();
                              }}></TipComponent>
                <Toolbar title={"广告列表"} history={this.props.history}></Toolbar>
                <div style={{marginTop:20,display:'flex'}}>
                    <EditorComponent
                        title="标题"
                        value={this.state.banner_title}
                        onChange={(value)=>{
                            this.setState({
                                banner_title:value,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getBeannrs(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>广告类型</p1>
                    </div>
                    <CheckComponent title="普通广告" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_types.push("common");
                                }else{
                                    var index=this.state.banner_types.indexOf("common");
                                    this.state.banner_types.splice(index,1);
                                }

                                this.setState({
                                    banner_types:this.state.banner_types,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="商品广告" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_types.push("goods");
                                }else{
                                    var index=this.state.banner_types.indexOf("goods");
                                    this.state.banner_types.splice(index,1);
                                }

                                this.setState({
                                    banner_types:this.state.banner_types,
                                })
                            }}></CheckComponent>
                </div>
                {view}
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.bannerBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderAdd={()=>{
                        return(
                            <Link to={"/banner_editor2/"+encodeURIComponent(JSON.stringify({}))}
                                            style={{textDecoration:'none'}}>
                                <p1 style={styles.tabP1}>+</p1>
                            </Link>
                        )
                    }}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/banner_editor2/"+encodeURIComponent(JSON.stringify(this.state.bannerBeans[rowID]))}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[编辑]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                        <Link to={"/banner_detail_editor/"+encodeURIComponent(this.state.bannerBeans[rowID].banner_url)}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[图文详情]</p1>
                                        </Link>
                                    </div>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    banner_index:rowID
                                                })
                                            }}>
                                        <div>
                                            <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                        </div>
                                    </div>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getBeannrs(page)
                    }}>
                </ListViewComponent>
            </div>
        );
    }


    renderSSP(){
        return(
            <div style={{display:'flex',alignItems:'center'}}>
                <div style={styles.tabTitle}>
                    <p1 style={styles.font}>广告位置</p1>
                </div>
                <CheckComponent title="首页" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("home");
                                }else{
                                    var index=this.state.banner_positions.indexOf("home");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="预售商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("is_pre");
                                }else{
                                    var index=this.state.banner_positions.indexOf("is_pre");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="礼物商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("gift");
                                }else{
                                    var index=this.state.banner_positions.indexOf("gift");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="生鲜商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("fresh");
                                }else{
                                    var index=this.state.banner_positions.indexOf("fresh");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="母婴商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("baby");
                                }else{
                                    var index=this.state.banner_positions.indexOf("baby");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="女士商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("lady");
                                }else{
                                    var index=this.state.banner_positions.indexOf("lady");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="特色商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("feature");
                                }else{
                                    var index=this.state.banner_positions.indexOf("feature");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="进口商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("import");
                                }else{
                                    var index=this.state.banner_positions.indexOf("import");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
                <CheckComponent title="促销商品" checked="0"
                                onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.banner_positions.push("promotion");
                                }else{
                                    var index=this.state.banner_positions.indexOf("promotion");
                                    this.state.banner_positions.splice(index,1);
                                }

                                this.setState({
                                    banner_positions:this.state.banner_positions,
                                })
                            }}></CheckComponent>
            </div>
        )
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
        fontSize:13,
        wordBreak:'break-all'
    },
    tab:{
        display:'flex',
        height:30,
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
};

module.exports=BannerComponent;
