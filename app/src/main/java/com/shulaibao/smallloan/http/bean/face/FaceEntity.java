package com.shulaibao.smallloan.http.bean.face;

/**
 * Created by Administrator on 2017/4/21.
 */

public class FaceEntity {
   private Identity identity;
    private Selfie selfie;
    private String request_id;
    private String status;
    private Float confidence;

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Selfie getSelfie() {
        return selfie;
    }

    public void setSelfie(Selfie selfie) {
        this.selfie = selfie;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

}
