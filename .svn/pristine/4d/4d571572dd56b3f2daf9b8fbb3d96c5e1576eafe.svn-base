package tts.moudle.api.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import tts.moudle.api.TTSBaseActivity;
import tts.moudle.api.adapter.CustomPictureAdapter;
import tts.moudle.api.bean.BarBean;
import tts.moudle.api.bean.ImgBean;
import tts.moudle.api.bean.MenuItemBean;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.utils.SystemUtils;
import tts.moudle.api.widget.CustomPicturePopupwindow;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/11.
 * <p/>
 * 自定义的图片选择器
 */
public class CustomPictureSelectorView extends TTSBaseActivity {
    private GridView pictureList;
    private ProgressDialog mProgressDialog;
    private int totalCount = 0;
    CustomPictureAdapter customPictureAdapter;
    /**
     * 图片数量最多的文件夹
     */
    private File mImgDir;

    /**
     * 存储文件夹中的图片数量
     */
    private int mPicsSize;
    /**
     * 临时的辅助类，用于防止同一个文件夹的多次扫描
     */
    private HashSet<String> mDirPaths = new HashSet<String>();
    /**
     * 扫描拿到所有的图片文件夹
     */
    private List<ImgBean> mImageFloders = new ArrayList<ImgBean>();

    private List<ImgBean> imgBeans;
    private TextView id_total_count;

    private File cameraFile;

    private int maxCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_picture_selector_activity);
        maxCount=getIntent().getIntExtra("maxCount",0);
        findAllView();
        applyPermission(1, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    protected void startApplyPermissions(int index) {
        super.startRequestData(index);
        switch (index) {
            case 1:
                getImages();
                break;
            case 2:
                photoPicture();
                break;
        }
    }

    private void photoPicture() {
        String path = mImgDir.getAbsolutePath() + "/" + System.currentTimeMillis() + "pic.jpg";
        cameraFile = new File(path);
        SystemUtils.startPhotoPicture(CustomPictureSelectorView.this, 2000, cameraFile);
    }

    private void findAllView() {
        setTitle(new BarBean().setMsg("选择图片"));
        addMenu(new MenuItemBean().setTitle("确定"));
        pictureList = (GridView) findViewById(R.id.pictureList);
        id_total_count = (TextView) findViewById(R.id.id_total_count);
    }

    public void doClick(View v) {
        if (v.getId() == R.id.RlAllPicture) {
            CustomPicturePopupwindow customPicturePopupwindow = new CustomPicturePopupwindow(this, LayoutInflater.from(this).inflate(R.layout.custom_picture_popupwindow, null), mImageFloders);
            customPicturePopupwindow.showAsDropDown(toolbar);
            customPicturePopupwindow.setOnSelectDirListener(new CustomPicturePopupwindow.OnSelectDirListener() {
                @Override
                public void selected(ImgBean imgBean) {
                    mImgDir = new File(imgBean.getDir());
                    mHandler.sendEmptyMessage(0x110);
                }
            });
        }
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mProgressDialog.dismiss();
            id_total_count.setText(totalCount + "");
            if (mImgDir != null) {
                imgBeans = new ArrayList<ImgBean>();
                for (String str : mImgDir.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String filename) {
                        if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".jpeg"))
                            return true;
                        return false;
                    }
                })) {
                    ImgBean imgBean = new ImgBean();
                    imgBean.setPath(mImgDir.getAbsolutePath() + "/" + str);
                    imgBean.setSelect(false);
                    imgBeans.add(imgBean);
                }
                customPictureAdapter = new CustomPictureAdapter(CustomPictureSelectorView.this, imgBeans,maxCount);
                pictureList.setAdapter(customPictureAdapter);
                pictureList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        applyPermission(2, Manifest.permission.CAMERA);
                    }
                });
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 2000:
                if (resultCode == RESULT_OK) {
                    if (cameraFile != null) {
                        ImgBean imgBean = new ImgBean();
                        imgBean.setPath(cameraFile.getAbsolutePath());
                        imgBean.setSelect(false);
                        imgBeans.add(0, imgBean);
                        customPictureAdapter.notifyDataSetChanged();
                        SystemUtils.startUpdatePicture(CustomPictureSelectorView.this, cameraFile);
                    }
                }
                break;
        }
    }

    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中 完成图片的扫描，最终获得jpg最多的那个文件夹
     */
    private void getImages() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            CustomUtils.showTipLong(this, "暂无外部存储");
            return;
        }
        // 显示进度条
        mProgressDialog = ProgressDialog.show(this, null, "正在加载...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String firstImage = null;

                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = CustomPictureSelectorView.this.getContentResolver();
                // 只查询jpeg和png的图片
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

                Log.e("TAG", mCursor.getCount() + "");// TODO 打印图片数量
                while (mCursor.moveToNext()) {
                    // 获取图片的路径
                    String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    Log.e("TAG", path);
                    // 拿到第一张图片的路径
                    if (firstImage == null)
                        firstImage = path;
                    // 获取该图片的父路径名
                    File parentFile = new File(path).getParentFile();
                    if (parentFile == null)
                        continue;
                    String dirPath = parentFile.getAbsolutePath();
                    ImgBean imgBean = null;
                    // 利用一个HashSet防止多次扫描同一个文件夹（不加这个判断，图片多起来还是相当恐怖的~~）
                    if (mDirPaths.contains(dirPath)) {
                        continue;
                    } else {
                        mDirPaths.add(dirPath);
                        // 初始化imageFloder
                        imgBean = new ImgBean();
                        imgBean.setDir(dirPath);
                        imgBean.setFirstImagePath(path);
                    }

                    if (parentFile.list() == null)
                        continue;
                    int picSize = parentFile.list(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String filename) {
                            if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".jpeg"))
                                return true;
                            return false;
                        }
                    }).length;
                    totalCount += picSize;

                    imgBean.setCount(picSize);
                    mImageFloders.add(imgBean);

                    if (picSize > mPicsSize) {
                        mPicsSize = picSize;
                        mImgDir = parentFile;
                    }
                }
                mCursor.close();
                // 扫描完成，辅助的HashSet也就可以释放内存了
                mDirPaths = null;
                // 通知Handler扫描图片完成
                mHandler.sendEmptyMessage(0x110);
            }
        }).start();

    }


    @Override
    protected void doMenu(MenuItemBean menuItemBean) {
        super.doMenu(menuItemBean);
        List<ImgBean> imgBeansTemp = new ArrayList<ImgBean>();
        if (imgBeans != null) {
            for (int i = 0; i < imgBeans.size(); i++) {
                if (imgBeans.get(i).isSelect()) {
                    imgBeansTemp.add(imgBeans.get(i));
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("imgBeans", (Serializable) imgBeansTemp);
        setResult(RESULT_OK, intent);
        finish();
    }


}
