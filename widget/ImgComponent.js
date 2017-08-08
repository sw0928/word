/**
 * Created by shenjiabo on 16/10/18.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
import {toast} from 'react-android-style-toast';
import Upload from 'rc-upload';

class ImgComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            uploaderProps :{
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
            <div style={{display:!this.props.visible||this.props.visible==='true'?'flex':"none",alignItems:'center',
            marginLeft:this.props.marginLeft?this.props.marginLeft:0,
            marginTop:this.props.marginTop?this.props.marginTop:0}}>
                <div style={styles.tabTitle}>
                    <p1 style={styles.font}>{this.props.title}</p1>
                </div>
                <Upload {...this.state.uploaderProps}
                    ref="inner"
                    style={{outline:'none'}}
                    action={this.props.url}
                    data={this.props.data}
                    onSuccess={(data)=>{
                            if(data.status==='ok'){
                                if(this.props.onSuccess){
                                    this.props.onSuccess(data.data);
                                }
                            }else{
                                toast.show(data.error);
                            }
                        }}>
                    <img src={this.props.src}
                         style={{marginLeft:10,width:this.props.imgWidth?this.props.imgWidth:80,height:this.props.imgHeight?this.props.imgHeight:80}}/>
                </Upload>
                <p1 style={{display:(this.props.is_must==='true'?"flex":"none"),color:'red',marginLeft:10}}>*</p1>
            </div>
        )
    }
}

const styles = {
    tab:{
        display:'flex',
        alignItems:'center',
    },
    tabTitle:{
        width:100,
        display:'flex',
        justifyContent:'flex-end',
    },
    font:{
        fontSize:13,
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
    },
}

module.exports=ImgComponent;