package tts.moudle.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tts.moudle.api.bean.ImgBean;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.utils.ImgUtils;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/13.
 */
public class CustomPicturePopupwindowAdapter extends BaseAdapter {
    private List<ImgBean> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private int selectCount = 0;//选中的数量
    private int maxCount = 0;//最大选择的数量

    public CustomPicturePopupwindowAdapter(Context context, List<ImgBean> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }


    /**
     * 组件集合，对应list.xml中的控件
     *
     * @author Administrator
     */
    public final class Zujian {
        public TextView id_dir_item_name;
        public TextView id_dir_item_count;
        public ImageView id_dir_item_image;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Zujian zujian = null;
        if (convertView == null) {
            zujian = new Zujian();
            // 获得组件，实例化组件
            convertView = layoutInflater.inflate(R.layout.custom_picture_popupwindow_item, null);
            zujian.id_dir_item_name = (TextView) convertView.findViewById(R.id.id_dir_item_name);
            zujian.id_dir_item_count = (TextView) convertView.findViewById(R.id.id_dir_item_count);
            zujian.id_dir_item_image = (ImageView) convertView.findViewById(R.id.id_dir_item_image);
            convertView.setTag(zujian);
        } else {
            zujian = (Zujian) convertView.getTag();
        }
        zujian.id_dir_item_count.setText(data.get(position).getCount() + "");
        ImgUtils.setImageLoader(data.get(position).getFirstImagePath(), zujian.id_dir_item_image, 0);
        return convertView;
    }
}

