package com.system.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class Notice {
    @JsonProperty("noticId")
    private Integer noticeId;

    @JsonProperty("noticTitle")
    private String noticeTitle;

    @JsonProperty("noticContent")
    private String noticeContent;

    @JsonProperty("noticTime")
    @JSONField(format = "yyyy-MM-dd")
    private Date noticeTime;

    @JsonProperty("noticPublisher")
    private String noticePublisher;

    public Notice(Integer noticeId, String noticeTitle, String noticeContent, Date noticeTime, String noticePublisher) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeTime = noticeTime;
        this.noticePublisher = noticePublisher;
    }

    public Notice() {
        super();
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticePublisher() {
        return noticePublisher;
    }

    public void setNoticePublisher(String noticePublisher) {
        this.noticePublisher = noticePublisher == null ? null : noticePublisher.trim();
    }
}