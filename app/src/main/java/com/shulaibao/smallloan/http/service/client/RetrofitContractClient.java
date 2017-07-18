package com.shulaibao.smallloan.http.service.client;

import com.shulaibao.frame.http2.retrofit.BaseRetrofitClient;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.http.MyOkhttpClient;

/**
 * 描述：用于APP请求的Client
 * Created by Lee
 * on 2016/9/20.
 */
public class RetrofitContractClient extends BaseRetrofitClient {
    private static RetrofitContractClient mInstance;
    public static RetrofitContractClient getInstance(String baseUrl){
        if(mInstance == null){
            synchronized (RetrofitContractClient.class){
                if(mInstance == null){
                    mInstance = new RetrofitContractClient(baseUrl);
                }
            }
        }
        return mInstance;
    }

    public RetrofitContractClient(String url) {
        attchBaseUrl(url, Base.getContext(), MyOkhttpClient.getClientBuilder());
    }
}
