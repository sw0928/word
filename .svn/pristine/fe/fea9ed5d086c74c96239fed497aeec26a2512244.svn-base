/**
 * Created by shenjiabo on 16/12/29.
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');


class GoodsEditorComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var goodsBean = this.props.goodsBean;
        this.state = {
            goods_no: goodsBean.goods_no,
            goods_id: goodsBean.goods_id,
            goodsBean: {},
            goods_index:-1,//记录选中的商品的下标
            parameterBeans: [],
            goods_parameters: [],
            goodsBeans: [],

            detailBean:{},
            storehouseBeans:[],
            brandBeans:[],
            goodsStateBeans:[{id:'0',name:'下架中'},{id:'1',name:'上架中'}],
            goodsLabelBeans:[],

            selectBean:{},
            allMerchantsBeans:[],
            merchants_name:"",
            merchants_id:this.isNull(goodsBean.goods_id)?(Widget.storage.get("goods_merchants_id")?Widget.storage.get("goods_merchants_id"):""):goodsBean.merchants_id,
        };
    }

    componentDidMount() {
        this.getGoodsByNo();
        this.getDataByPost(6,homeurl+"merchantsController.api?getAllMerchantsNopage",{merchants_type:'2,4'});
        this.getDataByPost(7,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'goods_detail'});
        this.getStorehouses();
        this.getBrands();
    }
    getBrands(){
        this.getDataByPost(8,homeurl+"goodsController.api?getAllBrands",{})
    }
    getStorehouses(){
        this.getDataByPost(9,homeurl+"/goodsController.api?getGoodsStorehousesNoPage",{})
    }
    getGoodsByNo() {
        this.getDataByPost(3, homeurl + "goodsController2.api?getGoodsByNo",
            {goods_no: this.state.goods_no});
    }

    getParameters(goods_no) {
        this.getDataByPost(2, homeurl + "goodsController2.api?getGoodsParametersByNo",
            {goods_no: goods_no});
    }

    saveParameter() {
        this.getDataByPost(1, homeurl + "goodsController2.api?insertGoodsParameters",
            {parameters: JSON.stringify(this.state.parameterBeans), goods_no: this.state.goods_no});
    }

    insertGoodsDetail() {
        if((!this.state.detailBean.merchants_name
            ||this.state.detailBean.merchants_name==='true')
            &&this.isNull(this.state.selectBean.merchants_id)){

            Widget.storage.set("goods_merchants_id",his.state.selectBean.merchants_id);

            this.showTip("请先选择商家");
            return;
        }

        if(this.isNull(this.state.goodsBean.goods_name)){
            this.showTip("名称不可为空");
            return;
        }

        if(isNaN(this.state.goodsBean.goods_origin_price)){
            this.showTip("原价非法");
            return;
        }

        if(isNaN(this.state.goodsBean.goods_now_price)){
            this.showTip("现价非法");
            return;
        }

        if(isNaN(this.state.goodsBean.goods_pc_price)){
            this.showTip("PC价非法");
            return;
        }

        if(isNaN(this.state.goodsBean.express_price)){
            this.showTip("邮费非法");
            return;
        }

        if(isNaN(this.state.goodsBean.year_sales)){
            this.showTip("总销量非法");
            return;
        }
        if(isNaN(this.state.goodsBean.month_sales)){
            this.showTip("月销量非法");
            return;
        }
        if(isNaN(this.state.goodsBean.day_sales)){
            this.showTip("日销量非法");
            return;
        }
        if(isNaN(this.state.goodsBean.goods_stock)){
            this.showTip("库存非法");
            return;
        }

        if(isNaN(this.state.goodsBean.give_integral_value)){
            this.showTip("赠送积分非法");
            return;
        }


        var params = {}
        params["goods_name"] = this.state.goodsBean.goods_name;
        params["goods_img"] = this.state.goodsBean.goods_img;
        params["parameters"] = JSON.stringify(this.state.parameterBeans);
        params["goods_no"] = this.state.goods_no;


        params["merchants_id"]=this.state.selectBean.merchants_id;
        params["goods_type"]="2";
        params["sort_time"]=this.state.goodsBean.sort_time;
        params["is_express"]=this.state.goodsBean.is_express;
        params["express_price"]=this.state.goodsBean.express_price;
        params["goods_address"]=this.state.goodsBean.goods_address;
        params["brand_id"]=this.isNull(this.state.goodsBean.brand_id)?(this.state.brandBeans.length>0?this.state.brandBeans[0].brand_id:""):this.state.goodsBean.brand_id;
        params["goods_stock"]=this.state.goodsBean.goods_stock;
        params["goods_state"]=this.isNull(this.state.goodsBean.goods_state)?"0":this.state.goodsBean.goods_state;
        params["goods_origin_price"]=this.state.goodsBean.goods_origin_price;

        params["goods_now_price"]=this.state.goodsBean.goods_now_price;
        params["is_hot"]=this.state.goodsBean.is_hot;
        params["is_selling"]=this.state.goodsBean.is_selling;
        params["goods_labels"]=JSON.stringify(this.state.goodsLabelBeans);


        params["is_recommend"]=this.state.goodsBean.is_recommend;
        params["is_cross_border"]=this.state.goodsBean.is_cross_border;
        params["cross_border_tax"]=this.state.goodsBean.cross_border_tax;
        params["goods_sku"]=this.state.goodsBean.goods_sku;
        params["goods_skus"]=this.state.goodsBean.goods_skus;
        params["year_sales"]=this.state.goodsBean.year_sales;
        params["month_sales"]=this.state.goodsBean.month_sales;
        params["day_sales"]=this.state.goodsBean.day_sales;
        params["goods_storehouse"]=this.isNull(this.state.goodsBean.goods_storehouse)?(this.state.storehouseBeans.length>0?this.state.storehouseBeans[0].storehouse_name:""):this.state.goodsBean.goods_storehouse;
        params["is_new"]=this.state.goodsBean.is_new;
        params["goods_img"]=this.state.goodsBean.goods_img;
        params["give_integral_value"]=this.state.goodsBean.give_integral_value;
        params["is_give_integral"]=this.state.goodsBean.is_give_integral;
        params["is_class_recommend"]=this.state.goodsBean.is_class_recommend;
        params["class_recommend_img"]=this.state.goodsBean.class_recommend_img;
        params["goods_pc_price"]=this.state.goodsBean.goods_pc_price;

        if (!this.state.goodsBean.goods_id) {
            this.getDataByPost(4, homeurl + "goodsController2.api?insertGoodsDetail", params);
        } else {
            params["goods_id"] = this.state.goodsBean.goods_id;
            this.getDataByPost(5, homeurl + "goodsController2.api?updateGoodsDetail", params);
        }
    }


    doSuccess(index, data) {
        switch (index) {
            case 9:
                this.setState({
                    storehouseBeans:data
                })
                break;
            case 8:
                this.setState({
                    brandBeans:data
                })
                break;
            case 7:
                this.setState({
                    detailBean:JSON.parse(data)
                })
                break;
            case 6:
                this.setState({
                    allMerchantsBeans:data
                })
                if(data.length>0) {
                    var d=data.filter(function(item){
                        return item["merchants_id"]+""===this.state.merchants_id+"";
                    }.bind(this))
                    if(d.length>0){
                        this.setState({
                            selectBean: d[0],
                            merchants_name:d[0].merchants_name,
                        })
                    }else{
                        this.setState({
                            selectBean: data[0],
                            merchants_name:data[0].merchants_name,
                        })
                    }
                }
                break;
            case 5:
                this.showTip("保存成功");
                this.state.goodsBeans.splice(this.state.goods_index,1,data);
                this.setState({
                    goodsBeans:this.state.goodsBeans,
                })
                this.props.updateMoudle(data);
                break;
            case 4:
                this.showTip("保存成功");
                this.setState({
                    goodsBeans:this.state.goodsBeans.concat([data]),
                    goodsBean:data,
                })
                this.props.updateMoudle(data);
                this.getParameters(data.goods_no);
                break;
            case 3:
                console.log(JSON.stringify(data))
                if (data != null && data.length > 0) {
                    let is_hava = "0";
                    let goodsBean = {};
                    let goods_parameters = [];
                    let goods_index=-1;
                    for (let i = 0; i < data.length; i++) {
                        if (data[i].goods_id === this.state.goods_id) {
                            goods_index=i;
                            is_hava = "1";
                            goodsBean = data[i];
                            goods_parameters = data[i].goods_parameters.split(',')
                            break;
                        }
                    }

                    if (is_hava === '0') {
                        goods_index=0;
                        goodsBean = data[0];
                        goods_parameters = data[0].goods_parameters.split(',')
                    }

                    this.setState({
                        goods_index:goods_index,
                        goodsBeans: data,
                        goodsBean: goodsBean,
                        goods_parameters: goods_parameters
                    })
                } else {
                    this.setState({
                        goods_index:-1,
                        goodsBeans: data
                    })
                }
                this.getParameters(this.state.goods_no);
                break;
            case 2:
                if (data != null) {
                    for (let i = 0; i < data.length; i++) {
                        let goodsParameterBeans = data[i].goodsParameterBeans;
                        if (goodsParameterBeans != null && goodsParameterBeans.length > 0) {
                            var is_hava = '0';
                            for (let j = 0; j < goodsParameterBeans.length; j++) {
                                for (let h = 0; h < this.state.goods_parameters.length; h++) {
                                    if (goodsParameterBeans[j].parameter_id + "" === this.state.goods_parameters[h]) {
                                        is_hava = "1";
                                        data[i].goodsParameterBeans[j].is_select = '1';
                                        break;
                                    }
                                }
                            }

                            if (is_hava === '0') {
                                data[i].goodsParameterBeans[0].is_select = '1';
                            }
                        }
                    }
                }
                this.setState({
                    parameterBeans: data
                })
                break;
            case 1:
                this.showTip("保存成功");
                this.setState({
                    goods_no: data,
                });
                break;

        }
    }

    render() {
        return (
            <div>
                <Widget.Button value="保存"
                               width={80}
                               marginLeft={100}
                               marginTop={20}
                               onClick={()=>{
                                    this.insertGoodsDetail();
                                 }}/>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商家</p1>
                    </div>
                    <Widget.SearchBar
                        marginLeft={10}
                        item_name="merchants_name"
                        name={this.state.merchants_name}
                        dataSource={this.state.allMerchantsBeans}
                        onPress={(data,value)=>{
                            this.setState({
                                selectBean:data,
                                merchants_name:value,
                            })
                        }}/>
                 </div>
                <div style={styles.div}>
                    <Widget.Editor
                        visible={this.state.detailBean.goods_name}
                        title="商品名称"
                        value={this.state.goodsBean.goods_name}
                        onChange={(value)=>{
                            this.state.goodsBean.goods_name=value;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            })
                        }}/>
                    <Widget.Img
                        title="图片"
                        src={imgurl+this.state.goodsBean.goods_img}
                        url={homeurl+"goodsController.api?uploadGoodsImg"}
                        onSuccess={(data)=>{
                                this.state.goodsBean.goods_img=data;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                });
                        }}/>
                    <Widget.Check
                        title="是否推荐"
                        visible={this.state.detailBean.is_recommend}
                        checked={this.state.goodsBean.is_recommend}
                        onClick={(value)=>{
                            this.state.goodsBean.is_recommend=value;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            });
                        }}/>
                </div>
                <Widget.ViewComponent visible={this.state.detailBean.goods_sku_show}>
                    <Widget.Editor
                        visible={this.state.detailBean.goods_sku}
                        title="商品编码"
                        value={this.state.goodsBean.goods_sku}
                        onChange={(value)=>{
                                this.state.goodsBean.goods_sku=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                })
                            }}/>
                    <Widget.Editor
                        visible={this.state.detailBean.goods_skus}
                        title="组合编码"
                        value={this.state.goodsBean.goods_skus}
                        onChange={(value)=>{
                                this.state.goodsBean.goods_skus=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean
                                })
                            }}/>
                </Widget.ViewComponent>
                <div style={styles.div}>
                    <Widget.Editor
                        title="原价(元)"
                        value={this.state.goodsBean.goods_origin_price}
                        onChange={(value)=>{
                            this.state.goodsBean.goods_origin_price=value;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            })
                        }}/>

                    <Widget.Editor
                        title="现价(元)"
                        value={this.state.goodsBean.goods_now_price}
                        onChange={(value)=>{
                            this.state.goodsBean.goods_now_price=value;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            })
                        }}/>

                    <Widget.Editor
                        visible={this.state.detailBean.goods_pc_price}
                        title="PC现价(元)"
                        value={this.state.goodsBean.goods_pc_price}
                        onChange={(value)=>{
                            this.state.goodsBean.goods_pc_price=value;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            })
                        }}/>
                </div>
                <Widget.ViewComponent visible={this.state.detailBean.give_integral_show}>
                    <div style={styles.div}>
                        <Widget.Editor
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
                            }}/>
                        <Widget.Check
                            visible={this.state.detailBean.is_give_integral}
                            title="是否赠送"
                            checked={this.state.goodsBean.is_give_integral}
                            onClick={(value)=>{
                                this.state.goodsBean.is_give_integral=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                });
                            }}/>
                    </div>
                </Widget.ViewComponent>
                <Widget.ViewComponent visible={this.state.detailBean.express_show}>
                    <Widget.Editor
                        visible={this.state.detailBean.express_price}
                        title="邮费"
                        value={this.state.goodsBean.express_price}
                        onChange={(value)=>{
                                this.state.goodsBean.express_price=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                })
                            }}/>
                    <Widget.Check
                        visible={this.state.detailBean.is_express}
                        title="是否包邮"
                        checked={this.state.goodsBean.is_express}
                        onClick={(value)=>{
                                this.state.goodsBean.is_express=value;
                                this.setState({
                                    goodsBean:this.state.goodsBean,
                                })
                            }}/>
                </Widget.ViewComponent>
                <div style={styles.div}>
                    <Widget.Editor
                        title="总销量"
                        value={this.state.goodsBean.year_sales}
                        onChange={(value)=>{
                            this.state.goodsBean.year_sales=value;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            })
                        }}/>
                    <Widget.Editor
                        title="月销量"
                        value={this.state.goodsBean.month_sales}
                        onChange={(value)=>{
                            this.state.goodsBean.month_sales=value;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            })
                        }}/>
                    <Widget.Editor
                        title="日销量"
                        value={this.state.goodsBean.day_sales}
                        onChange={(value)=>{
                            this.state.goodsBean.day_sales=value;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            })
                        }}/>
                </div>
                <div style={styles.div}>
                    <Widget.SelectV2
                        visible={this.state.detailBean.goods_storehouse}
                        dataSource={this.state.storehouseBeans}
                        title="所属仓库"
                        init_value={this.state.goodsBean.goods_storehouse}
                        select_value="storehouse_name"
                        show_value="storehouse_name"
                        onChange={(rowID)=>{
                            this.state.goodsBean.goods_storehouse=this.state.storehouseBeans[rowID].storehouse_name;
                            this.setState({
                                goodsBean:this.state.goodsBean
                            });
                        }}/>
                    <Widget.Editor
                        title="库存"
                        value={this.state.goodsBean.goods_stock}
                        onChange={(value)=>{
                            this.state.goodsBean.goods_stock=value;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            })
                        }}/>
                </div>

                <div style={styles.div}>
                    <Widget.Date
                        title="排序时间"
                        style={{marginLeft:10}}
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.goodsBean.sort_time}
                        onChange={(value)=>{
                            this.state.goodsBean.sort_time=value;
                            this.setState({
                                goodsBean:this.state.goodsBean,
                            })
                        }}
                    />
                </div>
                {this.renderGoodsLabel()}
                <div style={{display:'flex'}}>
                    {this.renderBrand()}
                    {this.renderGoodsState()}
                </div>
                <div style={{marginLeft:20,marginRight:20,marginTop:40,background:'#efefef'}}>
                    <div style={{background:'#f5f5f5',height:40,alignItems:'center',display:'flex'}}>
                        <p1 style={{marginLeft:20}}>规格设置</p1>
                        <Widget.Button
                            visible={this.isNull(this.state.goods_no)?"true":"false"}
                            marginLeft={20}
                            value="添加"
                            onClick={()=>{
                                this.state.parameterBeans.push({goodsParameterBeans:[]});
                                this.setState({
                                    parameterBeans:this.state.parameterBeans
                                })
                            }}/>
                    </div>
                    <Widget.ListView
                        dataSource={this.state.parameterBeans}
                        renderRow={(rowID)=>{
                            return(
                                <div>
                                    <div style={{height:40,display:'flex',alignItems:"center"}}>
                                        <Widget.Editor
                                            inputWidth={100}
                                            tip="规格名"
                                            value={this.state.parameterBeans[rowID].parameter_name}
                                            onChange={(value)=>{
                                                this.state.parameterBeans[rowID].parameter_name=value;
                                                this.setState({
                                                    parameterBeans:this.state.parameterBeans
                                                })
                                            }}/>
                                        <Widget.ListView
                                            style={{display:'flex'}}
                                            dataSource={this.state.parameterBeans[rowID].goodsParameterBeans}
                                            renderRow={(index)=>{
                                                return(
                                                    <Widget.Button
                                                        background={this.state.parameterBeans[rowID].goodsParameterBeans[index].is_select==='1'?"blue":"#000000"}
                                                        marginLeft={20}
                                                        value={this.state.parameterBeans[rowID].goodsParameterBeans[index].parameter_name}
                                                        onClick={()=>{
                                                            for(let i=0;i<this.state.parameterBeans[rowID].goodsParameterBeans.length;i++){
                                                                if(i===index){
                                                                    this.state.parameterBeans[rowID].goodsParameterBeans[i].is_select="1";
                                                                }else{
                                                                    this.state.parameterBeans[rowID].goodsParameterBeans[i].is_select="0";
                                                                }
                                                            }

                                                            let goods_parameters=[]
                                                            for(let i=0;i<this.state.parameterBeans.length;i++){
                                                                for(let j=0;j<this.state.parameterBeans[i].goodsParameterBeans.length;j++){
                                                                    if(this.state.parameterBeans[i].goodsParameterBeans[j].is_select==='1'){
                                                                        goods_parameters.push(this.state.parameterBeans[i].goodsParameterBeans[j].parameter_id);
                                                                    }
                                                                }
                                                            }
                                                            let goodsBean={};
                                                            let is_have="0";
                                                            let goods_index=-1;
                                                            for(let i=0;i<this.state.goodsBeans.length;i++){
                                                                if(this.state.goodsBeans[i].goods_parameters===goods_parameters.toString()){
                                                                    this.state.goodsBean=this.state.goodsBeans[i];
                                                                    goodsBean=this.state.goodsBeans[i];
                                                                    goods_index=i;
                                                                    is_have="1";
                                                                    break;
                                                                }
                                                            }

                                                            if(is_have==='0'){
                                                                goods_index=-1;
                                                                this.state.goodsBean={};
                                                                goodsBean={};
                                                            }

                                                            this.props.updateMoudle(goodsBean);
                                                            this.setState({
                                                                goods_index:goods_index,
                                                                parameterBeans:this.state.parameterBeans,
                                                                goods_parameters:goods_parameters,
                                                                goodsBean:this.state.goodsBean,
                                                            })
                                                        }}/>
                                                )
                                            }}/>
                                        <Widget.Editor
                                            inputWidth={100}
                                            tip="规格"
                                            value={this.state.parameterBeans[rowID].name}
                                            onChange={(value)=>{
                                                this.state.parameterBeans[rowID].name=value;
                                                this.setState({
                                                    parameterBeans:this.state.parameterBeans
                                                })
                                            }}/>
                                        <Widget.Button
                                            marginLeft={20}
                                            value="添加"
                                            onClick={()=>{
                                                if(this.isNull(this.state.parameterBeans[rowID].name)){
                                                    this.showTip("规格不可为空");
                                                }else{
                                                    if(this.state.parameterBeans[rowID].goodsParameterBeans.length>0){
                                                        this.state.parameterBeans[rowID].goodsParameterBeans
                                                                .push({parameter_name:this.state.parameterBeans[rowID].name,is_select:"0"})
                                                    }else{
                                                        this.state.parameterBeans[rowID].goodsParameterBeans
                                                                .push({parameter_name:this.state.parameterBeans[rowID].name,is_select:"1"})
                                                    }

                                                    this.state.parameterBeans[rowID].name="";
                                                    this.setState({
                                                        parameterBeans:this.state.parameterBeans
                                                    });
                                                }
                                            }}/>
                                    </div>
                                    <div style={{background:'#f5f5f5',height:1}}></div>
                                </div>
                            )
                        }}>

                    </Widget.ListView>
                </div>
            </div>
        )
    }


    renderGoodsLabel(){
        return(
            <Widget.ListView
                style={{marginLeft:100}}
                dataSource={this.state.goodsLabelBeans}
                renderRow={(rowID)=>{
                    return(
                        <div style={{display:'flex',flexDirection:"column"}}>
                            <p style={{fontSize:15}}>{this.state.goodsLabelBeans[rowID].label_name}</p>
                            <Widget.ListView
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

                            </Widget.ListView>
                        </div>
                    )
                }}>
            </Widget.ListView>
        )
    }

    renderBrand() {
        return (
            <div style={{display:(company_name==='hbr'?'none':'flex')}}>
                <Widget.SelectV2 dataSource={this.state.brandBeans}
                                 title="品牌"
                                 init_value={this.state.goodsBean.brand_id}
                                 select_value="brand_id"
                                 show_value="brand_name"
                                 onChange={(rowID)=>{
                                    this.state.goodsBean.brand_id=this.state.brandBeans[rowID].brand_id;
                                    this.setState({
                                        goodsBean:this.state.goodsBean
                                    })
                                 }}/>
            </div>
        )
    }

    renderGoodsState(){
        return(
            <Widget.SelectV2 dataSource={this.state.goodsStateBeans}
                             title="商品状态"
                             init_value={this.state.goodsBean.goods_state}
                             select_value="id"
                             show_value="name"
                             onChange={(rowID)=>{
                                this.state.goodsBean.goods_state=this.state.goodsStateBeans[rowID].id;
                                this.setState({
                                    goodsBean:this.state.goodsBean
                                })
                             }}/>
        )
    }
}

const styles = {
    div: {
        marginTop: 20,
        display: 'flex',
        alignItems: 'center'
    },
}
module.exports = GoodsEditorComponent;