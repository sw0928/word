/**
 * Created by shenjiabo on 17/2/4.
 * 发现好货---专辑列表
 */

import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

class FoundGoodAlbum extends Widget.BaseComponent{
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
        this.getAlbumGoodss(this.state.page);
    }

    getGoods(goods_name){
        this.getDataByPost(3,homeurl+"goodsController2.api?searchGoods",{goods_name:goods_name})
    }

    getAlbumGoodss(page){
        this.getDataByPost(1,homeurl+"swController.api?getAlbumGoodss",
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
            case 2:
                this.showTip("删除成功");
                this.getAlbumGoodss(this.state.page);
                break;
            case 3:
                this.setState({
                    allGoodsBeans:data
                });
                break;
            case 4:
                this.showTip("添加成功");
                this.getAlbumGoodss(this.state.page);
                break;
        }
    }

    insertAlbumGoods(){
        if(this.isNull(this.state.selectBean.goods_id)){
            this.showTip("请先选择商品");
            return;
        }
        this.getDataByPost(4,homeurl+"swController.api?insertAlbumGoods",
            {album_id:this.props.params.album_id,goods_id:this.state.selectBean.goods_id});
    }
    deleteAlbumGoods(){
        this.getDataByPost(2,homeurl+"swController.api?deleteAlbumGoods",
            {album_id:this.props.params.album_id,goods_id:this.state.goodsBeans[this.state.album_index].goods_id});
    }

    render(){
        return(
            <div>
                <Widget.Toolbar title="好货专辑" history={this.props.history}/>
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
                                 this.deleteAlbumGoods();
                            }}/>
                <div style={{display:'flex',marginTop:20}}>
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
                            this.insertAlbumGoods();
                        }}/>
                </div>
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
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
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
                            this.getAlbumGoodss(page)
                    }}/>
            </div>
        )

    }
}

module.exports=FoundGoodAlbum;