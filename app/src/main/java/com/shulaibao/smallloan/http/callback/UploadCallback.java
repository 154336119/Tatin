package com.shulaibao.smallloan.http.callback;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.convert.StringConvert;
import com.shulaibao.frame.http2.exception.ResultException;
import com.shulaibao.smallloan.http.bean.common.UploadInfo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

/**
 * 描述：
 * Created by Lee
 * on 2016/12/28.
 */
public abstract  class UploadCallback extends AbsCallback<List<UploadInfo>> {
    @Override
    public List<UploadInfo> convertSuccess(Response response) throws Exception {
        List<UploadInfo> list = new ArrayList<UploadInfo>();
        String s = StringConvert.create().convertSuccess(response);
        JSONObject jb = JSONObject.parseObject(s);
        int code = jb.getInteger("code");
        if(code != 0 ){
            onError(null ,null ,new ResultException(code));
        }
        JSONObject  jbData = jb.getJSONObject("data");
        JSONArray jsonArray = jbData.getJSONArray("bean");
        for(int i=0 ;i<jsonArray.size();i++){
            UploadInfo info = new UploadInfo();
            info.setFileName(jsonArray.getJSONObject(i).getString("fileName"));
            info.setDownLoad(jsonArray.getJSONObject(i).getString("downLoad"));
            list.add(info);
        }
        response.close();
        return list;
    }

}
