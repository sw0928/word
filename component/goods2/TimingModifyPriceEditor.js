/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class GoodsClassEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            timingBean:JSON.parse(this.props.params.timingBean),
        };
    }

    componentDidMount() {
    }

    insertClass() {
        if (this.isNull(this.state.timingBean.goods_sku)) {
            this.showTip("sku不可为空");
            return;
        }

        var params={};
        params["goods_sku"]=this.state.timingBean.goods_sku;
        params["goods_now_price"]=this.state.timingBean.goods_now_price;
        params["goods_origin_price"]=this.state.timingBean.goods_origin_price;
        params["goods_new_price"]=this.state.timingBean.goods_new_price;
        params["modify_time"]=this.state.timingBean.modify_time;

        this.getDataByPost(1,homeurl+"goodsController2.api?insertGoodsTiming",params);
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.showTip("添加成功");
                this.props.history.goBack();
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="定时编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="sku"
                    value={this.state.timingBean.goods_sku}
                    onChange={(value)=>{
                        this.state.timingBean.goods_sku=value;
                        this.setState({
                            timingBean:this.state.timingBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="现价"
                    value={this.state.timingBean.goods_now_price}
                    onChange={(value)=>{
                        this.state.timingBean.goods_now_price=value;
                        this.setState({
                            timingBean:this.state.timingBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="原价"
                    value={this.state.timingBean.goods_origin_price}
                    onChange={(value)=>{
                        this.state.timingBean.goods_origin_price=value;
                        this.setState({
                            timingBean:this.state.timingBean
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="改价"
                    value={this.state.timingBean.goods_new_price}
                    onChange={(value)=>{
                        this.state.timingBean.goods_new_price=value;
                        this.setState({
                            timingBean:this.state.timingBean
                        })
                    }}/>
                <Widget.Date
                    title="修改时间"
                    marginRight={20}
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.state.timingBean.modify_time}
                    onChange={(value)=>{
                            this.state.timingBean.modify_time=value;
                            this.setState({
                                timingBean:this.state.timingBean,
                            })
                        }}
                />
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