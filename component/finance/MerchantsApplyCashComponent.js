/**
 * Created by shenjiabo on 17/1/9.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');


class MerchantsApplyCashComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var info=Widget.storage.get("merchantsAccountBean");
        this.state = {
            merchants_id:JSON.parse((info===null?"{}":info)).merchants_id,
        };
    }

    applyCash(){
        if(isNaN(this.state.cash_price)){
            this.showTip("提现金额非法");
            return;
        }

        if(this.isNull(this.state.brank_name)){
            this.showTip("请先填写银行名称");
            return;
        }

        if(this.isNull(this.state.brank_code)){
            this.showTip("请先填写银行卡号");
            return;
        }

        if(this.isNull(this.state.brank_open_name)){
            this.showTip("请先填写开户行");
            return;
        }

        if(this.isNull(this.state.brank_open_usr)){
            this.showTip("请先填写开户人");
            return;
        }

        if(this.isNull(this.state.brank_open_mobile)){
            this.showTip("请先填写开户手机");
            return;
        }

        if(this.isNull(this.state.cash_time)){
            this.showTip("请先填写提现时间");
            return;
        }

        this.getDataByPost(1,homeurl+"financeController.api?applyCash",
                            {
                                merchants_id:this.state.merchants_id,
                                brank_code:this.state.brank_code,
                                brank_name:this.state.brank_name,
                                brank_open_name:this.state.brank_open_name,
                                cash_price:this.state.cash_price,
                                brank_open_usr:this.state.brank_open_usr,
                                brank_open_mobile:this.state.brank_open_mobile,
                                cash_time:this.state.cash_time,
                                cash_type:'merchants'});
    }


    doSuccess(index,data){
        switch (index){
            case 1:
                this.showTip("申请成功");
                this.props.history.goBack();
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.Toolbar title="申请提现" history={this.props.history}/>
                <Widget.Button
                    value="保存"
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    onClick={()=>{
                        this.applyCash();
                    }}/>
                <Widget.Editor
                    title="提现金额"
                    value={this.state.cash_price}
                    marginTop={20}
                    onChange={(value)=>{
                        this.setState({
                            cash_price:value
                        })
                    }}/>
                <Widget.Editor
                    title="银行名称"
                    marginTop={20}
                    value={this.state.brank_name}
                    onChange={(value)=>{
                        this.setState({
                            brank_name:value
                        })
                    }}/>
                <Widget.Editor
                    marginTop={20}
                    title="银行卡号"
                    value={this.state.brank_code}
                    onChange={(value)=>{
                        this.setState({
                            brank_code:value
                        })
                    }}/>
                <Widget.Editor
                    title="开户行"
                    marginTop={20}
                    value={this.state.brank_open_name}
                    onChange={(value)=>{
                        this.setState({
                            brank_open_name:value
                        })
                    }}/>
                <Widget.Editor
                    title="开户人"
                    marginTop={20}
                    value={this.state.brank_open_usr}
                    onChange={(value)=>{
                        this.setState({
                            brank_open_usr:value
                        })
                    }}/>
                <Widget.Editor
                    title="开户手机"
                    marginTop={20}
                    value={this.state.brank_open_mobile}
                    onChange={(value)=>{
                        this.setState({
                            brank_open_mobile:value
                        })
                    }}/>
                <Widget.Date
                    title="提现时间"
                    format="YYYY-MM-DD"
                    marginTop={20}
                    value={this.state.cash_time}
                    onChange={(value)=>{
                        this.setState({
                            cash_time:value
                        })
                    }}/>
            </div>
        )
    }
}

module.exports=MerchantsApplyCashComponent;