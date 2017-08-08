/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var Widget=require("./../../widget/WidgetComponent");

class GoodsRecommendComponent extends  Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            goodsBeans:[],
            page:1,
            total:0,
            goods_index:0,
        };
    }

    componentDidMount() {
        this.getDataByPost(3,homeurl+"systemController.api?getSystemListShows",{list_type:'goods'});
        this.getGoods(this.state.page)
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    goodsBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                toast.show("删除成功");
                this.getGoods(this.state.page);
                break;
            case 3:
                this.setState({
                    baseData:data
                })
                break;
        }
    }

    getGoods(page){
        this.getDataByPost(1,homeurl+'goodsController.api?getAllGoodsDetail',
            {page:page,is_recommend:"1"},{type:2});
    }

    deleteGoods(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"goodsController.api?deleteGoodsDetail",
            {goods_id:this.state.goodsBeans[this.state.goods_index].goods_id})
    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Widget.Toolbar title="推荐商品" history={this.props.history}></Widget.Toolbar>
                <Widget.Tip visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteGoods();
                              }}/>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push((company_name==='hbr'?"/hbr_goods_editor/":"/goods_editor/")+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID])));
                            break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    goods_index:rowID
                                });
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getGoods(page)
                    }}/>

            </div>
        )
    }
}

module.exports=GoodsRecommendComponent;
