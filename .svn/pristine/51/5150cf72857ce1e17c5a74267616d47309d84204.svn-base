package tts.moudle.api.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Request;
import tts.moudle.api.Host;
import tts.moudle.api.activity.AutoUpdatePopupwindow;
import tts.moudle.api.bean.UpdateBean;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/15.
 */
public class UpdateUtils {
    public static void checkUpdate(final Context context, final View view) {
        checkUpdate(context, view, true,true);
    }

    public static void checkUpdate(final Context context, final View view,final boolean isCancel) {
        checkUpdate(context, view, true,isCancel);
    }

    public static void checkUpdate(final Context context,final boolean isShowTip, final View view) {
        checkUpdate(context, view, isShowTip,true);
    }

    /**
     * @param context
     * @param view      任意View
     * @param isShowTip 是否展示 已是最新提示
     * @param isCancel 当用戶按返回鍵，是否取消下载
     */
    public static void checkUpdate(final Context context, final View view, final boolean isShowTip,final boolean isCancel) {
        try {
            PackageInfo packInfo = context.getPackageManager().getPackageInfo(context
                    .getPackageName(), 0);
            if (!SystemUtils.isNetAvailable(context)) {
                CustomUtils.showTipShort(context, "无网络");
            }
            OkHttpUtils.get()
                    .url(Host.hostUrl + "api.php?m=Api&c=index&a=upapp" + "&name=" + packInfo.versionName + "&num=" + packInfo.versionCode
                            + "&type=android&for=user")
                    .tag(context)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Request request, Exception e) {
                            CustomUtils.showTipShort(context, "网络异常");
                        }

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                if (jsonObject.getString("status").equals("1")) {
                                    String data = jsonObject.getString("data");
                                    JSONObject jsonObject1 = new JSONObject(data);
                                    String msgData = jsonObject1.getString("msgData");
                                    UpdateBean updateBean = new Gson().fromJson(msgData, UpdateBean.class);
                                    if (updateBean.getUpdate().equals("1")) {
                                        final AutoUpdatePopupwindow popupWindow = new AutoUpdatePopupwindow(context, View.inflate(context, R.layout.auto_update_view, null), updateBean);
                                        popupWindow.setBackgroundDrawable(new BitmapDrawable());
                                        popupWindow.setFocusable(true);
                                        // 这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
                                        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                                        // 设置PopupWindow的弹出和消失效果
                                        // popupWindow.setAnimationStyle(R.style.popupAnimation);
                                        popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                                        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                            @Override
                                            public void onDismiss() {
                                                if(isCancel){
                                                    OkHttpUtils.getInstance().cancelTag(popupWindow);
                                                }
                                            }
                                        });
                                    } else {
                                        if (isShowTip) {
                                            CustomUtils.showTipShort(context, "已最新版本");
                                        }
                                    }
                                } else {
                                    if (isShowTip) {
                                        CustomUtils.showTipShort(context, "已最新版本");
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                CustomUtils.showTipShort(context, "网络异常");
                            }
                        }
                    });
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            CustomUtils.showTipShort(context, "网络异常");
        }

    }
}
