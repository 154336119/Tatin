package com.shulaibao.smallloan.http.callback;

import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.orhanobut.logger.Logger;
import com.shulaibao.frame.http2.exception.ResultException;
import com.shulaibao.smallloan.http.bean.SignUploadSuccessEntity;
import com.shulaibao.smallloan.http.bean.common.UploadInfo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

/**
 * 描述：
 * Created by Lee
 * on 2016/12/28.
 */
public abstract  class UploadSignCallback extends AbsCallback<SignUploadSuccessEntity> {
    @Override
    public SignUploadSuccessEntity convertSuccess(Response response) throws Exception {
        List<UploadInfo> list = new ArrayList<UploadInfo>();
        String s = StringConvert.create().convertSuccess(response);
        Logger.d(s);
        JSONObject jb = JSONObject.parseObject(s);
        int code = jb.getInteger("code");
        if(code != 0 ){
            onError(null ,null ,new ResultException(code,jb.getString("message")));
        }
        JSONObject  jbData = jb.getJSONObject("data");
        JSONObject  jbBean = jbData.getJSONObject("bean");
        SignUploadSuccessEntity info = new SignUploadSuccessEntity();
        info.setDownloadPdf(jbBean.getString("downloadPdf"));
        info.setDownloadVdo(jbBean.getString("downloadVdo"));
        response.close();
        return info;
    }

}
