package com.shulaibao.smallloan.http.service.client;

import com.shulaibao.frame.http2.retrofit.BaseRetrofitClient;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.http.MyOkhttpClient;

/**
 * 刁剑
 * Created on 2017/2/8.
 * 注释:
 */

public class RetrofitMsgClient extends BaseRetrofitClient {
    private static RetrofitMsgClient mInstance;
    public static RetrofitMsgClient getInstance(String baseUrl){
        if(mInstance == null){
            synchronized (RetrofitMsgClient.class){
                if(mInstance == null){
                    mInstance = new RetrofitMsgClient(baseUrl);
                }
            }
        }
        return mInstance;
    }

    public RetrofitMsgClient(String url) {
        attchBaseUrl(url, Base.getContext(), MyOkhttpClient.getClientBuilder());
    }
}
