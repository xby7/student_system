package com.jxd.student_information.mapper;

import com.jxd.student_information.model.EvaluationOfDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface IEvaluationOfDeptMapper extends BaseMapper<EvaluationOfDept> {


    /**
     * 获取学生评价信息===经理
     * @param studentId 学生id
     * @param periodNo  时期
     * @return
     * @Author cbb
     */
    EvaluationOfDept selectEvaluationByStuIdWithManager(@Param("studentId") int studentId,@Param("periodNo") int periodNo);

    /**
     * 评价学生===经理
     * @param evaluationOfSchool
     * @return
     * @Author cbb
     */
    boolean updateStudentQualityWithManager(EvaluationOfDept evaluationOfSchool);
}
