/**
 * Created by shenjiabo on 16/12/10.
 *
 * 帮助中心
 */
import React, {Component} from 'react'
import ReactDOM from 'react-dom'
var Widget = require('./../../widget/WidgetComponent');

/**
 * 商品分类(2.0版本)
 */
class HelpClassComponent extends Widget.BaseComponent {
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            parent_id: this.props.parent_id?this.props.parent_id:this.props.params.parent_id,
            level:this.props.level?this.props.level:this.props.params.level,
            baseData: [],
            htmlBeans: [],
            help_index:-1,
        };
    }

    componentDidMount() {
        this.setState({
            baseData:[
                {name:"ID",flex:1,key:'html_id'},
                {name:"名称",flex:2,key:'html_name'},
                {name:"类型",flex:2,key:'html_type'},
                {name:"权重",flex:1,key:'sort'},
                {name:"操作",flex:2,key:"-1"}
            ]
        })
        this.getHelpClasss()
    }

    getHelpClasss() {
        this.getDataByPost(1, homeurl + "othersController.api?getHelpClasss",
            {parent_id: this.state.parent_id});
    }

    deleteHelpDetail(){
        this.getDataByPost(2, homeurl + "othersController.api?deleteHelpDetail"
            , {html_id: this.state.htmlBeans[this.state.help_index].html_id});
    }

    doSuccess(index, data) {
        switch (index) {
            case 1:
                this.setState({
                    htmlBeans: data,
                })
                break;
            case 2:
                this.showTip("删除成功");
                this.setState({
                    page:1,
                });
                this.getHelpClasss();
                break;
        }
    }

    render() {
        return (
            <div>
                <Widget.Toolbar title={this.state.level+"级分类"} history={this.props.history}/>
                <div style={{display:'flex',justifyContent:'flex-end',marginTop:20}}>
                    <Widget.Button
                        marginRight={20}
                        value="添加"
                        onClick={()=>{
                            this.props.history.push("/setting_help_editor/"+
                            encodeURIComponent(JSON.stringify({parent_id:this.state.parent_id})));
                        }}/>
                </div>
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
                                 this.deleteHelpDetail();
                              }}/>
                <Widget.ListViewComponent
                    data={this.state.baseData}
                    dataSource={this.state.htmlBeans}
                    operationData={[{title:"子分类",type:0},{title:"编辑",type:1},{title:"删除",type:2},{title:"图文详情",type:1}]}
                    operationClick={(rowID,index)=>{
                        switch (index){
                            case 0:
                                if(parseInt(this.state.level%2)){
                                    this.props.history.push("/setting_help_html2/"+this.state.htmlBeans[rowID].html_id+"/"+(parseInt(this.state.level)+1));
                                }else{
                                    this.props.history.push("/setting_help_html/"+this.state.htmlBeans[rowID].html_id+"/"+(parseInt(this.state.level)+1));
                                }
                            break
                            case 1:
                                this.props.history.push("/setting_help_editor/"+encodeURIComponent(JSON.stringify(this.state.htmlBeans[rowID])));
                            break;
                            case 2:
                                this.setState({
                                    visible:true,
                                    help_index:rowID
                                })
                            break;
                            case 3:
                                if(this.state.htmlBeans[rowID].html_type==="1"){
                                    this.showTip("此类型无详情");
                                }else{
                                    this.props.history.push("/setting_help_html_editor/"+encodeURIComponent(this.state.htmlBeans[rowID].html_url));
                                }
                            break;
                        }
                    }}/>
            </div>
        )
    }
}

module.exports = HelpClassComponent;