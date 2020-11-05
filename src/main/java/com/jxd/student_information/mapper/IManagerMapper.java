package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IManagerMapper extends BaseMapper<Manager> {

    List<Map<String, Object>> selectAllManagerWithDept_name(@Param("managerName") String managerName);

    List<Map<String, Object>> selectAllManagerWithDept_nameByPage(@Param("pageStart") int pageStart,
                                                                  @Param("pageSize") int pageSize,
                                                                  @Param("managerName") String managerName);

    boolean insertManager(@Param("password")String password,
                          @Param("role")String role,
                          @Param("managerName") String managerName,
                          @Param("deptName") String deptName);

    boolean updateManagerById(@Param("managerId") int managerId, @Param("managerName") String managerName,
                              @Param("deptName") String deptName);
}
