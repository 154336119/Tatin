package com.shulaibao.smallloan.http.callback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.orhanobut.logger.Logger;
import com.shulaibao.frame.http2.exception.ResultException;
import com.shulaibao.smallloan.http.bean.Element;

import okhttp3.Response;

/**
 * 描述：
 * Created by Lee
 * on 2016/12/28.
 */
public abstract  class ElementCallback extends AbsCallback<Element> {
    @Override
    public Element convertSuccess(Response response) throws Exception {
        String s = StringConvert.create().convertSuccess(response);
        Logger.d(s);
        JSONObject jb = JSONObject.parseObject(s);
        int code = jb.getInteger("code");
        if(code != 0 ){
            onError(null ,null ,new ResultException(code,jb.getString("msg")));
        }
        JSONObject  jbBean = jb.getJSONObject("data");

        Element element = JSON.parseObject(jbBean.getString("bean"), Element.class);
        response.close();
        return element;
    }

}
