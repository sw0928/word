/**
 * Created by shenjiabo on 16/10/14.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var storage = require('key-storage');
var ListView=require('./ListView');

class TabBar extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        if(this.props.onPress){
            this.props.onPress(parseInt(storage.get(this.props.saveIndex)));
        }
        this.state = {
            itemCurIndex:parseInt(storage.get(this.props.saveIndex)),
            component:null,
        };

    }
    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <ListView
                    style={{display:'flex',flex:1,flexWrap:'wrap',height:40,background:'#323232'}}
                    dataSource={this.props.dataSource}
                    renderRow={(rowID)=>{
                                return(
                                    <div style={{width:100,display:'flex',
                                                alignItems:'center',justifyContent:'center',
                                                background:this.state.itemCurIndex===rowID?"#efefef":"#323232"}}
                                        onClick={()=>{
                                            storage.set(this.props.saveIndex,rowID);
                                            this.setState({
                                                itemCurIndex:rowID,
                                                component:this.props.dataSource[rowID].component
                                            })
                                            if(this.props.onPress){
                                                this.props.onPress(rowID);
                                            }
                                        }}>
                                        <p1 style={{fontSize:15,color:this.state.itemCurIndex===rowID?"#000000":"#ffffff"}}>
                                            {this.props.dataSource[rowID].name}
                                        </p1>
                                    </div>
                                );
                            }}>
                </ListView>
                {this.props.component}
            </div>
        )
    }
}

module.exports=TabBar;