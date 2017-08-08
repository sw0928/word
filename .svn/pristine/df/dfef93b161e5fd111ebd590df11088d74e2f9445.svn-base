/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';

class TextComponent extends Component{
    render(){
        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",alignItems:'center',
            marginLeft:this.props.marginLeft?this.props.marginLeft:0,
            marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={styles.tabTitle}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <div style={styles.desc}>
                    <p style={{fontSize:13,marginLeft:10}}>{this.props.value}</p>
                </div>
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
    desc:{
        width:200,
        display:'flex',
        alignItems:"center",
        borderStyle:'solid',
        borderWidth:1,
        borderColor:'#efefef',
        marginLeft:10,
    },
    font:{
        fontSize:13,
    },
}


module.exports=TextComponent;
