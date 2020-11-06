package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IClassMapper extends BaseMapper<Class> {

    List<Map<String, Object>> selectAllClassWithTeacher_name();

    List<Map<String, Object>> selectAllClassWithTeacher_nameByPage(@Param("pageStart") int pageStart,
                                                                  @Param("pageSize") int pageSize);

    boolean insertClass(@Param("teacherId") int teacherId);

    boolean updateClassById(@Param("classNo") int classNo, @Param("teacherId") int teacherId);

}
