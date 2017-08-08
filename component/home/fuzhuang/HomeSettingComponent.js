/**
 * Created by shenjiabo on 17/1/9.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require("./../../../widget/WidgetComponent");

class HomeSettingComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            activityBeans:[],
            typeBeans:[{name:"好货推荐",id:"recommend"},{name:"配饰精品",id:"accessories"}
                        ,{name:"活动热销",id:"hot"},{name:"特惠专场",id:"discount"}],
            home_type:Widget.storage.get("home_type")?Widget.storage.get("home_type"):"recommend",
            stateBeans:[{name:"上架",id:"1"},{name:"下架",id:"0"}],
            activity_state:"0",
            activity_index:-1,
        }
    }

    componentDidMount() {
        this.getHomeActivitys(this.state.home_type);
    }
    getHomeActivitys(home_type){
        this.getDataByPost(1,homeurl+"goodsController.api?getHomeActivitys",{home_type:home_type});
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                let activity_state="0";
                if(data.length>0){
                    activity_state=data[0].activity_state;
                }
                this.setState({
                    activityBeans:data,
                    activity_state:activity_state
                })
                break;
            case 2:
                this.showTip("保存成功");
                break;
            case 3:
                this.showTip("删除成功");
                this.getHomeActivitys(this.state.home_type);
                break;
        }
    }

    updateHomeActivityState(){
        this.getDataByPost(2,homeurl+"goodsController.api?updateHomeActivityState",
            {home_type:this.state.home_type,activity_state:this.state.activity_state});
    }

    deleteHomeActivity(){
        this.getDataByPost(3,homeurl+"goodsController.api?deleteHomeActivity",
            {activity_id:this.state.activityBeans[this.state.activity_index].activity_id});
    }

    render(){
        return(
            <div>
                <Widget.Toolbar title="首页设置" history={this.props.history}></Widget.Toolbar>
                <Widget.Tip visible={this.state.visible} msg="确定删除?"
                            onClose={()=>{
                                this.setState({
                                    visible:false
                                })
                              }}
                            onPress={()=>{
                                 this.setState({
                                        visible:false
                                 })
                                 this.deleteHomeActivity();
                              }}/>
                <div style={{display:'flex',flex:1,marginTop:20,alignItems:'center'}}>
                    <Widget.SelectV2
                        dataSource={this.state.typeBeans}
                        title="类型"
                        init_value={this.state.home_type}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                        this.setState({
                            home_type:this.state.typeBeans[rowID].id
                        })
                        Widget.storage.set("home_type",this.state.typeBeans[rowID].id);
                        this.getHomeActivitys(this.state.typeBeans[rowID].id);
                    }}/>
                    <Widget.SelectV2
                        dataSource={this.state.stateBeans}
                        title="上下架"
                        init_value={this.state.activity_state}
                        select_value="id"
                        show_value="name"
                        onChange={(rowID)=>{
                            this.setState({
                                activity_state:this.state.stateBeans[rowID].id
                            });
                        }}/>
                    <Widget.Button
                        marginLeft={20}
                        value="保存"
                        onClick={()=>{
                            this.updateHomeActivityState();
                        }}/>
                </div>
                <div style={{display:'flex',flex:1,marginTop:20,alignItems:'center',justifyContent:'flex-end'}}>
                    <Widget.Button
                        marginRight={20}
                        visible={this.state.home_type==='hot'||"discount"===this.state.home_type?"true":"false"}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/fuzhuang_home_editor/"+
                                    encodeURIComponent(JSON.stringify({home_type:this.state.home_type
                                    ,activity_state:this.state.activity_state,activity_type:"goods"})));
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={[{name:"ID",flex:1,key:'activity_id'},
                    {name:"名称",flex:1,key:'activity_name'},
                    {name:"图片",flex:1,key:"activity_img",type:'img'},
                    {name:"权重",flex:1,key:"sort"},
                    {name:"操作",flex:2,key:"-1"}]}
                    dataSource={this.state.activityBeans}
                    operationData={this.state.home_type==='hot'||"discount"===this.state.home_type?[{title:"编辑",type:1},{title:"删除",type:2}]:[{title:"编辑",type:1}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/fuzhuang_home_editor/"+encodeURIComponent(JSON.stringify(this.state.activityBeans[rowID])));
                            break;
                            case 1:
                                this.setState({
                                    visible:true,
                                    activity_index:rowID
                                })
                            break;
                        }
                    }}/>
            </div>
        )
    }
}
module.exports=HomeSettingComponent;