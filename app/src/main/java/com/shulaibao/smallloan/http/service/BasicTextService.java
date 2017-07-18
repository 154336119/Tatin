package com.shulaibao.smallloan.http.service;

import com.shulaibao.frame.http2.retrofit.HttpResult;
import com.shulaibao.smallloan.http.bean.FundRiskRevealEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 刁剑
 * 2017/4/27
 * 描述:
 */

public interface BasicTextService {
    /**
     * 获取风险揭示文本
     *
     */
    @FormUrlEncoded
    @POST("cs/basic-text")
    Observable<HttpResult<FundRiskRevealEntity,Object>> getFundRiskRevealText(@Field("fileUrl") String fileUrl);
}
