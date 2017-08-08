package tts.moudle.api.moudle;

import android.content.SharedPreferences;

import tts.moudle.api.bean.UserBean;

/**
 * Created by sjb on 2016/1/21.
 */
public class AccountMoudle {
    private UserBean userBean;

    private static class Moudle {
        protected final static AccountMoudle mInstance = new AccountMoudle();
    }

    public static AccountMoudle getInstance() {
        return Moudle.mInstance;
    }

    public UserBean getUserBean() {
        if (userBean == null) {
            userBean = new UserBean();
        }
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
