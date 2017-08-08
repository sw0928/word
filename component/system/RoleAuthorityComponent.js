/**
 * Created by shenjiabo on 17/3/29.
 * 角色权限设置
 *
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'

var Widget=require("./../../widget/WidgetComponent");

class RoleAuthorityComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            listTypeBeans:[],
            detailTypeBeans: [],
            moudleBeans:[],

            listBeans:[],
            detailBeans:[],
            role_id:this.props.params.role_id
        };
    }
    componentDidMount() {
        this.getSystemListTypesNoPage();
        //this.getMoudles();
    }

    getMoudles(){
        this.getDataByPost(1, homeurl + "systemController.api?getAuthorityByRoleV2", {role_id: this.props.params.role_id,parent_id:-1})
    }

    getAuthorityByRoleV2(parent_id){
        this.getDataByPost(6, homeurl + "systemController.api?getAuthorityByRoleV2", {role_id: this.props.params.role_id,parent_id:parent_id})
    }
    getSystemListTypesNoPage(){
        this.getDataByPost(2, homeurl + "systemController.api?getSystemListTypesNoPage", {type_type:"list"});
        //this.getDataByPost(3, homeurl + "systemController.api?getSystemListTypesNoPage",{type_type:"detail"});
    }

    getSystemListShowsPage(page,list_type) {
        this.getDataByPost(4, homeurl + "systemController.api?getSystemListShowsNoPage",
            {list_type:list_type,role_id:this.state.role_id});
    }


    getSystemDetailShowsPage(page,detail_type) {
        this.getDataByPost(5, homeurl + "systemController.api?getSystemDetailShowsPage",
            {page:page,detail_type:detail_type,limit:100});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    moudleBeans:data
                });
                this.getAuthorityByRoleV2(data[0].moudle_id);
                break;
            case 2:
                this.setState({
                    listTypeBeans:data
                });
                this.getSystemListShowsPage(1,data[0].type_value);
                break;
            case 3:
                this.setState({
                    detailTypeBeans:data
                });
                this.getSystemDetailShowsPage(1,data[0].type_value);
                break;
            case 4:
                this.setState({
                    listBeans:data
                });
                break;
            case 5:
                this.setState({
                    detailBeans:data
                })
                break;
            case 6:
                this.setState({
                    moudleBeans2:data
                });
                break;
            case 7:
                this.showTip("保存成功");
                break;
        }
    }

    saveRoleList(){
        this.getDataByPost(7, homeurl + "systemController.api?saveRoleList",
            {role_id:this.state.role_id,
            json:JSON.stringify(this.state.listBeans)});
    }
    render(){
        return(
            <div>
                <div style={{display:'flex',marginTop:20,flexDirection:'column'}}>
                    <div style={{display:'flex',alignItems:'center'}}>
                        <Widget.SelectV2
                            dataSource={this.state.listTypeBeans}
                            title="列表"
                            init_value={this.state.list_type_value}
                            select_value="type_value"
                            show_value="type_name"
                            onChange={(rowID)=>{
                                this.setState({
                                    list_type_value:this.state.listTypeBeans[rowID].type_value
                                })
                                this.getSystemListShowsPage(1,this.state.listTypeBeans[rowID].type_value);
                            }}/>
                        <Widget.ButtonComponent
                            marginLeft={20}
                            value="保存"
                            onClick={()=>{
                                this.saveRoleList();
                            }}/>
                    </div>

                    <Widget.ListView
                        style={{display:'flex',marginLeft:20,flexWrap:'wrap'}}
                        dataSource={this.state.listBeans}
                        renderRow={(rowID)=>{
                            return(
                                <div style={{display:'flex',alignItems:"center",borderStyle:'solid',
                                        borderWidth:1,borderColor:'#efefef'}}>
                                    <div style={{width:200,display:'flex',alignItems:'center',justifyContent:'center'}}>
                                        <p1 style={{fontSize:13}}>{this.state.listBeans[rowID].name}</p1>
                                    </div>
                                    <Widget.Check
                                        checked={this.state.listBeans[rowID].list_state}
                                        visible="true"
                                        marginLeft={10}
                                        onClick={(checked)=>{
                                            this.state.listBeans[rowID].list_state=checked;
                                            this.setState({
                                                listBeans:this.state.listBeans
                                            })
                                        }}/>
                                </div>
                            )
                        }}/>
                </div>

            </div>
        )
    }
}

module.exports=RoleAuthorityComponent;