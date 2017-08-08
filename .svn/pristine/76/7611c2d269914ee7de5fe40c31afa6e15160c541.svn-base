/**
 * Created by shenjiabo on 16/8/17.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
import {Router, Route, IndexRoute, Link, hashHistory} from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView = require('./../../widget/ListView');
var BaseComponent = require('./../BaseComponent');

var TipComponent = require('./../../widget/TipComponent');
var Toolbar=require("./../../widget/Toolbar");


class AuthorityEditorComponent extends BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            moudleBeans: [],
        };
    }

    componentDidMount() {
        this.getRoles();
    }

    getRoles() {
        this.getDataByPost(1, homeurl + "systemController.api?getAuthorityByRole", {role_id: this.props.params.role_id})
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    moudleBeans: data
                })
                break;
            case 2:
                toast.show("保存成功");
                break;
        }
    }

    insertAuthority(moudleBeans) {
        this.getDataByPost(2, homeurl + "systemController.api?updateRoleAuthority", {json: JSON.stringify(moudleBeans)})
    }

    render() {
        return (
            <div>
                <Toolbar title="权限分配" history={this.props.history}></Toolbar>
                <ListView
                    style={styles.item}
                    dataSource={this.state.moudleBeans}
                    renderHeader={()=>{
                        return(
                            <div style={{flex:1,display:'flex'}}>
                                    <div style={styles.tabColumn}>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>ID</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>模块名称</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>操作</p1>
                                    </div>
                            </div>
                        )
                    }}
                    renderRow={(rowID)=>{
                        return(
                            <div>
                                <div style={{flex:1,display:'flex',background:'#e6e6e6'}}>
                                    <div style={styles.tabColumn}>
                                        <input type="checkbox" checked={this.state.moudleBeans[rowID].is_authority==='0'?false:true}
                                            onClick={()=>{
                                                if(this.state.moudleBeans[rowID].is_authority==='1'){
                                                    this.state.moudleBeans[rowID].is_authority="0";
                                                    for(let i=0;i<this.state.moudleBeans[rowID].menuBeans.length;i++){
                                                        for(let j=0;j<this.state.moudleBeans[rowID].menuBeans[i].menuBeans.length;j++){
                                                            this.state.moudleBeans[rowID].menuBeans[i].menuBeans[j].is_authority="0";
                                                        }
                                                        this.state.moudleBeans[rowID].menuBeans[i].is_authority="0";
                                                    }
                                                }else{
                                                    this.state.moudleBeans[rowID].is_authority="1";
                                                    for(let i=0;i<this.state.moudleBeans[rowID].menuBeans.length;i++){
                                                           for(let j=0;j<this.state.moudleBeans[rowID].menuBeans[i].menuBeans.length;j++){
                                                               this.state.moudleBeans[rowID].menuBeans[i].menuBeans[j].is_authority="1";
                                                           }
                                                           this.state.moudleBeans[rowID].menuBeans[i].is_authority="1";
                                                    }
                                                }
                                                this.setState({
                                                    moudleBeans:this.state.moudleBeans,
                                                })
                                            }}/>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].moudle_id}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].moudle_name}</p1>
                                    </div>
                                    <div style={styles.tabColumn}
                                        onClick={()=>{
                                            this.insertAuthority(this.state.moudleBeans[rowID]);
                                        }}>
                                        <p1 style={{fontSize:15,color:'blue'}}>保存</p1>
                                    </div>
                                </div>
                                <ListView
                                    dataSource={this.state.moudleBeans[rowID].menuBeans}
                                    renderRow={(index)=>{
                                        return(
                                            <div>
                                                <div style={{flex:1,display:'flex',background:'#ffffff'}}>
                                                        <div style={styles.tabColumn}>
                                                            <input type="checkbox"
                                                            checked={this.state.moudleBeans[rowID].menuBeans[index].is_authority==='0'?false:true}
                                                            onClick={()=>{
                                                                var is_all=true;
                                                                if(this.state.moudleBeans[rowID].menuBeans[index].is_authority==='1'){
                                                                    this.state.moudleBeans[rowID].menuBeans[index].is_authority="0";
                                                                    this.state.moudleBeans[rowID].is_authority="0";
                                                                    for(let i=0;i<this.state.moudleBeans[rowID].menuBeans[index].menuBeans.length;i++){
                                                                        this.state.moudleBeans[rowID].menuBeans[index].menuBeans[i].is_authority='0';
                                                                    }
                                                                }else{
                                                                    for(let i=0;i<this.state.moudleBeans[rowID].menuBeans[index].menuBeans.length;i++){
                                                                        this.state.moudleBeans[rowID].menuBeans[index].menuBeans[i].is_authority='1';
                                                                    }

                                                                    this.state.moudleBeans[rowID].menuBeans[index].is_authority="1";
                                                                    for(let i=0;i<this.state.moudleBeans[rowID].menuBeans.length;i++){
                                                                        if(this.state.moudleBeans[rowID].menuBeans[i].is_authority==='0'&&i!==index){
                                                                            is_all=false;
                                                                        }
                                                                    }
                                                                    if(is_all){
                                                                        this.state.moudleBeans[rowID].is_authority="1";
                                                                    }
                                                                }
                                                                this.setState({
                                                                    moudleBeans:this.state.moudleBeans,
                                                                })
                                                            }}/>
                                                        </div>
                                                        <div style={styles.tabColumn}>
                                                            <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].menuBeans[index].moudle_id}</p1>
                                                        </div>
                                                        <div style={styles.tabColumn}>
                                                            <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].menuBeans[index].moudle_name}</p1>
                                                        </div>
                                                        <div style={styles.tabColumn}>
                                                        </div>
                                                </div>
                                                {this.render3(rowID,index)}
                                            </div>
                                        )
                                }}/>
                            </div>
                        )
                    }}/>
            </div>
        );
    }


    /**
     * 第三级目录
     */
    render3(rowID,index) {
        return (
            <ListView
                dataSource={this.state.moudleBeans[rowID].menuBeans[index].menuBeans}
                renderRow={(position)=>{
                    return(
                        <div style={{flex:1,display:'flex'}}>
                            <div style={styles.tabColumn}>
                                <input type="checkbox" checked={this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].is_authority==='0'?false:true}
                                    onClick={()=>{
                                        var is_all=true;
                                        if(this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].is_authority==='1'){
                                            this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].is_authority="0";
                                            this.state.moudleBeans[rowID].menuBeans[index].is_authority="0";
                                            this.state.moudleBeans[rowID].is_authority="0";
                                        }else{
                                            this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].is_authority="1";
                                            for(let i=0;i<this.state.moudleBeans[rowID].menuBeans[index].menuBeans.length;i++){
                                                if(this.state.moudleBeans[rowID].menuBeans[index].menuBeans[i].is_authority==='0'&&i!==position){
                                                    is_all=false;
                                                }
                                            }

                                            if(is_all){
                                                this.state.moudleBeans[rowID].menuBeans[index].is_authority="1";
                                                var is_all_2=true;
                                                for(let i=0;i<this.state.moudleBeans[rowID].menuBeans.length;i++){
                                                    if(this.state.moudleBeans[rowID].menuBeans[i].is_authority==='0'&&i!==index){
                                                        is_all_2=false;
                                                    }
                                                }
                                                if(is_all_2){
                                                    this.state.moudleBeans[rowID].is_authority="1";
                                                }
                                            }
                                        }
                                        this.setState({
                                             moudleBeans:this.state.moudleBeans,
                                        })
                                    }}/>
                            </div>
                            <div style={styles.tabColumn}>
                                <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].moudle_id}</p1>
                            </div>
                            <div style={styles.tabColumn}>
                                <p1 style={styles.tabP1}>{this.state.moudleBeans[rowID].menuBeans[index].menuBeans[position].moudle_name}</p1>
                            </div>
                            <div style={styles.tabColumn}>
                            </div>
                        </div>
                    )
            }}/>
        )
    }
}
const styles = {
    item: {
        flex: 1,
        display: 'flex',
        borderLeftWidth: 1,
        borderTopWidth: 1,
        borderLeftColor: '#efefef',
        borderTopColor: '#efefef',
        borderLeftStyle: 'solid',
        borderTopStyle: 'solid',
        flexDirection: 'column',
        marginLeft: 10,
        marginRight: 10,
        marginTop: 10
    },
    tabColumn: {
        flex: 1,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#efefef',
        borderRightColor: '#efefef',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabRow: {
        flex: 1,
        display: 'flex',
        flexWrap: 'wrap',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#efefef',
        borderRightColor: '#efefef',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabP1: {
        fontSize: 15,
        wordBreak: 'break-all'
    }
};

module.exports = AuthorityEditorComponent;
