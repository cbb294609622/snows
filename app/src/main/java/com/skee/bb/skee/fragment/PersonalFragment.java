package com.skee.bb.skee.fragment;

import android.view.View;

import com.skee.bb.skee.R;
import com.skee.bb.skee.base.BaseFragment;

/**
 * Created by bb on 2017/1/13.
 */
public class PersonalFragment  extends BaseFragment {
    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_personal, null);
        return view;

    }

    @Override
    public void initData() {

    }
}
