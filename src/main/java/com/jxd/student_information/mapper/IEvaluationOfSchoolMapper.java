package com.jxd.student_information.mapper;

import com.jxd.student_information.model.EvaluationOfSchool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface IEvaluationOfSchoolMapper extends BaseMapper<EvaluationOfSchool> {

    /**
     * 获取学生评价信息===教师
     * @param studentId 学生id
     * @return
     * @Author cbb
     */
    EvaluationOfSchool selectEvaluationByStuId(@Param("studentId") int studentId);


    /**
     * 评价学生===教师
     * @param evaluationOfSchool 封装的评价对象
     * @return
     * @Author cbb
     */
    boolean updateStudentWithTeacher(EvaluationOfSchool evaluationOfSchool);
}
