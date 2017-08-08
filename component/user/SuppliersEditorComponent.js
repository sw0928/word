/**
 * Created by shenjiabo on 16/8/24.
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
import {Router, Route, IndexRoute, Link, hashHistory} from 'react-router'
import {toast} from 'react-android-style-toast';

var Widget = require("./../../widget/WidgetComponent");

var MerchantsAccountComponent = require("./MerchantsAccountComponent");
class MerchantsEditorComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsBean = JSON.parse(decodeURIComponent(this.props.params.merchantsBean));
        this.state = {
            merchantsBean: merchantsBean,
            moudleBeans: [],
            index: 0,
        }
    }

    componentDidMount() {
        this.setState({
            moudleBeans: [
                {"name": "基本信息", component: this.renderBase()},
                {"name": "账号分配", component: this.renderMerchantsAccount()},
            ]
        });
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title="供应商详情管理" history={this.props.history}/>
                <Widget.TabBar saveIndex="merchantsIndex"
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

    renderBase() {
        return (
            <MerchantsBaseDetailComponent
                history={this.props.history}
                merchants_id={this.state.merchantsBean.merchants_id}>

            </MerchantsBaseDetailComponent>
        );
    }

    renderMerchantsAccount() {
        return (
            <MerchantsAccountComponent
                merchants_type="2"
                merchantsBean={this.state.merchantsBean}
                history={this.props.history}>

            </MerchantsAccountComponent>
        );
    }
}

var province_index = -1;
var state_index = -1;

class MerchantsBaseDetailComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        //var merchantsBean = this.props.merchantsBean;
        this.state = {
            stateBeans: [{state_id: "0", name: "关闭"}, {state_id: "1", name: "开启"}],
            state_id: 0,
            provinceBeans: [{provice_id: "0", name: "上海"}, {provice_id: "1", name: "北京"}],
            provice_id: 0,
            merchantsBean: {},
            merchants_id: this.props.merchants_id,
            click_index: 0,
            detailBean:{},
            img:"",
            imgVisible:false,
            merchantsDescImgBeans:[],
            brandBeans:[],
            brandBeansHad:[],
            brandTotal:0,
            brandPage:0
        }
    }

    componentWillMount(){
        this.getAllBrand()
        this.getMerchantsDetail();
    }

    componentDidMount() {
        this.getDataByPost(5,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'merchants_detail'});
        this.getMerchantsDescImgs();
    }

    getMerchantsDescImgs(){
        this.getDataByPost(6,homeurl+"merchantsController.api?getMerchantsDescImgs",{merchants_id:this.state.merchants_id});
    }

    getMerchantsDetail() {
        this.getDataByPost(4, homeurl + "merchantsController.api?getOneMerchantsDetail",{merchants_id: this.state.merchants_id});
    }

    insertMerchants() {
        if (this.isNull(this.state.merchantsBean.merchants_name)) {
            toast.show("商家名称不可为空");
            return;
        }
        if (province_index === -1) {
            toast.show("请选择所属地");
            return;
        }
        if (this.isNull(this.state.merchantsBean.merchants_address)) {
            toast.show("请填写详细地址");
            return;
        }
        if (this.isNull(this.state.merchantsBean.contact_name)) {
            toast.show("请填写联系人");
            return;
        }
        if (this.isNull(this.state.merchantsBean.contact_mobile)) {
            toast.show("请填写联系电话");
            return;
        }

        if (this.isNull(this.state.merchantsBean.merchants_img)) {
            toast.show("请先上传展示图片");
            return;
        }


        if (!this.state.merchantsBean.merchants_id) {
            this.getDataByPost(1, homeurl + "merchantsController.api?insertMerchantDetail",
                {
                    merchants_name: this.state.merchantsBean.merchants_name,
                    //merchants_province: this.state.provinceBeans[province_index].name,
                    merchants_address: this.state.merchantsBean.merchants_address,
                    contact_name: this.state.merchantsBean.contact_name,
                    contact_mobile: this.state.merchantsBean.contact_mobile,
                    merchants_state:  this.state.merchantsBean.merchants_state,
                    role_id: "2",
                    merchants_type: this.state.merchantsBean.merchants_type,
                    express_free_price: this.state.merchantsBean.express_free_price,
                    merchants_img: this.state.merchantsBean.merchants_img,
                    apply_state: '1',
                    is_hot:this.state.merchantsBean.is_hot,
                    is_dynamic:this.state.merchantsBean.is_dynamic,
                    bidding_price:this.state.merchantsBean.bidding_price,
                    job_start_time:this.state.merchantsBean.job_start_time,
                    job_end_time:this.state.merchantsBean.job_end_time,
                    // hy add
                    brandIds:this.state.merchantsBean.brandIds,
                    merchants_province:this.state.merchantsBean.merchants_province,
                    merchants_city:this.state.merchantsBean.merchants_city,
                    merchants_area:this.state.merchantsBean.merchants_area
                });
        } else {
            this.getDataByPost(2, homeurl + "merchantsController.api?updateMerchantDetail",
                {
                    merchants_id: this.state.merchantsBean.merchants_id,
                    merchants_name: this.state.merchantsBean.merchants_name,
                    merchants_address: this.state.merchantsBean.merchants_address,
                    contact_name: this.state.merchantsBean.contact_name,
                    contact_mobile: this.state.merchantsBean.contact_mobile,
                    merchants_state: this.state.merchantsBean.merchants_state,
                    role_id: "2",
                    merchants_type: this.state.merchantsBean.merchants_type,
                    express_free_price: this.state.merchantsBean.express_free_price,
                    merchants_img: this.state.merchantsBean.merchants_img,
                    apply_state: '1',
                    is_hot:this.state.merchantsBean.is_hot,
                    is_dynamic:this.state.merchantsBean.is_dynamic,
                    bidding_price:this.state.merchantsBean.bidding_price,
                    job_start_time:this.state.merchantsBean.job_start_time,
                    job_end_time:this.state.merchantsBean.job_end_time,
                    // hy add
                    brandIds:this.state.merchantsBean.brandIds,
                    merchants_province:this.state.merchantsBean.merchants_province,
                    merchants_city:this.state.merchantsBean.merchants_city,
                    merchants_area:this.state.merchantsBean.merchants_area
                });
        }
    }

    // 获取初始分页品牌、指定客户的品牌
    getAllBrand(){
        this.getDataByPost(11,homeurl+"goodsController.api?getAllBrandByMerchantsId",{merchants_id:this.state.merchants_id})
        this.getDataByPost(10,homeurl+"goodsController.api?getAllBrandsPage",{page:1,limit:10}, {type:2})
    }

    // 根据分页获取品牌
    getBrandByPage(page){
        this.getDataByPost(10,homeurl+"goodsController.api?getAllBrandsPage",{page:page,limit:10},{type:2})
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
            case 3:
                toast.show("操作成功");
                this.state.merchantsBean.apply_state = this.state.click_index === 0 ? "1" : "2";
                this.setState({
                    merchantsBean: this.state.merchantsBean
                });
                break;
            case 4:
                console.log('加载数据！！')
                this.setState({
                    merchantsBean: data
                });
                break;
            case 5:
                this.setState({
                    detailBean:JSON.parse(data)
                })
                break;
            case 6:
                this.setState({
                    merchantsDescImgBeans:data
                })
                break;
            case 7:
                this.showTip("添加成功");
                this.setState({
                    merchants_img:"",
                    merchants_url:""
                })
                this.getMerchantsDescImgs();
                break;
            case 8:
                this.showTip("修改成功");
                break;
            case 9:
                this.showTip("删除成功");
                this.getMerchantsDescImgs();
                break;
            case 10:
                // 分页的全部品牌数据
                this.setState({
                    brandBeans:data['data'],
                    brandTotal:data['total']
                })
                break;
            case 11:
                // 指定客户的品牌
                this.setState({
                    brandBeansHad:data
                })
                console.log(this.state.brandBeansHad)
                break;
        }
    }

    insertMerchantsDescImg(){
        this.getDataByPost(7, homeurl + "merchantsController.api?insertMerchantsDescImg",
            {merchants_id: this.state.merchantsBean.merchants_id,merchants_img:this.state.merchants_img,
                merchants_url:this.state.merchants_url});
    }
    updateMerchantsDescImg(){
        this.getDataByPost(8, homeurl + "merchantsController.api?updateMerchantsDescImg",
            {merchants_img_id: this.state.merchantsDescImgBeans[this.state.button_index].merchants_img_id,
                merchants_img:this.state.merchantsDescImgBeans[this.state.button_index].merchants_img,
                merchants_url:this.state.merchantsDescImgBeans[this.state.button_index].merchants_url});
    }

    deleteMerchantsDescImg(){
        this.getDataByPost(9, homeurl + "merchantsController.api?deleteMerchantsDescImg",
            {merchants_img_id: this.state.merchantsDescImgBeans[this.state.button_index].merchants_img_id});
    }
    auditingApplyMerchants() {
        this.getDataByPost(3, homeurl + "merchantsController.api?auditingApplyMerchants",
            {merchants_id: this.state.merchantsBean.merchants_id,
                apply_state: this.state.click_index === 0 ? "1" : "2",
                refuse_remark: this.state.click_index === 0 ? "" : this.state.merchantsBean.refuse_remark
            });
    }


    render() {
        let view=[];
        //if(this.state.merchantsBean.merchants_id){
        view=this.renderData();
        //}
        return (
            <div >
                {view}
            </div>
        )
    }

    renderData() {
        return (
            <div>
                <Widget.TipImg visible={this.state.imgVisible}
                               src={this.state.img}
                               onClose={()=>{
                                   this.setState({
                                       imgVisible:false
                                   })
                               }}></Widget.TipImg>
                <Widget.Tip visible={this.state.visible} msg={this.state.click_index===0?"确认通过?":"确认拒绝?"}
                            onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                            }}
                            onPress={()=>{
                                this.setState({
                                    visible:false
                                })
                                this.auditingApplyMerchants();
                            }}></Widget.Tip>
                <Widget.Button
                    value="保存"
                    width={100}
                    marginTop={20}
                    marginLeft={100}
                    onClick={()=>{
                        this.insertMerchants();
                    }}/>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor
                        title="供应商名称"
                        value={this.state.merchantsBean.merchants_name}
                        onChange={(value)=>{
                            this.state.merchantsBean.merchants_name=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                    <Widget.Img
                        marginTop={20}
                        title="图片展示"
                        src={this.isNull(this.state.merchantsBean.merchants_img)?"./images/add.jpg":imgurl+this.state.merchantsBean.merchants_img}
                        url={homeurl+'merchantsController.api?uploadMerchantsImg'}
                        onSuccess={(data)=>{
                            this.state.merchantsBean.merchants_img=data;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                </div>
                <div style={{marginLeft:100,marginTop:20,display:'flex',alignItems:'center',flexWrap:'wrap'}}>
                    <Widget.CheckV2
                        title="是否动态店铺"
                        visible={this.state.detailBean.is_dynamic}
                        checked={this.state.merchantsBean.is_dynamic}
                        onClick={(value)=>{
                            this.state.merchantsBean.is_dynamic=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean
                            });
                        }}/>
                    <Widget.CheckV2
                        title="是否热门店铺"
                        visible={this.state.detailBean.is_hot}
                        checked={this.state.merchantsBean.is_hot}
                        onClick={(value)=>{
                            this.state.merchantsBean.is_hot=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean
                            });
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor
                        title="客服开始时间"
                        value={this.state.merchantsBean.job_start_time}
                        onChange={(value)=>{
                            this.state.merchantsBean.job_start_time=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                    <Widget.Editor
                        title="客服结束时间"
                        value={this.state.merchantsBean.job_end_time}
                        onChange={(value)=>{
                            this.state.merchantsBean.job_end_time=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor
                        title="竞价价格"
                        value={this.state.merchantsBean.bidding_price}
                        onChange={(value)=>{
                            this.state.merchantsBean.bidding_price=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                    <Widget.Editor
                        title="满多少免邮"
                        value={this.state.merchantsBean.express_free_price}
                        onChange={(value)=>{
                            this.state.merchantsBean.express_free_price=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean,
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Text
                        title="申请状态"
                        value={this.state.merchantsBean.apply_state==='0'?"待审核":
                            (this.state.merchantsBean.apply_state==='1'?"已通过":"已拒绝")}/>
                    <Widget.Button
                        visible={this.state.merchantsBean.apply_state==='0'?"true":"false"}
                        value="接受"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                click_index:0,
                                visible:true,
                            })
                        }}/>
                    <Widget.Button
                        visible={this.state.merchantsBean.apply_state==='0'?"true":"false"}
                        value="拒绝"
                        marginLeft={10}
                        onClick={()=>{
                            this.setState({
                                click_index:1,
                                visible:true,
                            });
                        }}/>
                    <Widget.Text
                        visible={this.state.merchantsBean.apply_state==='2'?"true":"false"}
                        title="拒绝原因"
                        marginLeft={10}
                        value={this.state.merchantsBean.refuse_remark}/>

                    <Widget.Editor
                        visible={this.state.merchantsBean.apply_state==='0'?"true":"false"}
                        title="拒绝原因"
                        marginLeft={10}
                        value={this.state.merchantsBean.refuse_remark}
                        onChange={(value)=>{
                            this.state.merchantsBean.refuse_remark=value;
                            this.setState({
                                merchantsBean:this.state.merchantsBean
                            })
                        }}
                    />
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Select
                        dataSource={this.state.provinceBeans}
                        title="所在区域"
                        init_value={this.state.merchantsBean.merchants_province}
                        select_value="name"
                        show_value="name"
                        onChange={(rowID)=>{
                            province_index=rowID
                        }}/>
                    <Widget.Editor title="具体地址"
                                   value={this.state.merchantsBean.merchants_address}
                                   onChange={(value)=>{
                                       this.state.merchantsBean.merchants_address=value;
                                       this.setState({
                                           merchantsBean:this.state.merchantsBean,
                                       })
                                   }}>/</Widget.Editor>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor title="联系人"
                                   value={this.state.merchantsBean.contact_name}
                                   onChange={(value)=>{
                                       this.state.merchantsBean.contact_name=value;
                                       this.setState({
                                           merchantsBean:this.state.merchantsBean,
                                       })
                                   }}/>
                    <Widget.Editor title="联系电话"
                                   value={this.state.merchantsBean.contact_mobile}
                                   onChange={(value)=>{
                                       this.state.merchantsBean.contact_mobile=value;
                                       this.setState({
                                           merchantsBean:this.state.merchantsBean,
                                       })
                                   }}/>
                </div>
                <Widget.SelectV2
                    marginTop={20}
                    dataSource={this.state.stateBeans}
                    title="上货状态"
                    init_value={this.state.merchantsBean.merchants_state}
                    select_value="state_id"
                    show_value="name"
                    onChange={(rowID)=>{
                        this.state.merchantsBean.merchants_state=this.state.stateBeans[rowID].state_id;
                        this.setState({
                            merchantsBean:this.state.merchantsBean
                        })
                    }}/>
                {this.renderLabel()}
                {this.renderLabelPicture()}
                {this.renderDescPicture()}
                {this.renderBrand()}
            </div>)
    }

    renderLabel(){
        return(
            <div>
                <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                    <p1 style={{fontSize:13}}>商品类型</p1>
                </div>
                <Widget.ListView
                    style={{display:'flex',flexDirection:'row',marginLeft:100}}
                    dataSource={this.state.merchantsBean.merchantsLabelBeans}
                    renderRow={(rowID)=>{
                        return(
                            <div style={{display:'flex',width:100,height:30,marginLeft:20,background:'#000000',alignItems:'center',justifyContent:'center'}}>
                                <p1 style={{fontSize:13,color:'#ffffff'}}>{this.state.merchantsBean.merchantsLabelBeans[rowID].label_name}</p1>
                            </div>
                        )
                    }}/>
            </div>
        )
    }

    renderLabelPicture(){
        return(
            <div>
                <div style={{width:100,display:'flex',justifyContent:'flex-end',}}>
                    <p1 style={{fontSize:13}}>商品证照</p1>
                </div>
                <Widget.ListView
                    style={{display:'flex',flexDirection:'row',marginLeft:100}}
                    dataSource={this.state.merchantsBean.merchantsImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <img src={imgurl+this.state.merchantsBean.merchantsImgBeans[rowID].merchants_img}
                                 style={{width:40,height:100,marginLeft:20}}
                                 onClick={()=>{
                                     this.setState({
                                         imgVisible:true,
                                         img:imgurl+this.state.merchantsBean.merchantsImgBeans[rowID].merchants_img
                                     })
                                 }}/>
                        )
                    }}/>
            </div>
        )
    }

    renderDescPicture(){
        return(
            <div>
                <div style={{display:'flex',alignItems:"center",marginTop:20}}>
                    <Widget.Img
                        marginTop={20}
                        title="图片(1220*420)"
                        src={this.state.merchants_img===''?"./images/add.jpg":imgurl+this.state.merchants_img}
                        url={homeurl+'bannerController.api?uploadBannerImg'}
                        onSuccess={(data)=>{
                            this.setState({
                                merchants_img:data
                            })
                        }}/>

                    <Widget.EditorComponent
                        placeholder="链接"
                        value={this.state.merchants_url}
                        onChange={(value)=>{
                            this.setState({
                                merchants_url:value
                            })
                        }}/>
                    <Widget.Button
                        marginLeft={20}
                        value="添加"
                        onClick={()=>{
                            if(this.isNull(this.state.merchantsBean.merchants_id)){
                                this.showTip("请先保存店铺");
                                return;
                            }
                            this.insertMerchantsDescImg();
                        }}/>
                </div>
                <Widget.Tip
                    visible={this.state.visible}
                    msg={this.state.click_index===1?"确认修改":"确实删除"}
                    onClose={()=>{
                        this.setState({
                            visible:false
                        })
                    }}
                    onPress={()=>{
                        this.setState({
                            visible:false
                        })
                        if(this.state.click_index===1){
                            this.updateMerchantsDescImg();
                        }else{
                            this.deleteMerchantsDescImg();
                        }
                    }}/>
                <Widget.ListView
                    style={{display:'flex',flexDirection:'column'}}
                    dataSource={this.state.merchantsDescImgBeans}
                    renderRow={(rowID)=>{
                        return(
                            <div style={{display:'flex',alignItems:"center",marginTop:20}}>
                                <Widget.Img
                                    marginTop={20}
                                    title="图片"
                                    src={this.state.merchantsDescImgBeans[rowID].merchants_img===''?"./images/add.jpg":imgurl+this.state.merchantsDescImgBeans[rowID].merchants_img}
                                    url={homeurl+'bannerController.api?uploadBannerImg'}
                                    onSuccess={(data)=>{
                                        this.state.merchantsDescImgBeans[rowID].merchants_img=data;
                                        this.setState({
                                            merchantsDescImgBeans:this.state.merchantsDescImgBeans
                                        })
                                    }}/>
                                <Widget.EditorComponent
                                    placeholder="链接"
                                    value={this.state.merchantsDescImgBeans[rowID].merchants_url}
                                    onChange={(value)=>{
                                        this.state.merchantsDescImgBeans[rowID].merchants_url=value;
                                        this.setState({
                                            merchantsDescImgBeans:this.state.merchantsDescImgBeans
                                        })
                                    }}/>
                                <Widget.Button
                                    marginLeft={20}
                                    value="修改"
                                    onClick={()=>{
                                        this.setState({
                                            button_index:rowID,
                                            click_index:1,
                                            visible:true,
                                        })
                                    }}/>
                                <Widget.Button
                                    marginLeft={20}
                                    value="删除"
                                    onClick={()=>{
                                        this.setState({
                                            button_index:rowID,
                                            click_index:2,
                                            visible:true,
                                        })
                                    }}/>
                            </div>
                        )
                    }}/>
            </div>
        )
    }

    // 品牌组件、库存位置组件渲染
    renderBrand(){
        console.log(this.state.merchantsBean.merchants_province)
        return(
            <div>
                <Widget.CheckList
                    checklist_id = 'lista1'
                    title="品牌"
                    sectitle="已选择品牌："
                    flex="2"
                    dataSource={this.state.brandBeans}
                    dataSourceHad={this.state.brandBeansHad}
                    save_value="brand_id"
                    show_value="brand_name"
                    total={this.state.brandTotal}
                    page={this.state.brandPage}
                    onPage={(page)=>{
                        this.setState({
                            brandPage:page
                        });
                        this.getBrandByPage(page)
                    }}
                    onSelectChange={(value)=>{
                        this.state.merchantsBean.brandIds=value;
                        this.setState({
                            merchantsBean:this.state.merchantsBean,
                        })
                    }}/>
                <Widget.Address
                    title="库存位置："
                    province={this.state.merchantsBean.merchants_province}
                    city={this.state.merchantsBean.merchants_city}
                    area={this.state.merchantsBean.merchants_area}
                    onSelectChange={(pro,city,area)=>{
                        this.state.merchantsBean.merchants_province=pro;
                        this.state.merchantsBean.merchants_city=city;
                        this.state.merchantsBean.merchants_area=area;
                        this.setState({
                            merchantsBean:this.state.merchantsBean,
                        })
                    }}/>
            </div>
        )
    }










}

var styles = {
    div: {
        marginLeft: 10,
        height: 40,
        display: 'flex',
        alignItems: 'center'
    },
    div1: {
        display: 'flex',
        width: 150,
        alignItems: 'center',
        justifyContent: 'flex-end'
    },
    input: {
        width: 300,
        marginLeft: 20,
        borderRadius: 10,
        height: 25
    }, button: {
        paddingLeft: 20,
        paddingRight: 20,
        height: 30,
        alignItems: 'center',
        justifyContent: 'center',
        display: 'flex',
        background: 'blue'
    },
    buttonFont: {
        fontSize: 15,
        color: '#ffffff'
    },
    tab: {
        display: 'flex',
        height: 50,
        alignItems: 'center',
    },
    tabTitle: {
        width: 100,
        display: 'flex',
        justifyContent: 'flex-end',
    },
    input: {
        width: 200,
        marginLeft: 10,
        height: 30,
        paddingLeft: 10
    },
    font: {
        fontSize: 15,
    },
    button: {
        paddingLeft: 20,
        paddingRight: 20,
        height: 30,
        alignItems: 'center',
        justifyContent: 'center',
        display: 'flex',
        background: 'blue'
    },
    buttonFont: {
        fontSize: 15,
        color: '#ffffff'
    },
}

module.exports = MerchantsEditorComponent;


