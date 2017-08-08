package tts.moudle.api.cityapi;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tts.moudle.api.TTSBaseActivity;
import tts.moudle.api.utils.CustomUtils;
import tts.moudle.api.widget.BladeView;
import tts.moudle.api.widget.ListViewPinnedHeader;
import tts.moudle.ttsmoduleapi.R;

/**
 * Created by sjb on 2016/3/16.
 */
public class ProvinceSelectActivity extends TTSBaseActivity {
    CityDbHelper helper;
    public static String APP_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/";

    private static final int COPY_DB_SUCCESS = 10;
    private static final int COPY_DB_FAILED = 11;
    protected static final int QUERY_CITY_FINISH = 12;

    private MySectionIndexer mIndexer;

    private List<CityBean> cityList = new ArrayList<CityBean>();

    private CityListAdapter mAdapter;
    private static final String ALL_CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected static final String TAG = null;

    private String[] sections = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"};
    private int[] counts;
    private ListViewPinnedHeader mListView;

    List<CityBean> hotBeans;

    private GridView hotList;
    private CityHeaderAdapter cityHeaderAdapter;
    private SearchView searchBtn;

    private ListView tipList;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case QUERY_CITY_FINISH:
                    adapterCity();
                    cityHeaderAdapter = new CityHeaderAdapter(ProvinceSelectActivity.this, hotBeans);
                    hotList.setAdapter(cityHeaderAdapter);
                    hotList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("cityBean", hotBeans.get(position));
                            intent.putExtras(bundle);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    });
                    break;
                case COPY_DB_SUCCESS:
                    requestData();
                    break;
                default:
                    break;
            }
        }
    };
    CityTipAdapter cityTipAdapter;
    BladeView mLetterListView;

    public void reFresh(List<CityBean> data) {
        cityList.clear();
        cityList.addAll(data);
        cityTipAdapter.notifyDataSetChanged();
    }

    public void adapterCity() {
        cityTipAdapter = new CityTipAdapter(this, cityList);
        tipList.setAdapter(cityTipAdapter);
        tipList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cityBean", cityList.get(position));
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        mIndexer = new MySectionIndexer(sections, counts);
        mAdapter = new CityListAdapter(cityList, mIndexer, this);
        mListView.setAdapter(mAdapter);
        mListView.setTextFilterEnabled(true);
        mListView.setOnScrollListener(mAdapter);
        mListView.setPinnedHeaderView(LayoutInflater.from(this).inflate(
                R.layout.list_group_item, mListView, false));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cityBean", cityList.get(position));
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.province_select_activity);
        hotBeans = (List<CityBean>) getIntent().getSerializableExtra("hotBeans");
        helper = new CityDbHelper();
        applyPermission(1, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        findAllView();
    }

    @Override
    protected void startApplyPermissions(int index) {
        super.startRequestData(index);
        copyDBFile();
    }

    @Override
    protected void applyPermissionsFailed() {
        CustomUtils.showTipShort(this,"无访问存储信息权限,此页面无法加载");
        finish();
    }

    private void copyDBFile() {
        File file = new File(APP_DIR + "/city.db");
        if (file.exists()) {
            requestData();
        } else {    //拷贝文件
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    copyAssetsFile2SDCard("city.db");
                }
            };
            new Thread(task).start();
        }
    }

    /**
     * 拷贝资产目录下的文件到 手机
     */
    private void copyAssetsFile2SDCard(String fileName) {
        File desDir = new File(APP_DIR);
        if (!desDir.exists()) {
            desDir.mkdirs();
        }
        // 拷贝文件
        File file = new File(APP_DIR + fileName);
        if (file.exists()) {
            file.delete();
        }

        try {
            InputStream in = getAssets().open(fileName);

            FileOutputStream fos = new FileOutputStream(file);

            int len = -1;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) > 0) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            fos.close();
            handler.sendEmptyMessage(COPY_DB_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendEmptyMessage(COPY_DB_FAILED);
        }
    }

    private void requestData() {

        Runnable task = new Runnable() {

            @Override
            public void run() {
                CityMoudle dao = new CityMoudle();

                if (hotBeans == null) {
                    hotBeans = dao.getHotCities();    //热门城市
                }
                List<CityBean> all = dao.getAllCities();    //全部城市
                if (all != null) {
                    getCityBeans(all);
                    handler.sendEmptyMessage(QUERY_CITY_FINISH);
                }
            }
        };

        new Thread(task).start();
    }

    public void getCityBeans(List<CityBean> all) {
        cityList.clear();
        Collections.sort(all, new MyComparator());    //排序
        cityList.addAll(all);
        //初始化每个字母有多少个item
        counts = new int[sections.length];
        for (CityBean city : all) {    //计算全部城市
            String firstCharacter = city.getSortKey();
            int index = ALL_CHARACTER.indexOf(firstCharacter);
            counts[index]++;
        }
    }

    public class MyComparator implements Comparator<CityBean> {

        @Override
        public int compare(CityBean c1, CityBean c2) {

            return c1.getSortKey().compareTo(c2.getSortKey());
        }

    }

    private void findAllView() {
        setTitle("城市选择");
        tipList = (ListView) findViewById(R.id.tipList);
        hotList = (GridView) findViewById(R.id.hotList);
        searchBtn = (SearchView) findViewById(R.id.searchBtn);
        searchBtn.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Filter f = ((Filterable) mAdapter).getFilter();
                f.filter(newText == null ? "" : newText);
                if (newText == null || newText.length() == 0) {
                    hotList.setVisibility(View.VISIBLE);
                    mListView.setVisibility(View.VISIBLE);
                    mLetterListView.setVisibility(View.VISIBLE);
                    tipList.setVisibility(View.GONE);
                } else {
                    hotList.setVisibility(View.GONE);
                    mListView.setVisibility(View.GONE);
                    mLetterListView.setVisibility(View.GONE);
                    tipList.setVisibility(View.VISIBLE);
                    //mListView.setFilterText(newText);
                }
                return false;
            }
        });
        mListView = (ListViewPinnedHeader) findViewById(R.id.mListView);
        mLetterListView = (BladeView) findViewById(R.id.mLetterListView);
        mLetterListView.setOnItemClickListener(new BladeView.OnItemClickListener() {

            @Override
            public void onItemClick(String s) {
                if (s != null) {
                    int section = ALL_CHARACTER.indexOf(s);
                    int position = mIndexer.getPositionForSection(section);
                    Log.i(TAG, "s:" + s + ",section:" + section + ",position:" + position);

                    if (position != -1) {
                        mListView.setSelection(position);
                    } else {

                    }
                }

            }
        });
    }

}

