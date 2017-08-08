/**
 * Created by shenjiabo on 17/1/11.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');


class GoodsTagComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            parent_id: this.props.parent_id?this.props.parent_id:this.props.params.parent_id,
            level:this.props.level?this.props.level:this.props.params.level,
            tagBeans:[],
            page:1,
            total:0,
            tag_index:-1,
        };
    }

    componentDidMount() {
        this.getGoodsTags(this.state.page);
    }

    getGoodsTags(page){
        this.getDataByPost(1,homeurl+"goodsController2.api?getGoodsTags",
            {parent_id:this.state.parent_id,page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    tagBeans:data.data,
                    total:data.total
                })
                break;
            case 2:
                this.showTip("删除成功");
                this.getGoodsTags(this.state.page);
                break;
        }
    }

    deleteTag(){
        this.getDataByPost(2,homeurl+"goodsController2.api?deleteGoodsTag",
            {tag_id:this.state.tagBeans[this.state.tag_index].tag_id});
    }
    render(){
        return(
                <div>
                    <Widget.Toolbar title={this.state.level+"级分类"} history={this.props.history}/>
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
                            this.props.history.push("/goods_tag_editor/"+encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id})));
                        }}/>
                    </div>
                    <Widget.ListViewComponent
                        data={[{name:"ID",flex:1,key:'tag_id'},
                            {name:"名称",flex:1,key:'tag_name'},
                            {name:"权重",flex:1,key:'sort'},
                            {name:"创建时间",flex:1,key:'create_time'},
                            {name:"操作",flex:1,key:"-1"}]}
                        dataSource={this.state.tagBeans}
                        page={this.state.page}
                        total={this.state.total}
                        operationData={[{title:"子分类",type:0},{title:"编辑",type:1},{title:"删除",type:2}]}
                        operationClick={(rowID,index)=>{
                            switch (index){
                                case 0:
                                    if(parseInt(this.state.level%2)){
                                        this.props.history.push("/goods_tag2/"+this.state.tagBeans[rowID].tag_id+"/"+(parseInt(this.state.level)+1));
                                    }else{
                                        this.props.history.push("/goods_tag/"+this.state.tagBeans[rowID].tag_id+"/"+(parseInt(this.state.level)+1));
                                    }
                                    break
                                case 1:
                                    this.props.history.push("/goods_tag_editor/"+encodeURIComponent(JSON.stringify(this.state.tagBeans[rowID])));
                                break;
                                case 2:
                                    this.setState({
                                        visible:true,
                                        tag_index:rowID
                                    })
                                break;
                            }
                        }}
                        onPage={(page)=>{
                            this.setState({
                                page:page
                            });
                            this.getGoodsTags(page)
                        }}/>
                </div>
            )

    }
}

module.exports=GoodsTagComponent;