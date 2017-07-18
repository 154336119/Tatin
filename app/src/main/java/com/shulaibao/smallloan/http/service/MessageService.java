package com.shulaibao.smallloan.http.service;

import com.shulaibao.frame.http2.retrofit.HttpResult;
import com.shulaibao.smallloan.http.bean.MsgEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface MessageService {

    /**
     * 消息列表
     */
    @FormUrlEncoded
//    @POST("userMessage/list")
    @POST("ms/list")
    Observable<HttpResult<Object,MsgEntity>> getMsgList(@Field("pageSize") int pageSize, @Field("pageNum") int pageNum, @Field("sysName") String sysName);
    /**
     *删除消息
     */
//    @FormUrlEncoded
//    @POST("userMessage/delete")
//    Observable<HttpResult<Object,Object>> delMsg(@Field("messageId") String messageId);
    /**
     * 删除消息
     */
    @FormUrlEncoded
    @POST("ms/delete")
    Observable<HttpResult<Object, Object>> delMsg(@Field("userId") String userId, @Field("ids[]") long[] ids, @Field("sysName") String sysName);
    /**
     * 标记全部消息为已读
     */
    @FormUrlEncoded
    @POST("ms/readall")
    Observable<HttpResult<Object, Object>> readAllMsg(@Field("userId") int userId, @Field("sysName") String sysName);
}
