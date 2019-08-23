package com.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FileUpload{


    private int fileId;
    private String fileName;
    private String furl;
    private Date fdate;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    @Override
    public String toString() {
        return "FileUpload{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", furl='" + furl + '\'' +
                ", fdate=" + fdate +
                '}';
    }
}
