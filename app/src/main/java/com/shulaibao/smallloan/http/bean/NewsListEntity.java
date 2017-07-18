package com.shulaibao.smallloan.http.bean;

import com.shulaibao.smallloan.http.bean.MarketAdInfoListEntity;

import java.util.List;

/**
 * 刁剑
 * Created on 2017/1/9.
 * 注释:
 */

public class NewsListEntity {
    private Integer spaceId;
    private Integer clientType;
    private Integer spaceType;
    private String spaceName;
    private String spaceKey;
    private String remark;
    private Integer state;
    private Long created;
    private List<MarketAdInfoListEntity> marketAdInfoList;

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(Integer spaceType) {
        this.spaceType = spaceType;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceKey() {
        return spaceKey;
    }

    public void setSpaceKey(String spaceKey) {
        this.spaceKey = spaceKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public List<MarketAdInfoListEntity> getMarketAdInfoList() {
        return marketAdInfoList;
    }

    public void setMarketAdInfoList(List<MarketAdInfoListEntity> marketAdInfoList) {
        this.marketAdInfoList = marketAdInfoList;
    }
}
