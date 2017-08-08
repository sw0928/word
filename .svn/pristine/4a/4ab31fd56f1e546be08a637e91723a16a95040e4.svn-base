package tts.moudle.api.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import tts.moudle.api.bean.ImgBean;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.utils.ImageLoader;
import tts.moudle.api.utils.ImgUtils;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/1/11.
 */
public class CustomPictureAdapter extends BaseAdapter {
    private List<ImgBean> data;
    private LayoutInflater layoutInflater;
    private Context context;
    private int selectCount = 0;//选中的数量
    private int maxCount = 0;//最大选择的数量

    public CustomPictureAdapter(Context context, List<ImgBean> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public CustomPictureAdapter(Context context, List<ImgBean> data, int maxCount) {
        this.maxCount = maxCount;
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
        public ImageView id_item_image;
        public ImageButton id_item_select;
    }

    @Override
    public int getCount() {
        return data == null ? 1 : data.size() + 1;
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
    public View getView(final int index, View convertView, ViewGroup parent) {
        final int position = index - 1;
        Zujian zujian = null;
        if (convertView == null) {
            zujian = new Zujian();
            // 获得组件，实例化组件
            convertView = layoutInflater.inflate(R.layout.custom_picture_selector_item, null);
            zujian.id_item_image = (ImageView) convertView.findViewById(R.id.id_item_image);
            zujian.id_item_select = (ImageButton) convertView.findViewById(R.id.id_item_select);
            convertView.setTag(zujian);
        } else {
            zujian = (Zujian) convertView.getTag();
        }
        if (index == 0) {
            zujian.id_item_select.setVisibility(View.GONE);
            zujian.id_item_image.setImageResource(R.drawable.photo);
        } else {
            zujian.id_item_select.setVisibility(View.VISIBLE);
            final ImageButton id_item_select = (ImageButton) convertView.findViewById(R.id.id_item_select);
            if (data.get(position).isSelect()) {
                zujian.id_item_select.setBackgroundResource(R.drawable.photopick_pictures_selected);
                id_item_select.setTag("1");
                selectCount++;
            } else {
                zujian.id_item_select.setBackgroundResource(R.drawable.photopick_picture_unselected);
                id_item_select.setTag("0");
            }
            //ImgUtils.setImageLoader(data.get(position).getPath(), zujian.id_item_image, R.drawable.photopick_pictures_no);
            Glide.with(context).load(data.get(position).getPath()).into(zujian.id_item_image);
            zujian.id_item_select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.get(position).isSelect()) {
                        data.get(position).setSelect(false);
                    } else {
                        if (maxCount != 0) {
                            if (selectCount >= maxCount) {
                                CustomUtils.showTipLong(context, "最多可选择" + maxCount + "张图片");
                                return;
                            } else {
                                data.get(position).setSelect(true);
                            }
                        } else {
                            data.get(position).setSelect(true);
                        }
                    }
                    selectCount = 0;
                    notifyDataSetChanged();
                }
            });
        }

        //zujian.id_item_image.setImageBitmap(ImgUtils.getBitMapFromUrl("file:/" + path + "/" + data.get(position)));
        return convertView;
    }
}
