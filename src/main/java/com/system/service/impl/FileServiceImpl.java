package com.system.service.impl;

import com.system.dao.FileMapper;
import com.system.model.FileUpload;
import com.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;


    @Override
    public FileUpload selectOneFile(int fileId) throws Exception {
        return fileMapper.selectOneFile(fileId);
    }

    @Override
    public List<FileUpload> selectPartFile() throws Exception {
        return fileMapper.selectPartFile();
    }

    @Override
    public List<FileUpload> selectAllFile() throws Exception {
        return fileMapper.selectAllFile();
    }

    @Override
    public void uploadFile(FileUpload file) throws Exception {
       fileMapper.uploadFile(file);
    }
}
