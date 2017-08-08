/**
 * Created by shenjiabo on 16/7/28.
 */

/**
 * 验证手机号
 * @param msg
 */
export function verMobile(tel):boolean {
    var reg = /^0?1[3|4|5|8|7][0-9]\d{8}$/;
    if (reg.test(tel)) {
        return true;
    }else{
        return false;
    }

}

//判断输入的字符是否为整数
export function verInteger(str)
{
    if(str.length!=0){
        reg=/^[-+]?\d*$/;
        if(!reg.test(str)){
            return false
            //alert("对不起，您输入的整数类型格式不正确!");//请将“整数类型”要换成你要验证的那个属性名称！
        }
    }

    return true;
}

/**
 * 验证密码
 * @param msg
 */
export function verPassword(tel):boolean {
    var reg = /^[a-zA-Z]\w{5,17}$/;
    if (reg.test(tel)) {
        return true;
    }else{
        return false;
    }

}
