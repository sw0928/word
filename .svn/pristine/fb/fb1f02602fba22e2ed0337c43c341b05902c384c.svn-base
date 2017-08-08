/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';

class SelectV2Component extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state={
        }
    }
    render(){
        var is_have=false;
        let view=[];

        for(let i=0;i<this.props.dataSource.length;i++){
            if(this.props.init_value+""===this.props.dataSource[i][this.props.select_value]+""){
                view.push(<option selected="selected">{this.props.dataSource[i][this.props.show_value]}</option>);
            }else{
                view.push(<option>{this.props.dataSource[i][this.props.show_value]}</option>);
            }
        }

        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",height:50, alignItems:'center'
            ,marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={styles.tabTitle}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <select
                    style={{marginLeft:10}}
                    ref="select"
                    onChange={()=>{
                            this.props.onChange(this.refs.select.selectedIndex);
                        }}>
                    {view}
                </select>
            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        height:50,
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

module.exports=SelectV2Component;