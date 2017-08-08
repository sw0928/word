/**
 * Created by shenjiabo on 16/7/20.
 */

/**
 * 时间差(单位天)
 * @param startTime
 * @param endTime
 */
export function getTimeDifferenceDay(startTime,endTime):number{
    var end_date = new Date(endTime.replace(/-/g, "\/"));//将字符串转化为时间
    var sta_date = new Date(startTime.replace(/-/g, "\/"));
    //showTipShort(end_date+"=="+sta_date);
    var num = ((end_date-sta_date)/(1000*3600*24));//求出两个时间的时间差，这个是天数
    //var days = parseInt(Math.ceil(num));//转化为整天（小于零的话剧不用转了）
    return num;
}

/**
 * 时间差(单位时)
 * @param startTime
 * @param endTime
 */
export function getTimeDifferenceHour(startTime,endTime):number{
    var end_date = new Date(endTime.replace(/-/g, "\/"));//将字符串转化为时间
    var sta_date = new Date(startTime.replace(/-/g, "\/"));
    //showTipShort(end_date+"=="+sta_date);
    var num = ((end_date-sta_date)/(1000*3600));//求出两个时间的时间差，这个是天数
    //var days = parseInt(Math.ceil(num));//转化为整天（小于零的话剧不用转了）
    return num;
}

/**
 * 时间差(单位分)
 * @param startTime
 * @param endTime
 */
export function getTimeDifferenceMinute(startTime,endTime):number{
    var end_date = new Date(endTime.replace(/-/g, "\/"));//将字符串转化为时间
    var sta_date = new Date(startTime.replace(/-/g, "\/"));
    //showTipShort(end_date+"=="+sta_date);
    var num = ((end_date-sta_date)/(1000*60));//
    //var days = parseInt(Math.ceil(num));//转化为整天（小于零的话剧不用转了）
    return num;
}

/**
 * 时间差(单位秒)
 * @param startTime
 * @param endTime
 */
export function getTimeDifferenceSecond(startTime,endTime):number{
    var end_date = new Date(endTime.replace(/-/g, "\/"));//将字符串转化为时间
    var sta_date = new Date(startTime.replace(/-/g, "\/"));
    //showTipShort(end_date+"=="+sta_date);
    var num = ((end_date.getTime()-sta_date.getTime())/(1000));//
    //var days = parseInt(Math.ceil(num));//转化为整天（小于零的话剧不用转了）
    return num;
}

/**
 * 时间差(单位耗秒)
 * @param startTime
 * @param endTime
 */
export function getTimeDifferenceMilliSecond(startTime,endTime):number{
    var num = ((endTime-startTime));//
    return num;
}