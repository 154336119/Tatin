package com.shulaibao.smallloan.http.bean.face;

/**
 * Created by Administrator on 2017/4/24.
 */

public class FaceInsideEntity {
    private Position position;
    private Landmark landmark;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }
}
