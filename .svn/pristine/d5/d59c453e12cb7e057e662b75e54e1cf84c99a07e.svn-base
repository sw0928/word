/**
 * Created by shenjiabo on 16/10/13.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var ListView=require('./ListView');

class SearchBarV2 extends  Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            selectVisible: false,
            data:[],
            selectBean:{},
            name:"",
        };
    }
    render(){
        return(
            <div style={{display:!this.props.visible||this.props.visible==='true'?"":"none",
                background:'#ffffff',width:200,height:30,marginLeft:this.props.marginLeft?this.props.marginLeft:0}}>
                <div style={{height:30,display:'flex',flex:1,borderStyle:'solid',borderWidth:1,borderColor:'#efefef'}}>
                    <input style={{flex:1,outline:'none',border:"none"}}
                           value={this.props.name}
                           onChange={(e)=>{
                                    if(this.props.onPress){
                                        this.props.onPress({},e.target.value);
                                    }
                           }}/>
                </div>
                <div style={{display:'flex',position:'relative',
                                left:0,right:0,top:0,flexDirection:'column',}}>
                    <ListView
                        style={{background:'#ffffff',borderStyle:'solid',borderWidth:1,borderColor:'#efefef'}}
                        dataSource={this.props.dataSource}
                        renderRow={(rowID)=>{
                            return(
                                <div style={{display:'flex',flex:1,flexDirection:'column',}}
                                    onClick={()=>{
                                        if(this.props.onPress){
                                            this.props.onPress(this.props.dataSource[rowID],this.props.dataSource[rowID][this.props.item_name]);
                                        }
                                    }}>
                                    <div style={{display:'flex',alignItems:'center',marginTop:4,marginBottom:4}}>
                                        <p1 style={{fontSize:15,marginLeft:10}}>{this.props.dataSource[rowID][this.props.item_name]}</p1>
                                    </div>
                                    <div style={{background:'#efefef',height:1}}></div>
                                </div>
                            )
                        }}/>
                </div>
            </div>
        )
    }
}

module.exports=SearchBarV2;