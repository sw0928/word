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
            othersBean:{},
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"activityController.api?getActivityOthers",{others_type:'time_limit'});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    othersBean:data
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.Img
                        marginTop={20}
                        title="限时抢购图片"
                        src={this.isNull(this.state.othersBean.others_img)?"./images/add.jpg":imgurl+this.state.othersBean.others_img}
                        url={homeurl+'activityController.api?uploadHomeOthersImg'}
                        onSuccess={(data)=>{
                            this.state.othersBean.others_img=data;
                            this.setState({
                                othersBean:this.state.othersBean
                            })
                        }}/>
            </div>
        )
    }


}

module.exports=GoodsClassEditorComponent;