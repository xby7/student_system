package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IManagerMapper extends BaseMapper<Manager> {

    List<Map<String, Object>> selectAllManagerWithDept_name(@Param("manager_name") String manager_name);

    List<Map<String, Object>> selectAllManagerWithDept_nameByPage(@Param("pageStart") int pageStart,
                                                                  @Param("pageSize") int pageSize,
                                                                  @Param("manager_name") String manager_name);

    boolean insertManager(@Param("managerName") String managerName, @Param("deptName") String deptName);
}
