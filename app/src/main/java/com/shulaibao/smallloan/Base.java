package com.shulaibao.smallloan;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.shulaibao.frame.cache.ACache;
import com.shulaibao.frame.utils.AppUtils;
import com.shulaibao.frame.utils.SPUtils;
import com.shulaibao.smallloan.http.bean.UserEntity;
import com.shulaibao.smallloan.http.bean.city.Province;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.List;


/**
 * 描述：存放全局变量
 * Created by Lee
 * on 2016/9/20.
 */
public class Base{
    /** 测试环境*/
    public static final int DEBUG = 999;
    /** 预发布环境*/
    public static final int LIVE = 998;
    /** 线上环境*/
    public static final int RELEASE = 997;
    private static Context mContext;
    /** 城市三级联动的数据源 */
    private static List<Province> mProList;
    /** SP-序列化本地工具 */
    private static SPUtils mSpUtils;
    /** APP相关信息 */
    private static AppUtils.AppInfo mAppInfo;
    /** 用户信息 */
    private static UserEntity mUserEntity;
    /** APP环境：debug、live、release */
    private static int mEnvironment;


    private RefWatcher refWatcher;
    public static void  initialize(@NonNull Context context) {
        mContext = context;
        initEnvironment();
    }

    public static Context getContext() {
        synchronized (Base.class){
            if (Base.mContext == null){
                throw new NullPointerException("Call Base.initialize(context) within your Application onCreate() method.");
            }
            return Base.mContext;
        }
    }


    /**
     * 序列化用得
     * @return
     */
    public static SPUtils getSpUtils(){
        if(mSpUtils == null){
            mSpUtils = new SPUtils(getContext(),AppConfig.APP_NAME);
         }
        return mSpUtils;
        }

    /**
     * APP通用信息
     * @return
     */
    public static AppUtils.AppInfo getmAppInfo() {
        if(mAppInfo == null){
            mAppInfo = AppUtils.getAppInfo(getContext());
        }
        return mAppInfo;
    }
    /**
     * 获取用户信息
     * @return
     */
    public static UserEntity getUserEntity() {
        if(mUserEntity == null){
            if(ACache.get(getContext()).getAsObject("userEnity") !=null){
                return (UserEntity)ACache.get(getContext()).getAsObject("userEnity");
            }
        }
//        mUserEntity = new UserEntity();
//        mUserEntity.setUserId(8695);
        return mUserEntity;
    }
    /**
     * 保存用户信息信息
     * @return
     */
    public static void setUserEntity(UserEntity mUserEntity) {
        ACache.get(getContext()).put("userEnity",mUserEntity);
        Base.mUserEntity = mUserEntity;
    }

    /**
     * 初始化APP环境
     */
    private static void initEnvironment(){
        mEnvironment = BuildConfig.ENV;
    }

    public static int getEnvironment() {
        return mEnvironment;
    }

    /**
     *
     */
    public RefWatcher getRefWatcher() {
        if(refWatcher == null){
            refWatcher  = LeakCanary.install((Application) Base.getContext());
        }
        return refWatcher;
    }

}
