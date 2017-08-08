/**
 * Created by shenjiabo on 16/7/20.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
require("./../css/style.css");

class Tabs extends Component{
    constructor(){
        super();
        this.state={
            currentIndex : 0
        };
    }
    
    render(){
        let _this=this;
        return(
            <div style={{display:'flex',flex:1,flexDirection:'column'}}>
                <div style={{flex:1,background:'#ffffff',overflow:'scroll'}}>
                    {React.Children.map(this.props.children,(element,index)=>{
                        if(this.props.onPress&&index===this.state.currentIndex){
                            this.props.onPress(index);
                        }
                        return(
                            <div style={{display:index===this.state.currentIndex?"flex":"none"}}>{ element }</div>
                        );
                    })}
                </div>
                <div style={{display:'flex',background:"#323232",height:50}}>
                    {React.Children.map( this.props.children , (element,index) => {
                        return(
                            /*箭头函数没有自己的this，这里的this继承自外围作用域，即组件本身*/
                            <div onClick={ () => { this.setState({currentIndex : index}) } }
                                 style={{display:'flex',flex:1,alignItems:'center',justifyContent:'center',
                                        flexDirection:'column'}}>
                                <img src={index===this.state.currentIndex?this.props.tabs[index].selectIcon:this.props.tabs[index].unSelectIcon}
                                     style={{height:20,width:20}}/>
                                <p1 style={{color:index===this.state.currentIndex?"#db4c3e":"#ffffff",fontSize:16,marginTop:4}}>{this.props.tabs[index].title}</p1>
                            </div>
                        );
                    }) }
                </div>
            </div>
        );
    }
}

module.exports=Tabs;
