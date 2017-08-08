/**
 * Created by shenjiabo on 16/10/19.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
import Upload from 'rc-upload';

class ButtonComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            uploaderProps :{
                data:{},
                headers: {
                    Authorization: 'xxxxxxx',
                },
                multiple: false,
                beforeUpload(file) {
                    console.log('beforeUpload', file.name);
                },
                onStart: (file) => {
                    console.log('onStart', file.name);
                },
                onProgress(step, file) {
                    console.log('onProgress', Math.round(step.percent), file.name);
                },
                onError(err) {
                    console.log('onError', err);
                    toast.show("上传失败");
                },
            },
        };
    }
    render(){
        return(
            <Upload
                {...this.state.uploaderProps}
                action={this.props.action}
                ref="inner"
                style={{outline:'none'}}
                onSuccess={(data)=>{
                    if(data.status==='ok'){
                        if(this.props.onSuccess){
                            this.props.onSuccess(data)
                        }
                    }else{
                        toast.show(data.error);
                    }
                }}>
                <div style={{
                        background:this.props.background?this.props.background:'#000000',
                        width:this.props.width?this.props.width:"auth",
                        height:this.props.height?this.props.height:30,
                        marginLeft:this.props.marginLeft?this.props.marginLeft:0,
                        marginTop:this.props.marginTop?this.props.marginTop:0,
                        marginRight:this.props.marginRight?this.props.marginRight:0,
                        paddingLeft:10,paddingRight:10,display:!this.props.visible||this.props.visible==='true'?'flex':"none",
                        alignItems:'center',justifyContent:'center',
                        borderRadius:5}}
                        onClick={()=>{
                            if(this.props.onClick){
                                this.props.onClick();
                            }
                        }}>
                    <p1 style={{color:'#ffffff',fontSize:15}}>{this.props.value}</p1>
                </div>
            </Upload>
        )
    }
}


module.exports=ButtonComponent;