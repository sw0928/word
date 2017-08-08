package tts.moudle.api.cityapi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import tts.moudle.api.utils.FileUtils;
import tts.moudle.ttsmoduleapi.R;

public class CityMoudle {
    public static String APP_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/";
    private CityDbHelper helper;
    public ProvinceSelectPopupwindow popupWindow;

    public List<CityBean> cityBeans;

    public List<CityBean> getCityBeans(Context context) {
        if (cityBeans == null) {
            String json = FileUtils.readAssets(context, "area.json");
            cityBeans = new Gson().fromJson(json, new TypeToken<List<CityBean>>() {
            }.getType());
        }
        return cityBeans;
    }

    public void setCityBeans(List<CityBean> cityBeans) {
        this.cityBeans = cityBeans;
    }

    private static class Moudle {
        protected final static CityMoudle mInstance = new CityMoudle();
    }

    public static CityMoudle getInstance() {
        return Moudle.mInstance;
    }

    public CityMoudle() {
        this.helper = new CityDbHelper();
    }

    public void showProvincePopupwindow(Context context, View view, ProvinceSelectPopupwindow.OnClickListener listener) {
        showProvincePopupwindow(context, view, 1, listener);
    }

    /**
     * @param context
     * @param view     任意View
     * @param listener
     */
    public void showProvincePopupwindow(Context context, View view, int type, ProvinceSelectPopupwindow.OnClickListener listener) {
        popupWindow = new ProvinceSelectPopupwindow(context, View.inflate(context, R.layout.city_select_popupwindow, null), type);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);
        // 这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 设置PopupWindow的弹出和消失效果
        // popupWindow.setAnimationStyle(R.style.popupAnimation);
        popupWindow.showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER, 0, 0);
        popupWindow.setOnClickListener(listener);
    }

    public List<CityBean> getHotCities() {

        SQLiteDatabase db = helper.getReadableDataBase(APP_DIR, "city.db");

        List<CityBean> list = new ArrayList<CityBean>();

        Cursor cursor = null;

        try {
            if (db.isOpen()) {
                String sql = "SELECT id,name,pyf,pys FROM city where hot = 1";
                cursor = db.rawQuery(sql, null);
                while (cursor.moveToNext()) {

                    CityBean city = new CityBean();
                    city.setId(cursor.getString(0));
                    city.setName(cursor.getString(1));
                    city.setPyf(cursor.getString(2));
                    city.setPys(cursor.getString(3));

                    list.add(city);
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return list;
    }

    public List<CityBean> getAllCities() {

        SQLiteDatabase db = helper.getReadableDataBase(APP_DIR, "city.db");

        List<CityBean> list = new ArrayList<CityBean>();

        Cursor cursor = null;

        try {
            if (db.isOpen()) {
                String sql = "SELECT id,name,pyf,pys FROM city";
                cursor = db.rawQuery(sql, null);
                while (cursor.moveToNext()) {

                    CityBean city = new CityBean();
                    city.setId(cursor.getString(0));
                    city.setName(cursor.getString(1));
                    city.setPyf(cursor.getString(2));
                    city.setPys(cursor.getString(3));

                    list.add(city);
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return list;
    }

}
