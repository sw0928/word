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
            htmlBean:JSON.parse(this.props.params.htmlBean),
            typeBeans:[{id:'1',name:'分类'},{id:'2',name:'网页'}],
            detailBean:{},
            html_type:"1",
        };
    }

    componentDidMount() {
        this.getDataByPost(3,homeurl+"systemController.api?getSystemDetailShows",{detail_type:"class_detail"});
    }

    insertClass() {
        if (this.isNull(this.state.htmlBean.html_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["html_name"]=this.state.htmlBean.html_name;
        params["sort"]=this.state.htmlBean.sort;
        params["parent_id"]=this.state.htmlBean.parent_id;
        params["html_type"]=this.state.html_type;

        if(this.isNull(this.state.htmlBean.html_id)){
            this.getDataByPost(1,homeurl+"othersController.api?insertHelpDetail",params);
        }else{
            params["html_id"]=this.state.htmlBean.html_id;
            this.getDataByPost(2,homeurl+"othersController.api?updateHelpDetail",params);
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
            case 3:
                this.setState({
                    detailBean:JSON.parse(data)
                })
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
                    value={this.state.htmlBean.html_name}
                    onChange={(value)=>{
                        this.state.htmlBean.html_name=value;
                        this.setState({
                            htmlBean:this.state.htmlBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.htmlBean.sort}
                    onChange={(value)=>{
                        this.state.htmlBean.sort=value;
                        this.setState({
                            htmlBean:this.state.htmlBean
                        })
                    }}/>
                <div style={{display:'flex'}}>
                    <Widget.SelectV2
                        visible={this.isNull(this.state.htmlBean.html_id)?"true":"false"}
                        marginTop={20}
                        dataSource={this.state.typeBeans}
                        title="是否推荐"
                        init_value={this.state.htmlBean.html_type}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                            this.setState({
                                html_type:this.state.typeBeans[rowID].id
                            })
                        }}/>
                </div>
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