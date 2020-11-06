import com.jxd.student_information.StudentInformationApplication;
import com.jxd.student_information.mapper.IStudentMapper;
import com.jxd.student_information.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description
 * @Author liukai
 * @Date 2020/10/29
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudentInformationApplication.class)
public class Test1 {
    @Autowired
    private IStudentMapper studentMapper;

    @Autowired
    private IStudentService studentService;

    @Test
    public void teis(){
        List<Map<String,Object>> list = studentService.getAllStudentByPage("",0,1,5);
        for (Map map:list){
            System.out.println(map.get("student_name"));
        }
    }

}
