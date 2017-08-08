/**
 * Created by shenjiabo on 17/1/11.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require('./../../widget/WidgetComponent');

class GoodsDetailEditorComponent extends  Widget.BaseComponent{
    render(){
        return(
            <div style={{display:this.props.goodsBean.goods_id?'flex':"none"}}>
                <iframe src={htmlurl+"/goods_editor.html?goods_url="+this.props.goodsBean.goods_url}
                        style={{display:'flex',width:1000,height:800}}>
                </iframe>
            </div>
        )
    }
}

module.exports=GoodsDetailEditorComponent;