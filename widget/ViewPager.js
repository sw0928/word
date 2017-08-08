/**
 * Created by shenjiabo on 16/7/21.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

class ViewPager extends Component{
    constructor(props) {
        super(props);
        this.state = {
            currIndex:0,
        }
    };
    componentDidMount() {
        this.startTime();
    };

    startTime(){
        this.timer=setTimeout(()=>{
            if (this.state.currIndex === this.props.dataSource.length - 1) {
                this.setState({
                    currIndex: 0
                });
            } else {
                this.setState({
                    currIndex: this.state.currIndex + 1
                });
            }
            this.startTime();
        },3000);
    }
    componentWillUnmount() {
        this.timer && clearTimeout(this.timer);
    }

    render(){
        let view;
        if(this.props.dataSource!=null&&this.props.dataSource.length>this.state.currIndex){
            view=this.props.renderRow(this.state.currIndex);
        }

        let circleView=this.renderCircle();
        return(
                <div style={{height:150}}>
                    {view}
                    {circleView}
                </div>
        );
    }

    renderCircle(){
        let view=[];
        if(this.props.dataSource!=null){
            for(let i=0;i<this.props.dataSource.length;i++){
                view.push(<div style={{width:10,height:10,borderRadius:10,
                    background:(this.state.currIndex===i?"#db4c3e":'#ffffff'),marginLeft:4}}>
                </div>);
            }
        }
        return(
            <div style={{display:'flex',height:40,alignItems:'center',justifyContent:'center',position:'relative',left:0,bottom:40}}>
                {view}
            </div>
        );
    }
}
module.exports= ViewPager;