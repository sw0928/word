/**
 * Created by shenjiabo on 16/10/19.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';


class ButtonComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {};
    }
    render(){
        return(
            <div style={{
                    background:this.props.background?this.props.background:'#000000',
                    width:this.props.width?this.props.width:"auth",
                    height:this.props.height?this.props.height:30,
                    marginLeft:this.props.marginLeft?this.props.marginLeft:0,
                    marginTop:this.props.marginTop?this.props.marginTop:0,
                    marginRight:this.props.marginRight?this.props.marginRight:0,
                    paddingLeft:10,paddingRight:10,display:!this.props.visible||this.props.visible==='true'?'flex':"none",
                    alignItems:'center',justifyContent:'center',
                    cursor:"pointer",
                    borderRadius:5}}
                    onClick={()=>{
                        if(this.props.onClick){
                            this.props.onClick();
                        }
                    }}>
                <p1 style={{color:'#ffffff',fontSize:15}}>{this.props.value}</p1>
            </div>
        )
    }
}


module.exports=ButtonComponent;