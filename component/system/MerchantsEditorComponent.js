/**
 * Created by shenjiabo on 16/8/22.
 */
/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');
var ListView=require('./../../widget/ListView');
var BaseComponent=require('./../BaseComponent');

var Toolbar=require("./../../widget/Toolbar");

var EditorComponent=require('./../../widget/EditorComponent');
var ButtonComponent=require('./../../widget/ButtonComponent');
var HiddenSonSelectComponent=require('./../../widget/HiddenSonSelectComponent');

var Widget=require('./../../widget/WidgetComponent');

var role_index=-1;
var storehouse_index=-1;
var showArr = [6,7];
class MerchantsEditorComponent extends BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        var merchantsBean=JSON.parse(decodeURIComponent(this.props.params.merchantsBean));
        let role_id = merchantsBean.role_id;
        this.state = {
            roleBeans:[],
            storehouseBeans:[],
            merchantsBean:merchantsBean,
            merchants_account:merchantsBean.merchants_account,
            password:"",
            role_id:merchantsBean.role_id,
            merchants_name:merchantsBean.merchants_name,
            storehouse_id:merchantsBean.storehouse_id,
            show_son:!merchantsBean.storehouse_id?"-1":merchantsBean.storehouse_id==""?"-1":"true",
        };
    }

    componentDidMount() {
        this.getRoles();
        this.getStoreHouses();
    }

    getRoles(){
        this.getDataByPost(1,homeurl+"systemController.api?getAllRole",{})
    }
    getStoreHouses(){
        this.getDataByPost(4,homeurl+"goodsController.api?getGoodsStorehouses2NoPage");
    }
    insertMerchants(){

        if(!this.state.merchantsBean.merchants_account_id){
            if(this.state.merchants_account===''){
                    toast.show("账号不可为空");
                    return;
            }
            if(this.state.password===''){
                toast.show("密码不可为空");
                return;
            }
            if(role_index===-1){
                toast.show("请先选中角色");
                return;
            }
            if((role_index===6 ||role_index===7)&& storehouse_index===-1){
                toast.show("仓库人员请选择具体网点");
                return;
            }
            //改变storehouse_id的值
            if(!this.contains(showArr,role_index+1)){
                storehouse_index=-2;
            }
            console.log(this.state);
        this.getDataByPost(2,homeurl+"systemController.api?insertMerchantsAccount",
            {merchants_id:"-1",merchants_account:this.state.merchants_account,merchants_name:this.state.merchants_name,
                password:this.state.password,role_id:this.state.roleBeans[role_index].role_id,
                merchants_type:"1",
                storehouse_id: storehouse_index===-2?"":this.state.storehouseBeans[storehouse_index].storehouse_id,
                search_end_time:this.state.merchantsBean.search_end_time,
                search_start_time:this.state.merchantsBean.search_start_time
            });
        }else{
            if(role_index===-1){
                toast.show("请先选中角色");
                return;
            }
            //改变storehouse_id的值
            if(!this.contains(showArr,role_index+1)){
                storehouse_index=-2;
            }
            this.getDataByPost(3,homeurl+"systemController.api?updateMerchantsAccountDetail",
                {merchants_account_id:this.state.merchantsBean.merchants_account_id,
                    merchants_name:this.state.merchants_name,role_id:this.state.roleBeans[role_index].role_id,
                    city:this.state.merchantsBean.city,
                    storehouse_id:storehouse_index===-2?"":this.state.storehouseBeans[storehouse_index].storehouse_id,
                    search_end_time:this.state.merchantsBean.search_end_time,
                    search_start_time:this.state.merchantsBean.search_start_time
                });
        }
    }
    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    roleBeans:data
                })
                break;
            case 2:
                toast.show("添加成功");
                this.props.history.goBack();
                break;
            case 3:
                toast.show("修改成功");
                this.props.history.goBack();
                break;
            case 4:
                this.setState({
                    storehouseBeans:data
                })
        }
    }
    contains(arr, obj){
        let i = arr.length;
        while (i--) {
            if (arr[i] === obj) {
                return true;
            }
        }
        return false;
    }
    render(){
        return(
            <div>
                <Toolbar title="账号编辑" history={this.props.history}></Toolbar>
                <EditorComponent
                    visible={this.state.merchantsBean.merchants_account_id&&this.state.merchantsBean.merchants_account_id!=="0"?"false":"true"}
                    marginTop={20}
                    title="账号"
                    value={this.state.merchants_account}
                    onChange={(value)=>{
                        this.setState({
                            merchants_account:value
                        })
                    }}/>
                <EditorComponent
                    visible={this.state.merchantsBean.merchants_account_id&&this.state.merchantsBean.merchants_account_id!=="0"?"false":"true"}
                    marginTop={20}
                    title="密码"
                    type="password"
                    value={this.state.password}
                    onChange={(value)=>{
                        this.setState({
                            password:value
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="市"
                    value={this.state.merchantsBean.city}
                    onChange={(value)=>{
                        this.state.merchantsBean.city=value;
                        this.setState({
                            merchantsBean:this.state.merchantsBean
                        })
                    }}/>
                <Widget.Date
                    marginTop={20}
                    title="搜索开始时间"
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.state.merchantsBean.search_start_time}
                    onChange={(value)=>{
                        this.state.merchantsBean.search_start_time=value;
                        this.setState({
                            merchantsBean:this.state.merchantsBean
                        })
                    }}/>
                <Widget.Date
                    marginTop={20}
                    title="搜索结束时间"
                    format="YYYY-MM-DD HH:mm:ss"
                    value={this.state.merchantsBean.search_end_time}
                    onChange={(value)=>{
                        this.state.merchantsBean.search_end_time=value;
                        this.setState({
                            merchantsBean:this.state.merchantsBean
                        })
                    }}/>
                <EditorComponent
                    marginTop={20}
                    title="昵称"
                    value={this.state.merchants_name}
                    onChange={(value)=>{
                        this.setState({
                            merchants_name:value
                        })
                    }}/>
                <HiddenSonSelectComponent
                    marginTop={20}
                    title="角色"
                    show_value="role_name"
                    init_value={this.state.role_id}
                    select_value="role_id"
                    dataSource={this.state.roleBeans}
                    onChange={(rowID)=>{
                        role_index=rowID;
                    }}
                    show_son={this.state.show_son}
                    showArr ={showArr}
                    son_marginTop={20}
                    son_title="网点"
                    son_show_value="storehouse_name"
                    son_init_value={this.state.storehouse_id}
                    son_select_value="storehouse_id"
                    son_dataSource={this.state.storehouseBeans}
                    son_onChange={(rowID)=>{
                        storehouse_index=rowID;
                    }}
                />
                <ButtonComponent
                    marginTop={20}
                    marginLeft={100}
                    width={100}
                    value="保存"
                    onClick={()=>{
                        this.insertMerchants();
                    }}/>
            </div>
        )
    }


}

const styles = {
    div:{
        display:'flex',
        flex:1,
        height:50,
        alignItems:'center',
        marginLeft:300
    },
    input:{
        width:300,
        marginLeft:10,
        height:30,
        paddingLeft:10
    },
    font:{
        fontSize:15,
        width:100
    },
    button:{
        paddingLeft:20,
        paddingRight:20,
        height:30,
        alignItems:'center',
        justifyContent:'center',
        display:'flex',
        background:'blue'
    },
    buttonFont:{
        fontSize:15,
        color:'#ffffff'
    }
}

module.exports=MerchantsEditorComponent;
