/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';

class CheckComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            checked:this.props.checked,
        };
    }
    render(){
        return(
            <div style={{ display:!this.props.visible||this.props.visible==='true'?'flex':"none",
                        height:40,alignItems:'center'}}>
                <input
                    style={{marginLeft:this.props.marginLeft?this.props.marginLeft:10}}
                    type="checkbox"
                       checked={(this.props.checked||this.props.value)+""==='1'?true:false}
                       onClick={()=>{
                           if(this.props.onClick){
                                if(this.props.checked+""==='1'){
                                    this.props.onClick("0");
                                }else{
                                    this.props.onClick("1");
                                }
                           }
                       }}/>
                    <p1 style={styles.font}>{this.props.title}</p1>
            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        height:40,
        alignItems:'center',
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    desc:{
        width:200,
        height:30,
        display:'flex',
        alignItems:"center",
        justifyContent:'center'
    },
    font:{
        fontSize:13,
        marginLeft:10,
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    },
}


module.exports=CheckComponent;
