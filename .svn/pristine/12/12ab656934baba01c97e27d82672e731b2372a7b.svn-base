/**
 * Created by shenjiabo on 16/7/21.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

var height=10;//默认高度
var maxColor="#efefef";
var curColor="#db4c3e";

class Slider extends Component{
    render(){
        return(
            <div style={{flex:1,display:'flex',alignItems:'center'}}>
                <div style={{flex:1,display:'flex',height:height,borderRadius:height}}>
                    <div style={{flex:this.props.value,background:this.props.curColor?this.props.curColor:curColor}}></div>
                    <div style={{flex:(1-this.props.value),background:this.props.maxColor?this.props.maxColor:maxColor}}></div>
                </div>
            </div>

        );
    }
}

module.exports=Slider;