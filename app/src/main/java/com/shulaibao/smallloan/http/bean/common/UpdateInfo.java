package com.shulaibao.smallloan.http.bean.common;

/**
 * 描述：更新版本信息
 * Created by Lee
 * on 2016/11/3.
 */
public class UpdateInfo {

    /**
     * created : 1478069914000
     * description : ss
     * isForce : 1
     * os : 7
     * toVersionCode : 102
     * updateType : 1
     * updateUrl : ss
     * version : 2.0.0
     * versionCode : 200
     * versionId : 5
     */

    private long created;
    private String description;
    private int isForce;
    private int os;
    private int toVersionCode;
    private int updateType;
    private String updateUrl;
    private String version;
    private int versionCode;
    private int versionId;
    private String patchVersion;

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsForce(int isForce) {
        this.isForce = isForce;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public void setToVersionCode(int toVersionCode) {
        this.toVersionCode = toVersionCode;
    }

    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public long getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public int getIsForce() {
        return isForce;
    }

    public int getOs() {
        return os;
    }

    public int getToVersionCode() {
        return toVersionCode;
    }

    public int getUpdateType() {
        return updateType;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public String getVersion() {
        return version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public int getVersionId() {
        return versionId;
    }

    @Override
    public String toString() {
        return "UpdateInfo{" +
                "created=" + created +
                ", description='" + description + '\'' +
                ", isForce=" + isForce +
                ", os=" + os +
                ", toVersionCode=" + toVersionCode +
                ", updateType=" + updateType +
                ", updateUrl='" + updateUrl + '\'' +
                ", version='" + version + '\'' +
                ", versionCode=" + versionCode +
                ", versionId=" + versionId +
                '}';
    }
}
