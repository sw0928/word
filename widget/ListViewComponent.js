/**
 * Created by shenjiabo on 16/7/21.
 */
import React,{Component} from 'react'
import ReactDOM from 'react-dom'

var orientation='vertical';
var PageComponent=require("./PageComponent");
var LinkComponent=require("./LinkComponent");

class ListViewComponent extends Component{
    constructor(props) {
        super(props);
        this.state={
            checked:0
        }
    };
    render(){
        let headerView=[];
        let view=[];
        if(this.props.data){
            if(!this.props.hideVisible||this.props.hideVisible!=='true'){
                for(let i=0;i<this.props.data.length;i++){
                    if(this.props.data[i].key==='-2') {//选择按钮
                        headerView.push(
                            <div style={{flex:this.props.data[i].flex,display:'flex',
                             flexWrap:'wrap',flexDirection: 'row',
                             alignItems:'center',justifyContent:'center',
                             borderBottomWidth:1,borderRightWidth:1,
                             borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                             borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                <input type="checkbox"
                                       checked={this.props.checked==='1'?true:false}
                                       onClick={()=>{
                                            if(!this.props.checked||this.props.checked+""==="0"){
                                               if(this.props.onChecked){
                                                    this.props.onChecked(-1,"1");
                                               }
                                            }else{
                                               if(this.props.onChecked){
                                                    this.props.onChecked(-1,"0");
                                               }
                                            }
                                       }}/>
                            </div>
                        )
                    }else {
                        headerView.push(
                            <div style={{flex:this.props.data[i].flex,display:'flex',
                                         flexWrap:'wrap',flexDirection: 'row',
                                         alignItems:'center',justifyContent:'center',
                                         borderBottomWidth:1,borderRightWidth:1,
                                         borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                         borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                <div style={{display:'flex',flex:1,flexDirection:'row',alignItems:'center',justifyContent:'center'}}>
                                    <p1 style={styles.tabP1}>{this.props.data[i].name}</p1>
                                </div>
                            </div>
                        )
                    }
                }
            }
            let viewTemp=[];
            if(this.props.dataSource!=null){
                for(let i=0;i<this.props.dataSource.length;i++){
                    viewTemp=[];
                    for(let j=0;j<this.props.data.length;j++){
                        if(this.props.data[j].key==='-2') {//选择按钮
                            viewTemp.push(
                                <div style={{flex:this.props.data[j].flex,display:'flex',
                                     flexWrap:'wrap',flexDirection: 'row',
                                     alignItems:'center',justifyContent:'center',
                                     borderBottomWidth:1,borderRightWidth:1,
                                     borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                     borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                    <input type="checkbox" checked={this.props.dataSource[i]["is_select"]==='1'?true:false}
                                        onClick={()=>{
                                            if(this.props.onChecked){
                                                if(this.props.dataSource[i]["is_select"]==='1'){
                                                    this.props.onChecked(i,"0");
                                                }else{
                                                    let is_all_check="1";
                                                    for(let j=0;j<this.props.dataSource.length;j++){
                                                        if((!this.props.dataSource[j]["is_select"]||this.props.dataSource[j]["is_select"]==='0')&&i!==j){//一个未选中 则全选就是未选中
                                                            is_all_check="0";
                                                            break;
                                                        }
                                                    }
                                                    if(is_all_check==="0"){//没有全部选中
                                                        this.props.onChecked(i,"1");
                                                    }else{//全部选中
                                                        this.props.onChecked(-1,"1");
                                                    }
                                                }
                                           }
                                        }}/>
                                </div>
                            )
                        }else if(this.props.data[j].key==='-1'){//操作框
                            let opertionView=[];
                            if(this.props.operationData){
                                for(let h=0;h<this.props.operationData.length;h++){
                                    opertionView.push(
                                        <div style={{display:!this.props.operationData[h].visible||this.props.operationData[h].visible==='true'?'flex':"none"
                                        ,marginLeft:10,alignItems:'center',justifyContent:'center'}}
                                                 onClick={()=>{this.props.operationClick(i,h)}}>
                                            <p1 style={{ fontSize:13,color:'blue'}}>[{this.props.operationData[h].title}]</p1>
                                        </div>
                                    )
                                }
                            }
                            viewTemp.push(
                                <div style={{flex:this.props.data[j].flex,display:'flex',
                                     flexWrap:'wrap',flexDirection: 'row',
                                     alignItems:'center',justifyContent:'center',
                                     borderBottomWidth:1,borderRightWidth:1,
                                     borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                     borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                    {this.props.renderOperation?this.props.renderOperation(i):null}
                                    {opertionView}
                                </div>
                            )
                        }else {
                            let title;
                            if(this.props.data[j].keys){
                                title=this.props.dataSource[i];
                                for(let m=0;m<this.props.data[j].keys.length;m++){
                                    title=title[this.props.data[j].keys[m]];
                                }
                            }else{
                                title=this.props.dataSource[i][this.props.data[j].key]
                            }
                            if(this.props.data[j].type==='img'){//图片展示
                                viewTemp.push(
                                    <div style={{flex:this.props.data[j].flex,display:'flex',
                                         flexWrap:'wrap',flexDirection: 'row',
                                         alignItems:'center',justifyContent:'center',
                                         borderBottomWidth:1,borderRightWidth:1,
                                         borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                         borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                        <img src={imgurl+this.props.dataSource[i][this.props.data[j].key]}
                                             style={{width:50,height:50}}/>
                                    </div>
                                )
                            }else if(this.props.data[j].type==='img1'){//图片展示
                                viewTemp.push(
                                    <div style={{flex:this.props.data[j].flex,display:'flex',
                                         flexWrap:'wrap',flexDirection: 'row',
                                         alignItems:'center',justifyContent:'center',
                                         borderBottomWidth:1,borderRightWidth:1,
                                         borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                         borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                        <img src={this.props.dataSource[i][this.props.data[j].key]}
                                             style={{width:50,height:50}}/>
                                    </div>
                                )
                            }else{
                                viewTemp.push(
                                    <div style={{flex:this.props.data[j].flex,display:'flex',
                                         flexWrap:'wrap',flexDirection: 'row',
                                         alignItems:'center',justifyContent:'center',
                                         borderBottomWidth:1,borderRightWidth:1,
                                         borderBottomColor:'#c8c8c8',borderRightColor:'#c8c8c8',
                                         borderBottomStyle:'solid',borderRightStyle:'solid',padding:10,}}>
                                        <p1 style={styles.tabP1}>{title}</p1>
                                    </div>
                                )
                            }
                        }
                    }
                    let childView=[];
                    if(this.props.renderChild){//子布局
                        childView.push(this.props.renderChild(i));
                    }
                    view.push(
                        <div>
                            <div style={{flex:1,display:'flex'}} >
                                {viewTemp}
                            </div>
                            {childView}
                        </div>
                    )
                }
            }

        }
        return(
            <div>
                <div style={{flex:1,display:'flex',justifyContent:'flex-end',
                    marginTop:this.props.renderAdd?20:0,
                    marginRight: this.props.marginRight?this.props.marginRight:10,}}>
                        {this.props.renderAdd ? this.props.renderAdd() : null}
                </div>
                <div style={{flex: 1,
                        display: 'flex',
                        borderLeftWidth: 1,
                        borderTopWidth: 1,
                        borderLeftColor: '#c8c8c8',
                        borderTopColor: '#c8c8c8',
                        borderLeftStyle: 'solid',
                        borderTopStyle: 'solid',
                        flexDirection: 'column',
                        background:this.props.background?this.props.background:"#ffffff",
                        marginLeft: this.props.marginLeft?this.props.marginLeft:10,
                        marginRight: this.props.marginRight?this.props.marginRight:10,
                        marginTop: this.props.marginTop?this.props.marginTop:10}}>
                    <div style={{flex:1,display:'flex'}}>
                        {headerView}
                    </div>
                    {view}
                </div>
                <div style={{display:this.props.page?'flex':"none"}}>
                    <PageComponent count={this.props.total}
                                   curIndex={this.props.page}
                                   onPage={(page)=>{
                                        if(this.props.onPage){
                                            this.props.onPage(page);
                                        }
                                   }}>
                    </PageComponent>
                </div>
            </div>
        );
    }
}


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
    }
}
module.exports= ListViewComponent;