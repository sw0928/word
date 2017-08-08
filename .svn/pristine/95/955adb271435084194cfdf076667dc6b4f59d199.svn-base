/**
 * Created by hy.
 *
 * dataSource 数据源列表
 * flex 列宽
 * show_value 展示的字段名
 * save_value 保存用的字段名
 */

import React,{Component} from 'react'
import ReactDOM from 'react-dom'
var PageComponent=require("./PageComponent");

class CheckListComponent extends Component{
    constructor(props) {
        super(props);
        this.checkedindex = new Set() // 保存字段
        this.resetCheck()
        this.isfirstMount = 0
    }

    componentDidMount(){

    }

    componentDidUpdate(){
        this.resetCheck()
    }

    render(){
        let view=[]; // 左侧表格
        if(this.props.dataSource){
            // 加载原始选择数据
            if (this.isfirstMount == 0 && this.props.dataSourceHad.length>0){
                var dataSourceHads = this.props.dataSourceHad
                for (var i = 0 ; i < dataSourceHads.length ; ++i){
                    this.checkedindex.add(dataSourceHads[i][this.props.save_value])
                }
                this.isfirstMount = 1
                this.fillCheckBtn()
            }
            // 加载左侧列表
            var _this = this;
            for(let i=0;i<this.props.dataSource.length;i++){
                var title = this.props.dataSource[i][this.props.show_value]
                var save_value = this.props.dataSource[i][this.props.save_value]
                view.push(<div id={i} data-nid={save_value} style={{flex:this.props.flex,display:'flex',flexWrap:'wrap',flexDirection: 'row',
                                     alignItems:'center',justifyContent:'center',
                                     borderTopWidth:1,borderLeftWidth:1,borderBottomWidth:1,borderRightWidth:1,
                                     borderTopColor:'#c8c8c8',borderLeftColor:'#c8c8c8',borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                     borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}
                               onMouseOver={function(inc){return(()=>{_this.onchecking(title,inc)})}(save_value)}
                               onMouseOut={function(inc){return(()=>{_this.onuncheck(title,inc)})}(save_value)}
                               onClick={function(inc){return(()=>{_this.oncheck(title,inc)})}(save_value)} ><p1>{title}</p1></div>)
            }
        }
        else{
            view.push(<div>数据为空</div>)
        }

        return(
            <div style={{display:'flex',flexDirection:'column',alignItems:"left",marginTop:20,marginLeft:this.props.marginLeft?this.props.marginLeft:20}}>
                <div styles ={{flex:this.props.flex,display:'flex',
                    flexWrap:'nowrap',flexDirection: 'column',
                    alignItems:'center',justifyContent:'center',
                    borderTopWidth:1,borderLeftWidth:1,borderBottomWidth:1,borderRightWidth:1,
                    borderTopColor:'#c8c8c8',borderLeftColor:'#c8c8c8',borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                    borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                    <div style={{width:this.props.width?this.props.width:(this.props.title?100:0),display:'flex',justifyContent:'flex-end',}}>
                        <p1 style={styles.tabP1}>{this.props.title}</p1>
                    </div>
                    <div styles = {{flex:this.props.flex,display:'flex'}}>
                        <div style= {{borderTopWidth:1,borderLeftWidth:1,borderBottomWidth:1,borderRightWidth:1,
                            borderTopColor:'#c8c8c8',borderLeftColor:'#c8c8c8',borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                            marginLeft: 0, marginTop: 20}}>
                            {view}
                            <div>
                                <PageComponent count={this.props.total}
                                               curIndex={this.props.page}
                                               onPage={(page)=>{
                                                   if(this.props.onPage){
                                                       this.props.onPage(page)
                                                   }
                                               }}>
                                </PageComponent>
                            </div>
                        </div>
                    </div>
                </div>
                <div id={this.props.checklist_id}>
                    <p1>{this.props.sectitle}</p1>
                </div>
            </div>
        )
    }

    // 鼠标移上项目
    onchecking(i,savinc) {
        var ee_q = $("[data-nid=" + savinc + "]")
        if(ee_q) {
            if (!ee_q.hasClass("checked")) {
                ee_q.addClass("checking")
                ee_q.css("background-color","lightgrey")
            }
        }
    }

    // 鼠标点击项目
    oncheck(i,savinc) {
        var ee_q = $("[data-nid=" + savinc + "]")
        if(ee_q) {
            if (!ee_q.hasClass("checked")) {
                ee_q.removeClass("checking")
                ee_q.addClass("checked")
                ee_q.css("background-color","grey")
                this.checkedindex.add(savinc)
                var ee_name = ee_q.find('p1').text()
                $("#" + this.props.checklist_id).append($('<button style="' + btnstyle_temp +'" delid="' + savinc + '" >' + ee_name + '</button>'))
                this.onSelectChange(this.checkedindex)
            }else {
                ee_q.removeClass("checked")
                ee_q.addClass("checking")
                ee_q.css("background-color","lightgrey")
                this.checkedindex.delete(savinc)
                $("#" + this.props.checklist_id).find('[delid=' + savinc + ']').remove()
                this.onSelectChange(this.checkedindex)
            }
        }
    }

    // 鼠标离开项目
    onuncheck(i,savinc){
        var ee_q = $("[data-nid=" + savinc + "]")
        if(ee_q) {
            if (!ee_q.hasClass("checked")) {
                ee_q.removeClass("checking")
                ee_q.css("background-color","")
            }
        }
    }

    // 换页时重置选中
    resetCheck(){
        var ee_q = $('[data-nid]')
        ee_q.removeClass("checked")
        ee_q.css("background-color","")
        // 填色
        for (let i = 0;i < this.props.dataSource.length;++i ){
            var inc = this.props.dataSource[i][this.props.save_value]
            if (this.checkedindex.has(inc)) {
                var ee_qc = $("[data-nid=" + inc + "]")
                ee_qc.addClass("checked")
                ee_qc.css("background-color", "grey")
            }
        }
    }

    // 填充选择项列表
    fillCheckBtn(){
        var dataSourceHads = this.props.dataSourceHad
        for (var i = 0 ; i < dataSourceHads.length ; ++i){
            var ee_name = $('[data-nid]').find('p1').text()
            var deel = dataSourceHads[i][this.props.save_value]
            if($("#" + this.props.checklist_id).find("[delid=" + deel + "]").length == 0){
                $("#" + this.props.checklist_id).append($('<button style="' + btnstyle_temp + '" delid="' + deel + '">' + dataSourceHads[i][this.props.show_value] + '</button>'))
            }
        }
    }

    // 调用上级方法改变state
    onSelectChange(select_sets){
        if(this.props.onSelectChange){
            var es = ''
            select_sets.forEach(
                function (e) {
                    es += e + ',';
                }
            )
            if(es.length > 0){
                es = es.substring(0,es.length-1)
            }
            this.props.onSelectChange(es)
        }
    }

}

// 按钮样式
const btnstyle_temp = 'border:none;color: white;font-family:Arial;padding: 10px 24px;text-align: center;text-decoration: none;display: inline-block;font-size: 18px;margin: 4px 2px;cursor: pointer'





const styles = {
    item: {
        flex: 1,
        display: 'flex',
        borderLeftWidth: 1,
        borderTopWidth: 1,
        borderLeftColor: '#c8c8c8',
        borderTopColor: '#c8c8c8',
        borderLeftStyle: 'solid',
        borderTopStyle: 'solid',
        flexDirection: 'column',
        marginLeft: 10,
        marginRight: 10,
        marginTop: 10
    },
    tabColumn: {
        flex: 1,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#c8c8c8',
        borderRightColor: '#c8c8c8',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabRow: {
        flex: 1,
        display: 'flex',
        flexWrap: 'wrap',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        borderBottomWidth: 1,
        borderRightWidth: 1,
        borderBottomColor: '#c8c8c8',
        borderRightColor: '#c8c8c8',
        borderBottomStyle: 'solid',
        borderRightStyle: 'solid',
        padding: 10,
    },
    tabP1: {
        fontSize: 13,
        wordBreak: 'break-all'
    },
    floatleft:{
        float: 'left',
        display:'inline'
    },
    secBtn:{
        border: 'none',
        color: 'white',
        'font-family':'Arial',
        padding: '10px 24px',
        'text-align': 'center',
        'text-decoration': 'none',
        display: 'inline-block',
        'font-size': '18px',
        margin: '4px 2px',
        cursor: 'pointer'
    }

}


module.exports= CheckListComponent;