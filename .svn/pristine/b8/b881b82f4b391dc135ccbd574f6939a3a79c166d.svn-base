package tts.moudle.api.moudle;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sjb on 2016/3/1.
 */
public class SharedPreferencesMoudle {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private SharedPreferencesMoudle() {
    }

    private static class Moudle {
        protected final static SharedPreferencesMoudle mInstance = new SharedPreferencesMoudle();
    }

    public static SharedPreferencesMoudle getInstance() {
        return Moudle.mInstance;
    }

    public String getJson(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return sharedPreferences.getString("msg", "");
    }

    public boolean setJson(Context context, String name, String json) {
        try {
            sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("msg", json);
            editor.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getPush(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return sharedPreferences.getString("push", "");
    }

    public boolean setPush(Context context, String name, String json) {
        try {
            sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("push", json);
            editor.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
