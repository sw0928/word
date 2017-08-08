/**
 * Created by shenjiabo on 16/8/2.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

class TipComponent extends  Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            value:""
        };
    }

    componentDidMount() {

    }
    render(){
        return(
            <div style={{display:this.props.visible?"flex":'none',flex:1,
                position:'fixed',top:0,left:0,right:0,bottom:0,flexDirection:'column'}}>
                <div style={{flex:1,background:'#000000',opacity:0.5}}>

                </div>
                <div style={{display:'flex'}}>
                    <div style={{flex:1,background:'#000000',opacity:0.5}}>

                    </div>
                    <div>
                       <div style={{display:'flex',flex:1,background:'#efefef',
                                height:30,justifyContent:'flex-end',alignItems:'center'}}
                            onClick={()=>{
                                if(this.props.onClose){
                                    this.props.onClose();
                                }
                            }}>
                            <p style={{marginRight:20,fontSize:13}}>关闭</p>
                       </div>
                       <img src={this.props.src} style={{maxWidth:300,maxHeight:600}}/>
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

module.exports=TipComponent;