package com.shulaibao.frame.http2.rxjava;


import com.shulaibao.frame.ui.view.IBaseLoadingDialogView;

import rx.Subscriber;

/**
 * 描述：
 * Created by Lee
 * on 2017/1/19.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {
    /**MVP view接口*/
    private IBaseLoadingDialogView mView;
    public BaseSubscriber(IBaseLoadingDialogView view) {
        mView = view;
    }
    @Override
    public void onStart() {
        super.onStart();
        mView.showLoadingDialog("正在加载");
    }

    @Override
    public void onError(Throwable e) {
        mView.loadingDialogDismiss();
        mView.showMsg(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        mView.loadingDialogDismiss();
    }

    @Override
    public void onCompleted() {

    }

}
