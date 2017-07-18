package com.shulaibao.smallloan.http.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 刁剑
 * Created on 2017/2/28.
 * 注释:
 */

public class UserAddressEntity implements Parcelable {
    private Integer addressId;
    private Integer userId;
    private Integer province;
    private Integer city;
    private Integer area;
    private String address;
    private String completeAddress;
    private Long created;
    private Long updated;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.addressId);
        dest.writeValue(this.userId);
        dest.writeValue(this.province);
        dest.writeValue(this.city);
        dest.writeValue(this.area);
        dest.writeString(this.address);
        dest.writeString(this.completeAddress);
        dest.writeValue(this.created);
        dest.writeValue(this.updated);
    }

    public UserAddressEntity() {
    }

    protected UserAddressEntity(Parcel in) {
        this.addressId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.province = (Integer) in.readValue(Integer.class.getClassLoader());
        this.city = (Integer) in.readValue(Integer.class.getClassLoader());
        this.area = (Integer) in.readValue(Integer.class.getClassLoader());
        this.address = in.readString();
        this.completeAddress = in.readString();
        this.created = (Long) in.readValue(Long.class.getClassLoader());
        this.updated = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Creator<UserAddressEntity> CREATOR = new Creator<UserAddressEntity>() {
        @Override
        public UserAddressEntity createFromParcel(Parcel source) {
            return new UserAddressEntity(source);
        }

        @Override
        public UserAddressEntity[] newArray(int size) {
            return new UserAddressEntity[size];
        }
    };
}
