/**
 * Created by shenjiabo on 16/12/10.
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class ActivityGoodsComponent extends  Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            activity_id:this.props.activity_id,
            activity_type:this.props.activity_type,

            allGoodsBeans:[],
            selectBean:{},
            goods_name:"",
            goodsBeans:[],
            page:1,
            total:0,
            baseData:[],


            goods_search_name:"",

            page:Widget.storage.get("activity_goods_page")?Widget.storage.get("activity_goods_page"):1,
            goods_id:Widget.storage.get("activity_goods_goods_id")?Widget.storage.get("activity_goods_goods_id"):"",
            goods_search_name:Widget.storage.get("activity_goods_goods_name")?Widget.storage.get("activity_goods_goods_name"):"",
            goods_sku:Widget.storage.get("activity_goods_goods_sku")?Widget.storage.get("activity_goods_goods_sku"):"",

            activity_goods_index:-1,

            goods_name:"",
            allGoodsClassBeans:[],
            selectClassBean:{},
            goods_class_name:""
        };
    }
    componentDidMount() {
        this.getGoods();
        this.getActivityGoods(this.state.page);
        this.getDataByPost(3,homeurl+"systemController.api?getSystemListShows",{list_type:'goods'});
        this.getDataByPost(7,homeurl+"goodsController.api?getAllGoodsClassNoPage",{})
    }

    getGoods(goods_name){
        this.getDataByPost(1,homeurl+"goodsController2.api?searchGoods",{goods_name:goods_name})
    }

    getActivityGoods(page){
        Widget.storage.set("activity_goods_page",page);
        Widget.storage.set("activity_goods_goods_name",this.state.goods_search_name);
        Widget.storage.set("activity_goods_goods_id",this.state.goods_id);
        Widget.storage.set("activity_goods_goods_sku",this.state.goods_sku);

        this.getDataByPost(2,homeurl+"activityController.api?getActivityGoods",
            {activity_id:this.state.activity_id,page:page,
                goods_id:this.isNull(this.state.goods_id)?"0":this.state.goods_id,goods_name:this.state.goods_search_name,
                goods_sku:this.state.goods_sku,
                goods_uuid:this.state.selectClassBean.goods_uuid},{type:2});
    }



    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    allGoodsBeans:data
                });
                break;
            case 2:
                this.setState({
                    goodsBeans:data.data,
                    total:data.total
                })
                break;
            case 3:
                this.setState({
                    baseData:data,
                })
                break;
            case 4:
                this.showTip("添加成功");
                this.setState({
                    goods_name:"",
                    selectBean:{}
                })
                this.getActivityGoods(this.state.page);
                break;
            case 6:
                this.showTip("删除成功");
                this.getActivityGoods(this.state.page);
                break;
            case 7:
                this.setState({
                    allGoodsClassBeans:data
                })
                break;
            case 8:
                this.showTip("添加成功");
                this.getActivityGoods(this.state.page);
                break;
            case 9:
                this.showTip("删除成功");
                this.setState({
                    page:1
                })
                this.getActivityGoods(1);
                break;
        }
    }

    insertGoods(){
        if(this.isNull(this.state.selectBean.goods_id)){
            this.showTip("请先选择商品");
            return;
        }

        this.getDataByPost(4,homeurl+"activityController.api?insertActivityGoods",
            {activity_id:this.state.activity_id,
                goods_id:this.state.selectBean.goods_id,
                activity_type:this.state.activity_type});
    }


    insertAllGoods(){
        if(this.isNull(this.state.selectClassBean.goods_id)){
            this.showTip("请先选择分类");
            return;
        }
        console.log(this.state.selectClassBean.goods_uuid+"===="+this.state.activity_id);
        this.getDataByPost(8,homeurl+"activityController.api?insertAllActivityGoods",
            {activity_id:this.state.activity_id,
                goods_uuid:this.state.selectClassBean.goods_uuid,
                activity_type:this.state.activity_type});
    }

    deleteGoods(){
        this.getDataByPost(5,homeurl+"activityController.api?deleteActivityGoods",
            {activity_goods_ids:this.state.activity_goods_ids});
    }

    deleteAllActivityGoods(){
        this.getDataByPost(9,homeurl+"activityController.api?deleteAllActivityGoods",
            {activity_id:this.state.activity_id,
                goods_id:this.isNull(this.state.goods_id)?"0":this.state.goods_id,
                goods_name:this.state.goods_search_name,
                goods_sku:this.state.goods_sku,
                goods_uuid:this.state.selectClassBean.goods_uuid});
    }
    render(){
        return(
            <div>
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
                                  this.deleteGoods();
                              }}/>
                <Widget.Tip visible={this.state.allVisible} msg="确定全部删除?"
                            onClose={()=>{
                                this.setState({
                                    allVisible:false
                                })
                            }}
                            onPress={()=>{
                                this.setState({
                                    allVisible:false
                                })
                                this.deleteAllActivityGoods();
                            }}/>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <div style={{width:this.props.width?this.props.width:100,display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={{fontSize:13}}>商品名</p1>
                    </div>
                    <Widget.SearchBarV2
                        marginLeft={20}
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

                    <Widget.Button
                        marginLeft={20}
                        value="添加"
                        onClick={()=>{
                            this.insertGoods();
                        }}/>

                    <p1 style={{fontSize:13,marginLeft:20,marginRight:20}}>商品分类名</p1>
                    <Widget.SearchBar
                        item_name="goods_name"
                        dataSource={this.state.allGoodsClassBeans}
                        name={this.state.goods_class_name}
                        onPress={(data,value)=>{
                            this.setState({
                                selectClassBean:data,
                                goods_class_name:value,
                            })
                        }}/>

                    <Widget.Button
                        marginLeft={20}
                        value="添加"
                        onClick={()=>{
                            this.insertAllGoods();
                        }}/>
                </div>

                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor
                        title="商品ID"
                        value={this.state.goods_id}
                        onChange={(value)=>{
                            this.setState({
                                goods_id:value
                            })
                        }}/>
                    <Widget.Editor
                        title='商品sku'
                        value={this.state.goods_sku}
                        onChange={(value)=>{
                            this.setState({
                                goods_sku:value
                            })
                        }}/>
                    <Widget.Editor
                        title="商品名"
                        value={this.state.goods_search_name}
                        onChange={(value)=>{
                            this.setState({
                                goods_search_name:value
                            })
                        }}/>
                    <Widget.Button
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            this.setState({
                                page:1,
                            });
                            this.getActivityGoods(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20,justifyContent:'flex-end'}}>
                    <Widget.Button
                        marginRight={20}
                        value="删除"
                        onClick={()=>{
                            this.setState({
                                allVisible:true
                            })
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    checked={this.state.checked}
                    onChecked={(i,checked)=>{
                        if(i===-1){
                            for(let j=0;j<this.state.goodsBeans.length;j++){
                                this.state.goodsBeans[j].is_select=checked;
                            }
                            this.setState({
                                checked:checked
                            })
                        }else{
                            this.state.goodsBeans[i].is_select=checked;
                            this.setState({
                                goodsBeans:this.state.goodsBeans,
                                checked:checked==="0"?checked:this.state.checked,
                            });
                        }
                    }}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                             case 0:
                                this.props.history.push((company_name==='hbr'?"/hbr_goods_editor/":"/goods_editor/")+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID])));
                                break;
                             case 1:
                                 this.setState({
                                    visible:true,
                                    activity_goods_ids:this.state.goodsBeans[rowID].activity_goods_id
                                })
                                break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getActivityGoods(page)
                    }}/>
            </div>
        )
    }
}

module.exports=ActivityGoodsComponent;
