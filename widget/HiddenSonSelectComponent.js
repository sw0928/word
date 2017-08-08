/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
var SelectComponent=require('./SelectComponent');
class HiddenSonSelectComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state={
            init_value:this.props.init_value,
            son_show:this.props.show_son,
        }
    }
    contains(arr, obj){
        let i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    }
    render(){
        var is_have=false;
        let view=[];
        for(let i=0;i<this.props.dataSource.length;i++){
            if(this.state.init_value+""===this.props.dataSource[i][this.props.select_value]+""){
                if(this.props.onChange){
                    this.props.onChange(i);
                }
                is_have=true;
                view.push(<option selected="selected">{this.props.dataSource[i][this.props.show_value]}</option>);
            }else{
                view.push(<option>{this.props.dataSource[i][this.props.show_value]}</option>);
            }
        }
        if(this.props.dataSource.length>0&&!is_have){
            if (this.props.onChange) {
                this.props.onChange(0);
            }
        }
        return(
            <div>
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",height:50, alignItems:'center'
            ,marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={styles.tabTitle}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <select
                    style={{marginLeft:10}}
                    ref="select"
                        onChange={()=>{
                            let choosedIndex =this.refs.select.selectedIndex;
                            let ifShow = this.contains(this.props.showArr,choosedIndex+1)?"true":-1;
                            this.setState({
                                init_value:this.props.dataSource[this.refs.select.selectedIndex][this.props.select_value],
                                son_show:ifShow
                            });
                            this.props.onChange(choosedIndex);
                        }}>
                    {view}
                </select>
            </div>
            <SelectComponent
                visible={this.state.son_show}
                marginTop={this.props.son_marginTop}
                title={this.props.son_title}
                show_value={this.props.son_show_value}
                init_value={this.props.son_init_value}
                select_value={this.props.son_select_value}
                dataSource={this.props.son_dataSource}
                onChange={this.props.son_onChange}/>
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

module.exports=HiddenSonSelectComponent;