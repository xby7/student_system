package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.ITeacherMapper;
import com.jxd.student_information.model.Teacher;
import com.jxd.student_information.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<ITeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private ITeacherMapper teacherMapper;


   /* @Override
    public List<Map<String, Object>> getAllStuWithTeacher(String student_name,int teacher_id) {
        return teacherMapper.selectAllStu(student_name,teacher_id);
    }*/

    @Override
    public List<Map<String, Object>> getAllStuWithTeacherByPage(String student_name,int teacher_id ,int curPage, int pageSize) {
        int pageIndex = (curPage - 1) * pageSize;
        return teacherMapper.selectAllStuBypage(student_name,teacher_id,pageIndex,pageSize);
    }
}
