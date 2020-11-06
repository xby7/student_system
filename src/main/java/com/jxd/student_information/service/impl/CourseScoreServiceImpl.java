package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.ICourseScoreMapper;
import com.jxd.student_information.model.CourseScore;
import com.jxd.student_information.service.ICourseScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class CourseScoreServiceImpl extends ServiceImpl<ICourseScoreMapper, CourseScore> implements ICourseScoreService {

    @Autowired
    private ICourseScoreMapper courseScoreMapper;

    /*批量更新单个学生的所有品质分数===教师(cbb)*/
    @Override
    public boolean updateStuScoreWithTeacher(List<CourseScore> list) {
        return courseScoreMapper.updateStuScoreWithTeacher(list);
    }

    /*根据学生id获取学生成绩信息===教师(cbb)*/
    @Override
    public List<Map<String, Object>> getScoreWithStudentId(int studentId) {
        return courseScoreMapper.selectScoreWithStudentId(studentId);
    }
}
