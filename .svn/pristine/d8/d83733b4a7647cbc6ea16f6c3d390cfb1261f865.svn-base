/**
 * Created by shenjiabo on 16/8/17.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
import {Router, Route, IndexRoute, Link, hashHistory} from 'react-router'
import {toast} from 'react-android-style-toast';

var Widget = require('./../../widget/WidgetComponent');

class GoodsLabelComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            goods_id:this.props.params.goods_id,
            labelBeans: [],
            label_id:-1,
        };
    }

    componentDidMount() {
        this.getAllGoodsClassLabels();
    }

    getAllGoodsClassLabels(){
        this.getDataByPost(1,homeurl+"goodsController.api?getAllGoodsClassLabels",{goods_class_id:this.state.goods_id,parent_id:'-1'});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    labelBeans:data,
                });
                break;
            case 2:
                this.showTip("删除成功");
                this.getAllGoodsClassLabels();
                break;
        }
    }

    deleteGoodsClassLabel(){
        this.getDataByPost(2,homeurl+"goodsController.api?deleteGoodsClassLabel",
            {label_id:this.state.label_id});
    }
    render() {
        return (
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <Widget.Tip visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.setState({
                                    visible:false
                                  })
                                  this.deleteGoodsClassLabel();
                              }}/>
                <Widget.Toolbar title="筛选标签管理" history={this.props.history}/>
                <Widget.ListView
                    style={styles.item}
                    dataSource={this.state.labelBeans}
                    renderHeader={()=>{
                        return(
                            <div style={{flex:1,display:'flex'}}>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>ID</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>标签名称</p1>
                                    </div>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>选择方式</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>操作</p1>
                                       <Link to={"/goods_label_editor/1/"+JSON.stringify({goods_id:this.state.goods_id,parent_id:'-1'})}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>+</p1>
                                        </Link>
                                    </div>
                            </div>
                        )
                    }}
                    renderRow={(rowID)=>{
                        return(
                            <div>
                                <div style={{flex:1,display:'flex',background:'#efefef'}}>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>{this.state.labelBeans[rowID].label_id}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>{this.state.labelBeans[rowID].label_name}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>{this.state.labelBeans[rowID].select_way==='1'?"多选":"单选"}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <Link to={"/goods_label_editor/1/"+JSON.stringify(this.state.labelBeans[rowID])}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[编辑]</p1>
                                        </Link>
                                        <Link to={"/goods_label_editor/2/"+
                                            JSON.stringify({goods_id:this.state.goods_id,parent_id:this.state.labelBeans[rowID].label_id})}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[添加]</p1>
                                        </Link>
                                        <div style={{display:'flex',alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                label_id:this.state.labelBeans[rowID].label_id
                                            })
                                            }}>
                                            <div>
                                                <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                {this.render2(rowID)}
                            </div>
                        )
                    }}/>
            </div>
        );
    }

    render2(rowID){
        return(
            <Widget.ListView style={{ flex: 1,
                                display: 'flex',
                                borderLeftWidth: 1,
                                borderTopWidth: 1,
                                borderLeftColor: '#efefef',
                                borderTopColor: '#efefef',
                                borderLeftStyle: 'solid',
                                borderTopStyle: 'solid',
                                flexDirection: 'column',}}
                dataSource={this.state.labelBeans[rowID].goodsLabelBeans}
                renderRow={(index)=>{
                        return(
                            <div>
                                <div style={{flex:1,display:'flex',background:'#ffffff'}}>
                                    <div style={styles.tabColumn}>
                                        <p1 style={styles.tabP1}>{this.state.labelBeans[rowID].goodsLabelBeans[index].label_id}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}>{this.state.labelBeans[rowID].goodsLabelBeans[index].label_name}</p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <p1 style={styles.tabP1}></p1>
                                    </div>
                                    <div style={styles.tabRow}>
                                        <Link to={"/goods_label_editor/2/"+JSON.stringify(this.state.labelBeans[rowID].goodsLabelBeans[index])}
                                            style={{textDecoration:'none'}}>
                                            <p1 style={styles.tabP1}>[编辑]</p1>
                                        </Link>
                                        <div style={{display:'flex',alignItems:'center',justifyContent:'center'}}
                                            onClick={()=>{
                                            this.setState({
                                                visible:true,
                                                label_id:this.state.labelBeans[rowID].goodsLabelBeans[index].label_id
                                            })
                                            }}>
                                            <div>
                                                <p1 style={{ fontSize:13,wordBreak:'break-all',color:'blue'}}>[删除]</p1>
                                            </div>
                                        </div>
                                    </div>
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
        fontSize: 13,
        wordBreak: 'break-all'
    }
};

module.exports = GoodsLabelComponent;
