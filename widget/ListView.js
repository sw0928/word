/**
 * Created by shenjiabo on 16/7/21.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

var orientation='vertical';
var PageComponent=require("./PageComponent");

class ListView extends Component{
    constructor(props) {
        super(props);
        this.state={
            state:0,//0从未加载过  1:加载更多 2:正在加载中  3:已全部加载

        }
    };
    ;
    componentDidMount() {

    };

    componentWillUnmount() {

    }

    loadEnd(state){
        this.setState({
            state:state,
        });
    }
    render(){
        let view=[];
        if(this.props.dataSource!=null&&this.props.dataSource.length>0) {
            for (let i = 0; i < this.props.dataSource.length; i++) {
                view.push(this.props.renderRow(i));
            }
        }

        let headerView=[];
        if(this.props.renderHeader){
            headerView.push(this.props.renderHeader());
        }else{
            headerView=null;
        }

        return(
            <div style={this.props.style?this.props.style:{flex:1}}
                 onScroll={this.props.onScroll?this.props.onScroll:this.onScroll}
                 onMouseOut={this.props.onMouseOut?this.props.onMouseOut:this.onMouseOut}
                 id={this.props.id}
                 ref={this.props.ref}>
                {headerView}
                {view}
            </div>
        );
    }

    onScroll(e){

    }
    onMouseOut(){

    }
}
module.exports= ListView;