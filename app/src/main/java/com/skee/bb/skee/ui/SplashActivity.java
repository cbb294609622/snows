package com.skee.bb.skee.ui;


import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.skee.bb.skee.R;
import com.skee.bb.skee.base.BaseActivity;
import com.skee.bb.skee.util.ActivityAnimUitl;
import com.skee.bb.skee.util.ToastUtils;

import butterknife.InjectView;

/**
 * Created by bb on 2017/1/6.
 * 广告
 */
public class SplashActivity extends BaseActivity{

    @InjectView(R.id.splash_picture)
    ImageView mSplashImg;

    @InjectView(R.id.splash_time)
    TextView mSplashTime;
    private static final int AD_show = 6;
    private boolean CLOSE_TIMER = true;

    @Override
    public int getLayoutView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mContext = SplashActivity.this;
        showAnimImg();
    }

    private void showAnimImg() {
        //让图片动起来
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_scale_translate);
        mSplashImg.setAnimation(animation);
        animation.setFillAfter(true);
    }

    @Override
    public void initData() {
        showAD();
        mSplashTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeAD();
            }
        });
    }
    private MyCountDownTimer mc;
    private void showAD() {
        mc = new MyCountDownTimer(AD_show * 1000, 1000);
        mc.start();
    }

    private void closeAD() {
        CLOSE_TIMER = false;
        startActivity(new Intent(mContext,GuideActivity.class));
        ActivityAnimUitl.isRightLeft(SplashActivity.this);
        this.finish();
    }

    /**
     * 继承 CountDownTimer 防范
     * 重写 父类的方法 onTick() 、 onFinish()
     */
    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            /**
             * 为true 说明 用户没有跳过广告页面
             * 为false 说明 用户跳过了广告界面
             */
            if (CLOSE_TIMER) {
                closeAD();
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mSplashTime.setText("" + (millisUntilFinished / 1000) + "s");
        }
    }

}
