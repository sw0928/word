/**
 * Created by shenjiabo on 16/12/16.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class ListTypeEditorComponent extends Widget.BaseComponent {

    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            listTypeBean:JSON.parse(this.props.params.listTypeBean)
        };
    }

    insertListType(){
        if(this.isNull(this.state.listTypeBean.type_name)){
            this.showTip("名称不可为空");
            return;
        }

        if(this.isNull(this.state.listTypeBean.type_value)){
            this.showTip("键值不可为空");
            return;
        }

        if(this.isNull(this.state.listTypeBean.type_id)){
            this.getDataByPost(1,homeurl+"systemController.api?insertSystemListType",
                {type_name:this.state.listTypeBean.type_name,
                type_value:this.state.listTypeBean.type_value,
                    type_type:this.state.listTypeBean.type_type});
        }else{
            this.getDataByPost(2,homeurl+"systemController.api?updateSystemListType",
                {type_name:this.state.listTypeBean.type_name,
                 type_value:this.state.listTypeBean.type_value,
                 type_id:this.state.listTypeBean.type_id});
        }
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
    render(){
        return(
            <div>
                <Widget.Toolbar title="类型编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.listTypeBean.type_name}
                    onChange={(value)=>{
                        this.state.listTypeBean.type_name=value;
                        this.setState({
                            listTypeBean:this.state.listTypeBean
                        })
                    }}/>
                <Widget.Editor
                    visible={this.isNull(this.state.listTypeBean.type_id)?"true":"false"}
                    marginTop={20}
                    title="键值"
                    value={this.state.listTypeBean.type_value}
                    onChange={(value)=>{
                        this.state.listTypeBean.type_value=value;
                        this.setState({
                            listTypeBean:this.state.listTypeBean
                        })
                    }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertListType();
                    }}/>
            </div>
        )
    }
}

module.exports=ListTypeEditorComponent;

