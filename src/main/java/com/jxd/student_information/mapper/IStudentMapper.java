package com.jxd.student_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.student_information.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentMapper extends BaseMapper<Student> {
    /**
     * 通过姓名、班期查找学生
     * @return
     */
    List<Map<String,Object>> getAllStudent(@Param("student_name") String student_name, @Param("class_no") int class_no);

    /**
     * 分页查询
     * @param student_name
     * @param class_no
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Map<String,Object>> getAllStudentByPage(@Param("student_name") String student_name, @Param("class_no") int class_no, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 新增学员信息
     * @param student 接收一个学员对象，里面封装了学员的信息
     * @return 返回是否新增成功
     */
    boolean addStudents(Student student);

    /**
     * 删除学员信息
     * @param studentId 接收id
     * @return 返回是否删除成本
     */
    boolean delStudent(Integer studentId);

    /**
     * 修改学员信息
     * @param student
     * @return
     */

    boolean editStudent(Student student);


    /**
     * 用户查询学生信息
     * @param studentId
     * @return
     * @Author cbb
     */
    Map<String, Object> selectStudentWithUserById(@Param("studentId") int studentId);

    boolean delSelectStu(@Param("stu_id") List<Integer> stu_id);


}
