/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
import 'react-date-picker/index.css'
import { DateField, Calendar } from 'react-date-picker'


class EditorComponent extends Component{
    render(){
        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",height:30,alignItems:'center',
            marginLeft:this.props.marginLeft?this.props.marginLeft:0,
            marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={{width:this.props.width?this.props.width:100,display:'flex',justifyContent:'flex-end',}}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <DateField
                    style={{marginLeft:10,marginRight:10}}
                    dateFormat={this.props.format}
                    value={this.props.value}
                    onChange={(dateString, { dateMoment, timestamp })=>{
                        if(this.props.onChange){
                            this.props.onChange(dateString);
                        }
                    }}
                />
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

module.exports=EditorComponent;