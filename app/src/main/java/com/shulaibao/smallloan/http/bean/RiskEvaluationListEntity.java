package com.shulaibao.smallloan.http.bean;

/**
 * 作者：刁剑
 * Created by Administrator on 2017/4/12.
 * 描述：
 */

public class RiskEvaluationListEntity {
    private Long created;
    private String questionResult;

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getQuestionResult() {
        return questionResult;
    }

    public void setQuestionResult(String questionResult) {
        this.questionResult = questionResult;
    }
}
