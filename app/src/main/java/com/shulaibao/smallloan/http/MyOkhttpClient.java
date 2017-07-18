package com.shulaibao.smallloan.http;


import com.shulaibao.frame.http2.retrofit.HttpLoggingInterceptor;
import com.shulaibao.frame.utils.DeviceUtils;
import com.shulaibao.frame.utils.security.Security;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/19.
 */
public class MyOkhttpClient {
    private  static OkHttpClient.Builder mClientBuilder;
    private SingInterceptor mSingInterceptor;
    private HttpLoggingInterceptor mHttpLoggingInterceptor;
    private static MyOkhttpClient mInstance;
    /**
     * 单例
     * @return
     */
    public static synchronized MyOkhttpClient getInstance(){
        if(mInstance==null){
            mInstance = new MyOkhttpClient();
        }
        return mInstance;
    }

    public static OkHttpClient.Builder getClientBuilder() {
        if(mInstance==null){
            mInstance = new MyOkhttpClient();
        }
        return mClientBuilder;
    }

    public MyOkhttpClient() {
        initInterceptor();
        mClientBuilder = new OkHttpClient.Builder();
        mClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        mClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        mClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        mClientBuilder.addInterceptor(mSingInterceptor)
                .addInterceptor(mHttpLoggingInterceptor);
    }

    /**
     * 初始化拦截器
     */
    private void initInterceptor(){
        mSingInterceptor = new SingInterceptor();
        mHttpLoggingInterceptor = new HttpLoggingInterceptor();
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    }

    /**
     * request拦截器 - 统一传递参数的接口
     */
    class SingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            long time = System.currentTimeMillis();
            HttpUrl httpUrl;
            if (Base.getUserEntity()==null || Base.getUserEntity().getUserId()==0){
                httpUrl = oldRequest.url().newBuilder()
                        .host(oldRequest.url().host())
                        .scheme(oldRequest.url().scheme())
                        .addQueryParameter("mac", DeviceUtils.getMacAddress(Base.getContext()))
                        .addQueryParameter("os", BuildConfig.APP_ANDROID)
                        .addQueryParameter("version", BuildConfig.VERSION_NAME)
                        .addQueryParameter("timestamp",time+"")
                        .addQueryParameter("appName", BuildConfig.APP_NAME)
                        .addQueryParameter("access_token", Security.getMD5Value(time)).build();
            }else {
                httpUrl = oldRequest.url().newBuilder()
                        .host(oldRequest.url().host())
                        .scheme(oldRequest.url().scheme())
                        .addQueryParameter("mac", DeviceUtils.getMacAddress(Base.getContext()))
                        .addQueryParameter("os", BuildConfig.APP_ANDROID)
                        .addQueryParameter("version",BuildConfig.VERSION_NAME)
                        .addQueryParameter("timestamp",time+"")
                        .addQueryParameter("appName",BuildConfig.APP_NAME)
                        .addQueryParameter("userId", Base.getUserEntity().getUserId()+"")
                        .addQueryParameter("access_token", Security.getMD5Value(time)).build();
            }
            /** 添加公共参数后的request*/
            Request modifiedRequest = oldRequest.newBuilder()
                    .url(httpUrl)
                    .method(oldRequest.method(),oldRequest.body())
                    .build();
            Response response = chain.proceed(modifiedRequest);
            return response;
        }
    }

}
