/**
 * Created by shenjiabo on 16/12/16.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var list_type_index=-1;
var state_index=-1;
class ListShowEditorComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            listShowBean:JSON.parse(this.props.params.listShowBean),
            listTypeBeans:[],
            stateBeans:[{name:"开启",id:'1'},{name:"关闭",id:"0"}],
        };
    }

    componentDidMount() {
        this.getSystemListTypesNoPage();
    }

    getSystemListTypesNoPage(){
        this.getDataByPost(1, homeurl + "systemController.api?getSystemListTypesNoPage", {type_type:'list'});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    listTypeBeans:data
                })
                break;
            case 2:
                this.showTip("添加成功");
                this.props.history.goBack();
                break;
            case 3:
                this.showTip("修改成功");
                this.props.history.goBack();
                break;
        }
    }

    insertListShow(){
        if(isNaN(this.state.listShowBean.flex)){
            this.showTip("比例非法");
            return;
        }

        var params={};
        params["name"]=this.state.listShowBean.name;
        params["flex"]=this.state.listShowBean.flex;
        params["list_key"]=this.state.listShowBean.list_key;
        params["sort"]=this.state.listShowBean.sort;
        params["type"]=this.state.listShowBean.type;
        params["list_type"]=this.state.listTypeBeans[list_type_index].type_value;
        params["state"]=this.state.stateBeans[state_index].id;

        if(this.isNull(this.state.listShowBean.id)){
            this.getDataByPost(2,homeurl+"systemController.api?insertSystemListShow",params);
        }else{
            params["id"]=this.state.listShowBean.id;
            this.getDataByPost(3,homeurl+"systemController.api?updateSystemListShow",params);
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="列表编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.listShowBean.name}
                    onChange={(value)=>{
                        this.state.listShowBean.name=value;
                        this.setState({
                            listShowBean:this.state.listShowBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="比例"
                    value={this.state.listShowBean.flex}
                    onChange={(value)=>{
                        this.state.listShowBean.flex=value;
                        this.setState({
                            listShowBean:this.state.listShowBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="键值"
                    value={this.state.listShowBean.list_key}
                    onChange={(value)=>{
                        this.state.listShowBean.list_key=value;
                        this.setState({
                            listShowBean:this.state.listShowBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.listShowBean.sort}
                    onChange={(value)=>{
                        this.state.listShowBean.sort=value;
                        this.setState({
                            listShowBean:this.state.listShowBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="类型"
                    value={this.state.listShowBean.type}
                    onChange={(value)=>{
                        this.state.listShowBean.type=value;
                        this.setState({
                            listShowBean:this.state.listShowBean
                        })
                    }}/>
                <Widget.Select
                    dataSource={this.state.stateBeans}
                    title="状态"
                    init_value={this.state.listShowBean.state}
                    select_value="id"
                    show_value="name"
                    onChange={(rowID)=>{
                            state_index=rowID;
                        }}/>
                <Widget.Select
                    dataSource={this.state.listTypeBeans}
                    title="位置"
                    init_value={this.state.listShowBean.list_type}
                    select_value="type_value"
                    show_value="type_name"
                    onChange={(rowID)=>{
                            list_type_index=rowID;
                        }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertListShow();
                    }}/>
            </div>
        )
    }
}

module.exports=ListShowEditorComponent;