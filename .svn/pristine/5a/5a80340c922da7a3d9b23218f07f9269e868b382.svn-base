/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'

import ReactDOM from 'react-dom'
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router'
import {toast} from 'react-android-style-toast';

var Widget=require("./../../widget/WidgetComponent");

class BrandComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            brandBeans:[],
            visible:false,
            brand_index:1,
            baseData:[],
            detailBean:{},
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'-2'},
                {name:"ID",flex:1,key:'brand_id'},
                {name:"品牌名称",flex:1,key:'brand_name'},
                {name:"图标",flex:1,key:"brand_img",type:'img'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:1.5,key:"-1"}
            ]
        })
        this.getBrands();
    }

    getBrands(){
        this.getDataByPost(1,homeurl+"goodsController.api?getAllBrands",{})
        this.getDataByPost(3,homeurl+"systemController.api?getSystemDetailShows",{detail_type:'brand_list_detail'});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    brandBeans:data
                });
                break;
            case 2:
                toast.show("删除成功");
                this.getBrands();
                break;
            case 3:
                this.setState({
                    detailBean:JSON.parse(data)
                })
                break;
        }
    }

    deleteBrand(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"goodsController.api?deleteBrand",
            {brand_id:this.state.brandBeans[this.state.brand_index].brand_id});
    }


    render(){
        return(
            <div style={{background:'#ffffff',display:'flex',flexDirection:'column'}}>
                <Widget.Tip visible={this.state.visible} msg="确定删除?"
                              onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                              onPress={()=>{
                                  this.deleteBrand();
                              }}></Widget.Tip>
                <Widget.Toolbar title="品牌管理" history={this.props.history}></Widget.Toolbar>
                <div style={{marginTop:20,display:'flex',justifyContent:'flex-end',flex:1,alignItems:'center'}}>
                    <Widget.ImgButton
                        visible={this.state.detailBean.load}
                        marginRight={20}
                        value="批量导入"
                        action={homeurl+"goodsController.api?loadBrandExcel"}
                        onSuccess={(data)=>{
                             toast.show("操作成功");
                             this.setState({
                                page:1
                             })
                             this.getBrands();
                        }}/>
                    <Widget.ImgButton
                        visible={this.state.detailBean.loadimg}
                        marginRight={20}
                        value="批量图片"
                        action={homeurl+"goodsController.api?uploadBrandImgs"}
                        onSuccess={(data)=>{
                             toast.show("操作成功");
                        }}/>

                    <Widget.Button
                        visible={this.state.detailBean.down}
                        marginRight={20}
                        value="下载模板"
                        onClick={()=>{
                            window.open(imgurl+"/excel/brand.xlsx");
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/brand_editor/"+encodeURIComponent(JSON.stringify({})))
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.brandBeans}
                    operationData={[{title:"编辑",type:1},{title:"网页编辑",type:2},{title:"删除",type:1}]}
                    checked={this.state.checked}
                    onChecked={(i,checked)=>{
                        if(i===-1){
                            for(let j=0;j<this.state.brandBeans.length;j++){
                                this.state.brandBeans[j].is_select=checked;
                            }
                            this.setState({
                                checked:checked
                            })
                        }else{
                            this.state.brandBeans[i].is_select=checked;
                            this.setState({
                                brandBeans:this.state.brandBeans,
                                checked:checked==="0"?checked:this.state.checked,
                            });
                        }
                    }}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/brand_editor/"+encodeURIComponent(JSON.stringify(this.state.brandBeans[rowID])));
                            break
                            case 1:
                                this.props.history.push("/brand_detail_editor/"+encodeURIComponent(this.state.brandBeans[rowID].brand_url));
                            break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    brand_index:rowID
                                })
                            break;
                        }
                    }}/>

            </div>
        );
    }

}

const styles = {
    item:{
        flex:1,
        display:'flex',
        borderLeftWidth:1,
        borderTopWidth:1,
        borderLeftColor:'#efefef',
        borderTopColor:'#efefef',
        borderLeftStyle:'solid',
        borderTopStyle:'solid',
        flexDirection:'column',
        marginLeft:10,
        marginRight:10,
        marginTop:10
    },
    tabColumn: {
        flex: 1,
        display:'flex',
        flexDirection: 'column',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabRow: {
        flex: 1,
        display:'flex',
        flexWrap:'wrap',
        flexDirection: 'row',
        alignItems:'center',
        justifyContent:'center',
        borderBottomWidth:1,
        borderRightWidth:1,
        borderBottomColor:'#efefef',
        borderRightColor:'#efefef',
        borderBottomStyle:'solid',
        borderRightStyle:'solid',
        padding:10,
    },
    tabP1:{
        fontSize:15,
        wordBreak:'break-all'
    }
};

module.exports=BrandComponent;
