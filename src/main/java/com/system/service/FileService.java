package com.system.service;

import com.system.model.FileUpload;

import java.util.List;

public interface FileService {

    public FileUpload selectOneFile(int fileId) throws Exception;

    public List<FileUpload> selectPartFile() throws Exception;

    public List<FileUpload> selectAllFile() throws Exception;

    public void uploadFile(FileUpload file) throws Exception;



}


