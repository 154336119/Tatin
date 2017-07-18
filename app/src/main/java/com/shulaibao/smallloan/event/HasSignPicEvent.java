package com.shulaibao.smallloan.event;

/**
 * Created by YoKeyword on 16/6/5.
 */
public class HasSignPicEvent {
    public String picPath;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public HasSignPicEvent(String picPath) {
        this.picPath = picPath;
    }
}
