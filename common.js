/**
 * Created by shenjiabo on 16/8/31.
 */
var homeurl="http://localhost:8080/Shop_sw/";
var htmlurl="http://www.valubio.com/";
var imgurl='http://www.valubio.com/';
var company_name='sw';

/**
 * 链接参数
 */

function getParameter(index,name){
    var str =decodeURIComponent(window.location.search); // location.search是从当前URL的?号开始的字符串
    // 例如：http://www.51job.com/viewthread.jsp?tid=22720
    // 它的search就是?tid=22720
    str = str.substring(1, str.length);
    var arr = str.split('&');

    if (arr[index].indexOf(name) != -1) {
        var pos_start = arr[index].indexOf(name) + name.length + 1;
        var pos_end = arr[index].indexOf("&", pos_start);
        if (pos_end == -1) {
            return arr[index].substring(pos_start);
        } else {
            
        }
    }
}


function getDataByPost(index,url,params,dataOnly){
    /* 统一验证token */
    if(params==null){
        params={};
    }
    $.post(url,params, function(data) {
        if(dataOnly=='1'){
            doSuccess(index,data);
        }else{
            var result = eval("(" + data + ")");
            if (result.status == "ok") {
                doSuccess(index,result.data);
            } else if (result.status == "error"){

            }else{

            }
        }
    });
}

