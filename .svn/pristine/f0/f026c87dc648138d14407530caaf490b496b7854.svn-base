package tts.moudle.api.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjb on 2016/1/7.
 */
public class TabManager implements TabHost.OnTabChangeListener {
    private final FragmentActivity mActivity;
    private final TabHost mTabHost;
    private final int mContainerID;

    public FragmentManager fragmentManager;
    public FragmentTransaction fragmentTransaction;
    public TabInfo tabInfo;
    // 保存tab
    private final Map<String, TabInfo> mTabs = new HashMap<String, TabInfo>();
    private TabInfo mLastTab;

    public TabManager(FragmentActivity activity, TabHost tabHost, int containerID) {
        mActivity = activity;
        mTabHost = tabHost;
        mContainerID = containerID;
        mTabHost.setOnTabChangedListener(this);
    }

    class TabFactory implements TabHost.TabContentFactory {
        private Context mContext;

        TabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }

    // 加入tab
    public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
        tabSpec.setContent(new TabFactory(mActivity));
        String tag = tabSpec.getTag();
        TabInfo info = new TabInfo(tag, clss, args);
        final FragmentManager fm = mActivity.getSupportFragmentManager();
        info.fragment = fm.findFragmentByTag(tag);
        // isDetached分离状态
        if (info.fragment != null && !info.fragment.isDetached()) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.detach(info.fragment);
            ft.commit();
        }
        mTabs.put(tag, info);
        mTabHost.addTab(tabSpec);
    }

    @SuppressLint("Recycle")
    @Override
    public void onTabChanged(String tabId) {
        TabInfo newTab = mTabs.get(tabId);
        if (mLastTab != newTab) {
            String lastTabName = "";
            if (mLastTab != null) {
                lastTabName = mLastTab.fragment.getTag().toString();
            }
            showTab(newTab);
        }
    }

    private void showTab(TabInfo newTab) {
        fragmentManager = mActivity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // 脱离之前的tab
        if (mLastTab != null && mLastTab.fragment != null) {
            fragmentTransaction.detach(mLastTab.fragment);
        }
        if (newTab != null) {
            if (newTab.fragment == null) {
                newTab.fragment = Fragment.instantiate(mActivity, newTab.clss.getName(), newTab.args);
                fragmentTransaction.add(mContainerID, newTab.fragment, newTab.tag);
            } else {
                // 激活
                fragmentTransaction.attach(newTab.fragment);
            }
        }
        mLastTab = newTab;

        fragmentTransaction.commitAllowingStateLoss();// commit();
        // 会在进程的主线程中，用异步的方式来执行,如果想要立即执行这个等待中的操作，就要调用这个方法
        // 所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
        fragmentManager.executePendingTransactions();
    }

}


