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
    //List<Map<String,Object>> getAllStuWithTeacher(String student_name,int teacher_id);

    List<Map<String,Object>> getAllStuWithTeacherByPage(String student_name,int teacher_id,int curPage,int pageSize);
}
