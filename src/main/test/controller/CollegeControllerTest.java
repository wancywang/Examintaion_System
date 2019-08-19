package controller;

import com.github.pagehelper.PageInfo;
import com.system.model.College;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.json.Json;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author: Alex
 * @Date: 2019/6/28 16:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","file:src/main/webapp/WEB-INF/web.xml"})
public class CollegeControllerTest {
    //传入SpringMvc的ioc
    @Autowired
    WebApplicationContext context;

    //虚拟mvc
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc =MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception{
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/college/lists").param("pn","1")).andReturn();
        //请求成功以后，请求域中会有pageInfo,我们可以取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();

        PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pi.getPageNum());
        System.out.println("总页码" + pi.getPages());
        System.out.println("总记录数" + pi.getTotal());
        System.out.println("再也没有需要连续显示的页码：");
        //获取员工数据
        List<College> list = pi.getList();
        for(College college:list){
            System.out.println("ID" + college.getCollegeId() + "Name" + college.getCollegeName());
        }
    }

}
