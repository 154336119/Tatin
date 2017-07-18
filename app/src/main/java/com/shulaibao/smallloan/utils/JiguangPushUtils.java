package com.shulaibao.smallloan.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.shulaibao.frame.utils.DeviceUtils;
import com.shulaibao.smallloan.Base;

import java.util.LinkedHashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * 刁剑
 * Created on 2017/2/8.
 * 注释:
 */

public class JiguangPushUtils {
    private Context mContext;
    private String mUserid;
    public JiguangPushUtils(Context context,String userid){
        mContext=context;
        mUserid=userid;
    }
    public void setTag(){
        if (TextUtils.isEmpty(mUserid)){
            return;
        }
        // ","隔开的多个 转换成 Set
        String[] sArray = mUserid.split(",");
        Set<String> tagSet = new LinkedHashSet<String>();
        for (String sTagItme : sArray) {
            if (!ExampleUtil.isValidTagAndAlias(sTagItme)) {
                Logger.e("推送Tag格式错误");
                return;
            }
            tagSet.add("USERID_"+sTagItme);
            tagSet.add("MAC_"+ DeviceUtils.getMacAddress(Base.getContext()));
        }
        //调用JPush API设置Tag
        if(Base.getEnvironment() == Base.DEBUG){
            JPushInterface.setAliasAndTags(mContext, "DEBUG", tagSet, mTagsCallback);
        }else if(Base.getEnvironment() == Base.RELEASE){
            JPushInterface.setAliasAndTags(mContext, "ONLINE", tagSet, mTagsCallback);
        }else if(Base.getEnvironment() == Base.LIVE){
            JPushInterface.setAliasAndTags(mContext, "LIVE", tagSet, mTagsCallback);
        }
    }
    public void clearTag(){
        Set<String> tagSet=new LinkedHashSet<>();
        JPushInterface.setAliasAndTags(mContext, "", tagSet, mTagsCallback);
    }
    private TagAliasCallback mTagsCallback = new TagAliasCallback() {

        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    Logger.i(logs);
                    break;

                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    Logger.i(logs);
//                    if (ExampleUtil.isConnected(getApplicationContext())) {
//                        mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_TAGS, tags), 1000 * 60);
//                    } else {
//                        Log.i(TAG, "No network");
//                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (ExampleUtil.isConnected(mContext)) {
                                setTag();
                            }
                        }
                    },3000);
                    break;

                default:
                    logs = "Failed with errorCode = " + code;
                    Logger.e(logs);
            }
            Logger.e(logs);
        }

    };
}
