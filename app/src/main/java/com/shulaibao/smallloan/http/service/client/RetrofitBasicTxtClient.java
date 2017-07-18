package com.shulaibao.smallloan.http.service.client;

import com.shulaibao.frame.http2.retrofit.BaseRetrofitClient;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.http.MyOkhttpClient;

/**
 * 描述：用于APP请求的Client
 * Created by Lee
 * on 2016/9/20.
 */
public class RetrofitBasicTxtClient extends BaseRetrofitClient {
    private static RetrofitBasicTxtClient mInstance;
    public static RetrofitBasicTxtClient getInstance(String baseUrl){
        if(mInstance == null){
            synchronized (RetrofitBasicTxtClient.class){
                if(mInstance == null){
                    mInstance = new RetrofitBasicTxtClient(baseUrl);
                }
            }
        }
        return mInstance;
    }

    public RetrofitBasicTxtClient(String url) {
        attchBaseUrl(url, Base.getContext(), MyOkhttpClient.getClientBuilder());
    }
}
