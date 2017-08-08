package tts.moudle.api.moudle;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import tts.moudle.api.bean.BankBean;

/**
 * Created by sjb on 2016/2/23.
 */
public class BankMoudle {
    private List<BankBean> bankBeans;

    private static class Moudle {
        protected final static BankMoudle mInstance = new BankMoudle();
    }

    public static BankMoudle getInstance() {
        return Moudle.mInstance;
    }

    public List<BankBean> getBankBeans() {
        return bankBeans;
    }

    public void setBankBeans(List<BankBean> bankBeans) {
        this.bankBeans = bankBeans;
    }

    public String getBankName(Context context, String bin) {
        return getBankName(context, bin, false);
    }

    public String getBankName(Context context, String bin, boolean IsAll) {
        if (bankBeans == null) {
            AssetManager assetManager = context.getAssets();
            try {
                InputStream is = assetManager.open("bankData.json");
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                String json = new String(buffer, "utf-8");
                is.close();
                bankBeans = new Gson().fromJson(json, new TypeToken<List<BankBean>>() {
                }.getType());
                return binarySearch(bin, IsAll);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return binarySearch(bin, IsAll);
        }

    }

    public String binarySearch(String des, boolean IsAll) {
        if (bankBeans != null) {
            for (BankBean bankBean : bankBeans) {
                if (des.contains(bankBean.getBin())) {
                    return IsAll ? bankBean.getBankName() : bankBean.getBankName().indexOf("-") < 0 ? bankBean.getBankName() : bankBean.getBankName().substring(0, bankBean.getBankName().indexOf("-"));
                }
            }
        }
        return "";
    }

}
