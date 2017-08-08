package tts.moudle.api.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import tts.moudle.api.Host;
import tts.moudle.api.TTSBaseActivity;
import tts.moudle.api.bean.BarBean;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/3.
 */
public class ProtocolActivity extends TTSBaseActivity {
    private WebView WVH5;
    private ProgressBar PBH5;
    private String url = "";

    private String title;

    @SuppressWarnings("deprecation")
    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts_h5_activity);
        getIntentData();
        findAllView();
        initWebView();
    }

    private void initWebView(){
        WVH5.getSettings().setJavaScriptEnabled(true); // 加上这句话才能使用javascript方法
        WVH5.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WVH5.requestFocus();// 如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件�?
        /**
         * 用WebView显示图片，可使用这个参数 设置网页布局类型�? 1、LayoutAlgorithm.NARROW_COLUMNS
         * ：�?应内容大�? 2、LayoutAlgorithm.SINGLE_COLUMN : 适应屏幕，内容将自动缩放
         */
        WVH5.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);

        // 启动缓存
        WVH5.getSettings().setAppCacheEnabled(true);
        // 设置缓存模式
        WVH5.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

		/*WVH5.getSettings().setUseWideViewPort(true);//宽度自适应
        WVH5.getSettings().setLoadWithOverviewMode(true);*/


        //WVH5.getSettings().setSupportZoom(true);// 支持缩放
        WVH5.addJavascriptInterface(new JavaScriptInterface(this), "demo");// h5回调java函数

        if (Build.VERSION.SDK_INT >= 19) {// 页面finish后再发起图片加载
            WVH5.getSettings().setLoadsImagesAutomatically(true);
        } else {
            WVH5.getSettings().setLoadsImagesAutomatically(false);
        }
        /*
         * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		 * {//加载白块同时界面闪烁现象 关闭硬件加�? WVH5.setLayerType(View.LAYER_TYPE_SOFTWARE,
		 * null); }
		 */

        WVH5.setWebChromeClient(new WebChromeClient() {
            // 进度�?
            public void onProgressChanged(WebView view, int newProgress) {
                PBH5.setProgress(newProgress);
                if (newProgress == 100) {
                    // 这里是设置activity的标题， 也可以根据自己的�?��做一些其他的操作
                    PBH5.setVisibility(View.GONE);
                } else {
                    PBH5.setProgress(newProgress);
                }
            }
        });

        WVH5.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                PBH5.setVisibility(View.VISIBLE);
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {// 页面finish后再发起图片加载
                if (!WVH5.getSettings().getLoadsImagesAutomatically()) {
                    WVH5.getSettings().setLoadsImagesAutomatically(true);
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // handler.proceed(); // 接受信任�?��网站的证�?
                Toast.makeText(ProtocolActivity.this, "", Toast.LENGTH_LONG);
                handler.cancel(); // 默认操作 不处
                // handler.handleMessage(null); // 可做其他处理
            }
        });

        WVH5.setOnLongClickListener(new View.OnLongClickListener() {// 屏蔽系统长按复制 粘贴事件
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        Map<String, String> extraHeaders = new HashMap<String, String>();
        extraHeaders.put("Referer", "http://www.google.com");// 防止盗链
        WVH5.loadUrl(url, extraHeaders);
    }


    private void getIntentData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        if (url == null) {
            url = Host.hostUrl + "wap.php?m=wap&c=siteinfo&a=protocol";
        }
        title = intent.getStringExtra("title");
    }

    private void findAllView() {
        setTitle(new BarBean().setMsg(title == null ? "用户协议" : title));
        WVH5 = (WebView) findViewById(R.id.WVH5);
        PBH5 = (ProgressBar) findViewById(R.id.PBH5);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (WVH5.canGoBack() && event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            WVH5.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class JavaScriptInterface {
        Context mContext;

        /**
         * Instantiate the interface and set the context
         */
        JavaScriptInterface(Context c) {
            mContext = c;
        }

        /**
         * Show a toast from the web page 由Js调用执行Native本地Java方法
         */
        @JavascriptInterface
        public void showToast(String toast) {
            // Log.d("TAG", "Js Invoker Native Function");
            WVH5.loadUrl("javascript:init('abc')");
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

    }
}
