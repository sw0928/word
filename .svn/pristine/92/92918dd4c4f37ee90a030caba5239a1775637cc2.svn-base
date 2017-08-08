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
            goodsClassBean:JSON.parse(this.props.params.goodsClassBean),
            goodsStateBeans:[{id:'0',name:'下架中'},{id:'1',name:'上架中'}],
            goodsRecommendBeans:[{id:'0',name:'不推荐'},{id:'1',name:'推荐'}],
            detailBean:{}
        };
    }

    componentDidMount() {
        this.getDataByPost(3,homeurl+"systemController.api?getSystemDetailShows",{detail_type:"class_detail"});
    }

    insertClass() {
        if (this.isNull(this.state.goodsClassBean.class_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["class_name"]=this.state.goodsClassBean.class_name;
        params["class_desc"]=this.state.goodsClassBean.class_desc;
        params["class_img"]=this.state.goodsClassBean.class_img;
        params["sort"]=this.state.goodsClassBean.sort;
        params["class_state"]=this.state.goodsStateBeans[goods_state_index].id;
        params["parent_id"]=this.state.goodsClassBean.parent_id;
        params["class_desc_img"]=this.state.goodsClassBean.class_desc_img;
        params["is_recommend"]=this.state.goodsRecommendBeans[goods_recommend_index].id;

        if(this.isNull(this.state.goodsClassBean.class_id)){
            this.getDataByPost(1,homeurl+"goodsController2.api?insertGoodsClass",params);
        }else{
            params["class_id"]=this.state.goodsClassBean.class_id;
            this.getDataByPost(2,homeurl+"goodsController2.api?updateGoodsClass",params);
        }
    }
    updateClassExpress() {
        var params={};
        params["is_express"]=this.state.goodsClassBean.is_express==="1"?"0":"1";
        params["class_id"]=this.state.goodsClassBean.class_id;
        params["class_uuid"]=this.state.goodsClassBean.class_uuid;
        this.getDataByPost(2,homeurl+"goodsController2.api?updateClassExpress",params);
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
                    value={this.state.goodsClassBean.class_name}
                    onChange={(value)=>{
                        this.state.goodsClassBean.class_name=value;
                        this.setState({
                            goodsClassBean:this.state.goodsClassBean
                        })
                    }}/>
                <Widget.Textarea
                    marginTop={20}
                    height={200}
                    title="描述"
                    value={this.state.goodsClassBean.class_desc}
                    onChange={(value)=>{
                        this.state.goodsClassBean.class_desc=value;
                        this.setState({
                            goodsClassBean:this.state.goodsClassBean
                        })
                    }}/>
                <div style={{display:'flex'}}>
                    <Widget.Img
                        marginTop={20}
                        title="图标"
                        src={this.isNull(this.state.goodsClassBean.class_img)?"./images/add.jpg":imgurl+this.state.goodsClassBean.class_img}
                        url={homeurl+'goodsController.api?uploadGoodsImg'}
                        onSuccess={(data)=>{
                        this.state.goodsClassBean.class_img=data;
                        this.setState({
                            goodsClassBean:this.state.goodsClassBean,
                        })
                    }}/>
                    <Widget.Img
                        visible={this.state.detailBean.class_desc_img}
                        marginTop={20}
                        title="背景大图"
                        src={this.isNull(this.state.goodsClassBean.class_desc_img)?"./images/add.jpg":imgurl+this.state.goodsClassBean.class_desc_img}
                        url={homeurl+'goodsController.api?uploadGoodsImg'}
                        onSuccess={(data)=>{
                        this.state.goodsClassBean.class_desc_img=data;
                        this.setState({
                            goodsClassBean:this.state.goodsClassBean,
                        })
                    }}/>
                </div>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.goodsClassBean.sort}
                    onChange={(value)=>{
                        this.state.goodsClassBean.sort=value;
                        this.setState({
                            goodsClassBean:this.state.goodsClassBean
                        })
                    }}/>
                <div style={{display:'flex'}}>
                    <Widget.Select
                        visible={this.state.detailBean.is_recommend}
                        marginTop={20}
                        dataSource={this.state.goodsRecommendBeans}
                        title="是否推荐"
                        init_value={this.state.goodsClassBean.is_recommend}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                                    goods_recommend_index=rowID
                                 }}>
                    </Widget.Select>
                    <Widget.Select
                        marginTop={20}
                        dataSource={this.state.goodsStateBeans}
                        title="商品状态"
                        init_value={this.state.goodsClassBean.class_state}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                            goods_state_index=rowID
                        }}/>
                </div>
                <div style={{display:'flex'}}>
                    <Widget.Button
                        marginTop={20}
                        marginLeft={100}
                        width={100}
                        value="保存"
                        onClick={()=>{
                        this.insertClass();
                    }}/>
                    <Widget.Button
                        marginTop={20}
                        marginLeft={100}
                        width={100}
                        value={this.state.goodsClassBean.is_express==="1"?"取消免邮":"免邮"}
                        onClick={()=>{
                            this.updateClassExpress();
                        }}/>
                </div>
            </div>
        )
    }


}

module.exports=GoodsClassEditorComponent;