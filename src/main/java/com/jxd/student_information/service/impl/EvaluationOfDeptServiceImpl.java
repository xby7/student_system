package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IEvaluationOfDeptMapper;
import com.jxd.student_information.model.EvaluationOfDept;
import com.jxd.student_information.service.IEvaluationOfDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class EvaluationOfDeptServiceImpl extends ServiceImpl<IEvaluationOfDeptMapper, EvaluationOfDept> implements IEvaluationOfDeptService {

    @Autowired
    private IEvaluationOfDeptMapper evaluationOfDeptMapper;

    //根据学生id获取学生评价信息===经理（cbb）
    @Override
    public EvaluationOfDept getEvaluationWithManagerByStudentId(int studentId, int periodNo) {
        return evaluationOfDeptMapper.selectEvaluationByStuIdWithManager(studentId, periodNo);
    }

    //评价学生===经理（cbb）
    @Override
    public boolean evaluatingStudentWithManager(EvaluationOfDept evaluationOfDept) {
        return evaluationOfDeptMapper.updateStudentQualityWithManager(evaluationOfDept);
    }
}
