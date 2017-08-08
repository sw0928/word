/**
 * Created by shenjiabo on 17/1/11.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require('./../../widget/WidgetComponent');

var ServiceComponent=require("./../goods/ServiceComponent");
var StandardComponent=require("./../goods/StandardComponent");
var GroupBuyComponent=require("./../goods/GroupBuyComponent");
var GoodsEditorComponent=require("./GoodsEditorComponent");
var GoodsDetailPictureComponent=require("./GoodsDetailPictureComponent");
var GoodsDetailEditorComponent=require("./GoodsDetailEditorComponent");

class GoodsDetailComponent extends  Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var goodsBean=JSON.parse(this.props.params.goodsBean);
        if(!goodsBean.goods_id){
            Widget.storage.set("goodsIndex",0);
        }
        this.state = {
            goodsBean:goodsBean,
            goodsImgBeans:goodsBean.goodsImgBeans?goodsBean.goodsImgBeans:[],
            moudleBeans:[],
            index:0,
        };
    }

    componentDidMount() {
        this.updateMoudle(this.state.goodsBean);
    }

    updateMoudle(goodsBean) {
        if(goodsBean.goods_id){
            this.setState({
                goodsBean:goodsBean,
            });
            this.setState({
                moudleBeans:[
                    {"name":"基本信息",component:this.renderBase()},
                    {"name":"图片编辑",component:this.renderPicture()},
                    {"name":"详情编辑",component:this.renderDetail()},
                    {"name":"服务编辑",component:this.renderService()},
                    {"name":"参数编辑",component:this.renderStandard()},
                    {"name":"团购编辑",component:this.renderGroupBuy()},
                ]
            })
        }else {
            this.setState({
                moudleBeans:[{"name":"基本信息",component:this.renderBase()}]
            })
        }
    }


    render(){
        return(
            <div>
                <Widget.Toolbar title="商品详情" history={this.props.history}/>
                <Widget.TabBar saveIndex="goodsIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}/>
            </div>
        )
    }

    /**
     *团购编辑
     */
    renderGroupBuy(){
        return(
            <GroupBuyComponent
                updateMoudle={this.updateMoudle.bind(this)}
                history={this.props.history}
                goodsBean={this.state.goodsBean}/>
        )
    }

    /**
     * 基本详情编辑
     */
    renderBase(){
        return(
            <GoodsEditorComponent
                updateMoudle={this.updateMoudle.bind(this)}
                history={this.props.history} goodsBean={this.state.goodsBean}></GoodsEditorComponent>
        )
    }

    /**
     * 详情编辑
     */
    renderDetail(){
        return(
            <GoodsDetailEditorComponent history={this.props.history} goodsBean={this.state.goodsBean}></GoodsDetailEditorComponent>
        )
    }

    renderParameter(){
        return(
            <ParameterComponent history={this.props.history} goods_id={this.state.goodsBean.goods_id}></ParameterComponent>
        )
    }

    renderService(){
        return(
            <ServiceComponent history={this.props.history} goods_id={this.state.goodsBean.goods_id}></ServiceComponent>
        )
    }

    renderPicture(){
        return(
            <GoodsDetailPictureComponent goodsBean={this.state.goodsBean}></GoodsDetailPictureComponent>
        )
    }

    renderStandard(){
        return(
            <StandardComponent history={this.props.history} goods_id={this.state.goodsBean.goods_id}></StandardComponent>
        )
    }

}

module.exports=GoodsDetailComponent;