package tts.moudle.api.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import okhttp3.Request;
import tts.moudle.api.TTSBaseApplication;

/**
 * Created by sjb on 2016/1/6.
 */
public class ImgUtils {
    /**
     * 下载网络图片 并配置
     *
     * @param Url       图片地址
     * @param imageView 需要配置的imgageview
     * @param drawable  默认图片和错误的图片
     */
    public static void setImageLoader(String Url, ImageView imageView, int drawable) {
        try {
            tts.moudle.api.utils.ImageLoader.getInstance(3, tts.moudle.api.utils.ImageLoader.Type.LIFO).loadImage(Url, imageView);
        } catch (Exception e) {
            imageView.setImageResource(drawable);
            e.getMessage();
        }
    }



    /**
     * 将资源文件 转化为Bitmap
     *
     * @param context
     * @return
     */
    public static Bitmap getBitMapFromRes(Context context, int res) {
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), res);
        return bmp;
    }

    /**
     * 将 bitmap转化为byte[]
     *
     * @param bm
     * @return
     */
    public static byte[] getByteFromBitMap(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * 将byte转化为bitmap
     *
     * @param b
     * @return
     */
    public static Bitmap getBitmapFromByte(byte[] b) {
        if (b != null && b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    /**
     * 得到本地或者网络上的bitmap url - 网络或者本地图片的绝对路径,比如:
     * <p/>
     * A.网络路径: url="http://blog.foreverlove.us/girl2.png" ;
     * <p/>
     * B.本地路径:url="file://mnt/sdcard/photo/image.png";
     * <p/>
     * C.支持的图片格式 ,png, jpg,bmp,gif等等
     *
     * @param url
     * @return
     */
    public static Bitmap getBitMapFromUrl(String url) {
        Bitmap bitmap = null;
        InputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new URL(url).openStream(), 9046);
            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
            out = new BufferedOutputStream(dataStream, 9046);
            copy(in, out);
            out.flush();
            byte[] data = dataStream.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            data = null;
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void copy(InputStream in, OutputStream out)
            throws IOException {
        byte[] b = new byte[1024];
        int read;
        while ((read = in.read(b)) != -1) {
            out.write(b, 0, read);
        }
    }

    public static void seyImg(String url, final ImageView img) {
        OkHttpUtils
                .get()//
                .url(url)//
                .build()//
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(Bitmap bitmap) {
                        img.setImageBitmap(bitmap);
                    }
                });
    }
}
