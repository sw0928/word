/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var goods_state_index=-1;
var goods_recommend_index=-1;

class GoodsClassEditorComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            albumBean:JSON.parse(this.props.params.albumBean)
        };
    }
    
    insertClass() {
        if (this.isNull(this.state.albumBean.ablum_name)) {
            this.showTip("名称不可为空");
            return;
        }

        var params={};
        params["ablum_name"]=this.state.albumBean.ablum_name;
        params["ablum_desc"]=this.state.albumBean.ablum_desc;
        params["ablum_img"]=this.state.albumBean.ablum_img;
        params["sort"]=this.state.albumBean.sort;

        if(this.isNull(this.state.albumBean.album_id)){
            this.getDataByPost(1,homeurl+"swController.api?insertAlbum",params);
        }else{
            params["album_id"]=this.state.albumBean.album_id;
            this.getDataByPost(2,homeurl+"swController.api?updateAlbum",params);
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
                <Widget.Toolbar title="专辑编辑" history={this.props.history}/>
                <Widget.Editor
                    marginTop={20}
                    title="名称"
                    value={this.state.albumBean.ablum_name}
                    onChange={(value)=>{
                        this.state.albumBean.ablum_name=value;
                        this.setState({
                            albumBean:this.state.albumBean
                        })
                    }}/>
                <Widget.Textarea
                    marginTop={20}
                    height={200}
                    title="描述"
                    value={this.state.albumBean.ablum_desc}
                    onChange={(value)=>{
                        this.state.albumBean.ablum_desc=value;
                        this.setState({
                            albumBean:this.state.albumBean
                        })
                    }}/>
                <div style={{display:'flex'}}>
                    <Widget.Img
                        marginTop={20}
                        title="图标"
                        src={this.isNull(this.state.albumBean.ablum_img)?"./images/add.jpg":imgurl+this.state.albumBean.ablum_img}
                        url={homeurl+'goodsController.api?uploadGoodsImg'}
                        onSuccess={(data)=>{
                        this.state.albumBean.ablum_img=data;
                        this.setState({
                            albumBean:this.state.albumBean,
                        })
                    }}/>
                </div>
                <Widget.Editor
                    marginTop={20}
                    title="权重"
                    value={this.state.albumBean.sort}
                    onChange={(value)=>{
                        this.state.albumBean.sort=value;
                        this.setState({
                            albumBean:this.state.albumBean
                        })
                    }}/>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertClass();
                    }}/>
            </div>
        )
    }


}

module.exports=GoodsClassEditorComponent;