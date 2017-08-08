/**
 * Created by shenjiabo on 16/12/2.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';

class ViewComponent extends Component{
    render(){
        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",
            marginTop:this.props.marginTop?this.props.marginTop:20,
            flexDirection:this.props.flexDirection?this.props.flexDirection:"row",alignItems:'center',background:'#ffffff'}}>
                {this.props.children}
            </div>
        )
    }
}


module.exports=ViewComponent;