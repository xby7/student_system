package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDeptMapper extends BaseMapper<Dept> {

    boolean insertDept(@Param("deptName") String deptName);

    List<Dept> selectAllDept(@Param("deptName") String deptName);

    List<Dept> selectAllDeptByPage(@Param("pageStart") int pageStart,
                                   @Param("pageSize") int pageSize,
                                   @Param("deptName") String deptName);

    boolean updateDeptById(@Param("deptNo") int deptNo, @Param("deptName") String deptName);
}
