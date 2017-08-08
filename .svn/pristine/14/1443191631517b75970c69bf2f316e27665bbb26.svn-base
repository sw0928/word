import {
    PixelRatio,
    Dimensions
} from 'react-native';

var Host=require('../Host');

/**
 * 动态计算宽度实际的像素值
 * values:单位px
 */
export function getWidthReal(values):number{
    //getPixelSizeForLayoutSize  dp转化为px 返回是整数型
    //Dimensions.get('window').width 手机的分辨率  单位dp
    //BaseWidth 设计图基础尺寸
    var realVlues=values*((PixelRatio.getPixelSizeForLayoutSize(Dimensions.get('window').width)/BaseWidth).toFixed(2));
    return realVlues/PixelRatio.get()
}

/**
 * 动态计算高度实际的像素值
 * values:单位px
 */
export function getHeightReal(values):number{
    var realVlues=values*((PixelRatio.getPixelSizeForLayoutSize(Dimensions.get('window').height)/BaseHeight).toFixed(2));
    return realVlues/PixelRatio.get()
}
