package com.shulaibao.smallloan;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okgo.model.HttpParams;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.shulaibao.frame.ui.widget.nodata.LoadingAndRetryManager;
import com.shulaibao.frame.utils.AppUtils;
import com.shulaibao.frame.utils.DeviceUtils;
import com.shulaibao.frame.utils.security.Security;
import com.shulaibao.smallloan.http.bean.UserEntity;
import com.shulaibao.smallloan.widget.dialog.application.ApplicationDialogUtils;
import com.shulaibao.smallloan.widget.dialog.application.CommonData;
import com.shulaibao.smallloan.widget.dialog.application.CommonDialogService;
import com.tencent.bugly.Bugly;


import cn.jpush.android.api.JPushInterface;

/**
 * 刁剑
 * Created on 2017/1/16.
 * 注释:
 */

public class TestApplication extends Application implements Application.ActivityLifecycleCallbacks{
    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(this);//注册
        MultiDex.install(this);
        Base.initialize(this);
        initLogUtils();
        initJpush();
        //okhttp上传下载初始化
        initOkgo();
        //全局无数据（或是无网络）页面配置
        LoadingAndRetryManager.BASE_RETRY_LAYOUT_ID=R.layout.base_retry;
        LoadingAndRetryManager.BASE_LOADING_LAYOUT_ID=R.layout.base_loading;
        LoadingAndRetryManager.BASE_EMPTY_LAYOUT_ID=R.layout.base_empty;
//        initTinker();
        //未登录的测试代码
//        UserEntity userEntity =  new UserEntity();
//        userEntity.setUserId(0);
//        Base.setUserEntity(userEntity);
        UserEntity userEntity=Base.getUserEntity();
        if (userEntity==null){
            userEntity =  new UserEntity();
            userEntity.setUserId(0);
            Base.setUserEntity(userEntity);
        }
        //initVCamera();
        Bugly.init(getApplicationContext(), "4503274377", false);
        //全局dialog
        Intent dialogservice = new Intent(this, CommonDialogService.class);
        startService(dialogservice);
        //SpeechUtility.createUtility(TestApplication.this,"appid=58ca4da2");
        //TTLUtils.initialEnv();
    }
    private void initLogUtils(){
        Logger.init(AppConfig.APP_NAME)
                .hideThreadInfo()
                .logLevel(LogLevel.FULL)
                .methodOffset(2);
    }
    /**
     * 极光推送初始化
     */
    private void initJpush(){
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);
    }
    private void initOkgo(){
        OkGo.init(this);
        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            long time = System.currentTimeMillis();
            HttpParams params = new HttpParams();
            params.put("mac", DeviceUtils.getMacAddress(Base.getContext()));
            params.put("os","ANDROID");
            params.put("version", AppUtils.getAppInfo(this).getVersionName());
            params.put("timestamp" ,time+"");
            params.put("access_token",  Security.getMD5Value(time));
            OkGo.getInstance()
                    // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                    // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                    //.debug("OkGo", Level.INFO, true)
                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间
                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.NO_CACHE)
                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                    //可以全局统一设置超时重连次数,默认为三次,那么最差的情况会请求4次(一次原始请求,三次重连请求),不需要可以设置为0
                    .setRetryCount(3)
                    .setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效
                    .setCertificates()                                  //方法一：信任所有证书,不安全有风险
                    .addCommonParams(params);   //设置全局公共参数

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else
            CommonData.mNowContext = activity;
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else
            CommonData.mNowContext = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if(activity.getParent()!=null){
            CommonData.mNowContext = activity.getParent();
        }else
            CommonData.mNowContext = activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        ApplicationDialogUtils.getInstances().cancel();
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
