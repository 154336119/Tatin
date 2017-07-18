package com.shulaibao.smallloan.http.bean;

import android.os.Parcel;
import android.os.Parcelable;


import java.io.Serializable;

/**
 * 描述：
 * Created by Lee
 * on 2016/9/20.
 */
public class UserEntity implements Serializable, Parcelable {
    public static final String USER_CATEGORY_A= "A";
    public static final String USER_CATEGORY_B = "B";
    public static final String USER_CATEGORY_C = "C";

    private static final long serialVersionUID = -7060210544600464481L;

    /**
     * userId : 10025
     * parentId : 12
     * comId : 12
     * userName : 13730661953
     * sex : 1
     * password :
     * email :
     * emailValid :
     * mobile : 137306619534
     * manageName : 贺冷豪
     * manageMobile :
     * avatar :
     * type : 10
     * lastLogin : 1491979269000
     * lastLoginIp : 0:0:0:0:0:0:0:1
     * state : 9
     * remark :
     * lastMac : 6a592b1167ee3f5b809a71996e
     * isPerfect : 1
     * created : 1484461542000
     * updated : 1490529078000
     * fundNo :
     * fundCertificate :
     * source :
     * failedReason :
     * authentication : true
     * userAddress : null
     */

    private int userId;
    private int parentId;
    private int comId;
    private String userName;
    private Integer sex;
    private String password;
    private String email;
    private String emailValid;
    private String mobile;
    private String manageName;
    private String manageMobile;
    private String avatar;
    private int type;
    private long lastLogin;
    private String lastLoginIp;
    private int state;
    private String remark;
    private String lastMac;
    private int isPerfect;
    private long created;
    private long updated;
    private String fundNo;
    private String fundCertificate;
    private String source;
    private String failedReason;
    private boolean authentication;
    private boolean isLogin;
    private UserAddressEntity userAddress;
    private Integer questionScore;
    private String questionResult;
    private String userCategory;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailValid() {
        return emailValid;
    }

    public void setEmailValid(String emailValid) {
        this.emailValid = emailValid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getManageMobile() {
        return manageMobile;
    }

    public void setManageMobile(String manageMobile) {
        this.manageMobile = manageMobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastMac() {
        return lastMac;
    }

    public void setLastMac(String lastMac) {
        this.lastMac = lastMac;
    }

    public int getIsPerfect() {
        return isPerfect;
    }

    public void setIsPerfect(int isPerfect) {
        this.isPerfect = isPerfect;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getFundNo() {
        return fundNo;
    }

    public void setFundNo(String fundNo) {
        this.fundNo = fundNo;
    }

    public String getFundCertificate() {
        return fundCertificate;
    }

    public void setFundCertificate(String fundCertificate) {
        this.fundCertificate = fundCertificate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public UserAddressEntity getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddressEntity userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(Integer questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionResult() {
        return questionResult;
    }

    public void setQuestionResult(String questionResult) {
        this.questionResult = questionResult;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeInt(this.parentId);
        dest.writeInt(this.comId);
        dest.writeString(this.userName);
        dest.writeInt(this.sex);
        dest.writeString(this.password);
        dest.writeString(this.email);
        dest.writeString(this.emailValid);
        dest.writeString(this.mobile);
        dest.writeString(this.manageName);
        dest.writeString(this.manageMobile);
        dest.writeString(this.avatar);
        dest.writeInt(this.type);
        dest.writeLong(this.lastLogin);
        dest.writeString(this.lastLoginIp);
        dest.writeInt(this.state);
        dest.writeString(this.remark);
        dest.writeString(this.lastMac);
        dest.writeInt(this.isPerfect);
        dest.writeLong(this.created);
        dest.writeLong(this.updated);
        dest.writeString(this.fundNo);
        dest.writeString(this.fundCertificate);
        dest.writeString(this.source);
        dest.writeString(this.failedReason);
        dest.writeByte(this.authentication ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLogin ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.userAddress, flags);
        dest.writeValue(this.questionScore);
        dest.writeString(this.questionResult);
        dest.writeString(this.userCategory);
    }

    public UserEntity() {
    }

    protected UserEntity(Parcel in) {
        this.userId = in.readInt();
        this.parentId = in.readInt();
        this.comId = in.readInt();
        this.userName = in.readString();
        this.sex = in.readInt();
        this.password = in.readString();
        this.email = in.readString();
        this.emailValid = in.readString();
        this.mobile = in.readString();
        this.manageName = in.readString();
        this.manageMobile = in.readString();
        this.avatar = in.readString();
        this.type = in.readInt();
        this.lastLogin = in.readLong();
        this.lastLoginIp = in.readString();
        this.state = in.readInt();
        this.remark = in.readString();
        this.lastMac = in.readString();
        this.isPerfect = in.readInt();
        this.created = in.readLong();
        this.updated = in.readLong();
        this.fundNo = in.readString();
        this.fundCertificate = in.readString();
        this.source = in.readString();
        this.failedReason = in.readString();
        this.authentication = in.readByte() != 0;
        this.isLogin = in.readByte() != 0;
        this.userAddress = in.readParcelable(UserAddressEntity.class.getClassLoader());
        this.questionScore = (Integer) in.readValue(Integer.class.getClassLoader());
        this.questionResult = in.readString();
        this.userCategory = in.readString();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
