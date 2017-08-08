/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class ListShowComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            listTypeBeans: [],
            page: 1,
            total: 0,
            type_index:-1,
        };
    }

    componentDidMount() {
        this.getSystemListTypes(this.state.page)
    }

    getSystemListTypes(page) {
        this.getDataByPost(1, homeurl + "systemController.api?getSystemListTypes", {page:page,type_type:this.props.params.type_type},{type:2});
    }

    deleteSystemListType(){
        this.getDataByPost(2, homeurl + "systemController.api?deleteSystemListType"
            , {type_id: this.state.listTypeBeans[this.state.type_index].type_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    listTypeBeans:data.data,
                    total:data.total
                });
                break;
            case 2:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                })
                this.getSystemListTypes(1);
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
                                 this.deleteSystemListType();
                              }}/>

                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/system_list_type_editor/"+
                            encodeURIComponent(JSON.stringify({type_type:this.props.params.type_type})));
                        }}/>
                </div>

                <Widget.ListViewComponent
                    data={[
                            {name:"ID",flex:1,key:'type_id'},
                            {name:"名称",flex:1,key:'type_name'},
                            {name:"值",flex:1,key:"type_value"},
                            {name:"操作",flex:2,key:"-1"}
                        ]}
                    dataSource={this.state.listTypeBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/system_list_type_editor/"+encodeURIComponent(JSON.stringify(this.state.listTypeBeans[rowID])));
                            break
                            case 1:
                                this.setState({
                                    visible:true,
                                    type_index:rowID
                                })
                            break;
                        }
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getSystemListTypes(page)
                    }}/>
            </div>
        )
    }
}

module.exports = ListShowComponent;