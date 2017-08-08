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
            albumBeans:[],
            page:1,
            total:0,
            album_index:-1,
        };
    }

    componentDidMount() {
        this.getAlbums(this.state.page);
    }

    getAlbums(page){
        this.getDataByPost(1,homeurl+"swController.api?getAlbums",
            {page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    albumBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                this.showTip("删除成功");
                this.getAlbums(this.state.page);
                break;
        }
    }

    deleteTag(){
        this.getDataByPost(2,homeurl+"swController.api?deleteAlbum",
            {album_id:this.state.albumBeans[this.state.album_index].album_id});
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
                                 this.deleteTag();
                              }}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/sw_album_editor/"+encodeURIComponent(JSON.stringify({})));
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={[{name:"ID",flex:1,key:'album_id'},
                            {name:"名称",flex:1,key:'ablum_name'},
                            {name:"描述",flex:1,key:'ablum_desc'},
                            {name:"图标",flex:1,key:'ablum_img',type:'img'},
                            {name:"权重",flex:1,key:'sort'},
                            {name:"创建时间",flex:1,key:'create_time'},
                            {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.albumBeans}
                    page={this.state.page}
                    total={this.state.total}
                    operationData={[{title:"编辑",type:1},{title:"专辑商品",type:2},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                            switch (index){
                                case 0:
                                    this.props.history.push("/sw_album_editor/"+encodeURIComponent(JSON.stringify(this.state.albumBeans[rowID])));
                                break;
                                case 1:
                                    this.props.history.push("/sw_album_goods/"+this.state.albumBeans[rowID].album_id);
                                break;
                                case 2:
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
                            this.getAlbums(page)
                        }}/>
            </div>
        )

    }
}

module.exports=FoundGoodAlbum;