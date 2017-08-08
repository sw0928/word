/**
 * Created by shenjiabo on 17/3/16.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require('./../../widget/WidgetComponent');


class InformationAppDetailComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            information_id:this.props.params.information_id,
            informationBean:{}
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"informationInterfaces.api?getInformationDetail",{information_id:this.state.information_id});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    informationBean:data
                });
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.ListView
                    style={{display:'flex',flexDirection:'column',}}
                    dataSource={this.state.informationBean.informationImgBeans}
                    renderRow={(index)=>{
                        return(
                            <img src={imgurl+this.state.informationBean.informationImgBeans[index].information_img}></img>
                        )
                    }}/>
            </div>
        )
    }
}

module.exports=InformationAppDetailComponent;
