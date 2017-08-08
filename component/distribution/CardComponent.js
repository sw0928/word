/**
 * Created by shenjiabo on 16/11/9.
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
var ListViewComponent=require("./../../widget/ListViewComponent");

var ButtonComponent=require("./../../widget/ButtonComponent");
var EditorComponent=require("./../../widget/EditorComponent");
var CheckComponent=require("./../../widget/CheckComponent");
var SelectComponent=require("./../../widget/SelectComponent");

import Upload from 'rc-upload';

var type_index=-1;

class CardComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            cardBeans:[],
            page:1,
            total:0,
            baseData:[],
            card_type:[],
            card_code:"",
            card_index:0,
            typeBeans:[
                {name:"收费",id:"goods"},
                {name:"活动",id:"activity"},
            ],
            count:1,
            card_price:'180',
            valid_time:365,
            uploaderProps :{
                action:homeurl+"distributionController.api?loadCardExcel",
                data:{},
                headers: {
                    Authorization: 'xxxxxxx',
                },
                multiple: false,
                beforeUpload(file) {
                    console.log('beforeUpload', file.name);
                },
                onStart: (file) => {
                    console.log('onStart', file.name);
                },
                onProgress(step, file) {
                    console.log('onProgress', Math.round(step.percent), file.name);
                },
                onError(err) {
                    console.log('onError', err);
                    toast.show("上传失败");
                },
            },
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"邀请码",flex:1,key:'card_code'},
                {name:"卡类型",flex:1,key:'card_type_show'},
                {name:"有效时间(天)",flex:2,key:'valid_time'},
                {name:"金额",flex:1,key:'card_price'},
                {name:"使用情况",flex:1,key:'is_used_show'},
                {name:"使用者ID",flex:1,key:'member_id'},
                {name:"使用者昵称",flex:1,key:'nick_name'},
                {name:"创建时间",flex:2,key:'create_time'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getCards(this.state.page)
    }

    getCards(page){
        this.getDataByPost(1,homeurl+"distributionController.api?getCardGoodss",
            {page:page,
                card_code:this.state.card_code,
                card_type:this.state.card_type.toString()},{type:2});
    }

    deleteCard(){
        this.getDataByPost(2,homeurl+"distributionController.api?deleteCardGoods",
            {card_code:this.state.cardBeans[this.state.card_index].card_code});
    }

    insertCard(){
        if(isNaN(this.state.card_price)){
            toast.show("价格非法");
            return;
        }

        if(isNaN(this.state.count)){
            toast.show("数量非法");
            return;
        }
        if(isNaN(this.state.valid_time)){
            toast.show("有效期非法");
            return;
        }
        if(parseInt(this.state.count)<1){
            toast.show("数量必须大于0");
            return;
        }

        if(parseInt(this.state.count)>10){
            toast.show("数量必须小于10");
            return;
        }

        this.getDataByPost(3,homeurl+"distributionController.api?insertCardGoods",
                            {count:this.state.count,
                             card_type:this.state.typeBeans[type_index].id,
                                card_price:this.state.card_price,
                                valid_time:this.state.valid_time});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    cardBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getCards(this.state.page)
                break;
            case 3:
                toast.show("生成成功");
                this.getCards(this.state.page)
                break;
        }
    }

    render(){
        return(
            <div>
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
                                  this.deleteCard();
                              }}></TipComponent>
                <Toolbar title="意见反馈" history={this.props.history}></Toolbar>
                <div style={{marginTop:20,display:'flex'}}>
                    <EditorComponent
                        title="邀请码"
                        onChange={(value)=>{
                            this.setState({
                                card_code:value,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1
                            })
                            this.getCards(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>卡类型</p1>
                    </div>
                    <CheckComponent title="收费类型" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.card_type.push("goods");
                                }else{
                                    var index=this.state.card_type.indexOf("goods");
                                    this.state.card_type.splice(index,1);
                                }

                                this.setState({
                                    card_type:this.state.card_type,
                                })
                            }}></CheckComponent>
                    <CheckComponent title="活动类型" checked="0"
                                    onClick={(checked)=>{
                                if(checked==='1'){
                                    this.state.card_type.push("activity");
                                }else{
                                    var index=this.state.card_type.indexOf("activity");
                                    this.state.card_type.splice(index,1);
                                }

                                this.setState({
                                    card_type:this.state.card_type,
                                })
                            }}></CheckComponent>
                </div>
                <div style={{marginTop:20,display:'flex',alignItems:'center',flexWrap:'wrap'}}>
                    <SelectComponent
                        title="卡类型"
                        show_value="name"
                        init_value={"goods"}
                        select_value="id"
                        dataSource={this.state.typeBeans}
                        onChange={(rowID)=>{
                            type_index=rowID;
                        }}>
                    </SelectComponent>
                    <EditorComponent
                        title="价格"
                        value={this.state.card_price}
                        onChange={(value)=>{
                            this.setState({
                                card_price:value,
                            })
                        }}/>
                    <EditorComponent
                        title="有效时间(天)"
                        value={this.state.valid_time}
                        onChange={(value)=>{
                            this.setState({
                                valid_time:value,
                            })
                        }}/>
                    <EditorComponent
                        title="条数(单次上限10条)"
                        width={160}
                        value={this.state.count}
                        onChange={(value)=>{
                            this.setState({
                                count:value,
                            })
                        }}/>
                    <ButtonComponent
                        marginLeft={20}
                        value="生成"
                        onClick={()=>{
                            this.insertCard();
                        }}/>
                </div>
                <div style={{marginTop:20,display:'flex',justifyContent:'flex-end',flex:1}}>
                        <Upload
                            {...this.state.uploaderProps}
                            ref="inner"
                            style={{outline:'none'}}
                            onSuccess={(data)=>{
                                if(data.status==='ok'){
                                    toast.show("操作成功");
                                    this.setState({
                                        page:1
                                    })
                                    this.getCards(1);
                                }else{
                                    toast.show(data.error);
                                }
                            }}>
                            <div style={{marginRight:20}}>
                                <p1 style={{fontSize:15,color:'blue'}}>批量导入</p1>
                            </div>
                        </Upload>
                    <a href={homeurl+"/excel/card.xlsx"} value="下载模板1" style={{marginRight:20,outline:'none',textDecoration:'none'}}>下载模板</a>
                </div>

                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.cardBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1}}>
                                    <div style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                                this.setState({
                                                    visible:true,
                                                    card_index:rowID
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
                        this.getCards(page)
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
module.exports=CardComponent;