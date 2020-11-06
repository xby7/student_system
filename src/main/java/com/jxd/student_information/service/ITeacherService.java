package com.jxd.student_information.service;

import com.jxd.student_information.model.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface ITeacherService extends IService<Teacher> {

    //获取分页数据===教师（cbb）
    List<Map<String,Object>> getAllStuWithTeacherByPage(String student_name,int teacher_id,int curPage,int pageSize);
    //获取学生总数===教师(cbb)
    List<Map<String,Object>> getAllStuTotalsWithTeacher(String student_name, int teacher_id);

    boolean addTeacher(String teacherName);

    List<Teacher> getAllTeacher(String teacherName);

    List<Teacher> getAllTeacherByPage(int pageSize,int currentPage,String teacherName);

    boolean updateTeacherById(int teacherId, String teacherName);
}
