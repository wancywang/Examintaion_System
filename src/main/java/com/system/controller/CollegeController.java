package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.model.College;
import com.system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/6/28 15:31
 */
@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @RequestMapping(value = "/collegelists",method = RequestMethod.GET)
    @ResponseBody
    public String getCollege(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model) throws Exception {
        //引入PageHelper分页插件
        //查询之前需要调用,,传入页码，以及每页的大小
        PageHelper.startPage(pn,50);
        //startPage后面紧跟的是这个查询就是一个分页查询
        List<College> colleges = collegeService.queryAllCollege();
        //使用pageInfo包装查询后的结果，只需要将Pageinfo交给页面就行了
        //封装了详细的分页信息，包括我们查出来的数据,传入连续显示的数据
        PageInfo page = new PageInfo(colleges,5);
        model.addAttribute("pageInfo",page);
        return page.toString();
    }

    @RequestMapping(value = "list/{collegeId}",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String showCollege(@PathVariable("collegeId")int collegeId) throws Exception{
       College college = collegeService.queryById(collegeId);
        return college.toString();
    }
}
