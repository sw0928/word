/**
 * Created by hy.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var PageComponent=require("./PageComponent");

class AddressComponent extends Component{

    constructor(props) {
        super(props);
        this.have_props = 0 // 是否已加载过数据
    }

    componentWillMount(){
        this.setTreAddressjs()
    }

    componentDidMount(){
    }

    componentDidUpdate(){
        if(this.have_props == 0 && this.props.province){
            console.log(this.props.province + '//' + this.props.city +  '//' + this.props.area)
            new PCAS("user.province","user.city","user.area",this.props.province,this.props.city,this.props.area);
            this.have_props += 1
        }
    }

    // 三级地域选择js
    setTreAddressjs(){
        var head= document.getElementsByTagName('head')[0];
        var script= document.createElement('script');
        script.type= 'text/javascript';
        script.src= './treAddress.js';
        head.appendChild(script);
    }

    // 获取三级地域选择内容
    setAddr(){
        if(this.props.onSelectChange){
            var getpro=document.getElementById("province").value;
            var getcity=document.getElementById("city").value;
            var getarea=document.getElementById("area").value;
            this.props.onSelectChange(getpro,getcity,getarea)
        }
    }

    render(){
        return(
            <form>
                <div style={{width:this.props.width?this.props.width:(this.props.title?100:0),display:'flex',justifyContent:'flex-end',}}>
                    <p1 style={styles.tabP1}>{this.props.title}</p1>
                </div>
                <div styles = {{flex:this.props.flex,display:'flex'}}>
                    <select name="user.province" id="province" onChange={()=>this.setAddr()}></select>
                    <select name="user.city" id="city" onChange={()=>this.setAddr()}></select>
                    <select name="user.area" id="area" onChange={()=>this.setAddr()}></select>
                </div>
            </form>
        )
    }

}



const styles = {
    item: {
        flex: 1,
        display: 'flex',
        borderLeftWidth: 1,
        borderTopWidth: 1,
        borderLeftColor: '#c8c8c8',
        borderTopColor: '#c8c8c8',
        borderLeftStyle: 'solid',
        borderTopStyle: 'solid',
        flexDirection: 'column',
        marginLeft: 10,
        marginRight: 10,
        marginTop: 10
    },
    tabColumn: {
        flex: 1,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#c8c8c8',
        borderRightColor: '#c8c8c8',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabRow: {
        flex: 1,
        display: 'flex',
        flexWrap: 'wrap',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#c8c8c8',
        borderRightColor: '#c8c8c8',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabP1: {
        fontSize: 13,
        wordBreak: 'break-all'
    },
    floatleft:{
        float: 'left',
        display:'inline'
    },
    secBtn:{
        border: 'none',
        color: 'white',
        'font-family':'Arial',
        padding: '10px 24px',
        'text-align': 'center',
        'text-decoration': 'none',
        display: 'inline-block',
        'font-size': '18px',
        margin: '4px 2px',
        cursor: 'pointer'
    }

}


module.exports= AddressComponent;