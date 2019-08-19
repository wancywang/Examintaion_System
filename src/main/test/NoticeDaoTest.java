import com.system.dao.CollegeMapper;
import com.system.dao.NoticeMapper;
import com.system.model.College;
import com.system.model.CollegeExample;
import com.system.model.Student;
import com.system.model.StudentCustom;
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
    private StudentService studentService;
    @Test
    public void testSelectUser() throws Exception{
        long id = 1;
        College college = collegeMapper.selectByPrimaryKey(1);
        System.out.println(college.getCollegeName());
        CollegeExample collegeExample = new CollegeExample();
        List<College> collegeList =collegeMapper.selectByExample(collegeExample);
        for(College college1:collegeList){
            System.out.println(college1.getCollegeName());
        }
    }

    @Test
    public void test() throws Exception{
        Integer id = 10002;
        StudentCustom student = studentService.findStudentById(id);
        System.out.println(student.toString());

    }
}
