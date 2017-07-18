package com.shulaibao.smallloan.http.dns;

/**
 * 描述：
 * Created by Lee
 * on 2017/3/1.
 */

public class ReleaseDns implements Dns {
    private static ReleaseDns releaseDns;
    public static ReleaseDns getInstance(){
        if(releaseDns == null){
            releaseDns = new ReleaseDns();
        }
        return releaseDns;
    }

    @Override
    public String getCommonBaseUrl() {
//        return "http://118.123.245.196:9876/";
        return "http://118.123.245.196:9877/";
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
        return "http://fundv2.totodi.com/personal/index.html";
    }

    @Override
    public String getBasicText() {
        return "http://118.123.245.196:9911/";
    }

    @Override
    public String getOrgRiskAnswerUrl() {
        return "http://fundv2.totodi.com/mechanism/index.html";
    }
}
