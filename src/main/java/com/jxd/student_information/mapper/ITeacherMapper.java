package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Teacher;
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
public interface ITeacherMapper extends BaseMapper<Teacher> {
    //获取总数
    List<Map<String,Object>> selectAllStuTotalsWithTeacher(@Param("student_name") String student_name,
                                          @Param("teacher_id") int teacher_id,String sql);
    //获取分页后的数据
    List<Map<String,Object>> selectAllStuBypageWithTeacher(@Param("student_name") String student_name,
                                                @Param("teacher_id") int teacher_id,String sql,
                                                @Param("pageIndex") int pageIndex,
                                                @Param("pageSize") int pageSize);

    //获取动态的行转列SQL语句
    List<String> getSequence();

    boolean insertTeacher(@Param("teacherName") String teacherName);

    List<Teacher> selectAllTeacher(@Param("teacherName") String teacherName);

    List<Teacher> selectAllTeacherByPage(@Param("pageStart") int pageStart,
                                         @Param("pageSize") int pageSize,
                                         @Param("teacherName") String teacherName);
}
