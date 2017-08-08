/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class OrderLogisticsComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            baseData: [],
            logisticsBeans: [],
            page: 1,
            total: 0,
            logistics_index:-1,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'logistics_id'},
                {name:"物流名称",flex:1,key:'logistics_name'},
                {name:"物流简写",flex:1,key:"logistics_pinyin"},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getOrderLogistics(this.state.page)
    }

    getOrderLogistics(page) {
        this.getDataByPost(2, homeurl + "orderController.api?getOrderLogistics"
            , {page: page}, {type: 2});
    }

    deleteOrderLogistics(){
        this.getDataByPost(3, homeurl + "orderController.api?deleteOrderLogistics"
            , {logistics_id: this.state.logisticsBeans[this.state.logistics_index].logistics_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 2:
                this.setState({
                    logisticsBeans: data.data,
                    total: data.total,
                })
                break;
            case 3:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                })
                this.getOrderLogistics(1);
                break;
        }
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title="物流公司" history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/order_logistics_editor/"+
                            encodeURIComponent(JSON.stringify({})));
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
                                 this.deleteOrderLogistics();
                              }}/>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.logisticsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/order_logistics_editor/"+encodeURIComponent(JSON.stringify(this.state.logisticsBeans[rowID])));
                            break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    logistics_index:rowID
                                })
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getOrderLogistics(page)
                    }}/>
            </div>
        )
    }
}

module.exports = OrderLogisticsComponent;