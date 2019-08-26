import com.alibaba.fastjson.JSONArray;
import com.system.dao.*;
import com.system.model.*;
import com.system.service.CourseService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class NoticeDaoTest {

    @Resource
    private CollegeMapper collegeMapper;

    @Autowired
    private SelectedCourseService selectedCourseService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherMapperCustom teacherMapperCustom;

    @Test
    public void testCourse() throws Exception{
        List<TeacherCustom> teacherCustoms = teacherMapperCustom.findAllCourseCustom();
        Map<String,Object> m =new HashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i = 0;i < teacherCustoms.size();i++){
                for (int j = 0;j <teacherCustoms.size();j++){

                }
            }
    }

    @Test
    public void test() throws Exception{
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andCollegeIdEqualTo(1);
//        List<Course> courseList = courseMapper.findAllCourse();
//            System.out.println(JSONArray.toJSON(courseList));
//        List<Course> courseList = courseMapper.selectByExample(null);
        List<CourseCustom> courseList = courseService.findAllCourse();
        System.out.println(JSONArray.toJSON(courseList));
    }
}
