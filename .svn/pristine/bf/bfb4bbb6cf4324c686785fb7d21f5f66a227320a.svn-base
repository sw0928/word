package tts.moudle.api.cityapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tts.moudle.api.cityapi.CityBean;
import tts.moudle.api.cityapi.MySectionIndexer;
import tts.moudle.api.widget.ListViewPinnedHeader;
import tts.moudle.ttsmoduleapi.R;

public class CityListAdapter extends BaseAdapter implements
        ListViewPinnedHeader.PinnedHeaderAdapter, OnScrollListener, Filterable {
    private List<CityBean> mList;
    private MySectionIndexer mIndexer;
    private Context mContext;
    private int mLocationPosition = -1;
    private LayoutInflater mInflater;

    public CityListAdapter(List<CityBean> mList, MySectionIndexer mIndexer,
                           Context mContext) {
        this.mList = mList;
        this.mIndexer = mIndexer;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.select_city_item, null);
            holder = new ViewHolder();
            holder.group_title = (TextView) view.findViewById(R.id.group_title);
            holder.city_name = (TextView) view.findViewById(R.id.city_name);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        CityBean city = mList.get(position);
        int section = mIndexer.getSectionForPosition(position);
        if (mIndexer.getPositionForSection(section) == position) {
            holder.group_title.setVisibility(View.VISIBLE);
            holder.group_title.setText(city.getSortKey());
        } else {
            holder.group_title.setVisibility(View.GONE);
        }

        holder.city_name.setText(city.getName());

        return view;
    }

    CityFilter cityFilter;

    @Override
    public Filter getFilter() {
        if (cityFilter == null) {
            cityFilter = new CityFilter();
        }
        return cityFilter;
    }

    private ArrayList<CityBean> mUnfilteredData;

    private class CityFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();
            if (mUnfilteredData == null) {
                mUnfilteredData = new ArrayList<CityBean>(mList);
            }
            if (prefix == null || prefix.length() == 0) {
                ArrayList<CityBean> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();
                ArrayList<CityBean> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();
                ArrayList<CityBean> newValues = new ArrayList<CityBean>(count);

                for (int i = 0; i < count; i++) {
                    CityBean pc = unfilteredValues.get(i);
                    if (pc != null) {
                        if ((pc.getName() != null && pc.getName().toLowerCase().indexOf(prefixString) == 0)
                                || (pc.getPyf() != null && pc.getPyf().toLowerCase().indexOf(prefixString) == 0)
                                || (pc.getPys() != null && pc.getPys().toLowerCase().indexOf(prefixString) == 0)) {
                            newValues.add(pc);
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mList = (List<CityBean>) results.values;
            ((ProvinceSelectActivity) mContext).reFresh(mList);
           /* if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }*/
        }
    }

    public static class ViewHolder {
        public TextView group_title;
        public TextView city_name;
    }

    @Override
    public int getPinnedHeaderState(int position) {
        int realPosition = position;
        if (realPosition < 0
                || (mLocationPosition != -1 && mLocationPosition == realPosition)) {
            return PINNED_HEADER_GONE;
        }
        mLocationPosition = -1;
        int section = mIndexer.getSectionForPosition(realPosition);
        int nextSectionPosition = mIndexer.getPositionForSection(section + 1);
        if (nextSectionPosition != -1
                && realPosition == nextSectionPosition - 1) {
            return PINNED_HEADER_PUSHED_UP;
        }
        return PINNED_HEADER_VISIBLE;
    }

    @Override
    public void configurePinnedHeader(View header, int position, int alpha) {
        // TODO Auto-generated method stub
        int realPosition = position;
        int section = mIndexer.getSectionForPosition(realPosition);
        String title = (String) mIndexer.getSections()[section];
        ((TextView) header.findViewById(R.id.group_title)).setText(title);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        if (view instanceof ListViewPinnedHeader) {
            ((ListViewPinnedHeader) view).configureHeaderView(firstVisibleItem);
        }

    }
}
