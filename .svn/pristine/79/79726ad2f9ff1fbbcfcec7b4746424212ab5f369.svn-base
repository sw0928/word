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
            detailShowBean:JSON.parse(this.props.params.detailShowBean),
            listTypeBeans:[],
            stateBeans:[{name:"开启",id:'true'},{name:"关闭",id:"false"}],
        };
    }

    componentDidMount() {
        this.getSystemListTypesNoPage();
    }

    getSystemListTypesNoPage(){
        this.getDataByPost(1, homeurl + "systemController.api?getSystemListTypesNoPage", {type_type:'detail'});
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
        var params={};
        params["name"]=this.state.detailShowBean.name;
        params["detail_type"]=this.state.listTypeBeans[list_type_index].type_value;
        params["is_visible"]=this.state.stateBeans[state_index].id;

        if(this.isNull(this.state.detailShowBean.detail_id)){
            this.getDataByPost(2,homeurl+"systemController.api?insertSystemDetailShow",params);
        }else{
            params["detail_id"]=this.state.detailShowBean.detail_id;
            this.getDataByPost(3,homeurl+"systemController.api?updateSystemDetailShow",params);
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="列表编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.detailShowBean.name}
                    onChange={(value)=>{
                        this.state.detailShowBean.name=value;
                        this.setState({
                            detailShowBean:this.state.detailShowBean
                        })
                    }}/>
                <Widget.Select
                    dataSource={this.state.stateBeans}
                    title="状态"
                    init_value={this.state.detailShowBean.is_visible}
                    select_value="id"
                    show_value="name"
                    onChange={(rowID)=>{
                            state_index=rowID;
                        }}/>
                <Widget.Select
                    dataSource={this.state.listTypeBeans}
                    title="位置"
                    init_value={this.state.detailShowBean.detail_type}
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