package com.skee.bb.skee.ui;

import android.content.Intent;

import com.skee.bb.skee.base.BaseActivity;

/**
 * Created by bb on 2017/1/10.
 * 启动页
 */
public class InstallActivity extends BaseActivity {
    @Override
    public void initView() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }

    @Override
    public void initData() {

    }
}
