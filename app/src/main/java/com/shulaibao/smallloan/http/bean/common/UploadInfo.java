package com.shulaibao.smallloan.http.bean.common;

/**
 * 描述：上传信息
 * Created by Lee
 * on 2016/11/3.
 */
public class UploadInfo {

    /**
     * fileName : dbs_20161124.sql
     * downLoad : http://192.168.0.251:83/pc/201612/852f0e1b-78ba-4232-8dc4-9a1424f0cff8.sql
     */

    private String fileName;
    private String downLoad;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDownLoad(String downLoad) {
        this.downLoad = downLoad;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDownLoad() {
        return downLoad;
    }

    @Override
    public String toString() {
        return "UploadInfo{" +
                "fileName='" + fileName + '\'' +
                ", downLoad='" + downLoad + '\'' +
                '}';
    }
}
