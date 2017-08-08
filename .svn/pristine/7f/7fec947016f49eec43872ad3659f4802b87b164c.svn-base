/**
 * Created by shenjiabo on 16/8/2.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

class EditInfoComponent extends  Component{
    // 构造
      constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            value:""
        };
      }
    render(){
        return(
            <div style={{display:this.props.visible?"flex":'none',flex:1,
                position:'fixed',top:0,left:0,right:0,bottom:0,flexDirection:'column'}}>
                <div style={{flex:1,background:'#000000',opacity:0.5}}>

                </div>
                <div style={{display:'flex',background:'#ffffff',}}>
                    <div style={{flex:1,background:'#000000',opacity:0.5}}>

                    </div>
                    <div style={{background:'#ffffff',opacity:0.5,width:300}}>
                        <div style={{display:'flex',alignItems:'center',justifyContent:'center',outLine:'none'}}>
                            <input style={{flex:1,height:40,border:'none',padding:10}} placeholder={this.props.placeholder}
                                onChange={(text)=>{
                                    this.setState({
                                        value:text.target.value
                                    });
                                }}/>
                        </div>
                        <div style={{flex:1,height:1,background:'#efefef'}}></div>
                        <div style={{height:40,display:'flex',alignItems:'center'}}>
                            <div style={{flex:1,display:'flex',alignItems:'center',justifyContent:'center'}}
                                onClick={()=>{
                                    this.props.onPress(this.state.value);
                                }}>
                                <p1 style={{fontSize:15}}>确定</p1>
                            </div>
                            <div style={{flex:1,display:'flex',alignItems:'center',justifyContent:'center'}}
                                    onClick={()=>{
                                        this.props.onClose();
                                    }}>
                                <p1 style={{fontSize:15}}>取消</p1>
                            </div>
                        </div>
                    </div>
                    <div style={{flex:1,background:'#000000',opacity:0.5}}>

                    </div>
                </div>
                <div style={{flex:1,background:'#000000',opacity:0.5}}>

                </div>
            </div>
        );
    }
}

module.exports=EditInfoComponent;