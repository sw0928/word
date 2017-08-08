/**
 * Created by shenjiabo on 16/8/17.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var Widget=require("./../../widget/WidgetComponent");

class RoleComponent extends Widget.BaseComponent{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            roleBeans:[],
            visible:false,
            role_index:0,
            baseData:[],
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'role_id'},
                {name:"名称",flex:1,key:'role_name'},
                {name:"操作",flex:1,key:"-1"}
            ]
        })
        this.getRoles();
    }

    getRoles(){
        this.getDataByPost(1,homeurl+"systemController.api?getAllRole",{})
    }

    doSuccess(index,data){
        switch (index){
            case 1:
                this.setState({
                    roleBeans:data
                })
                break;
            case 2:
                this.showTip("删除成功");
                this.getRoles();
                break;
        }
    }

    deleteRole(){
        this.setState({
            visible:false,
        })
        this.getDataByPost(2,homeurl+"systemController.api?deleteRole",
            {role_id:this.state.roleBeans[this.state.role_index].role_id});
    }

    render(){
        return(
            <div style={{background:'#ffffff',flex:1,height:'100%'}}>
                <Widget.TipComponent visible={this.state.visible} msg="确定删除?"
                                     onClose={()=>{
                                         this.setState({
                                             visible:false
                                         })
                                     }}
                                     onPress={()=>{
                                         this.deleteRole();
                                     }}/>
                <Widget.Toolbar title="角色列表" history={this.props.history}/>
                <div style={{display:'flex',flex:1,justifyContent:"flex-end"}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/role_editor/"+encodeURIComponent(JSON.stringify({})));
                        }}/>
                </div>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.roleBeans}
                    operationData={[{title:"权限设置",type:2},{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                this.props.history.push("/role_authority/"+JSON.stringify(this.state.roleBeans[rowID].role_id));
                                break;
                            case 1:
                                this.props.history.push("/role_editor/"+encodeURIComponent(JSON.stringify(this.state.roleBeans[rowID])));
                                break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    role_index:rowID
                                })
                                break;
                        }
                    }}/>
            </div>
        );
    }
}
module.exports=RoleComponent;
