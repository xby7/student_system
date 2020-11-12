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

    /*获取总数===教师(cbb)*/
    @Override
    public List<Map<String,Object>> getAllStuTotalsWithTeacher(String student_name, int teacher_id) {
        //获取动态拼接sql
        List<String> dynamicSequence = teacherMapper.getSequence();
        //手动与固定列拼接
        String sql ="SELECT s.student_id,student_name,sex,native_place,graduate_school,teacher_id,overall_score," +
                "evaluation_form_school,isdeleted,score,course_name," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM student s " +
                " LEFT JOIN class c ON s.class_no = c.class_no " +
                " LEFT JOIN course_score cs ON s.student_id = cs.student_id" +
                " LEFT JOIN course co ON co.course_id = cs.course_id " +
                " LEFT JOIN evaluation_of_school eos ON s.student_id = eos.student_id";

        return teacherMapper.selectAllStuTotalsWithTeacher(student_name,teacher_id,sql);
    }

    /*获取分页后的数据===教师(cbb)*/
    @Override
    public List<Map<String, Object>> getAllStuWithTeacherByPage(String student_name,int teacher_id,int curPage, int pageSize) {
        //获取动态拼接sql
        List<String> dynamicSequence = teacherMapper.getSequence();
        //手动与固定列拼接
        String sql ="SELECT s.student_id,student_name,sex,native_place,graduate_school,teacher_id,overall_score," +
                "evaluation_form_school,isdeleted,score,course_name," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM student s " +
                " LEFT JOIN class c ON s.class_no = c.class_no " +
                " LEFT JOIN course_score cs ON s.student_id = cs.student_id" +
                " LEFT JOIN course co ON co.course_id = cs.course_id " +
                " LEFT JOIN evaluation_of_school eos ON s.student_id = eos.student_id";
        int pageIndex = (curPage - 1) * pageSize;
        return teacherMapper.selectAllStuBypageWithTeacher(student_name,teacher_id,sql, pageIndex,pageSize);
    }

    @Override
    public boolean addTeacher(String role,String password,String teacherName) {
        return teacherMapper.insertTeacher(role,password,teacherName);
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
