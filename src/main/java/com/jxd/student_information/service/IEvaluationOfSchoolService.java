package com.jxd.student_information.service;

import com.jxd.student_information.model.EvaluationOfSchool;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface IEvaluationOfSchoolService extends IService<EvaluationOfSchool> {

    //根据学生id获取学生评价信息===教师（cbb）
    EvaluationOfSchool getEvaluationWithStudentId(int studentId);

    //评价学生===教师（cbb）
    boolean evaluatingStudent(EvaluationOfSchool evaluationOfSchool);
}
