package com.shulaibao.smallloan.http.service.client;

import com.shulaibao.frame.http2.retrofit.BaseRetrofitClient;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.http.MyOkhttpClient;

/**
 * 描述：用于APP请求的Client
 * Created by Lee
 * on 2016/9/20.
 */
public class RetrofitComClient extends BaseRetrofitClient {
    private static RetrofitComClient mInstance;
    public static RetrofitComClient getInstance(String baseUrl){
        if(mInstance == null){
            synchronized (RetrofitComClient.class){
                if(mInstance == null){
                    mInstance = new RetrofitComClient(baseUrl);
                }
            }
        }
        return mInstance;
    }

    public RetrofitComClient(String url) {
        attchBaseUrl(url, Base.getContext(), MyOkhttpClient.getClientBuilder());
    }
}
