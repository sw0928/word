/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var WXMenuComponent=require("./WXMenuComponent");

class WXMenu2Component extends Widget.BaseComponent{
    render(){
        return(
            <WXMenuComponent
                history={this.props.history}
                parent_id={this.props.params.parent_id}
                level={this.props.params.level}/>
        )
    }
}
module.exports=WXMenu2Component;