/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var goods_state_index=-1;
var goods_recommend_index=-1;

class GoodsClassEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            menuBean:JSON.parse(this.props.params.menuBean),
        };
    }

    componentDidMount() {
    }

    insertClass() {
        if (this.isNull(this.state.menuBean.menu_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["menu_name"]=this.state.menuBean.menu_name;
        params["menu_url"]=this.state.menuBean.menu_url;
        params["sort"]=this.state.menuBean.sort;
        params["parent_id"]=this.state.menuBean.parent_id;
        params["menu_type"]="view";

        if(this.isNull(this.state.menuBean.wx_menu_id)){
            this.getDataByPost(1,homeurl+"othersController.api?insertWXMenu",params);
        }else{
            params["wx_menu_id"]=this.state.menuBean.wx_menu_id;
            this.getDataByPost(2,homeurl+"othersController.api?updateWXMenu",params);
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
                <Widget.Toolbar title="菜单编辑" history={this.props.history}/>
                <Widget.Editor
                marginTop={20}
                title="名称"
                value={this.state.menuBean.menu_name}
                onChange={(value)=>{
                        this.state.menuBean.menu_name=value;
                        this.setState({
                            menuBean:this.state.menuBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="连接"
                    value={this.state.menuBean.menu_url}
                    onChange={(value)=>{
                        this.state.menuBean.menu_url=value;
                        this.setState({
                            menuBean:this.state.menuBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.menuBean.sort}
                    onChange={(value)=>{
                        this.state.menuBean.sort=value;
                        this.setState({
                            menuBean:this.state.menuBean
                        })
                    }}/>

                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertClass();
                    }}/>
            </div>
        )
    }


}

module.exports=GoodsClassEditorComponent;