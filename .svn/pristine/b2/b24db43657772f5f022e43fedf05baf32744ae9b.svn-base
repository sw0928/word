/**
 * Created by shenjiabo on 17/2/4.
 * 发现好货---专辑列表
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class FoundGoodExact extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            goodsBeans:[],
            page:1,
            total:0,
            album_index:-1,
            allGoodsBeans:[],
            selectBean:{},
            goods_name:"",
        };
    }

    componentDidMount() {
        this.getExactGoodss(this.state.page);
    }

    getExactGoodss(page){
        this.getDataByPost(1,homeurl+"swController.api?getExactGoodss",
            {album_id:this.props.params.album_id,page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    goodsBeans:data.data,
                    total:data.total
                })
                break;
        }
    }

    render(){
        return(
            <div>
                <Widget.Toolbar title="好货精选" history={this.props.history}/>
                <Widget.ListViewComponent
                    data={[{name:"ID",flex:1,key:'goods_id'},
                            {name:"商品名",flex:1,key:'goods_name'},
                            {name:"图标",flex:1,key:'goods_img',type:'img'},
                            {name:"原价",flex:1,key:'goods_origin_price'},
                            {name:"现价",flex:1,key:'goods_now_price'},
                            {name:"pc价",flex:1,key:'goods_pc_price'},
                            {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.goodsBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1}]}
                    operationClick={(rowID,index)=>{
                            switch (index){
                                case 0:
                                    this.props.history.push("/goods_editor/"+encodeURIComponent(JSON.stringify(this.state.goodsBeans[rowID])));
                                break;
                                case 1:
                                    this.setState({
                                        visible:true,
                                        album_index:rowID
                                    });
                                break;
                            }
                    }}
                    onPage={(page)=>{
                            this.setState({
                                page:page
                            });
                            this.getExactGoodss(page)
                    }}/>
            </div>
        )

    }
}

module.exports=FoundGoodExact;