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

    @Override
    public List<Map<String,Object>> getAllStuTotalsWithTeacher(String student_name, int teacher_id) {
        //获取动态拼接sql
        List<String> dynamicSequence = teacherMapper.getSequence();
        //手动与固定列拼接
        String sql ="SELECT e.student_id,student_name,sex,folk,native_place,graduate_school,e.teacher_id,"+
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM " +
                " (" +
                " SELECT d.student_id,student_name,sex,folk,graduate_school,native_place,score,course_id,d.teacher_id" +
                " FROM " +
                " (" +
                " SELECT student_id,student_name,sex,folk,graduate_school,native_place,teacher_id" +
                " FROM student s" +
                " LEFT JOIN class c ON c.class_no = s.class_no) d" +
                " LEFT JOIN course_score cs ON d.student_id = cs.student_id) e" +
                " LEFT JOIN course c ON e.course_id = c.course_id" ;

        return teacherMapper.selectAllStuTotalsWithTeacher(student_name,teacher_id,sql);
    }

    @Override
    public List<Map<String, Object>> getAllStuWithTeacherByPage(String student_name,int teacher_id,int curPage, int pageSize) {
        //获取动态拼接sql
        List<String> dynamicSequence = teacherMapper.getSequence();
        //手动与固定列拼接
        String sql ="SELECT e.student_id,student_name,sex,folk,native_place,graduate_school,e.teacher_id,"+

                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM " +
                " (" +
                " SELECT d.student_id,student_name,sex,folk,graduate_school,native_place,score,course_id,d.teacher_id" +
                " FROM " +
                " (" +
                " SELECT student_id,student_name,sex,folk,graduate_school,native_place,teacher_id" +
                " FROM student s" +
                " LEFT JOIN class c ON c.class_no = s.class_no) d" +
                " LEFT JOIN course_score cs ON d.student_id = cs.student_id) e" +
                " LEFT JOIN course c ON e.course_id = c.course_id" ;
        int pageIndex = (curPage - 1) * pageSize;
        return teacherMapper.selectAllStuBypageWithTeacher(student_name,teacher_id,sql, pageIndex,pageSize);
    }

    @Override
    public boolean addTeacher(String teacherName) {
        return teacherMapper.insertTeacher(teacherName);
    }

    @Override
    public List<Teacher> getAllTeacher(String teacherName) {
        return teacherMapper.selectAllTeacher(teacherName);
    }

    @Override
    public List<Teacher> getAllTeacherByPage(int pageSize, int currentPage,String teacherName) {
        int pageStart = (currentPage-1)*pageSize;
        return teacherMapper.selectAllTeacherByPage(pageStart,pageSize,teacherName);
    }

    @Override
    public boolean updateTeacherById(int teacherId, String teacherName) {
        return teacherMapper.updateTeacherById(teacherId,teacherName);
    }

}
