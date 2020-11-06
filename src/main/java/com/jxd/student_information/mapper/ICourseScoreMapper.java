package com.jxd.student_information.mapper;

import com.jxd.student_information.model.CourseScore;
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
public interface ICourseScoreMapper extends BaseMapper<CourseScore> {

    /**
     * 教师打分
     * @param list list集合(成绩对象)
     * @return
     * @Author cbb
     */
    boolean updateStuScoreWithTeacher(List<CourseScore> list);

    //根据学生id获取学生成绩信息（cbb）
    List<Map<String, Object>> selectScoreWithStudentId(@Param("studentId") int studentId);
}
