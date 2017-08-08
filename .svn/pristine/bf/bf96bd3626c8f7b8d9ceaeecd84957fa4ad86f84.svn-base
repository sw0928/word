import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class BusinessMemberComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            merchants_id:this.props.merchants_id,
            memberBeans:[],
            page: 1,
            total: 0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"systemController.api?getSystemListShows",{list_type:'business_member'});
        this.getBusinessMember(this.state.page);
    }

    getBusinessMember(page){
        this.getDataByPost(2,homeurl+"merchantsController.api?getBusinessFollower"
            ,{merchants_id:this.state.merchants_id,page:page},{type:2});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    baseData:data
                })
                break;
            case 2:
                this.setState({
                    memberBeans:data.data,
                    total:data.total,
                })
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.memberBeans}
                    page={this.state.page}
                    total={this.state.total}
                    onPage={(page)=>{
                        this.setState({
                            page:page
                        });
                        this.getBusinessMember(page)
                    }}/>
            </div>
        )
    }
}

module.exports=BusinessMemberComponent;
