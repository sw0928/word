/**
 * Created by shenjiabo on 16/12/10.
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class ClassGoodsListComponent extends  Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            allGoodsBeans:[],
            selectBean:{},
            goods_name:"",
            goodsBeans:[],
            class_id:this.props.params.class_id,
            page:1,
            total:0,
            baseData:[],

            page:Widget.storage.get("class_goods_page")?Widget.storage.get("class_goods_page"):1,
            goods_id:Widget.storage.get("class_goods_goods_id")?Widget.storage.get("class_goods_goods_id"):"",
            goods_search_name:Widget.storage.get("class_goods_goods_name")?Widget.storage.get("class_goods_goods_name"):"",
            goods_sku:Widget.storage.get("class_goods_goods_sku")?Widget.storage.get("class_goods_goods_sku"):"",

            class_index:-1,
        };
    }
    componentDidMount() {
        this.getGoods();
        this.getClassGoods(this.state.page);
        this.getDataByPost(3,homeurl+"systemController.api?getSystemListShows",{list_type:'goods'});
    }

    getClassGoods(page){
        Widget.storage.set("class_goods_page",page);
        Widget.storage.set("class_goods_goods_name",this.state.goods_search_name);
        Widget.storage.set("class_goods_goods_id",this.state.goods_id);
        Widget.storage.set("class_goods_goods_sku",this.state.goods_sku);

        this.getDataByPost(2,homeurl+"goodsController2.api?getClassGoods",
            {class_id:this.state.class_id,page:page,
            goods_id:this.isNull(this.state.goods_id)?"0":this.state.goods_id,goods_name:this.state.goods_search_name,
            goods_sku:this.state.goods_sku},{type:2});
    }

    getGoods(goods_name){
        this.getDataByPost(1,homeurl+"goodsController2.api?searchGoods",{goods_name:goods_name})
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
                this.getClassGoods(this.state.page);
                this.setState({
                    selectBean:{},
                    goods_name:"",
                });
                break;
            case 5:
                this.showTip("删除成功");
                this.getClassGoods(this.state.page);
                break;
        }
    }

    insertGoods(){
        if(this.isNull(this.state.selectBean.goods_id)){
            this.showTip("请先选择商品");
            return;
        }

        this.getDataByPost(4,homeurl+"goodsController2.api?insertClassGoods",
            {class_id:this.state.class_id,
             goods_id:this.state.selectBean.goods_id,});
    }

    deleteGoods(){
        this.getDataByPost(5,homeurl+"goodsController2.api?deleteClassGoods",
            {goods_class_ids:this.state.goods_class_ids});
    }

    render(){
        return(
            <div>
                <Widget.Toolbar title={"商品列表"} history={this.props.history}/>
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
                            this.getClassGoods(1);
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center',marginTop:20,justifyContent:'flex-end'}}>
                    <Widget.Button
                        marginRight={20}
                        value="删除"
                        onClick={()=>{
                            let goods_class_ids="";
                            for(let i=0;i<this.state.goodsBeans.length;i++){
                                if(this.state.goodsBeans[i].is_select==="1"){
                                    goods_class_ids+=this.state.goodsBeans[i].goods_class_id;
                                    if(i<this.state.goodsBeans.length-1){
                                        goods_class_ids+=",";
                                    }
                                }
                            }
                            if(goods_class_ids.length<=0){
                                this.showTip("未选择任何商品");
                                return;
                            }
                            this.setState({
                                visible:true,
                                goods_class_ids:goods_class_ids
                            })
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
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
                    operationClick={(rowID,index)=>{
                        switch (index){
                             case 0:
                                this.props.history.push((company_name==='hbr'?"/hbr_goods_editor/":"/goods_editor/")+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID])));
                                break;
                             case 1:
                                 this.setState({
                                    visible:true,
                                    goods_class_ids:this.state.goodsBeans[rowID].goods_class_id
                                })
                                break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getClassGoods(page)
                    }}/>
            </div>
        )
    }
}

module.exports=ClassGoodsListComponent;
