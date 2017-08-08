package tts.moudle.api.cityapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tts.moudle.api.TTSBaseActivity;
import tts.moudle.api.bean.ImgBean;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.utils.ImgUtils;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/16.
 */
public class CityHeaderAdapter extends BaseAdapter {
    private List<CityBean> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public CityHeaderAdapter(Context context, List<CityBean> data) {
        this.context = context;
        this.data=data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     *
     * @author Administrator
     */
    public final class Zujian {
        public TextView name;
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
            convertView = layoutInflater.inflate(R.layout.province_header_item, null);
            zujian.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(zujian);
        } else {
            zujian = (Zujian) convertView.getTag();
        }
        zujian.name.setText(data.get(position).getName());
        return convertView;
    }
}
