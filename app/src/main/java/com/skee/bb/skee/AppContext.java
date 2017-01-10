package com.skee.bb.skee;

import android.content.Context;

/**
 * Created by bb on 2017/1/6.
 * 主要用于APP内部数据共享
 */
public class AppContext {

    private static AppContext mDemoContext;
    public Context mContext;

    public static AppContext getInstance() {

        if (mDemoContext == null) {
            mDemoContext = new AppContext();
        }
        return mDemoContext;
    }

    private AppContext() {}

    private AppContext(Context context) {
        mContext = context;
        mDemoContext = this;
    }
}
