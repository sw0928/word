/**
 * Created by shenjiabo on 17/1/11.
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require('./../../widget/WidgetComponent');
import Upload from 'rc-upload';

class GoodsDetailPictureComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态

        this.state = {
            goodsBean:this.props.goodsBean,
            goodsImgBeans:[],
            uploaderProps :{
                action: homeurl+'goodsController.api?uploadGoodsImg',
                data: {},
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
            }
        };
    }

    componentDidMount() {
        this.getDataByPost(1,homeurl+"goodsController.api?getGoodsImgs",{goods_id:this.state.goodsBean.goods_id})
    }
    insertPicture(){
        if(this.state.goodsImgBeans.length<=0){
            toast.show("至少选择一张图片");
            return;
        }
        this.getDataByPost(2,homeurl+"goodsController.api?insertGoodsImg",{goods_id:this.state.goodsBean.goods_id,
            imgs:JSON.stringify(this.state.goodsImgBeans),});
    }

    doSuccess(index,data){
        switch(index){
            case 1:
                this.setState({
                    goodsImgBeans:data
                })
                break;
            case 2:
                toast.show("保存成功");
                break;
        }
    }
    render(){
        return(
            <div>
                <Widget.Button
                    marginTop={20}
                    marginLeft={100}
                    value="保存"
                    onClick={()=>{
                        this.insertPicture();
                    }}/>
                <div style={{display:'flex',flex:1,alignItems:'center',marginLeft:20}}>
                    <div style={{width:120,display:'flex',
                        justifyContent:'flex-end',marginLeft:20}}>
                        <p1 style={{fontSize:13}}>展示图片</p1>
                    </div>
                    <div style={{display:'flex',flexDirection:'row',flexWrap:'wrap'}}>
                        <Widget.ListView
                            style={{display:'flex',flexDirection:'row',flexWrap:'wrap'}}
                            dataSource={this.state.goodsImgBeans}
                            renderRow={(rowID)=>{
                                return(
                                    <div style={{display:'flex',flexDirection:'column'}}>
                                        <div style={{width:80,height:40,marginLeft:10,}}>
                                            <input style={{height:30,width:80}} placeholder="权重"
                                            value={this.state.goodsImgBeans[rowID].sort}
                                            onChange={(e)=>{
                                                this.state.goodsImgBeans[rowID].sort=e.target.value;
                                                this.setState({
                                                    goodsImgBeans:this.state.goodsImgBeans,
                                                })
                                            }}/>
                                        </div>
                                        <div style={{width:80,height:80,marginLeft:10}}>
                                            <img src={imgurl+this.state.goodsImgBeans[rowID].goods_img} style={{width:80,height:80}}/>
                                        </div>
                                        <div style={{height:40,width:80,display:'flex',
                                            justifyContent:'center',alignItems:'center'}}
                                            onClick={()=>{
                                                    this.state.goodsImgBeans.splice(rowID,1);
                                                    this.setState({
                                                        goodsImgBeans:this.state.goodsImgBeans,
                                                    });
                                            }}>
                                            <p1 style={{fontSize:15}}>删除</p1>
                                        </div>
                                    </div>
                                );
                            }}>
                        </Widget.ListView>
                        <div style={{display:'flex',flexDirection:'column',height:160,alignItems:'center',justifyContent:'center'}}>
                            <Upload {...this.state.uploaderProps} ref="inner" style={{outline:'none'}}
                                                                  onSuccess={(data)=>{
                                                if(data.status==='ok'){
                                                    this.setState({
                                                        goodsImgBeans:[{sort:'1',"goods_img":data.data}].concat(this.state.goodsImgBeans),
                                                    })
                                                }else{
                                                    toast.show(data.error);
                                                }
                                            }}>
                                <div style={{width:80,height:80,marginLeft:10}}>
                                    <img src='./images/add.jpg' style={{width:80,height:80}}/>
                                </div>
                            </Upload>
                        </div>
                    </div>

                </div>
            </div>

        )
    }
}


module.exports=GoodsDetailPictureComponent;