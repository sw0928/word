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
            tagBean:JSON.parse(this.props.params.tagBean),
        };
    }

    componentDidMount() {
    }

    insertClass() {
        if (this.isNull(this.state.tagBean.tag_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["tag_name"]=this.state.tagBean.tag_name;
        params["sort"]=this.state.tagBean.sort;

        if(this.isNull(this.state.tagBean.tag_id)){
            params["parent_id"]=this.state.tagBean.parent_id;
            this.getDataByPost(1,homeurl+"goodsController2.api?insertGoodsTag",params);
        }else{
            params["tag_id"]=this.state.tagBean.tag_id;
            this.getDataByPost(2,homeurl+"goodsController2.api?updateGoodsTag",params);
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
                <Widget.Toolbar title="分类编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.tagBean.tag_name}
                    onChange={(value)=>{
                        this.state.tagBean.tag_name=value;
                        this.setState({
                            tagBean:this.state.tagBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.tagBean.sort}
                    onChange={(value)=>{
                        this.state.tagBean.sort=value;
                        this.setState({
                            tagBean:this.state.tagBean
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