package tts.moudle.api.cityapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tts.moudle.api.widget.wheel.adapter.AbstractWheelTextAdapter;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/21.
 */
public class CityAdapter extends AbstractWheelTextAdapter {
    private List<CityBean> cityBeans;
    private List<String> areaBeans;

    public CityAdapter(Context context,  List<CityBean> cityBeans,List<String> areaBeans) {
        super(context, R.layout.city_select_item, NO_RESOURCE);
        this.cityBeans = cityBeans;
        this.areaBeans = areaBeans;
        setItemTextResource(R.id.cityName);
    }

    @Override
    public View getItem(int index, View cachedView, ViewGroup parent) {
        View view = super.getItem(index, cachedView, parent);
        return view;
    }

    @Override
    public int getItemsCount() {
        return cityBeans == null ? areaBeans.size() : cityBeans.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        return areaBeans==null?cityBeans.get(index).getName():areaBeans.get(index);
    }
}

