package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentMapper extends BaseMapper<Student> {
    /**
     * 通过姓名、班期查找学生
     * @return
     */
    List<Map<String,Object>> getAllStudent(@Param("student_name")String student_name, @Param("class_no")int class_no);

    /**
     * 分页查询
     * @param student_name
     * @param class_no
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Map<String,Object>> getAllStudentByPage(@Param("student_name")String student_name, @Param("class_no")int class_no,@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 新增学员信息
     * @param student 接收一个学员对象，里面封装了学员的信息
     * @return 返回是否新增成功
     */
    boolean addStudents(Student student);

    boolean delStudent(Integer studentId);


}
