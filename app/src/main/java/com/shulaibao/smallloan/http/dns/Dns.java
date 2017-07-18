package com.shulaibao.smallloan.http.dns;

/**
 * 描述：
 * Created by Lee
 * on 2017/3/1.
 */

public interface Dns {
    /**通用接口**/
    public String getCommonBaseUrl();
    /**消息接口**/
    public String getMsgUrl();
    /**上传接口**/
    public String getUploadUrl();
    /**pdf显示接口**/
    public String getUploadForPdfUrl();
    /**手写板**/
    public String getWebPanelUrl();
    /**合同相关 **/
    public String getContractBaseUrl();
    /**个人-风险调查问卷 **/
    public String getRiskAnswerUrl();
    /**机构-风险调查问卷 **/
    public String getOrgRiskAnswerUrl();
    /**获取纯文本*/
    public String getBasicText();
}
