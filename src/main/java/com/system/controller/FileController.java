package com.system.controller;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.system.model.FileUpload;
import com.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class FileController {


    @Autowired
    private FileService fileService;

    @RequestMapping("/selectOneFile")
    @ResponseBody
    public FileUpload selectOneFile(HttpServletRequest request , HttpServletResponse response,int fileId) throws Exception{
        return fileService.selectOneFile(fileId);
    }


    @RequestMapping(value = "/selectPartFile",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String,Object> selectPartFile(HttpServletRequest request , HttpServletResponse response) throws Exception {
        System.out.println("进入方法了");
        List<FileUpload> list = fileService.selectPartFile();
        for (FileUpload fileUpload : list) {
            System.out.println(fileUpload);
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",200);
        map.put("msg","获取文件列表成功");
        map.put("count",8);
        map.put("data",list);

        return map;
    }


    @RequestMapping("/selectAllFile")
    @ResponseBody
    public Map<String,Object> selectAllFile(HttpServletRequest request , HttpServletResponse response) throws Exception{

        List<FileUpload> list  =  fileService.selectAllFile();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",200);
        map.put("msg","获取文件列表成功");
        map.put("data",list);

        return map;
    }



    @RequestMapping("/uploadFile")
    @ResponseBody
    //返回1表示上传成功，返回0表示上传失败
    public int  uploadFile(HttpServletRequest request , HttpServletResponse response, MultipartFile file) throws Exception{

        try {
            //获取文件名称
            String originalFilename = file.getOriginalFilename();
            //进行保存文件,路径为以下
            String path="d:\\uploadFile\\"+originalFilename;
            file.transferTo(new File(path));
            //保存好文件后把文件的数据存进数据库里面
            FileUpload fileUpload = new FileUpload();
            fileUpload.setFileName(originalFilename);
            fileUpload.setFurl(path);
            fileUpload.setFdate(new Date());
            fileService.uploadFile(fileUpload);

            return 1;

    }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    @RequestMapping("/downloadFile")
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,int fileId) throws Exception{
           System.out.println("文件的主键是"+fileId);
           FileUpload fileUpload = fileService.selectOneFile(fileId);
           String filename=fileUpload.getFileName();
           String url = fileUpload . getFurl();
           System.out.println(url);
           InputStream inStream = new FileInputStream(new File("D:"+File.separator+"uploadFile"+File.separator+filename));// 文件的存放路径
           // 设置输出的格式
          response.reset();
          response.setContentType("bin");
          String uuid = UUID.randomUUID().toString();
          String extend = filename.substring(filename.lastIndexOf("."));
          response.setContentType("");
          response.addHeader("Content-Disposition", "attachment; filename="+ new String((filename).getBytes(),"ISO8859-1"));
        // 循环取出流中的数据
         byte[] b = new byte[100];
         int len;
         try {
            while ((len = inStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();

//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("code",200);
//            map.put("msg","下载成功");
//            return map;

        } catch (IOException e) {
             e.printStackTrace();
        }
    }




}
