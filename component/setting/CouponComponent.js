/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class CouponComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            baseData: [],
            couponBeans: [],
            page: 1,
            total: 0,
            coupon_index:-1,
            editorVisible:false,
            countBean:{}
        };
    }

    componentDidMount() {
        this.getDataByPost(1, homeurl + "systemController.api?getSystemListShows", {list_type: 'coupon'});
        this.getCoupons(this.state.page);
        this.getDataByPost(5, homeurl + "couponController.api?getCouponCount", {});
    }

    getCoupons(page) {
        this.getDataByPost(2, homeurl + "couponController.api?getCoupons",{page: page}, {type: 2});
    }

    deleteCoupon(){
        this.getDataByPost(3, homeurl + "couponController.api?deleteCoupon"
            ,{coupon_id: this.state.couponBeans[this.state.coupon_index].coupon_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    baseData: data,
                })
                break;
            case 2:
                this.setState({
                    couponBeans: data.data,
                    total: data.total,
                })
                break;
            case 3:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                })
                this.getCoupons(1);
                break;
            case 4:
                this.showTip("分配成功");
                this.setState({
                    page:1,
                    mobile:"",
                })
                this.getCoupons(1);
                break;
            case 5:
                this.setState({
                    countBean:data,
                })
                break;
            case 6:
                this.showTip("分配成功");
                break;
        }
    }

    allocationCoupon(){
        if(this.isNull(this.state.mobile)){
            this.showTip("请填写手机号");
            return;
        }
        this.getDataByPost(4, homeurl + "couponController.api?allocationCoupon"
            ,{coupon_id: this.state.couponBeans[this.state.coupon_index].coupon_id,
                mobile:this.state.mobile});
    }

    allocationAllCoupon(){
        this.getDataByPost(6, homeurl + "couponController.api?allocationAllCoupon"
            ,{coupon_id: this.state.couponBeans[this.state.coupon_index].coupon_id});
    }
    render() {
        return (
            <div>
                <Widget.Toolbar title="优惠卷" history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/setting_coupon_editor/"+encodeURIComponent(JSON.stringify({})));
                        }}/>
                </div>
                <Widget.TipEditor
                    visible={this.state.editorVisible}
                    value={this.state.mobile}
                    onClose={()=>{
                        this.setState({
                            editorVisible:false
                        })
                    }}
                    onChange={(value)=>{
                        this.setState({
                            mobile:value
                        })
                    }}
                    onPress={()=>{
                        this.setState({
                            editorVisible:false
                        })
                        this.allocationCoupon();
                    }}/>
                <Widget.Tip visible={this.state.visible} msg="确定删除?"
                            onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                            }}
                            onPress={()=>{
                                 this.setState({
                                        visible:false
                                 })
                                 this.deleteCoupon();
                            }}/>
                <Widget.Tip visible={this.state.allVisible} msg="确定分配?"
                            onClose={()=>{
                                this.setState({
                                    allVisible:false
                                })
                            }}
                            onPress={()=>{
                                this.setState({
                                    allVisible:false
                                })
                                this.allocationAllCoupon();
                            }}/>

                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Text
                        title="领取数量"
                        value={this.state.countBean.receive_count?this.state.countBean.receive_count:0}/>
                    <Widget.Text
                        title="发放数量"
                        value={this.state.countBean.allocation_count?this.state.countBean.allocation_count:0}/>
                </div>

                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.couponBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2},{title:"分配",type:3},{title:"分配所有用户",type:3}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/setting_coupon_editor/"+
                                        encodeURIComponent(JSON.stringify(this.state.couponBeans[rowID])));
                                break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    coupon_index:rowID
                                })
                                break;
                            case 2:
                                this.setState({
                                    editorVisible:true,
                                    coupon_index:rowID
                                })
                                break;
                            case 3:
                                this.setState({
                                    allVisible:true,
                                    coupon_index:rowID
                                })
                                break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getCoupons(page)
                    }}/>
            </div>
        )
    }
}

module.exports = CouponComponent;