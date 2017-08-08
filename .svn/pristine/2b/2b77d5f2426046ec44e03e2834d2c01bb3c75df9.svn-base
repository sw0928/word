package tts.moudle.api.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.util.List;

import okhttp3.Request;
import tts.moudle.api.adapter.CustomPicturePopupwindowAdapter;
import tts.moudle.api.bean.ImgBean;
import tts.moudle.api.bean.UpdateBean;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.utils.SystemUtils;
import tts.moudle.api.widget.ProgressBarUpdate;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/15.
 */
public class AutoUpdatePopupwindow extends PopupWindow {
    private Context context;
    View view = null;

    private ProgressBarUpdate progressBarUpdate;
    private UpdateBean updateBean;

    public AutoUpdatePopupwindow(Context context, View view, UpdateBean updateBean) {
        super(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                true);
        this.view = view;
        this.context = context;
        this.updateBean = updateBean;
        onCreate();
    }

    private void onCreate() {
        findAllView();
    }

    private void findAllView() {
        progressBarUpdate = (ProgressBarUpdate) view.findViewById(R.id.progressBarUpdate);
        progressBarUpdate.setOnClickListener(new ProgressBarUpdate.OnClickListener() {
            @Override
            public void doClick() {
                loadFile(1, updateBean.getApp_url(), Environment.getExternalStorageDirectory().toString(), "apk.apk", progressBarUpdate);
            }
        });
    }

    /**
     * 下载文件
     *
     * @param index    访问标识
     * @param url      接口地址
     * @param path     文件保存路径
     * @param fileName 文件名
     */
    protected void loadFile(final int index, String url, String path, String fileName, final ProgressBarUpdate mProgressBar) {
        if (!SystemUtils.isNetAvailable(context)) {
            CustomUtils.showTipShort(context, "网络不可用");
        }
        OkHttpUtils
                .get()//
                .tag(this)
                .url(url)//
                .build()//
                .execute(new FileCallBack(path, fileName)//
                {
                    @Override
                    public void inProgress(float progress) {
                        if (mProgressBar != null) {
                            mProgressBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        CustomUtils.showTipShort(context, "下载失败");
                    }

                    @Override
                    public void onResponse(File file) {
                        doSuccess(index, file);
                    }
                });
    }

    protected void doSuccess(int index, File file) {
        installApk(file);
    }

    protected void installApk(File file) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        ((Activity) context).startActivityForResult(intent, 2000);
    }

}

