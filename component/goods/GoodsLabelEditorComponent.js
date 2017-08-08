/**
 * Created by shenjiabo on 16/8/26.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'

var Widget=require("./../../widget/WidgetComponent");

class GoodsLabelEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var labelBean=JSON.parse(decodeURIComponent(this.props.params.labelBean));
        this.state = {
            labelBean:labelBean,
            type:this.props.params.type,
            label_name:labelBean.label_name?labelBean.label_name:"",
            sort:labelBean.sort?labelBean.sort:"",
            select_way:labelBean.select_way?labelBean.select_way:"0",
        };
    }


    inserLabel(){
        if(this.state.label_name===''){
            this.showTip("请先填写标签名");
            return;
        }

        if(this.state.labelBean.label_id){
            this.getDataByPost(1, homeurl + "goodsController.api?updateGoodsClassLabel",
                {label_id:this.state.labelBean.label_id,label_name: this.state.label_name,
                    sort: this.state.sort, select_way: this.state.select_way,
                    goods_id: this.state.labelBean.goods_id, parent_id: this.state.labelBean.parent_id
                });
        }else {
            this.getDataByPost(1, homeurl + "goodsController.api?insertGoodsClassLabel",
                {
                    label_name: this.state.label_name, sort: this.state.sort, select_way: this.state.select_way,
                    goods_id: this.state.labelBean.goods_id, parent_id: this.state.labelBean.parent_id
                });
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="筛选标签编辑" history={this.props.history}></Widget.Toolbar>
                <div style={{display:'flex',flex:1,marginTop:20,alignItems:'center'}}>
                    <Widget.Editor
                        title="标签名称"
                        value={this.state.label_name}
                        onChange={(value)=>{
                             this.setState({
                                label_name:value
                             })
                        }}/>
                    <Widget.Check
                        visible={this.state.type==="1"?"true":"false"}
                        title="是否多选"
                        checked={this.state.select_way}
                        onClick={(checked)=>{
                            this.setState({
                                select_way:checked
                            })
                        }}/>
                </div>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.sort}
                    onChange={(value)=>{
                             this.setState({
                                sort:value
                             })
                        }}/>

                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.inserLabel();
                    }}/>
            </div>
        )
    }




    doSuccess(index,data){
        switch (index){
            case 1:
                this.showTip("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                this.showTip("修改成功");
                this.props.history.goBack();
                break;
        }
    }
}
const styles = {
    input:{
        width:300,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
        width:100
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
    }
}
module.exports=GoodsLabelEditorComponent;