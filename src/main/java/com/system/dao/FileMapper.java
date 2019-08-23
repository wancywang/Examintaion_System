package com.system.dao;

import com.system.model.FileUpload;

import java.util.List;

public interface FileMapper {



    public FileUpload selectOneFile(int fileId) throws Exception;   //查找展示某一个文件



    public List<FileUpload> selectPartFile() throws Exception;   //默认显示8条



    public List<FileUpload> selectAllFile() throws Exception;   //查询出全部的信息



    public void uploadFile(FileUpload file) throws Exception;    //判断上传是否成功，管理员使用这个方法



}
