/**
 * Created by shenjiabo on 16/12/10.
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class GoodsClassComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            parent_id: this.props.parent_id?this.props.parent_id:this.props.params.parent_id,
            level:this.props.level?this.props.level:this.props.params.level,
            menuBeans: [],
            menu_index:-1,

        };
    }

    componentDidMount() {
        this.getMenu();
    }

    getMenu(){
        this.getDataByPost(1, homeurl + "othersController.api?getWxMenus", {parent_id:this.state.parent_id});
    }
    
    deleteWXMenu(){
        this.getDataByPost(3, homeurl + "othersController.api?deleteWXMenu"
            , {wx_menu_id: this.state.menuBeans[this.state.menu_index].wx_menu_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    menuBeans: data,
                })
                break;
            case 2:
                this.showTip("重置成功");
                break;
            case 3:
                this.showTip("删除成功");
                this.getMenu();
                break;
        }
    }

    settingWXMenu(){
        this.getDataByPost(2, homeurl + "othersController.api?settingWXMenu", {});
    }
    render() {
        return (
            <div>
                <Widget.Toolbar title={this.state.level+"级菜单"} history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="菜单重置"
                        onClick={()=>{
                            this.setState({
                                setVisible:true
                            })
                        }}/>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/setting_wx_menu_editor/"+
                            encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id})));
                        }}/>
                </div>
                <Widget.Tip visible={this.state.setVisible} msg="确定重置?"
                            onClose={()=>{
                                this.setState({
                                    setVisible:false
                                })
                              }}
                            onPress={()=>{
                                 this.setState({
                                        setVisible:false
                                 })
                                 this.settingWXMenu();
                              }}/>
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
                                 this.deleteWXMenu();
                              }}/>
                <Widget.ListViewComponent
                    data={[
                            {name:"ID",flex:1,key:'wx_menu_id'},
                            {name:"菜单名称",flex:2,key:'menu_name'},
                            {name:"菜单连接",flex:2,key:'menu_url'},
                            {name:"权重",flex:1,key:'sort'},
                            {name:"操作",flex:4,key:"-1"}
                        ]}
                    dataSource={this.state.menuBeans}
                    operationData={[{title:"子分类",type:0},{title:"编辑",type:1},{title:"删除",type:2}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                if(parseInt(this.state.level%2)){
                                    this.props.history.push("/setting_wx_menu2/"+this.state.menuBeans[rowID].wx_menu_id+"/"+(parseInt(this.state.level)+1));
                                }else{
                                    this.props.history.push("/setting_wx_menu/"+this.state.menuBeans[rowID].wx_menu_id+"/"+(parseInt(this.state.level)+1));
                                }
                                break
                            case 1:
                                this.props.history.push("/setting_wx_menu_editor/"+encodeURIComponent(JSON.stringify(this.state.menuBeans[rowID])));
                                break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    menu_index:rowID
                                })
                                break;
                        }
                    }}/>
            </div>
        )
    }
}

module.exports = GoodsClassComponent;