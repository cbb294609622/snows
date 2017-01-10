package com.skee.bb.skee;

import android.app.Application;

import com.skee.bb.skee.view.CrashHandler;

/**
 * Created by bb on 2017/1/6.
 */
public class MyApplication extends Application {
    private static MyApplication singleton;

    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        singleton = this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
}
