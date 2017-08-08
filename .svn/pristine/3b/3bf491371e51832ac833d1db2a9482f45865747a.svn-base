/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class CouponEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var couponBean=JSON.parse(this.props.params.couponBean);
        this.state = {
            couponBean:couponBean,
            typeBeans:[{name:"平台优惠卷",id:"platform"},{name:"商品优惠卷",id:"goods"},{name:"商家优惠卷",id:"merchants"}
                ,{name:"分类优惠卷",id:"class"}],
            postionBeans:[{name:"领卷中心",id:"coupon"},{name:"后台",id:"back"}],

            allGoodsBeans:[],
            selectBean:{goods_id:couponBean.goods_id,goods_name:couponBean.goods_name},
            goods_name:couponBean.goods_name,
            allGoodsClassBeans:[],
            selectClassBean:{},
            goods_class_name:"",
        };
    }

    componentDidMount() {
        this.getGoods();
        this.getGoodsClass();
    }

    getGoods(goods_name){
        this.getDataByPost(3,homeurl+"goodsController2.api?searchGoods",{goods_name:goods_name})
    }

    getGoodsClass(){
        this.getDataByPost(4,homeurl+"goodsController2.api?getGoodsClasssNoPage",{})
    }

    insertClass() {
        if (this.isNull(this.state.couponBean.coupon_name)) {
            this.showTip("名称不可为空");
            return;
        }

        if (this.isNull(this.state.couponBean.start_time)) {
            this.showTip("开始时间不可为空");
            return;
        }

        if (this.isNull(this.state.couponBean.start_time)) {
            this.showTip("结束时间不可为空");
            return;
        }

        if(isNaN(this.state.couponBean.coupon_price)){
            this.showTip("减免金额非法");
            return;
        }

        if(isNaN(this.state.couponBean.coupon_full_price)){
            this.showTip("满多少减非法");
            return;
        }

        if(isNaN(this.state.couponBean.valid_day)){
            this.showTip("有效天数非法非法");
            return;
        }

        var params={};
        params["coupon_name"]=this.state.couponBean.coupon_name;
        params["coupon_full_price"]=this.state.couponBean.coupon_full_price;
        params["coupon_img"]=this.state.couponBean.coupon_img;
        params["coupon_price"]=this.state.couponBean.coupon_price;
        params["start_time"]=this.state.couponBean.start_time;
        params["end_time"]=this.state.couponBean.end_time;
        params["coupon_type"]=this.isNull(this.state.couponBean.coupon_type)?"platform":this.state.couponBean.coupon_type;
        params["coupon_postion"]=this.isNull(this.state.couponBean.coupon_postion)?"coupon":this.state.couponBean.coupon_postion;
        params["coupon_desc"]=this.state.couponBean.coupon_desc;
        params["valid_day"]=this.state.couponBean.valid_day;
        params["goods_id"]=this.state.selectBean.goods_id;
        params["goods_name"]=this.state.selectBean.goods_name;
        params["class_id"]=this.state.selectClassBean.class_id;
        params["class_uuid"]=this.state.selectClassBean.class_uuid;

        if(this.isNull(this.state.couponBean.coupon_id)){
            this.getDataByPost(1,homeurl+"couponController.api?insertCoupon",params);
        }else{
            params["coupon_id"]=this.state.couponBean.coupon_id;
            this.getDataByPost(2,homeurl+"couponController.api?updateCoupon",params);
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
                    allGoodsBeans:data
                })
                break;
            case 4:
                this.setState({
                    allGoodsClassBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["class_uuid"]+""===this.state.couponBean.class_uuid+"";
                    }.bind(this));

                    if(d.length>0){
                        this.setState({
                            selectClassBean: d[0],
                            goods_class_name:d[0].class_name,
                        })
                    }else{
                    }
                }
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
                    value={this.state.couponBean.coupon_name}
                    onChange={(value)=>{
                        this.state.couponBean.coupon_name=value;
                        this.setState({
                            couponBean:this.state.couponBean
                        })
                    }}/>
                <div style={{display:'flex',alignItems:'center'}}>
                    <Widget.Editor
                        marginTop={20}
                        title="满多少可减"
                        value={this.state.couponBean.coupon_full_price}
                        onChange={(value)=>{
                        this.state.couponBean.coupon_full_price=value;
                        this.setState({
                            couponBean:this.state.couponBean
                        })
                    }}/>
                    <Widget.Editor
                        marginTop={20}
                        title="减免金额"
                        value={this.state.couponBean.coupon_price}
                        onChange={(value)=>{
                        this.state.couponBean.coupon_price=value;
                        this.setState({
                            couponBean:this.state.couponBean
                        })
                    }}/>
                    <Widget.Editor
                        marginTop={20}
                        title="有效天数"
                        value={this.state.couponBean.valid_day}
                        onChange={(value)=>{
                        this.state.couponBean.valid_day=value;
                        this.setState({
                            couponBean:this.state.couponBean
                        })
                    }}/>
                </div>

                <Widget.Textarea
                    marginTop={20}
                    title="描述"
                    value={this.state.couponBean.coupon_desc}
                    onChange={(value)=>{
                        this.state.couponBean.coupon_desc=value;
                        this.setState({
                            couponBean:this.state.couponBean
                        })
                    }}/>
                <Widget.Img
                    marginTop={20}
                    title="图标"
                    src={this.isNull(this.state.couponBean.coupon_img)?"./images/add.jpg":imgurl+this.state.couponBean.coupon_img}
                    url={homeurl+'goodsController.api?uploadGoodsImg'}
                    onSuccess={(data)=>{
                        this.state.couponBean.coupon_img=data;
                        this.setState({
                            couponBean:this.state.couponBean,
                        })
                    }}/>
                <div style={{marginTop:20,display:'flex'}}>
                    <Widget.Date
                        title="开始时间"
                        style={{marginLeft:10}}
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.couponBean.start_time}
                        onChange={(dateString)=>{
                            this.state.couponBean.start_time=dateString;
                            this.setState({
                                couponBean:this.state.couponBean
                            })
                        }}
                    />
                    <Widget.Date
                        title="结束时间"
                        style={{marginLeft:10}}
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.couponBean.end_time}
                        onChange={(dateString)=>{
                            this.state.couponBean.end_time=dateString;
                            this.setState({
                                couponBean:this.state.couponBean
                            })
                        }}
                    />
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <Widget.SelectV2
                        marginTop={20}
                        dataSource={this.state.typeBeans}
                        title="类型"
                        init_value={this.state.couponBean.coupon_type}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                            this.state.couponBean.coupon_type=this.state.typeBeans[rowID].id;
                            this.setState({
                                couponBean:this.state.couponBean
                            })
                        }}/>
                    <Widget.SelectV2
                        marginTop={20}
                        dataSource={this.state.postionBeans}
                        title="展示位置"
                        init_value={this.state.couponBean.coupon_postion}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                            this.state.couponBean.coupon_postion=this.state.postionBeans[rowID].id;
                            this.setState({
                                couponBean:this.state.couponBean
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <p1 style={{fontSize:13,marginLeft:20,marginRight:20}}>商品名</p1>
                    <Widget.SearchBarV2
                        item_name="goods_name"
                        dataSource={this.state.allGoodsBeans}
                        name={this.state.goods_name}
                        onPress={(data,value)=>{
                            this.setState({
                                goods_name:value,
                                allGoodsBeans:[],
                                selectBean:data,
                            })
                            if(!this.isNull(value)&&this.isNull(data.goods_name)){
                                this.getGoods(value);
                            }
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <p1 style={{fontSize:13,marginLeft:20,marginRight:20}}>商品分类名</p1>
                    <Widget.SearchBar
                        item_name="class_name"
                        dataSource={this.state.allGoodsClassBeans}
                        name={this.state.goods_class_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectClassBean:data,
                                goods_class_name:value,
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

module.exports=CouponEditorComponent;