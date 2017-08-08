/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class GoodsClassComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            parent_id: this.props.parent_id?this.props.parent_id:this.props.params.parent_id,
            level:this.props.level?this.props.level:this.props.params.level,
            baseData: [],
            goodsClassBeans: [],
            page: 1,
            total: 0,
            class_index:-1,
        };
    }

    componentDidMount() {
        this.getDataByPost(1, homeurl + "systemController.api?getSystemListShows", {list_type: 'goods_class'});
        this.getGoodsClass(this.state.page)
    }

    getGoodsClass(page) {
        this.getDataByPost(2, homeurl + "goodsController2.api?getGoodsClasss",{parent_id: this.state.parent_id, page: page}, {type: 2});
    }

    deleteGoodsClass(){
        this.getDataByPost(3, homeurl + "goodsController2.api?deleteGoodsClass"
            , {class_id: this.state.goodsClassBeans[this.state.class_index].class_id});
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
                    goodsClassBeans: data.data,
                    total: data.total,
                })
                break;
            case 3:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                });
                this.getGoodsClass(1);
                break;
        }
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title={this.state.level+"级分类"} history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/goods_class2_editor/"+
                            encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id})));
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
                                 this.deleteGoodsClass();
                              }}/>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.goodsClassBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"子分类",type:0},{title:"编辑",type:1},{title:"删除",type:2},{title:"商品列表",type:1}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                if(parseInt(this.state.level%2)){
                                    this.props.history.push("/goods_class3/"+this.state.goodsClassBeans[rowID].class_id+"/"+(parseInt(this.state.level)+1));
                                }else{
                                    this.props.history.push("/goods_class2/"+this.state.goodsClassBeans[rowID].class_id+"/"+(parseInt(this.state.level)+1));
                                }
                                break
                            case 1:
                                this.props.history.push("/goods_class2_editor/"+encodeURIComponent(JSON.stringify(this.state.goodsClassBeans[rowID])));
                                break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    class_index:rowID
                                })
                                break;
                            case 3:
                                this.props.history.push("/class_goods/"+this.state.goodsClassBeans[rowID].class_id);
                                break;
                                case 2:
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
                        this.getGoodsClass(page)
                    }}/>
            </div>
        )
    }
}

module.exports = GoodsClassComponent;