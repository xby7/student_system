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
    //List<Map<String,Object>> selectAllStu(@Param("student_name") String student_name,@Param("teacher_id") int teacher_id);

    List<Map<String,Object>> selectAllStuBypage(@Param("student_name") String student_name,
                                                @Param("teacher_id") int teacher_id,
                                                @Param("pageIndex") int pageIndex,
                                                @Param("pageSize") int pageSize);
}
