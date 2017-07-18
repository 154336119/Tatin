package com.shulaibao.smallloan.utils;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shulaibao.frame.utils.DeviceUtils;
import com.shulaibao.smallloan.Base;
import com.shulaibao.smallloan.http.bean.JsAppInfo;

/**
 * 
 * @className: JavaScriptUtil
 * @description:与js交互的类
 * @author: Z
 * @date: 2015年10月27日下午3:01:17
 */
public class JavaScriptUtil {
	private Context mContext;

	public JavaScriptUtil(Context mContxt) {
		this.mContext = mContxt;
	}

	/*
         * 获取用户信息
         */
	@JavascriptInterface
	public String getAppUserInfo() {
		JsAppInfo info = new JsAppInfo();
		info.setAppName(DeviceUtils.getMacAddress(Base.getContext()));
		info.setMac("1sdsasdasdsa");
		info.setOs("1");
		info.setVersion("1.0.0");
		info.setAppName("PPD");
		info.setUserId(Base.getUserEntity().getUserId());
		info.setUserType(Base.getUserEntity().getType());
		String jsonString = JSON.toJSONString(info,SerializerFeature.WriteMapNullValue);
		return jsonString;
	}

	@JavascriptInterface
	public void showToast(String msg) {
		Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
	}
	/**
	 * 关闭页面
	 */
	@JavascriptInterface
	public void pageFinish(){
		Activity activity = (Activity) mContext;
		activity.finish();
	}
//	@JavascriptInterface
//	public void openResultPage(String result){
//		Logger.e("result:"+result);
//		Logger.e("result:"+result);
//		Logger.e("result:"+result);
//		Logger.e("result:"+result);
//		Logger.e("result:"+result);
//		Activity activity = (Activity) mContext;
//		Bundle bundle = new Bundle();
//		bundle.putString("result",result);
//		ActivityUtil.next(activity,RiskEvaluationActivity.class,bundle,true);
//	}
}
