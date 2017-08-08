/**
 * Created by shenjiabo on 16/7/21.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
var storage = require('key-storage');

class TTSBaseComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
    }

    showTip(msg){
        toast.show(msg+"");
    }

    isNull(value){
        if(!value||value===''){
            return true;
        }else{
            return false;
        }
    }


    /**
     * get方式请求数据
     * @param index
     * @param url
     */
    getDataByGet(index,url,{dataOnly=false}={}){
        $.get(url, function (data) {
            var response = eval("(" + data + ")");
            if (dataOnly) {//不做任何处理
                this.doSuccess(index, data);
            } else {
                if (response.status === 'ok') {
                    this.doSuccess(index,response.data);                                                                    1``
                } else if (response.status === 'error') {
                    this.doFailed(index, response.error);
                } else {
                    this.doPending(index, response.error);
                }
            }
        }.bind(this));
    }
    /**
     * post方式请求数据
     * @param index
     * @param url
     * @param parameters
     */
    getDataByPost(index,url,params,{dataOnly=false,type=1}={}):void{
        var info=storage.get("merchantsAccountBean");
        var merchantsAccountBean=JSON.parse((info===null?"{}":info));

        /* 统一验证token */
        if(params==null){
            params={};
        }

        if(params["sort"]&&isNaN(params["sort"])){
            toast.show("权重非法");
            return;
        }
        params["merchants_account_id1"]=merchantsAccountBean.merchants_account_id+"";
        params["merchants_token"]=merchantsAccountBean.merchants_token+"";

        $.post(url,params, function(data) {
            var response = eval("(" + data + ")");
            if (dataOnly) {//不做任何处理
                this.doSuccess(index, data);
            } else {
                if (response.status === 'ok') {
                    if(type===1){
                        this.doSuccess(index,response.data);
                    }else if(type===2){
                        this.doSuccess(index,response);
                    }
                } else if (response.status === 'error') {
                    this.doFailed(index, response.error);
                } else {
                    this.doPending(index, response.error);
                }
            }
        }.bind(this));
    }
    getDataByJson(index,url,parameters,{ContentType="application/x-www-form-urlencoded",dataOnly=false}={}):void{
        var data='';
        if(ContentType==='application/x-www-form-urlencoded'){
            data=parameters;
        }else if(ContentType==='application/json'){
            data=JSON.stringify(parameters);
        }
        var options = {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                //json形式
                'Content-Type': ContentType
            },

            body: data
        };
        fetch(url,options)
            .then((response) => response.json())
            .then((response) => {
                if(dataOnly){//不做任何处理
                    this.doSuccess(index,response);
                }else {
                    if (response.status === 'ok') {
                        this.doSuccess(index, response.data);
                    } else if (response.status === 'error') {
                        this.doFailed(index, response.error);
                    } else {
                        this.doPending(index, response.error);
                    }
                }
            })
            .catch((error) => {
                this.doFailed(index,error.toString());
            });
    };

    /**
     * 表单提交数据
     * @param index
     * @param url
     * @param parameters
     * @param files
     */

    uploadFile(index,url,fileId) {
        var params={};
        $.ajaxFileUpload({
            url:url,
            secureuri:false,
            fileElementId:[fileId],// file标签的id
            dataType: 'JSON',// 返回数据的类型
            data:params,// 一同上传的数据
            success: function (data, status) {
                var response=eval("(" + data + ")");
                if (response.status === 'ok') {
                    this.doSuccess(index, response.data);
                } else if (response.status === 'error') {
                    this.doFailed(index, response.error);
                } else {
                    this.doPending(index, response.error);
                }
            }.bind(this),
            error: function (data, status, e) {
                console.log(JSON.stringify(e));
                this.doFailed(index,"上传失败");
            }.bind(this)
        });
    }


    /*
     * 访问数据错误返回回调
     * @param index
     * @param error
     */
    doFailed(index,error):void{
        //showTipShort(error)
        toast.show(error);
    }

    /**
     * 访问数据正确返回回调
     * @param index
     * @param data
     */
    doSuccess(index,data):void{

    }

    /**
     * 访问数据待处理回调
     * @param index
     * @param error
     */
    doPending(index,error):void{
        if(error==='token failed'){
            //this.props.history.push("/");
            window.location.href= htmlurl+"index.html";
        }else{
            toast.show(error);
        }
    }


}

module.exports=TTSBaseComponent;
