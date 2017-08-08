/**
 * Created by shenjiabo on 17/2/16.
 */
$(document).ready(function() {
    var a=decodeURIComponent(getParameter(0,"body")).split("+");

    getDataByPost(1,homeurl+"/orderInterfaces.api?payAlipayWapSuccessOrder",{order_pay_no:a[1]},false);
});

function doSuccess(index,data) {
    window.location.href=homeurl+"/core.html#/wddd";
}

