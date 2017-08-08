/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';

class TextareaComponent extends Component{
    render(){
        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",alignItems:'center',
            marginLeft:this.props.marginLeft?this.props.marginLeft:0,
            marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={{width:this.props.width?this.props.width:100,display:'flex',justifyContent:'flex-end',}}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <textarea
                    type={this.props.type?this.props.type:"text"}
                    placeholder={this.props.placeholder?this.props.placeholder:""}
                    style={{width:this.props.widthContent?this.props.widthContent:200,height:this.props.height?this.props.height:30,
                    marginLeft:10,paddingLeft:10}}
                    value={this.props.value}
                    onChange={(e)=>{
                            if(this.props.onChange){
                                this.props.onChange(e.target.value);
                            }
                      }}/>
                <p1 style={{display:(this.props.is_must==='true'?"flex":"none"),color:'red',marginLeft:10}}>*</p1>
            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        height:30,
        alignItems:'center',
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    input:{
        width:200,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:13,
    },
}

module.exports=TextareaComponent;