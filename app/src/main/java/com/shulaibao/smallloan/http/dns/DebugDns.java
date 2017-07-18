package com.shulaibao.smallloan.http.dns;

/**
 * 描述：
 * Created by Lee
 * on 2017/3/1.
 */

public class DebugDns implements Dns {
    private static DebugDns debugDns;
    public static DebugDns getInstance(){
        if(debugDns == null){
            debugDns = new DebugDns();
        }
        return debugDns;
    }
    @Override
    public String getCommonBaseUrl() {
//        return "http://118.123.245.196:9876/";
        return "http://192.168.0.252:9877/";
    }

    @Override
    public String getMsgUrl() {
        return "http://118.123.245.196:10086/";
//        return "http://api.live.totodi.com/message-service/";
    }

    @Override
    public String getUploadUrl() {
        return "http://118.123.245.198:9999/fs/file/uploadToLocal";
//        return "http://api.live.totodi.com/fs/fs/file/uploadToLocal";
    }

    @Override
    public String getUploadForPdfUrl() {
        return "http://118.123.245.198:9999/pdf/transformToImg?pdfURL=";
//        return "http://api.live.totodi.com/fs/pdf/transformToImg?pdfURL=";
    }

    @Override
    public String getWebPanelUrl() {
        return "http://trust.totodi.com/templates/h5/sign.html";
    }

    @Override
    public String getContractBaseUrl() {
        return "http://118.123.245.198:8981/";
//        return "http://api.live.totodi.com/zuul/ess/";
    }

    @Override
    public String getRiskAnswerUrl() {
        return "http://192.168.0.252:81/personal/index.html";
    }

    @Override
    public String getBasicText() {
        return "http://118.123.245.196:9911/";
    }

    @Override
    public String getOrgRiskAnswerUrl() {
        return "http://192.168.0.252:81/mechanism/index.html ";
    }
}
