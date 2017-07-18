package com.shulaibao.smallloan.http.service;

import com.shulaibao.frame.http2.retrofit.HttpResult;
import com.shulaibao.smallloan.http.bean.MsgEntity;
import com.shulaibao.smallloan.http.bean.UserEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/20.
 */
public interface ComService {
    /**
     * linkface 活体检测
     */
    public static final String VERIFICATION = "https://cloudapi.linkface.cn/identity/selfie_idnumber_verification";
    /**
     * 用户-登录
     */
    @FormUrlEncoded
    @POST("user/d-login")
    Observable<HttpResult<UserEntity, Object>> getUserInfo(@Field("userName") String username,
                                                           @Field("password") String password,
                                                           @Field("userType") int userType);

    /**
     * 用户-发短信验证码
     */
    @FormUrlEncoded
    @POST("sms/sendValidation")
    Observable<HttpResult<Object, Object>> sendMsgCode(@Field("mobile") String mobile);

    /**
     * 用户-注册
     */
    @FormUrlEncoded
    @POST("user/d-register")
    Observable<HttpResult<UserEntity, Object>> regist(@Field("userName") String userName, @Field("password") String password, @Field("vCode") String code);

}
