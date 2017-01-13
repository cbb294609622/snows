package com.skee.bb.skee.ui;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

import com.skee.bb.skee.R;
import com.skee.bb.skee.base.BaseActivity;
import com.skee.bb.skee.fragment.HotspotFragment;
import com.skee.bb.skee.fragment.PersonalFragment;
import com.skee.bb.skee.fragment.SnowDesFragment;
import com.skee.bb.skee.fragment.VideoFragment;
import com.skee.bb.skee.util.ToastUtils;

import butterknife.InjectView;

public class MainActivity extends BaseActivity implements OnClickListener {

    private Context mContext;
    @InjectView(R.id.tab_rb_0)
    RadioButton mTabZreo;

    @InjectView(R.id.tab_rb_1)
    RadioButton mTabOne;

    @InjectView(R.id.tab_rb_2)
    RadioButton mTabTwo;

    @InjectView(R.id.tab_rb_3)
    RadioButton mTabThree;

    @InjectView(R.id.tv_search)
    TextView mSearch;

    @InjectView(R.id.tv_title)
    TextView mTitle;

    private HotspotFragment hotspotFragment;
    private PersonalFragment personalFragment;
    private SnowDesFragment snowDesFragment;
    private VideoFragment videoFragment;

    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mContext = MainActivity.this;
        mTabZreo.setOnClickListener(this);
        mTabOne.setOnClickListener(this);
        mTabTwo.setOnClickListener(this);
        mTabThree.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        setSelectID(0);
    }

    @Override
    public void initData() {}

    /**
     * 初始化底部按钮
     */
    private void defaultRadioBtn() {
        mTabZreo.setTextColor(getResources().getColor( R.color.app_text_backgound));
        mTabOne.setTextColor(getResources().getColor( R.color.app_text_backgound));
        mTabTwo.setTextColor(getResources().getColor( R.color.app_text_backgound));
        mTabThree.setTextColor(getResources().getColor( R.color.app_text_backgound));

        mTabZreo.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.home),null,null);
        mTabOne.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.des),null,null);
        mTabTwo.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.active),null,null);
        mTabThree.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.my),null,null);
    }

    /**
     * 隐藏所有的Fragment
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (hotspotFragment != null) {
            transaction.hide(hotspotFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (snowDesFragment != null) {
            transaction.hide(snowDesFragment);
        }
        if (personalFragment != null) {
            transaction.hide(personalFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_rb_0:
                mSearch.setVisibility(View.VISIBLE);
                mTitle.setVisibility(View.GONE);
                setSelectID(0);
                break;
            case R.id.tab_rb_1:
                mSearch.setVisibility(View.GONE);
                mTitle.setVisibility(View.VISIBLE);
                mTitle.setText("全部视频");
                setSelectID(1);
                break;
            case R.id.tab_rb_2:
                mSearch.setVisibility(View.GONE);
                mTitle.setVisibility(View.VISIBLE);
                mTitle.setText("雪具介绍");
                setSelectID(2);
                break;
            case R.id.tab_rb_3:
                mSearch.setVisibility(View.GONE);
                mTitle.setVisibility(View.VISIBLE);
                mTitle.setText("个人中心");
                setSelectID(3);
                break;
            case R.id.tv_search:
                ToastUtils.showShortToast(mContext,"搜索功能");
                break;
        }
    }

    private void setSelectID(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();//创建一个事务
        //初始化
        hideFragment(transaction);
        defaultRadioBtn();
        switch (i){
            case 0:
                mTabZreo.setTextColor(getResources().getColor( R.color.app_background_bar));
                mTabZreo.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.home_click),null,null);
                if (hotspotFragment == null){
                    hotspotFragment = new HotspotFragment();
                    transaction.add(R.id.id_content, hotspotFragment);
                }else{
                    transaction.show(hotspotFragment);
                }
                break;
            case 1:
                mTabOne.setTextColor(getResources().getColor( R.color.app_background_bar));
                mTabOne.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.des_click),null,null);
                if (videoFragment == null){
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.id_content, videoFragment);
                }else{
                    transaction.show(videoFragment);
                }
                break;
            case 2:
                mTabTwo.setTextColor(getResources().getColor( R.color.app_background_bar));
                mTabTwo.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.active_click),null,null);
                if (snowDesFragment == null){
                    snowDesFragment = new SnowDesFragment();
                    transaction.add(R.id.id_content, snowDesFragment);
                }else{
                    transaction.show(snowDesFragment);
                }
                break;
            case 3:
                mTabThree.setTextColor(getResources().getColor( R.color.app_background_bar));
                mTabThree.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable( R.drawable.my_click),null,null);
                if (personalFragment == null){
                    personalFragment = new PersonalFragment();
                    transaction.add(R.id.id_content, personalFragment);
                }else{
                    transaction.show(personalFragment);
                }
                break;
        }
        transaction.commit();//提交事务
    }
}
