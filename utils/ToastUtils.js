import Toast from 'react-native-root-toast';

/**
 * 短时间展示提示消息
 * @param msg
 */
export function showTipShort(msg):void {
    Toast.show(msg, {
        duration: Toast.durations.SHORT,
        position: Toast.positions.CENTER,
    });
}

/**
 * 长时间展示消息
 * @param msg
 */
export function showTipLong(msg):void {
    Toast.show(msg, {
        duration: Toast.durations.LONG,
        position: Toast.positions.CENTER,
    });
}

