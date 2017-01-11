package com.skee.bb.skee.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skee.bb.skee.R;
import com.skee.bb.skee.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Context mContext;

    @Override
    public void initView() {
        mContext = MainActivity.this;
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initData() {

    }
}
