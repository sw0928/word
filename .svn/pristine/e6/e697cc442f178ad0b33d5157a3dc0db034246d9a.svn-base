package tts.moudle.api.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;

import tts.moudle.api.adapter.CustomPicturePopupwindowAdapter;
import tts.moudle.api.bean.ImgBean;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/12.
 */
public class CustomPicturePopupwindow extends PopupWindow {
    private Context context;
    private List<ImgBean> imgBeans;
    View view = null;
    private OnSelectDirListener listener;

    public CustomPicturePopupwindow(Context context, View view, List<ImgBean> data) {
        super(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                true);
        this.view = view;
        this.imgBeans = data;
        this.context = context;

        onCreate();
    }

    private void onCreate() {
        ListView dirList = (ListView) view.findViewById(R.id.dirList);
        CustomPicturePopupwindowAdapter customPicturePopupwindowAdapter = new CustomPicturePopupwindowAdapter(context, imgBeans);
        dirList.setAdapter(customPicturePopupwindowAdapter);
        dirList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.selected(imgBeans.get(position));
                }
                dismiss();
            }
        });
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        // 这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置PopupWindow的弹出和消失效果
        // popupWindow.setAnimationStyle(R.style.popupAnimation);
    }


    public interface OnSelectDirListener {
        void selected(ImgBean imgBean);
    }

    ;

    public void setOnSelectDirListener(OnSelectDirListener onSelectDirListener) {
        this.listener = onSelectDirListener;
    }
}
