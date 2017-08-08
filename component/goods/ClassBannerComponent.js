/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class ClassBannerComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            classBannerBeans:[],
            goods_id:this.props.params.goods_id
        };
    }

    componentDidMount() {
        this.getClassBanners();
    }

    getClassBanners(){
        this.getDataByPost(1, homeurl + "swController.api?getClassBanners",{class_id:this.state.goods_id});
    }
    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    classBannerBeans: data,
                })
                break;
            case 2:
                this.showTip("删除成功");
                this.getClassBanners();
                break;
        }
    }

    deleteClassBanner(){
        this.getDataByPost(2, homeurl + "swController.api?deleteClassBanner",
            {banner_id:this.state.classBannerBeans[this.state.class_index].banner_id});
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title="分类广告" history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/class_banner_editor/"+encodeURIComponent(JSON.stringify({class_id:this.state.goods_id})));
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
                                this.deleteClassBanner();
                            }}/>
                <Widget.ListViewComponent
                    data={[
                                {name:"ID",flex:1,key:'banner_id'},
                                {name:"图标",flex:1,key:'banner_img',type:'img'},
                                {name:"链接",flex:1,key:"banner_url"},
                                {name:"权重",flex:1,key:"sort"},
                                {name:"操作",flex:2,key:"-1"}
                            ]}
                    dataSource={this.state.classBannerBeans}
                    operationData={[{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/class_banner_editor/"+encodeURIComponent(JSON.stringify(this.state.classBannerBeans[rowID])));
                                break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    class_index:rowID
                                })
                                break;
                        }
                    }}/>
            </div>
        )
    }
}

module.exports = ClassBannerComponent;