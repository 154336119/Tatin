package com.shulaibao.frame.ui.fragment;

import android.os.Bundle;

import com.shulaibao.frame.ui.presenter.IBaseFragmentPresenter;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/14.
 */
public abstract class BaseMvpFragment<V,T extends IBaseFragmentPresenter> extends BaseFragment {
    public T mPresenter;
    public abstract T initPresenter();

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach((V)this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.deattach();
    }
}
