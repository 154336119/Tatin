package com.shulaibao.smallloan.http.dns;

/**
 * 描述：
 * Created by Lee
 * on 2017/3/1.
 */

public class LiveDns implements Dns {
    private static LiveDns liveDns;
    public static LiveDns getInstance(){
        if(liveDns == null){
            liveDns = new LiveDns();
        }
        return liveDns;
    }
    @Override
    public String getCommonBaseUrl() {
        return "http://118.123.245.196:9988/";
    }

    @Override
    public String getMsgUrl() {
        return "http://118.123.245.196:10086/";
    }

    @Override
    public String getUploadUrl() {
        return "http://118.123.245.197:9999/fs/file/uploadToLocal";
    }

    @Override
    public String getUploadForPdfUrl() {
        return "http://118.123.245.197:9999/pdf/transformToImg?pdfURL=";
    }

    @Override
    public String getWebPanelUrl() {
        return "http://118.123.245.198/templates/h5/sign.html";
    }

    @Override
    public String getContractBaseUrl() {
        return "http:/118.123.245.197:8981/";
    }

    @Override
    public String getRiskAnswerUrl() {
        return "http://118.123.245.196:92/h5/index.html";
    }

    @Override
    public String getBasicText() {
        return "http://118.123.245.196:9911/";
    }
    @Override
    public String getOrgRiskAnswerUrl() {
        return "http://192.168.0.252:81/mechanism/index.html  ";
    }
}
