package com.system.model;

import java.util.Date;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */

public class Notice {
    private Integer noticeId;

    private String noticeTitle;

    private String noticeContent;

    private Date noticeTime;

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