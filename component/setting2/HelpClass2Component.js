/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

var HelpClassComponent=require("./HelpClassComponent");

class HelpClass2Component extends Widget.BaseComponent{
    render(){
        return(
            <HelpClassComponent
                history={this.props.history}
                parent_id={this.props.params.parent_id}
                level={this.props.params.level}/>

        )
    }
}
module.exports=HelpClass2Component;