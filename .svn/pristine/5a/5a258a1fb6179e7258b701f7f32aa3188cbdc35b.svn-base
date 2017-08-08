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

var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var TextComponent=require('./../../widget/TextComponent');
var ListViewComponent=require("./../../widget/ListViewComponent");

class DistributionTakeComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        this.state={
            member_id:this.props.member_id,
            type:this.props.type,
            distributionBeans:[],
            page:1,
            total:0,
            total_price:0,
            total_count:0,
        }
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'user_id'},
                {name:"昵称",flex:1,key:'user_name'},
                {name:"头像",flex:1,key:'user_img',type:'img1'},
                {name:"贡献佣金",flex:1,key:'distribution_price'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })

        this.getDistributions(this.state.page);
    }

    getDistributions(page){
        this.getDataByPost(1,homeurl+"distributionController.api?getUnDistributions",
            {member_id:this.state.member_id,page:page,
                type:this.state.type},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    distributionBeans:data.data.distributionBeans,
                    total:data.total,
                    total_price:data.data.total_price,
                    total_count:data.data.total_count,
                })
                break;
            case 2:
                toast.show("导出已准备好");
                window.location.href=homeurl+data;
                break;
        }
    }

    render(){
        return(
            <div>
                <div style={{display:'flex',marginTop:20,alignItems:'center'}}>
                    <TextComponent
                        title="总数"
                        value={this.state.total_count}/>
                    <TextComponent
                        title="佣金总计"
                        value={this.state.total_price}/>
                  
                </div>
                <ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.distributionBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={()=>{

                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getDistributions(page)
                    }}/>
            </div>
        );
    }

    exportUnDistributions(){
        this.getDataByPost(2,homeurl+"distributionController.api?exportUnDistributions",
            {type:this.state.type,member_id:this.state.member_id});
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

module.exports=DistributionTakeComponent;
