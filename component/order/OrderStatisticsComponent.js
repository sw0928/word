/**
 * Created by shenjiabo on 17/3/15.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require("./../../widget/WidgetComponent");

class OrderStatisticsComponent extends Widget.BaseComponent{

    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            statisticsBean:{},
            start_time:"",
            end_time:""
        };
    }
    componentDidMount() {
        this.getData();
    }

    getData(){
        this.getDataByPost(1,homeurl+"orderController.api?getOrderStatistics",
            {start_time:this.state.start_time,end_time:this.state.end_time});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    statisticsBean:data
                })
                break;
        }
    }
    render(){
        return(
            <div style={{display:'flex',flexDirection:'column'}}>
                <Widget.Toolbar title="订单统计" history={this.props.history}></Widget.Toolbar>
                <div style={{display:'flex',alignItems:"center",marginTop:20}}>
                    <Widget.Date
                        marginRight={20}
                        title="开始"
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.start_time}
                        onChange={(date)=>{
                            this.setState({
                                start_time:date
                            })
                        }}/>
                    <Widget.Date
                        marginRight={20}
                        title="~"
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.end_time}
                        onChange={(date)=>{
                            this.setState({
                                end_time:date
                            })
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="搜索"
                        onClick={()=>{
                            this.getData();
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',marginTop:20}}>
                    <p style={{color:'red',fontSize:13}}>营业额:{this.isNull(this.state.statisticsBean.total_price)?0:this.state.statisticsBean.total_price.toFixed(2)}</p>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',height:1,background:'#c8c8c8'}}>
                </div>
                <div style={{marginLeft:200,marginRight:200,display:'flex',alignItems:"center",marginTop:20}}>
                    <p style={{fontSize:13}}>交易完成</p>
                    <div style={{display:'flex',flex:1,justifyContent:'flex-end'}}>
                        <p style={{color:'red',fontSize:13}}>¥</p><p style={{color:'red',fontSize:13}}>{this.isNull(this.state.statisticsBean.end_price)?0:this.state.statisticsBean.end_price.toFixed(2)}</p>
                    </div>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',height:1,background:'#c8c8c8'}}>
                </div>
                <div style={{marginLeft:200,marginRight:200,display:'flex',alignItems:"center",marginTop:20}}>
                    <p style={{fontSize:13}}>待收货</p>
                    <div style={{display:'flex',flex:1,justifyContent:'flex-end'}}>
                        <p style={{color:'red',fontSize:13}}>¥</p><p style={{color:'red',fontSize:13}}>{this.isNull(this.state.statisticsBean.wait_receive_price)?0:this.state.statisticsBean.wait_receive_price.toFixed(2)}</p>
                    </div>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',height:1,background:'#c8c8c8'}}>
                </div>
                <div style={{marginLeft:200,marginRight:200,display:'flex',alignItems:"center",marginTop:20}}>
                    <p style={{fontSize:13}}>已付款</p>
                    <div style={{display:'flex',flex:1,justifyContent:'flex-end'}}>
                        <p style={{color:'red',fontSize:13}}>¥</p><p style={{color:'red',fontSize:13}}>{this.isNull(this.state.statisticsBean.wait_send_price)?0:this.state.statisticsBean.wait_send_price.toFixed(2)}</p>
                    </div>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',height:1,background:'#c8c8c8'}}>
                </div>
                <div style={{marginLeft:200,marginRight:200,display:'flex',alignItems:"center",marginTop:20}}>
                    <p style={{fontSize:13}}>未付款</p>
                    <div style={{display:'flex',flex:1,justifyContent:'flex-end'}}>
                        <p style={{color:'red',fontSize:13}}>¥</p><p style={{color:'red',fontSize:13}}>{this.isNull(this.state.statisticsBean.wait_pay_price)?0:this.state.statisticsBean.wait_pay_price.toFixed(2)}</p>
                    </div>
                </div>
                <div style={{display:'flex',alignItems:"center",justifyContent:'center',height:1,background:'#c8c8c8'}}>
                </div>
            </div>
        )
    }
}

module.exports=OrderStatisticsComponent;