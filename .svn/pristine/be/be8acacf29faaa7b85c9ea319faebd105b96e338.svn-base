/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');


class GoodsClassEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            classBannerBean: JSON.parse(decodeURIComponent(this.props.params.classBannerBean))
        }
    }

    componentDidMount() {

    }

    insertClass() {
        var params={};
        params["class_id"]=this.state.classBannerBean.class_id;
        params["banner_url"]=this.state.classBannerBean.banner_url;
        params["banner_img"]=this.state.classBannerBean.banner_img;
        params["sort"]=this.state.classBannerBean.sort;

        if(this.isNull(this.state.classBannerBean.banner_id)){
            this.getDataByPost(1,homeurl+"swController.api?insertClassBanner",params);
        }else{
            params["banner_id"]=this.state.classBannerBean.banner_id;
            this.getDataByPost(2,homeurl+"swController.api?updateClassBanner",params);
        }
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.showTip("添加成功");
                this.props.history.goBack();
                break;
            case 2:
                this.showTip("修改成功");
                this.props.history.goBack();
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="广告编辑" history={this.props.history}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertClass();
                    }}/>
                <Widget.Img
                    marginTop={20}
                    title="图标(460*1390)"
                    src={this.isNull(this.state.classBannerBean.banner_img)?"./images/add.jpg":imgurl+this.state.classBannerBean.banner_img}
                    url={homeurl+'goodsController.api?uploadGoodsImg'}
                    onSuccess={(data)=>{
                        this.state.classBannerBean.banner_img=data;
                        this.setState({
                            classBannerBean:this.state.classBannerBean,
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="链接"
                    value={this.state.classBannerBean.banner_url}
                    onChange={(value)=>{
                        this.state.classBannerBean.banner_url=value;
                        this.setState({
                            classBannerBean:this.state.classBannerBean
                        })
                    }}/>

                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.classBannerBean.sort}
                    onChange={(value)=>{
                        this.state.classBannerBean.sort=value;
                        this.setState({
                            classBannerBean:this.state.classBannerBean
                        })
                    }}/>
            </div>
        )
    }


}

module.exports=GoodsClassEditorComponent;