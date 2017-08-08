/**
 * Created by shenjiabo on 16/8/4.
 */
import React,{Component, } from 'react'
import ReactDOM from 'react-dom'
var ListView=require('./ListView');

var data=''
class CityPickerComponent extends Component{
    // 构造
    constructor(props) {
        super(props);
        // 初始状态
        this.state = {
            source:[{name:""}],
            sourceArea:[""],
            addressBeans:[],
            provinceIndex:1,
            cityBeans:[],
            cityIndex:1,
            areaBeans:[],
            areaIndex:1,
        };
    }


    componentDidMount() {
        $.getJSON("./widget/data/city.json",(data)=>{
            this.setState({
                addressBeans: this.state.source.concat(data).concat(this.state.source),
                cityBeans:this.state.source.concat(data[0].cityList).concat(this.state.source),
                areaBeans:this.state.sourceArea.concat(data[0].cityList[0].areaList).concat(this.state.sourceArea)
            });
        })
    }

    render() {
        return (
            <div style={{display:this.props.visible?"flex":'none',flex:1,
                position:'fixed',top:0,left:0,right:0,bottom:0,flexDirection:'column'}}>
                <div style={{flex:1,background:'#323232',opacity:0.5}}
                    onClick={()=>{
                        this.props.onClose();
                    }}></div>
                <div style={{background:"#ffffff",height:40,display:"flex",justifyContent:'flex-end',alignItems:'center'}}>
                    <div style={{flex:1,display:'flex',justifyContent:"center",alignItems:'center'}}>
                        <p1 style={{marginLeft:10}}>选择地址</p1>
                    </div>
                    <p1 style={{marginRight:10}}
                        onClick={()=>{
                            this.props.onPress(this.state.addressBeans[this.state.provinceIndex].name,this.state.cityBeans[this.state.cityIndex].name,this.state.areaBeans[this.state.areaIndex]);
                        }}>确定</p1>
                </div>
                <div style={{background:"#efefef",height:1}}></div>
                <div style={{display:'flex',height:120,background:'#ffffff'}}>
                        <ListView
                            id="d1"
                            onScroll={this.onProvinceScroll.bind(this)}
                            onMouseOut={()=>{
                                    document.getElementById('d1').scrollTop=(this.state.provinceIndex-1)*40;
                            }}
                            style={{flex:1,height:120,background:'#ffffff',overflow:'scroll'}}
                            dataSource={this.state.addressBeans}
                            renderRow={(rowID)=>{
                            return(
                                <div style={{height:40,display:'flex',
                                    alignItems:"center",justifyContent:'center',
                                    background:this.state.provinceIndex===rowID?"#323232":"#ffffff"}}>
                                   <p1 style={{fontSize:14,color:this.state.provinceIndex===rowID?"#ffffff":"#323232"}}>{this.state.addressBeans[rowID].name}</p1>
                                </div>
                            );
                        }}/>
                    <ListView
                        id="d2"
                        onScroll={this.onCityScroll.bind(this)}
                        onMouseOut={()=>{
                                document.getElementById('d2').scrollTop=(this.state.cityIndex-1)*40;
                            }}
                        style={{flex:1,height:120,background:'#ffffff',overflow:'scroll'}}
                        dataSource={this.state.cityBeans}
                        renderRow={(rowID)=>{
                            return(
                                <div style={{height:40,display:'flex',
                                    alignItems:"center",justifyContent:'center',
                                    background:this.state.cityIndex===rowID?"#323232":"#ffffff"}}>
                                   <p1 style={{fontSize:14,color:this.state.cityIndex===rowID?"#ffffff":"#323232"}}>{this.state.cityBeans[rowID].name}</p1>
                                </div>
                            );
                        }}/>
                    <ListView
                        id="d3"
                        onScroll={this.onAreaScroll.bind(this)}
                        onMouseOut={()=>{
                                document.getElementById('d3').scrollTop=(this.state.areaIndex-1)*40;
                            }}
                        style={{flex:1,height:120,background:'#ffffff',overflow:'scroll'}}
                        dataSource={this.state.areaBeans}
                        renderRow={(rowID)=>{
                            return(
                                <div style={{height:40,display:'flex',
                                    alignItems:"center",justifyContent:'center',
                                    background:this.state.areaIndex===rowID?"#323232":"#ffffff"}}>
                                   <p1 style={{fontSize:14,color:this.state.areaIndex===rowID?"#ffffff":"#323232"}}>{this.state.areaBeans[rowID]}</p1>
                                </div>
                            );
                        }}/>
                </div>
                <div style={{flex:1,background:'#323232',opacity:0.5}}
                     onClick={()=>{
                        this.props.onClose();
                    }}></div>
            </div>
        );
    }

    onProvinceScroll(e){
        let el = e.target;
        //console.log((Math.floor(el.scrollTop/40)+1)!==this.state.provinceIndex)
        if((Math.floor(el.scrollTop/40)+1)!==this.state.provinceIndex){
            this.setState({
                provinceIndex:Math.floor(el.scrollTop/40)+1,
                cityBeans:this.state.source.concat(this.state.addressBeans[Math.floor(el.scrollTop/40)+1].cityList).concat(this.state.source),
                cityIndex:1,
                areaIndex:1,
                areaBeans:this.state.sourceArea.concat(this.state.addressBeans[Math.floor(el.scrollTop/40)+1].cityList[0].areaList).concat(this.state.sourceArea),
            });
        }

        // console.log(Math.floor(el.scrollTop/40));
        // console.log(this.state.addressBeans[Math.floor(el.scrollTop/40)+1].name);
    }

    onCityScroll(e){
        let el = e.target;
        if((Math.floor(el.scrollTop/40)+1)!==this.state.cityIndex){
            this.setState({
                cityIndex:Math.floor(el.scrollTop/40)+1,
                areaIndex:1,
                areaBeans:this.state.sourceArea.concat(this.state.cityBeans[Math.floor(el.scrollTop/40)+1].areaList).concat(this.state.sourceArea),
            });
        }
    }

    onAreaScroll(e) {
        let el = e.target;
        if ((Math.floor(el.scrollTop / 40) + 1) !== this.state.areaIndex) {
            this.setState({
                areaIndex: Math.floor(el.scrollTop / 40) + 1
            });
        }
    }
}

module.exports=CityPickerComponent;
