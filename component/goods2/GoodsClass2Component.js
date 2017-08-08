/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var GoodsClassComponent=require("./GoodsClassComponent");

class GoodsClass2Component extends Widget.BaseComponent{
    render(){
        return(
            <GoodsClassComponent
                history={this.props.history}
                parent_id={this.props.params.parent_id}
                level={this.props.params.level}/>

        )
    }
}
module.exports=GoodsClass2Component;