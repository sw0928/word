package tts.moudle.api.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sjb on 2016/3/1.
 */
public class JsonUtils {
    /**
     * 根据某个字段 一层一层解析json
     *
     * @param request
     * @param name
     */
    public static String getJsonFromJson(String request, String name) {
        try {
            JSONObject jsonObject = new JSONObject(request);
            String result = jsonObject.getString(name);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
