package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IEvaluationOfSchoolMapper;
import com.jxd.student_information.model.EvaluationOfSchool;
import com.jxd.student_information.service.IEvaluationOfSchoolService;
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
public class EvaluationOfSchoolServiceImpl extends ServiceImpl<IEvaluationOfSchoolMapper, EvaluationOfSchool> implements IEvaluationOfSchoolService {

    @Autowired
    private IEvaluationOfSchoolMapper evaluationOfSchoolMapper;

    //根据学生id获取学生评价信息===教师（cbb）
    @Override
    public EvaluationOfSchool getEvaluationWithStudentId(int studentId) {
        return evaluationOfSchoolMapper.selectEvaluationByStuId(studentId);
    }

    //评价学生===教师（cbb）
    @Override
    public boolean evaluatingStudent(EvaluationOfSchool evaluationOfSchool) {
        return evaluationOfSchoolMapper.updateStudentWithTeacher(evaluationOfSchool);
    }
}
