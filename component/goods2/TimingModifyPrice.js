/**
 * Created by shenjiabo on 17/3/7.
 * 定时改价
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class TimingModifyPrice extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            baseData: [],
            timingBeans: [],
            page: 1,
            total: 0,
            class_index:-1,
        };
    }

    componentDidMount() {
        this.getTimingGoods(this.state.page)
    }

    getTimingGoods(page) {
        this.getDataByPost(2, homeurl + "goodsController2.api?getTimingGoodss",{parent_id: this.state.parent_id, page: page}, {type: 2});
    }

    deleteTimingGoods(){
        this.getDataByPost(3, homeurl + "goodsController2.api?deleteTimingGoods"
            , {timing_id: this.state.timingBeans[this.state.class_index].timing_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 2:
                this.setState({
                    timingBeans: data.data,
                    total: data.total,
                })
                break;
            case 3:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                });
                this.getTimingGoods(1);
                break;
        }
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title="定时记录" history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/goods_timing_modify_editor/"+
                            encodeURIComponent(JSON.stringify({})));
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="下载模板"
                        onClick={()=>{
                            window.open(imgurl+"/excel/timing.xlsx");
                        }}/>
                    <Widget.ImgButton
                        marginRight={20}
                        value="批量导入"
                        action={homeurl+"goodsController2.api?loadGoodsTimings"}
                        onSuccess={(data)=>{
                             this.showTip("操作成功");
                             this.setState({
                                page:1
                             })
                             this.getTimingGoods(1);
                        }}/>
                </div>
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
                                 this.deleteTimingGoods();
                              }}/>
                <Widget.ListViewComponent
                    data={[{name:"ID",flex:1,key:'timing_id'},
                            {name:"SKU",flex:1,key:'goods_sku'},
                            {name:"现价",flex:1,key:'goods_now_price'},
                            {name:"原价",flex:1,key:'goods_origin_price'},
                            {name:"改价",flex:1,key:'goods_new_price'},
                            {name:"状态",flex:1,key:'timing_state'},
                            {name:"备注",flex:1,key:'remark'},
                            {name:"修改时间",flex:1,key:'modify_time'},
                            {name:"添加时间",flex:1,key:'create_time'},
                            {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.timingBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.setState({
                                    visible:true,
                                    class_index:rowID
                                })
                                break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getTimingGoods(page)
                    }}/>
            </div>
        )
    }
}


module.exports=TimingModifyPrice;