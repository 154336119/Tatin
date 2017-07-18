package com.shulaibao.smallloan.http.bean.face;

/**
 * Created by Administrator on 2017/5/23.
 */

public class Identity {

    /**
     * validity : true
     * photo_id : 6963927a2b1e4fbc9abd9ff15638a2b5
     * reason : xxx
     */

    private boolean validity;
    private String photo_id;
    private String reason;

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
