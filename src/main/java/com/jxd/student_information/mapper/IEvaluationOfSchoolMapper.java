package com.jxd.student_information.mapper;

import com.jxd.student_information.model.EvaluationOfSchool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IEvaluationOfSchoolMapper extends BaseMapper<EvaluationOfSchool> {

    //根据学生id获取学生评价信息
    EvaluationOfSchool selectEvaluationByStuId(@Param("studentId") int studentId);

    //评价学生
    boolean updateStudentWithTeacher(EvaluationOfSchool evaluationOfSchool);
}
