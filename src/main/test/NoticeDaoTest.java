import com.system.dao.CollegeMapper;
import com.system.dao.NoticeMapper;
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
import java.util.List;

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
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Test
    public void testCourse() throws Exception{
        Integer id = 1;
        Integer studentId = 10001;
        List<CourseCustom> courseCustoms = courseService.findStudentAndSelectCourseListById(studentId);
        for (CourseCustom courseCustom:courseCustoms){
            System.out.println(courseCustom);
        }
    }

    @Test
    public void test() throws Exception{
        Integer id = 10002;
        StudentCustom student = studentService.findStudentById(id);
        System.out.println(student.toString());

    }
}
