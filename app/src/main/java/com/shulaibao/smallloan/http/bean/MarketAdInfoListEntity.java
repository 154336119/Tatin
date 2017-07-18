package com.shulaibao.smallloan.http.bean;

/**
 * 刁剑
 * Created on 2017/1/9.
 * 注释:
 */

public class MarketAdInfoListEntity {
    private Integer adId;//广告ID
    private Integer spaceId;
    private String adTitle;//广告标题
    private String adPic;//广告图片
    private String adUrl;//广告图片跳转链接
    private String adDes;
    private Integer state;
    private Integer sort;//排序
    private Integer userId;
    private Long created;//创建时间戳
    private Long updated;////编辑时间戳

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdPic() {
        return adPic;
    }

    public void setAdPic(String adPic) {
        this.adPic = adPic;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getAdDes() {
        return adDes;
    }

    public void setAdDes(String adDes) {
        this.adDes = adDes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
