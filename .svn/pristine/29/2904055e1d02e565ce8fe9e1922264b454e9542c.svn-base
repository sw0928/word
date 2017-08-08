/**
 * Created by shenjiabo on 16/10/13.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var ListView=require('./ListView');

class SearchBar extends  Component{
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
                                    if(e.target.value===''){
                                        this.setState({
                                            selectBean:{},
                                            data:[],
                                            name:e.target.value,
                                        })
                                    }else{
                                        this.setState({
                                            name:e.target.value,
                                            selectBean:{},
                                            data:this.props.dataSource.filter(function(item){
                                                return item[this.props.item_name].indexOf(e.target.value)>=0
                                                        ||(item["goods_sku"]&&item["goods_sku"].indexOf(e.target.value)>=0);
                                            }.bind(this))
                                        })
                                    }
                                    if(this.props.onPress){
                                        this.props.onPress({},e.target.value);
                                    }
                           }}/>
                </div>
                <div style={{display:'flex',position:'relative',
                                left:0,right:0,top:0,flexDirection:'column',}}>
                    <ListView
                        style={{background:'#ffffff',borderStyle:'solid',borderWidth:1,borderColor:'#efefef'}}
                        dataSource={this.state.data}
                        renderRow={(rowID)=>{
                            return(
                                <div style={{display:'flex',flex:1,flexDirection:'column',}}
                                    onClick={()=>{
                                        if(this.props.onPress){
                                            this.props.onPress(this.state.data[rowID],this.state.data[rowID][this.props.item_name]);
                                        }
                                        this.setState({
                                            selectBean:this.state.data[rowID],
                                            data:[],
                                            name:this.state.data[rowID][this.props.item_name],
                                        })
                                    }}>
                                    <div style={{display:'flex',alignItems:'center',marginTop:4,marginBottom:4}}>
                                        <p1 style={{fontSize:15,marginLeft:10}}>{this.state.data[rowID][this.props.item_name]}</p1>
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

module.exports=SearchBar;