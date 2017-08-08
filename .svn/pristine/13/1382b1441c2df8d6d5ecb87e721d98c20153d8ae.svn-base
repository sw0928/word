/**
 * Created by shenjiabo on 16/8/25.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var TipComponent=require('./../../widget/TipComponent');
import Upload from 'rc-upload';
var Toolbar=require("./../../widget/Toolbar");

var parent_id="";

var ParameterComponent=require("./ParameterComponent");
var ServiceComponent=require("./ServiceComponent");
var StandardComponent=require("./StandardComponent");
var GroupBuyComponent=require("./GroupBuyComponent");

var TabBar=require('./../../widget/TabBar');

var TextComponent=require('./../../widget/TextComponent');
var EditorComponent=require('./../../widget/EditorComponent');
var CheckComponent=require('./../../widget/CheckComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var SelectComponent=require('./../../widget/SelectComponent');
var ImgComponent=require('./../../widget/ImgComponent');
var DateComponent=require('./../../widget/DateComponent');
var ViewComponent=require('./../../widget/ViewComponent');

var DetailConfig=require('./../../widget/DetailConfig');

class MerchantsGoodsEditorComponent extends  BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var goodsBean=JSON.parse(this.props.params.goodsBean);
        if(!goodsBean.goods_id){
            storage.set("goodsIndex",0);
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
                    {"name":"参数编辑",component:this.renderParameter()},
                    {"name":"服务编辑",component:this.renderService()},
                    {"name":"规格编辑",component:this.renderStandard()},
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
                <Toolbar title="商品详情" history={this.props.history}></Toolbar>
                <TabBar saveIndex="goodsIndex"
                        dataSource={this.state.moudleBeans}
                        component={this.state.moudleBeans.length>0?
                        this.state.moudleBeans[this.state.moudleBeans.length>this.state.index?this.state.index:0].component:null}
                        onPress={(rowID)=>{
                        this.setState({
                            index:rowID
                        })
                    }}></TabBar>
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
                goodsBean={this.state.goodsBean}>

            </GroupBuyComponent>
        )
    }

    /**
     * 基本详情编辑
     */
    renderBase(){
        return(
            <RenderBase
                updateMoudle={this.updateMoudle.bind(this)}
                history={this.props.history} goodsBean={this.state.goodsBean}></RenderBase>
        )
    }

    /**
     * 详情编辑
     */
    renderDetail(){
        return(
            <RenderDetail history={this.props.history} goodsBean={this.state.goodsBean}></RenderDetail>
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
            <RenderPicture goodsBean={this.state.goodsBean}></RenderPicture>
        )
    }

    renderStandard(){
        return(
            <StandardComponent history={this.props.history} goods_id={this.state.goodsBean.goods_id}></StandardComponent>
        )
    }

}

class RenderDetail extends  BaseComponent{
    render(){
        return(
            <div style={{display:this.props.goodsBean.goods_id?'flex':"none"}}>
                <iframe src={htmlurl+"/goods_editor.html?goods_url="+this.props.goodsBean.goods_url}
                        style={{display:'flex',width:1000,height:800}}>
                </iframe>
            </div>
        )
    }
}

class RenderPicture extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态

        this.state = {
            goodsBean:this.props.goodsBean,
            goodsImgBeans:[],
            uploaderProps :{
                action: homeurl+'goodsController.api?uploadGoodsImg',
                data: {},
                headers: {
                    Authorization: 'xxxxxxx',
                },
                multiple: false,
                beforeUpload(file) {
                    console.log('beforeUpload', file.name);
                },
                onStart: (file) => {
                    console.log('onStart', file.name);
                },
                onProgress(step, file) {
                    console.log('onProgress', Math.round(step.percent), file.name);
                },
                onError(err) {
                    console.log('onError', err);
                    toast.show("上传失败");
                },
            }
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"goodsController.api?getGoodsImgs",{goods_id:this.state.goodsBean.goods_id})
    }
    insertPicture(){
        if(this.state.goodsImgBeans.length<=0){
            toast.show("至少选择一张图片");
            return;
        }
        this.getDataByPost(2,homeurl+"goodsController.api?insertGoodsImg",{goods_id:this.state.goodsBean.goods_id,
            imgs:JSON.stringify(this.state.goodsImgBeans),});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    goodsImgBeans:data
                })
                break;
            case 2:
                toast.show("保存成功");
                break;
        }
    }
    render(){
        return(
            <div>
                <div style={{display:'flex',flex:1,height:50,alignItems:'center',marginLeft:20}}>
                    <div style={{width:100,display:'flex',height:30,
                                        alignItems:'center',justifyContent:'center',background:'blue'}}
                         onClick={()=>{
                                        this.insertPicture();
                                    }}>
                        <p1 style={{fontSize:15,color:'#ffffff'}}>保存</p1>
                    </div>
                </div>
                <div style={{display:'flex',flex:1,alignItems:'center',marginLeft:20}}>
                    <div style={{width:120,display:'flex',
                        justifyContent:'flex-end',marginLeft:20}}>
                        <p1 style={styles.font}>展示图片</p1>
                    </div>
                    <div style={{display:'flex',flexDirection:'row',flexWrap:'wrap'}}>
                        <ListView
                            style={{display:'flex',flexDirection:'row',flexWrap:'wrap'}}
                            dataSource={this.state.goodsImgBeans}
                            renderRow={(rowID)=>{
                                return(
                                    <div style={{display:'flex',flexDirection:'column'}}>
                                        <div style={{width:80,height:40,marginLeft:10,}}>
                                            <input style={{height:30,width:80}} placeholder="权重"
                                            value={this.state.goodsImgBeans[rowID].sort}
                                            onChange={(e)=>{
                                                this.state.goodsImgBeans[rowID].sort=e.target.value;
                                                this.setState({
                                                    goodsImgBeans:this.state.goodsImgBeans,
                                                })
                                            }}/>
                                        </div>
                                        <div style={{width:80,height:80,marginLeft:10}}>
                                            <img src={imgurl+this.state.goodsImgBeans[rowID].goods_img} style={{width:80,height:80}}/>
                                        </div>
                                        <div style={{height:40,width:80,display:'flex',
                                            justifyContent:'center',alignItems:'center'}}
                                            onClick={()=>{
                                                    this.state.goodsImgBeans.splice(rowID,1);
                                                    this.setState({
                                                        goodsImgBeans:this.state.goodsImgBeans,
                                                    });
                                            }}>
                                            <p1 style={{fontSize:15}}>删除</p1>
                                        </div>
                                    </div>
                                );
                            }}>
                        </ListView>
                        <div style={{display:'flex',flexDirection:'column',height:160,alignItems:'center',justifyContent:'center'}}>
                            <Upload {...this.state.uploaderProps} ref="inner" style={{outline:'none'}}
                                                                  onSuccess={(data)=>{
                                                if(data.status==='ok'){
                                                    this.setState({
                                                        goodsImgBeans:[{sort:'1',"goods_img":data.data}].concat(this.state.goodsImgBeans),
                                                    })
                                                }else{
                                                    toast.show(data.error);
                                                }
                                            }}>
                                <div style={{width:80,height:80,marginLeft:10}}>
                                    <img src='./images/add.jpg' style={{width:80,height:80}}/>
                                </div>
                            </Upload>
                        </div>
                    </div>

                </div>
            </div>

        )
    }
}

var brand_index=-1;
var goods_state_index=-1;

var is_pre_sale_index=-1;
var ssp_gift_index=-1;
var ssp_fresh_index=-1;
var ssp_baby_index=-1;
var ssp_lady_index=-1;
var ssp_feature_index=-1;
var ssp_import_index=-1;
var ssp_promotion_index=-1;
var storehouse_index=-1;

class RenderBase extends  BaseComponent{
    constructor(props) {
        super(props);
        // 初始状态
        var goodsBean=this.props.goodsBean;
        this.state = {
            goodsImgBeans:goodsBean.goodsImgBeans?goodsBean.goodsImgBeans:[],
            goodsClassBeans:[],
            brandBeans:[],

            goodsStateBeans:[{id:'0',name:'下架中'},{id:'1',name:'上架中'}],
            goodsBean:goodsBean,
            goods_name:goodsBean.goods_name?goodsBean.goods_name:"",
            goods_now_price:goodsBean.goods_now_price?goodsBean.goods_now_price:0,
            goods_origin_price:goodsBean.goods_origin_price?goodsBean.goods_origin_price:0,
            is_express:goodsBean.is_express?goodsBean.is_express:"1",
            express_price:goodsBean.express_price?goodsBean.express_price:0,
            day_sales:goodsBean.day_sales?goodsBean.day_sales:0,
            month_sales:goodsBean.month_sales?goodsBean.month_sales:0,
            year_sales:goodsBean.year_sales?goodsBean.year_sales:0,
            goods_address:goodsBean.goods_address?goodsBean.goods_address:0,
            sort:goodsBean.sort,
            goods_stock:goodsBean.goods_stock?goodsBean.goods_stock:100,
            brand_id:goodsBean.brand_id,
            season_id:goodsBean.season_id,
            year_id:goodsBean.year_id,
            size_id:goodsBean.size_id,
            is_hot:goodsBean.is_hot?goodsBean.is_hot:0,
            is_selling:goodsBean.is_selling?goodsBean.is_selling:0,
            is_recommend:goodsBean.is_recommend?goodsBean.is_recommend:0,

            goods_state:goodsBean.goods_state,
            parent_uuid:goodsBean.parent_uuid?goodsBean.parent_uuid:"",
            ssp_gift:goodsBean.ssp_gift?goodsBean.ssp_gift:0,
            ssp_fresh:goodsBean.ssp_fresh?goodsBean.ssp_fresh:0,
            ssp_baby:goodsBean.ssp_baby?goodsBean.ssp_baby:0,
            ssp_lady:goodsBean.ssp_lady?goodsBean.ssp_lady:0,
            ssp_feature:goodsBean.ssp_feature?goodsBean.ssp_feature:0,
            ssp_import:goodsBean.ssp_import?goodsBean.ssp_import:0,
            ssp_promotion:goodsBean.ssp_promotion?goodsBean.ssp_promotion:0,

            is_pre_sale:goodsBean.is_pre_sale?goodsBean.is_pre_sale:0,
            is_pre_sale_id:goodsBean.is_pre_sale_id?goodsBean.is_pre_sale_id:0,

            is_cross_border:goodsBean.is_cross_border?goodsBean.is_cross_border:0,
            cross_border_tax:goodsBean.cross_border_tax?goodsBean.cross_border_tax:0,
            goods_excise_tax:goodsBean.goods_excise_tax?goodsBean.goods_excise_tax:0,
            goods_sku:goodsBean.goods_sku?goodsBean.goods_sku:0,
            goods_skus:goodsBean.goods_skus?goodsBean.goods_skus:0,
            goods_storehouse:goodsBean.goods_storehouse?goodsBean.goods_storehouse:0,

            moudleBeans:[],
            itemCurIndex:0,

            goods_class_id:0,
            allGoodsLabelBeans:[],
            goodsLabelBeans:[],
            sspClassBeans:[],
            preSaleBeans:[],
            sspPromotionBeans:[],
            sspGiftBeans:[],
            sspFreshBeans:[],
            sspBabyBeans:[],
            sspLadyBeans:[],
            sspFeatureBeans:[],
            sspImportBeans:[],
            storehouseBeans:[],
            detailBean:{},
        }

    }
    componentDidMount() {
        this.getDataByPost(1,homeurl+"goodsController.api?getAllGoodsClass",{})
        this.getDataByPost(2,homeurl+"goodsController.api?getAllBrands",{})
        this.getGoodsLabel(this.state.goodsBean.goods_id);
        if(company_name==='ssp'){
            this.getSSPGoodsClass();
        }else if(company_name==='hbr'){

        }else if(company_name==='jf'){
            
        }else{
            this.getSSPGoodsClass();
        }
        this.getDataByPost(7,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'goods_detail'});

    }

    getSSPGoodsClass(){
        this.getDataByPost(6,homeurl+"sspInterfaces.api?getSSPGoodsClass",{});
    }

    getGoodsLabel(goods_id){
        this.getDataByPost(5,homeurl+"goodsController.api?getGoodsClassLabels",{goods_id:goods_id,parent_id:'-1'});
    }

    insertGoodsDetail(){
        if(!this.state.goodsBean.merchants_id){
            toast.show("请先确定供应商");
            return;
        }
        if(isNaN(this.state.goods_now_price)){
            toast.show("现价含有非法数字");
            return;
        }
        if(isNaN(this.state.goods_origin_price)){
            toast.show("原价含有非法数字");
            return;
        }
        if(this.state.goods_name===''){
            toast.show("请先填写商品名称");
            return;
        }
        if(isNaN(this.state.express_price)){
            toast.show("邮费价格非法");
            return;
        }
        if(this.state.goods_address===''){
            toast.show("请先填写所属地");
            return;
        }
        if(isNaN(this.state.day_sales)){
            toast.show("日销量非法");
            return;
        }
        if(isNaN(this.state.month_sales)){
            toast.show("月销量非法");
            return;
        }
        if(isNaN(this.state.year_sales)){
            toast.show("年销量非法");
            return;
        }

        if(!parent_id||parent_id===''){
            toast.show("请先选择分类");
            return;
        }

        if(brand_index===-1){
            toast.show("请先选择品牌");
            return;
        }

        if(isNaN(this.state.goods_stock)){
            toast.show("非法库存");
            return;
        }

        if(isNaN(this.state.cross_border_tax)){
            toast.show("关税内容非法");
            return;
        }

        if(isNaN(this.state.goods_excise_tax)){
            toast.show("消费税非法");
            return;
        }
        if(isNaN(this.state.goodsBean.give_integral_value&&this.state.goodsBean.give_integral_value!==""?this.state.goodsBean.give_integral_value:"0")){
            toast.show("赠送积分非法");
            return;
        }


        if(company_name==='ssp'){
            if(is_pre_sale_index===-1){
                toast.show("请先选择预售分类");
                return;
            }
            if(ssp_gift_index===-1){
                toast.show("请先选择礼品分类");
                return;
            }
            if(ssp_fresh_index===-1){
                toast.show("请先选择生鲜分类");
                return;
            }
            if(ssp_baby_index===-1){
                toast.show("请先选择母婴分类");
                return;
            }
            if(ssp_lady_index===-1){
                toast.show("请先选择女士分类");
                return;
            }
            if(ssp_feature_index===-1){
                toast.show("请先选择推荐分类");
                return;
            }
            if(ssp_import_index===-1){
                toast.show("请先选择进口分类");
                return;
            }
            if(ssp_promotion_index===-1){
                toast.show("请先选择促销分类");
                return;
            }
        }else if(company_name==='hbr'){
        }else if(company_name==='jf'){
        }else{
            if(is_pre_sale_index===-1){
                toast.show("请先选择预售分类");
                return;
            }
            if(ssp_gift_index===-1){
                toast.show("请先选择礼品分类");
                return;
            }
            if(ssp_fresh_index===-1){
                toast.show("请先选择生鲜分类");
                return;
            }
            if(ssp_baby_index===-1){
                toast.show("请先选择母婴分类");
                return;
            }
            if(ssp_lady_index===-1){
                toast.show("请先选择女士分类");
                return;
            }
            if(ssp_feature_index===-1){
                toast.show("请先选择推荐分类");
                return;
            }
            if(ssp_import_index===-1){
                toast.show("请先选择进口分类");
                return;
            }
            if(ssp_promotion_index===-1){
                toast.show("请先选择促销分类");
                return;
            }
        }

        var params={}
        params["merchants_id"]=this.state.goodsBean.merchants_id;
        params["goods_name"]=this.state.goods_name;
        params["goods_type"]="2";
        params["sort"]=this.state.sort;
        params["parent_id"]=parent_id;
        params["is_express"]=this.state.is_express;
        params["express_price"]=this.state.express_price;
        params["goods_address"]=this.state.goods_address;
        params["day_sales"]=this.state.day_sales;
        params["brand_id"]=this.state.brandBeans[brand_index].brand_id;
        params["goods_stock"]=this.state.goods_stock;
        params["goods_state"]=this.isNull(this.state.goods_state)?0:this.state.goods_state;
        params["imgs"]=JSON.stringify(this.state.goodsImgBeans);
        params["goods_origin_price"]=this.state.goods_origin_price;
        params["goods_now_price"]=this.state.goods_now_price;
        params["is_hot"]=this.state.is_hot;
        params["is_selling"]=this.state.is_selling;
        params["goods_labels"]=JSON.stringify(this.state.goodsLabelBeans);
        if(storehouse_index!==-1){
            params["goods_storehouse"]=this.state.storehouseBeans[storehouse_index].storehouse_name;
        }
        params["is_recommend"]=this.state.is_recommend;
        params["is_cross_border"]=this.state.is_cross_border;
        params["cross_border_tax"]=this.state.cross_border_tax;
        params["goods_sku"]=this.state.goods_sku;
        params["goods_skus"]=this.state.goods_skus;
        params["goods_excise_tax"]=this.state.goods_excise_tax;
        params["is_new"]=this.state.is_new;
        params["goods_img"]=this.state.goodsBean.goods_img;
        params["give_integral_value"]=this.state.goodsBean.give_integral_value;
        params["is_give_integral"]=this.state.goodsBean.is_give_integral;

        if(company_name==='ssp'){
            params["is_pre_sale"]=this.state.is_pre_sale;
            params["is_pre_sale_id"]=this.state.preSaleBeans[is_pre_sale_index].class_id;
            params["send_goods_time"]=this.state.goodsBean.send_goods_time;
            params["ssp_gift"]=this.state.ssp_gift;
            params["ssp_gift_id"]=this.state.sspGiftBeans[ssp_gift_index].class_id;
            params["ssp_fresh"]=this.state.ssp_fresh;
            params["ssp_fresh_id"]=this.state.sspFreshBeans[ssp_fresh_index].class_id;
            params["ssp_baby"]=this.state.ssp_baby;
            params["ssp_baby_id"]=this.state.sspBabyBeans[ssp_baby_index].class_id;
            params["ssp_lady"]=this.state.ssp_lady;
            params["ssp_lady_id"]=this.state.sspLadyBeans[ssp_lady_index].class_id;
            params["ssp_feature"]=this.state.ssp_feature;
            params["ssp_feature_id"]=this.state.sspFeatureBeans[ssp_feature_index].class_id;
            params["ssp_import"]=this.state.ssp_import;
            params["ssp_import_id"]=this.state.sspImportBeans[ssp_import_index].class_id;
        }else if(company_name==='hbr'){
        }else if(company_name==='jf'){
        }else{
            params["is_pre_sale"]=this.state.is_pre_sale;
            params["is_pre_sale_id"]=this.state.preSaleBeans[is_pre_sale_index].class_id;
            params["send_goods_time"]=this.state.goodsBean.send_goods_time;
            params["ssp_gift"]=this.state.ssp_gift;
            params["ssp_gift_id"]=this.state.sspGiftBeans[ssp_gift_index].class_id;
            params["ssp_fresh"]=this.state.ssp_fresh;
            params["ssp_fresh_id"]=this.state.sspFreshBeans[ssp_fresh_index].class_id;
            params["ssp_baby"]=this.state.ssp_baby;
            params["ssp_baby_id"]=this.state.sspBabyBeans[ssp_baby_index].class_id;
            params["ssp_lady"]=this.state.ssp_lady;
            params["ssp_lady_id"]=this.state.sspLadyBeans[ssp_lady_index].class_id;
            params["ssp_feature"]=this.state.ssp_feature;
            params["ssp_feature_id"]=this.state.sspFeatureBeans[ssp_feature_index].class_id;
            params["ssp_import"]=this.state.ssp_import;
            params["ssp_import_id"]=this.state.sspImportBeans[ssp_import_index].class_id;
            params["ssp_promotion"]=this.state.ssp_promotion;
            params["ssp_promotion_id"]=this.state.sspPromotionBeans[ssp_promotion_index].class_id;
        }

        if(!this.state.goodsBean.goods_id){
            this.getDataByPost(3,homeurl+"goodsController.api?insertGoodsDetail",params)
        }else{
            params["goods_id"]=this.state.goodsBean.goods_id;
            this.getDataByPost(4,homeurl+"goodsController.api?updateGoodsDetail",params)
        }
    }

    doSuccess(index,data){
        switch (index){
            case 7:
                this.setState({
                    detailBean:JSON.parse(data)
                })
                break;
            case 1:
                this.setState({
                    goodsClassBeans:data,
                })
                break;
            case 2:
                this.setState({
                    brandBeans:data,
                });
                break;
            case 3:
                toast.show("添加成功");
                this.setState({
                    goodsBean:data,
                });
                this.props.updateMoudle(data);
                this.getGoodsLabel(data.goods_id);
                break;
            case 4:
                toast.show("修改成功");
                this.setState({
                    goodsBean:data,
                });
                this.props.updateMoudle(data);
                break;
            case 5:
                this.setState({
                    allGoodsLabelBeans:data,
                    goods_class_id:""
                })
                break;
            case 6:
                this.setState({
                    sspClassBeans:data,
                    preSaleBeans:data.filter(function(item){
                        return item["class_type"].indexOf("is_pre_sale")>=0;
                    }),
                    sspPromotionBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_promotion")>=0;
                    }),
                    sspGiftBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_gift")>=0;
                    }),
                    sspFreshBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_fresh")>=0;
                    }),
                    sspBabyBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_baby")>=0;
                    }),
                    sspLadyBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_lady")>=0;
                    }),
                    sspFeatureBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_feature")>=0;
                    }),
                    sspImportBeans:data.filter(function(item){
                        return item["class_type"].indexOf("ssp_import")>=0;
                    }),
                });
                break;
        }
    }

    render() {
        let classView=[];
        classView.push(<div style={{display:'flex',flex:1,height:50,alignItems:'center'}}>
            {this.addClass(this.state.goodsClassBeans,1,this.state.parent_uuid)}
        </div>);

        let view=[];
        if(company_name==='ssp'){
            view=this.renderSSP();
        }else if(company_name==='hbr'){
            view=this.renderHBR();
        }else if(company_name==='jf'){
            view.push(this.renderJF());
        }else{
            view.push(this.renderJF());
            view.push(this.renderSSP());
            view.push(this.renderHBR());
        }

        return(
            <div>
                <ButtonComponent value="保存"
                                 width={80}
                                 marginLeft={100}
                                 marginTop={20}
                                 onClick={()=>{
                                    this.insertGoodsDetail();
                                 }}>
                </ButtonComponent>
                <div style={styles.div}>
                    <EditorComponent
                        title="商品名称"
                        value={this.state.goods_name}
                        onChange={(value)=>{
                            this.setState({
                                goods_name:value
                            })
                        }}>

                    </EditorComponent>
                    <ImgComponent
                        title="图片"
                        src={this.state.goodsBean.goods_img}
                        url={homeurl+"goodsController.api?uploadGoodsImg"}
                        onSuccess={(data)=>{
                            this.state.goodsBean.goods_img=data;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            });
                        }}>
                    </ImgComponent>
                </div>
                <ViewComponent visible={this.state.detailBean.goods_sku_show}>
                    <div style={styles.div}>
                        <EditorComponent
                            visible={this.state.detailBean.goods_sku}
                            title="商品编码"
                            value={this.state.goods_sku}
                            onChange={(value)=>{
                                    this.setState({
                                        goods_sku:value
                                    })
                                }}>
                        </EditorComponent>
                        <EditorComponent
                            visible={this.state.detailBean.goods_skus}
                            title="组合编码"
                            value={this.state.goods_skus}
                            onChange={(value)=>{
                                    this.setState({
                                        goods_skus:value
                                    })
                                }}>
                        </EditorComponent>
                    </div>
                </ViewComponent>
                <ViewComponent visible={this.state.detailBean.give_integral_show}>
                    <div style={styles.div}>
                        <EditorComponent
                            visible={this.state.detailBean.give_integral_value}
                            title="赠送积分"
                            value={this.state.goodsBean.give_integral_value&&
                            this.state.goodsBean.give_integral_value!==''?
                                this.state.goodsBean.give_integral_value:0}
                            onChange={(value)=>{
                                this.state.goodsBean.give_integral_value=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                });
                            }}>
                        </EditorComponent>
                            <CheckComponent
                            visible={this.state.detailBean.is_give_integral}
                            title="是否赠送"
                            checked={this.state.goodsBean.is_give_integral}
                            onClick={(value)=>{
                                this.state.goodsBean.is_give_integral=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                });
                            }}></CheckComponent>
                    </div>
                </ViewComponent>
                {view}
                <div style={styles.div}>
                    <EditorComponent
                        title="原价(元)"
                        value={this.state.goods_origin_price}
                        onChange={(value)=>{
                            this.setState({
                                goods_origin_price:value
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        title="现价(元)"
                        value={this.state.goods_now_price}
                        onChange={(value)=>{
                            this.setState({
                                goods_now_price:value
                            })
                        }}>

                    </EditorComponent>
                    <EditorComponent
                        visible={this.state.detailBean.goods_excise_tax}
                        title="消费税"
                        value={this.state.goods_excise_tax}
                        onChange={(value)=>{
                            this.setState({
                                goods_excise_tax:value
                            })
                        }}>

                    </EditorComponent>
                </div>
                <ViewComponent visible={this.state.detailBean.express_show}>
                    <div style={styles.div}>
                        <EditorComponent
                            visible={this.state.detailBean.express_price}
                            title="邮费"
                            value={this.state.express_price}
                            onChange={(value)=>{
                                this.setState({
                                    express_price:value
                                })
                            }}></EditorComponent>
                        <CheckComponent
                            visible={this.state.detailBean.is_express}
                            title="是否包邮"
                            checked={this.state.is_express}
                            onClick={(value)=>{
                                this.setState({
                                    is_express:value
                                });
                            }}></CheckComponent>
                    </div>
                </ViewComponent>
                <ViewComponent visible={this.state.detailBean.sales_show}>
                    <EditorComponent
                        visible={this.state.detailBean.year_sales}
                        title="年销量"
                        value={this.state.year_sales}
                        onChange={(value)=>{
                            this.setState({
                                year_sales:value
                            })
                        }}></EditorComponent>
                    <EditorComponent
                        visible={this.state.detailBean.month_sales}
                        title="月销量"
                        value={this.state.month_sales}
                        onChange={(value)=>{
                            this.setState({
                                month_sales:value
                            })
                        }}></EditorComponent>
                    <EditorComponent
                        visible={this.state.detailBean.day_sales}
                        title="日销量"
                        value={this.state.day_sales}
                        onChange={(value)=>{
                            this.setState({
                                day_sales:value
                            })
                        }}></EditorComponent>
                </ViewComponent>
                <div style={styles.div}>
                    <EditorComponent
                        title="产地"
                        value={this.state.goods_address}
                        onChange={(value)=>{
                            this.setState({
                                goods_address:value
                            })
                        }}></EditorComponent>
                    <SelectComponent
                        visible={this.state.detailBean.express_show}
                        dataSource={this.state.storehouseBeans}
                        title="所属仓库"
                        init_value={this.state.goods_storehouse}

                        select_value="storehouse_name"
                        show_value="storehouse_name"
                        onChange={(rowID)=>{
                                        storehouse_index=rowID
                                     }}/>
                    <EditorComponent
                        title="库存"
                        value={this.state.goods_stock}
                        onChange={(value)=>{
                            this.setState({
                                goods_stock:value
                            })
                        }}></EditorComponent>

                </div>
                <div style={styles.div}>
                    <EditorComponent
                        title="权重"
                        value={this.state.sort}
                        onChange={(value)=>{
                            this.setState({
                                sort:value
                            })
                        }}></EditorComponent>
                </div>
                {classView}
                {this.renderGoodsLabel()}
                <div style={{display:'flex'}}>
                    {this.renderBrand()}
                </div>
            </div>
        )
    }
    /**
     * 顺手拍
     */
    renderSSP(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'row',flexWrap:'wrap',alignItems:'center'}}>
                <SelectComponent dataSource={this.state.preSaleBeans}
                                 title="预售分类"
                                 init_value={this.state.is_pre_sale_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    is_pre_sale_index=rowID
                                 }}/>
                <DateComponent
                    width={60}
                    title="发货时间"
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.props.goodsBean.send_goods_time}
                    onChange={(value)=>{
                        this.props.goodsBean.send_goods_time=value;
                        this.setState({
                            goodsBean:this.props.goodsBean,
                        })
                    }}/>
                <CheckComponent
                    title="是否预售"
                    checked={this.state.is_pre_sale}
                    onClick={(value)=>{
                            this.setState({
                                is_pre_sale:value
                            });
                        }}></CheckComponent>
                <SelectComponent dataSource={this.state.sspGiftBeans}
                                 title="礼品分类"
                                 init_value={this.state.goodsBean.ssp_gift_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                ssp_gift_index=rowID
                             }}>
                </SelectComponent>
                <CheckComponent
                    title="礼品"
                    checked={this.state.ssp_gift}
                    onClick={(value)=>{
                            this.setState({
                                ssp_gift:value
                            });
                        }}></CheckComponent>
                <SelectComponent dataSource={this.state.sspFreshBeans}
                                 title="生鲜分类"
                                 init_value={this.state.goodsBean.ssp_fresh_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                ssp_fresh_index=rowID

                             }}>
                </SelectComponent>
                <CheckComponent
                    title="生鲜"
                    checked={this.state.ssp_fresh}
                    onClick={(value)=>{
                            this.setState({
                                ssp_fresh:value
                            });
                        }}></CheckComponent>
                <SelectComponent dataSource={this.state.sspBabyBeans}
                                 title="母婴分类"
                                 init_value={this.state.goodsBean.ssp_baby_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    ssp_baby_index=rowID

                                }}/>
                <CheckComponent
                    title="母婴"
                    checked={this.state.ssp_baby}
                    onClick={(value)=>{
                            this.setState({
                                ssp_baby:value
                            });
                        }}/>
                <SelectComponent dataSource={this.state.sspLadyBeans}
                                 title="女士分类"
                                 init_value={this.state.goodsBean.ssp_lady_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    ssp_lady_index=rowID
                                }}/>
                <CheckComponent
                    title="女士"
                    checked={this.state.ssp_lady}
                    onClick={(value)=>{
                            this.setState({
                                ssp_lady:value
                            });
                        }}/>
                <SelectComponent dataSource={this.state.sspFeatureBeans}
                                 title="推荐分类"
                                 init_value={this.state.goodsBean.ssp_feature_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    ssp_feature_index=rowID
                                }}/>
                <CheckComponent
                    title="特别推荐"
                    checked={this.state.ssp_feature}
                    onClick={(value)=>{
                            this.setState({
                                ssp_feature:value
                            });
                        }}></CheckComponent>
                <SelectComponent dataSource={this.state.sspImportBeans}
                                 title="进口分类"
                                 init_value={this.state.goodsBean.ssp_import_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    ssp_import_index=rowID
                                }}/>
                <CheckComponent
                    title="进口商品"
                    checked={this.state.ssp_import}
                    onClick={(value)=>{
                            this.setState({
                                ssp_import:value
                            });
                        }}></CheckComponent>
                <SelectComponent dataSource={this.state.sspPromotionBeans}
                                 title="促销分类"
                                 init_value={this.state.goodsBean.ssp_promotion_id}
                                 select_value="class_id"
                                 show_value="class_name"
                                 onChange={(rowID)=>{
                                    ssp_promotion_index=rowID
                                }}/>
                <CheckComponent
                    title="促销商品"
                    checked={this.state.ssp_promotion}
                    onClick={(value)=>{
                            this.setState({
                                ssp_promotion:value
                            });
                        }}></CheckComponent>
            </div>
        )
    }

    /**
     * 何柏瑞
     */
    renderHBR(){
        return(
            <div style={{display:'flex'}}>
                <EditorComponent
                    title="关税(百分比)"
                    value={this.state.cross_border_tax}
                    onChange={(value)=>{
                            this.setState({
                                cross_border_tax:value
                            })
                        }}>

                </EditorComponent>
                <CheckComponent
                    title="是否跨境"
                    checked={this.state.is_cross_border}
                    onClick={(value)=>{
                            this.setState({
                                is_cross_border:value
                            });
                        }}>
                </CheckComponent>
            </div>
        )
    }

    /**
     * 家纺
     */
    renderJF(){
        return(
            <div style={{display:'flex',marginLeft:100}}>
                <CheckComponent
                    title="是否推荐"
                    checked={this.state.is_recommend}
                    onClick={(value)=>{
                            this.setState({
                                is_recommend:value
                            });
                        }}>
                </CheckComponent>
                <CheckComponent
                    title="热门商品"
                    checked={this.state.is_hot}
                    onClick={(value)=>{
                    this.setState({
                        is_hot:value
                    });
                }}>
                </CheckComponent>
                <CheckComponent
                    title="畅销商品"
                    checked={this.state.is_selling}
                    onClick={(value)=>{
                    this.setState({
                        is_selling:value
                    });
                }}>
                </CheckComponent>
                <CheckComponent
                    title="最新商品"
                    checked={this.state.goodsBean.is_new}
                    onClick={(value)=>{
                    this.state.goodsBean.is_new=value;
                    this.setState({
                        goodsBean:this.state.goodsBean,
                    });
                }}>
                </CheckComponent>
            </div>

        )
    }
    /**
     * 递归展示商品分类  灵活展示N级分类
     * @param goodsClassBeans
     * @param count
     * @param parent_uuid
     * @returns {Array}
     */
    addClass(goodsClassBeans,count,parent_uuid){
        let v=[];
        let view=[];
        var index=0;
        if(goodsClassBeans&&goodsClassBeans.length>0){
            for(let i=0;i<goodsClassBeans.length;i++){
                if(parent_uuid.indexOf(goodsClassBeans[i].goods_parent_uuid)>=0){//每次刷新 要定位到已经选择的这个类
                    index=i;//记录选择的这个  下级分类就可以确定下来了
                    view.push(<option selected="selected">{goodsClassBeans[i].goods_name}</option>);
                }else{
                    view.push(<option>{goodsClassBeans[i].goods_name}</option>);
                }
            }
            v.push(<div style={{display:'flex'}}>
                <div style={{width:80,display:'flex',justifyContent:'flex-end',marginLeft:20}}>
                    <p1 style={{fontSize:13,marginLeft:20}}>{count}级分类</p1>
                </div>
                <select
                    style={{marginLeft:10}}
                    ref={"class"+count}
                    onChange={()=>{//选择改变事件
                            //重新赋值parent_uuid  用来刷新下级分类的数据
                            this.setState({
                                parent_uuid:goodsClassBeans[this.refs["class"+count].selectedIndex].goods_parent_uuid
                            })
                        }}>
                    {view}
                </select>
            </div>);
            parent_id=goodsClassBeans[index].goods_id;//因为是递归 所以parent_id一定是最后一级的值
            if(count===1){//记录下第一级的goods_id  用来取这个分类下的筛选标签管理
                if(this.state.goods_class_id+""!==parent_id+""){//值变了 才会更新
                    var is_hava="0";
                    for(let j=0;j<this.state.allGoodsLabelBeans.length;j++){
                        if(this.state.allGoodsLabelBeans[j].goods_id+""===parent_id+""){
                            is_hava="1";
                            this.setState({
                                goods_class_id:parent_id,
                                goodsLabelBeans:this.state.allGoodsLabelBeans[j].goodsLabelBeans
                            });
                            break;
                        }
                    }
                    if(is_hava==='0'){//如果此分类下 没有匹配的  则数据为空
                        this.setState({
                            goods_class_id:parent_id,
                            goodsLabelBeans:[],
                        });
                    }
                }
            }
            if(goodsClassBeans[index].goodsBeans.length>0){//还有下级分类
                v.push(this.addClass(goodsClassBeans[index].goodsBeans,count+1,parent_uuid));
            }
        }
        return v;
    }

    renderGoodsLabel(){
        return(
            <ListView
                style={{marginLeft:160}}
                dataSource={this.state.goodsLabelBeans}
                renderRow={(rowID)=>{
                    return(
                        <div style={{display:'flex',flexDirection:"column"}}>
                            <p style={{fontSize:15}}>{this.state.goodsLabelBeans[rowID].label_name}</p>
                            <ListView
                                style={{display:'flex',flexDirection:'row',
                                flexWrap:'wrap',alignItems:'center',}}
                                dataSource={this.state.goodsLabelBeans[rowID].goodsLabelBeans}
                                renderRow={(index)=>{
                                    return(
                                        <div style={{display:'flex',alignItems:'center',height:30,marginLeft:10}}>
                                            <p>{this.state.goodsLabelBeans[rowID].goodsLabelBeans[index].label_name}</p>
                                            <input type="checkbox"
                                                checked={this.state.goodsLabelBeans[rowID].goodsLabelBeans[index].is_select==='1'?true:false}
                                                onClick={()=>{
                                                    if(this.state.goodsLabelBeans[rowID].goodsLabelBeans[index].is_select=='1'){
                                                        this.state.goodsLabelBeans[rowID].goodsLabelBeans[index].is_select="0";
                                                    }else{
                                                        this.state.goodsLabelBeans[rowID].goodsLabelBeans[index].is_select="1";
                                                        if(this.state.goodsLabelBeans[rowID].select_way!=='1'){//如果是单选 则需要把其他的变成未选中
                                                            for(let i=0;i<this.state.goodsLabelBeans[rowID].goodsLabelBeans.length;i++){
                                                                if(i!=index){
                                                                    this.state.goodsLabelBeans[rowID].goodsLabelBeans[i].is_select="0";
                                                                }
                                                            }
                                                        }
                                                    }
                                                    this.setState({
                                                        goodsLabelBeans:this.state.goodsLabelBeans,
                                                    })
                                                }}/>
                                        </div>
                                    )
                                }}>

                            </ListView>
                        </div>
                    )
                }}>
            </ListView>
        )
    }

    renderBrand() {
        return (
            <div style={{display:(company_name==='hbr'?'none':'flex')}}>
                <SelectComponent dataSource={this.state.brandBeans}
                                 title="品牌"
                                 init_value={this.state.brand_id}
                                 select_value="brand_id"
                                 show_value="brand_name"
                                 onChange={(rowID)=>{
                                        brand_index=rowID
                                     }}>
                </SelectComponent>
            </div>
        )
    }

    renderGoodsState(){
        return(
            <SelectComponent dataSource={this.state.goodsStateBeans}
                             title="商品状态"
                             init_value={this.state.goods_state}
                             select_value="id"
                             show_value="name"
                             onChange={(rowID)=>{
                                goods_state_index=rowID
                             }}>
            </SelectComponent>
        )
    }
}

const styles = {
    div:{
        marginTop:20,
        display:'flex',
        alignItems:'center'
    },
    tab:{
        display:'flex',
        flex:1,
        height:50,
        alignItems:'center',
        marginLeft:100,
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    input:{
        width:200,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,

    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    },
}
module.exports=MerchantsGoodsEditorComponent;

