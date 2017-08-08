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
            distribution_relation:this.props.distribution_relation,
            distributionBeans:[],
            page:1,
            total:0,
            total_price:0,

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
        this.getDataByPost(1,homeurl+"distributionController.api?getDistributions",
            {member_id:this.state.member_id,page:page,
                distribution_relation:this.state.distribution_relation},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    distributionBeans:data.data.distributionBeans,
                    total:data.total,
                    total_price:data.data.total_price
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <TextComponent
                    marginTop={20}
                    title="佣金总计"
                    value={this.state.total_price}/>
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
