package com.shulaibao.smallloan.http.bean;

/**
 * 描述：
 * Created by Lee
 * on 2016/12/26.
 */
public class MsgEntity {

    /**
     * content : 我的消息在哪里
     * created : 1482214677000
     * messageId : 1
     * orderFieldNextType : ASC
     * pageSize : 5
     * params : ds
     * state : 1
     * title : dds
     * type : 1
     * updated : 1482401815000
     * userId : 2
     */

    private String content;
    private long created;
    private int messageId;
    private String orderFieldNextType;
    private int pageSize;
    private String params;
    private int state;
    private String title;
    private int type;
    private long updated;
    private int userId;
    private int id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getOrderFieldNextType() {
        return orderFieldNextType;
    }

    public void setOrderFieldNextType(String orderFieldNextType) {
        this.orderFieldNextType = orderFieldNextType;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
