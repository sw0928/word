/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var goods_state_index=-1;
class LogisticsEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            logisticsBean:JSON.parse(this.props.params.logisticsBean),
        };
    }

    componentDidMount() {

    }

    insertOrderLogistics() {
        if (this.isNull(this.state.logisticsBean.logistics_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["logistics_name"]=this.state.logisticsBean.logistics_name;
        params["logistics_pinyin"]=this.state.logisticsBean.logistics_pinyin;

        if(this.isNull(this.state.logisticsBean.logistics_id)){
            this.getDataByPost(1,homeurl+"orderController.api?insertOrderLogistics",params);
        }else{
            params["logistics_id"]=this.state.logisticsBean.logistics_id;
            this.getDataByPost(2,homeurl+"orderController.api?updateOrderLogistics",params);
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
                <Widget.Toolbar title="物流编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.logisticsBean.logistics_name}
                    onChange={(value)=>{
                        this.state.logisticsBean.logistics_name=value;
                        this.setState({
                            logisticsBean:this.state.logisticsBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="简写"
                    value={this.state.logisticsBean.logistics_pinyin}
                    onChange={(value)=>{
                        this.state.logisticsBean.logistics_pinyin=value;
                        this.setState({
                            logisticsBean:this.state.logisticsBean
                        })
                    }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertOrderLogistics();
                    }}/>
            </div>
        )
    }


}

module.exports=LogisticsEditorComponent;