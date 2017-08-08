/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require("./../../widget/WidgetComponent");

class SalesReport extends  Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            shopSelects:[{id:"0",name:"商品ID"},{id:"0",name:"商品名称"}],
            start_time:"",
            end_time:"",

            orderBeans:[],

            allMerchantsBeans:[],
            selectBean:{},

            total:0,
            page:1,
            merchants_name:"",

            order_states:[],
            order_no:"",
            baseData:[],
            goods_price:0,
            pay_way:[]
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"systemController.api?getSystemListShowsV2",{list_type:'order'});
        this.getOrderList("",this.state.page)
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    baseData:data,
                });
                this.getOrderList("",this.state.page)
                break;
            case 2:
                this.setState({
                    orderBeans:data.data.orderGoodsBeans,
                    total:data.total,
                    goods_price:data.data.goods_price,
                    goods_num:data.data.goods_num
                })
                break;
            case 3:
                toast.show("删除成功");
                this.getGoods(this.state.selectBean.merchants_id,this.state.page);
                break;
            case 4:
                toast.show("下载中...");
                window.location.href=homeurl+data;
                break;
        }
    }

    exportOrderExcel(merchants_id){
        this.getDataByPost(4,homeurl+'orderController.api?exportOrderExcel',
            {merchants_id:'1',
                start_time:this.state.start_time,
                end_time:this.state.end_time,
                order_states:this.state.order_states.toString(),
                order_no:this.state.order_no})
    }
    getOrderList(merchants_id,page){
        this.getDataByPost(2,homeurl+'orderController.api?getOrderGoodsList',
            {merchants_id:"1",
                start_time:this.state.start_time,
                end_time:this.state.end_time,
                page:page,
                order_states:this.state.order_states.toString(),
                order_no:this.state.order_no,
                pay_way:this.state.pay_way.toString()},{type:2})
    }

    render(){
        return(
            <div style={{flex:1,display:'flex',flexDirection:'column'}}>
                <Widget.Toolbar title="销售报表" history={this.props.history}></Widget.Toolbar>
                <div style={{display:'flex',alignItems:'center',marginTop:20}}>
                    <Widget.Editor
                        title="订单号"
                        value={this.state.order_no}
                        onChange={(value)=>{
                            this.setState({
                                order_no:value,
                            })
                        }}/>
                    <Widget.Date
                        title="开始时间"
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.start_time}
                        onChange={(value)=>{
                            this.setState({
                                start_time:value
                            })
                        }}/>
                    <Widget.Date
                        title="结束时间"
                        format="YYYY-MM-DD HH:mm:ss"
                        value={this.state.end_time}
                        onChange={(value)=>{
                            this.setState({
                                end_time:value
                            })
                        }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>订单状态</p1>
                    </div>
                    <Widget.Check title="取消" checked={this.state.order1}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("cancel");
                                        }else{
                                            var index=this.state.order_states.indexOf("cancel");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order1:checked,
                                        })
                                    }}/>
                    <Widget.Check title="待付款" checked={this.state.order2}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("wait_pay");
                                        }else{
                                            var index=this.state.order_states.indexOf("wait_pay");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order2:checked,
                                        })
                                    }}/>
                    <Widget.Check title="待发货" checked={this.state.order3}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("wait_send");
                                        }else{
                                            var index=this.state.order_states.indexOf("wait_send");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order3:checked,
                                        })
                                    }}/>
                    <Widget.Check title="待确认收货" checked={this.state.order4}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("wait_receive");
                                        }else{
                                            var index=this.state.order_states.indexOf("wait_receive");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order4:checked,
                                        })
                                    }}/>
                    <Widget.Check title="待评价" checked={this.state.order5}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("wait_assessment");
                                        }else{
                                            var index=this.state.order_states.indexOf("wait_assessment");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order5:checked,
                                        })
                                    }}/>
                    <Widget.Check title="已完成" checked={this.state.order6}
                                    onClick={(checked)=>{
                                        if(checked==='1'){
                                            this.state.order_states.push("end");
                                        }else{
                                            var index=this.state.order_states.indexOf("end");
                                            this.state.order_states.splice(index,1);
                                        }

                                        this.setState({
                                            order_states:this.state.order_states,
                                            order6:checked,
                                        })
                                    }}/>
                </div>
                <div style={{display:'flex',alignItems:'center'}}>
                    <div style={styles.tabTitle}>
                        <p1 style={styles.font}>支付方式</p1>
                    </div>
                    <Widget.Check title="线上支付" checked={this.state.pay1}
                                  onClick={(checked)=>{
                                      if(checked==='1'){
                                          this.state.pay_way.push("online");
                                      }else{
                                          var index=this.state.pay_way.indexOf("online");
                                          this.state.pay_way.splice(index,1);
                                      }

                                      this.setState({
                                          pay_way:this.state.pay_way,
                                          pay1:checked,
                                      })
                                  }}/>
                    <Widget.Check title="余额支付" checked={this.state.pay2}
                                  onClick={(checked)=>{
                                      if(checked==='1'){
                                          this.state.pay_way.push("balance");
                                      }else{
                                          var index=this.state.pay_way.indexOf("balance");
                                          this.state.pay_way.splice(index,1);
                                      }

                                      this.setState({
                                          pay_way:this.state.pay_way,
                                          pay2:checked,
                                      })
                                  }}/>
                    <Widget.Check title="信用额度支付" checked={this.state.pay3}
                                  onClick={(checked)=>{
                                      if(checked==='1'){
                                          this.state.pay_way.push("trust");
                                      }else{
                                          var index=this.state.pay_way.indexOf("trust");
                                          this.state.pay_way.splice(index,1);
                                      }

                                      this.setState({
                                          pay_way:this.state.pay_way,
                                          pay3:checked,
                                      })
                                  }}/>
                </div>

                <div style={{marginTop:20,display:'flex',justifyContent:'flex-end',flex:1,alignItems:'center'}}>
                    <div style={{display:'flex',flex:1,alignItems:'center'}}>
                        <Widget.Text
                            title="总金额"
                            value={this.state.goods_price.toFixed(2)}/>
                        <Widget.Text
                            title="总数量"
                            value={this.state.goods_num}/>
                    </div>
                    <Widget.Button
                        value="搜索"
                        marginRight={20}
                        onClick={()=>{
                            this.setState({
                                page:1
                            });
                            this.getOrderList(this.state.selectBean.merchants_id,1)
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="导出"
                        onClick={()=>{
                            this.exportOrderExcel(this.state.selectBean.merchants_id,1);
                        }}/>
                </div>

                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.orderBeans}
                    page={this.state.page}
                    total={this.state.total}
                    renderOperation={(rowID)=>{
                        return(
                            <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                <Widget.Link to={"/order_detail/"+this.state.orderBeans[rowID].order_id}
                                      style={{textDecoration:'none'}}>
                                    <p1 style={{fontSize:13,wordBreak:'break-all'}}>[详情]</p1>
                                </Widget.Link>
                            </div>
                        )
                    }}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getOrderList(this.state.selectBean.merchants_id,page)
                    }}/>

            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        height:30,
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
}
module.exports=SalesReport;
