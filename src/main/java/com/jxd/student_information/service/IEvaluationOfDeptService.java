package com.jxd.student_information.service;

import com.jxd.student_information.model.EvaluationOfDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IEvaluationOfDeptService extends IService<EvaluationOfDept> {
    //根据学生id获取学生评价信息===经理（cbb）
    EvaluationOfDept getEvaluationWithManagerByStudentId(int studentId,int periodNo);

    //评价学生===经理（cbb）
    boolean evaluatingStudentWithManager(EvaluationOfDept evaluationOfDept);
}
