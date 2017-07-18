package com.shulaibao.smallloan.http.bean;

/**
 * Created by Administrator on 2017/5/10.
 */

public class Element {

    /**
     * resultCode : 00000000
     * resultMessage : 成功
     * status : 0
     * statusMessage : 身份核查成功一致
     * score :
     */

    private String resultCode;
    private String resultMessage;
    private String status;
    private String statusMessage;
    private String score;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Element{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", status='" + status + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
