/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');
var list_type_index=-1;

/**
 * 商品分类(2.0版本)
 */
class ListShowComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            detailShowBeans: [],
            page: 1,
            total: 0,
            list_index:-1,
            listTypeBeans:[],
            type_value:Widget.storage.get("detail_type_value")
        };
    }

    componentDidMount() {
        this.getGoodsClass(this.state.page,this.state.type_value);
        this.getSystemListTypesNoPage();
    }

    getSystemListTypesNoPage(){
        this.getDataByPost(2, homeurl + "systemController.api?getSystemListTypesNoPage",
            {type_type:"detail"});
    }

    getGoodsClass(page,detail_type) {
        this.getDataByPost(1, homeurl + "systemController.api?getSystemDetailShowsPage",
            {page:page,detail_type:detail_type},{type:2});
    }

    deleteListShow(){
        this.getDataByPost(3, homeurl + "systemController.api?deleteSystemDetailShow"
            , {detail_id: this.state.detailShowBeans[this.state.list_index].detail_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    detailShowBeans:data.data,
                    total:data.total
                });
                break;
            case 2:
                this.setState({
                    listTypeBeans:data
                })
                break;
            case 3:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                })
                this.getGoodsClass(1,this.state.type_value);
                break;
        }
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title={"列表展示"} history={this.props.history}/>
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
                                 this.deleteListShow();
                              }}/>
                <div style={{display:'flex',marginTop:20,alignItems:'center'}}>
                    <Widget.SelectV2
                        dataSource={this.state.listTypeBeans}
                        title="位置"
                        init_value={this.state.type_value}
                        select_value="type_value"
                        show_value="type_name"
                        onChange={(rowID)=>{
                            this.setState({
                                type_value:this.state.listTypeBeans[rowID].type_value
                            })
                        }}/>
                    <Widget.Button
                        marginLeft={20}
                        value="搜索"
                        onClick={()=>{
                            Widget.storage.set("detail_type_value",this.state.type_value);
                            this.setState({
                                page:1,
                            })
                            this.getGoodsClass(1,this.state.type_value);
                        }}/>
                </div>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/system_detail_show_editor/"+encodeURIComponent(JSON.stringify({detail_type:this.state.type_value})));
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={[
                            {name:"ID",flex:1,key:'detail_id'},
                            {name:"名称",flex:1,key:'name'},
                            {name:"是否可见",flex:1,key:"is_visible"},
                            {name:"类型",flex:1,key:"type_name"},
                            {name:"操作",flex:2,key:"-1"}
                        ]}
                    dataSource={this.state.detailShowBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/system_detail_show_editor/"+
                                encodeURIComponent(JSON.stringify(this.state.detailShowBeans[rowID])));
                            break
                            case 1:
                                this.setState({
                                    visible:true,
                                    list_index:rowID
                                })
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getGoodsClass(page,this.state.type_value)
                    }}/>
            </div>
        )
    }
}

module.exports = ListShowComponent;