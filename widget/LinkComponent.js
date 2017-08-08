/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'

class LinkComponent extends Component{
    render(){
        let view=[];
        let style={}
        if(this.props.history){
            view.push(
                <div style={{display:'flex',alignItems:'center'
                            ,justifyContent:'center',background:'#000000',width:100,borderRadius:10,height:30}}
                    onClick={()=>{
                        this.props.history.push(this.props.to);
                    }}>
                        <p1 style={{fontSize:13,color:this.props.color?this.props.color:'#ffffff'}}>{this.props.value}</p1>
                </div>
            )
        }else{
            view.push(
                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                    <Link to={this.props.to}
                                style={{textDecoration:'none'}}>
                        <p1 style={{fontSize:13,color:this.props.color?this.props.color:'blue'}}>[{this.props.value}]</p1>
                    </Link>
                </div>)
            style={display:"flex",flex:1}
        }
        return(
            <div style={style}>
                {view}
            </div>
        )
    }
}

module.exports=LinkComponent;