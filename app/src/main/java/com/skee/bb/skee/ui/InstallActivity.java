package com.skee.bb.skee.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.skee.bb.skee.base.BaseActivity;

/**
 * Created by bb on 2017/1/10.
 * 启动页
 */
public class InstallActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}
