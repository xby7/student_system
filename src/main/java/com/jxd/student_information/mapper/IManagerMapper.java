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

    boolean insertManager(@Param("role")String role,
                          @Param("password")String password,
                          @Param("managerName") String managerName,
                          @Param("deptName") String deptName);

    boolean updateManagerById(@Param("managerId") int managerId, @Param("managerName") String managerName,
                              @Param("deptName") String deptName);


    /**
     * 获取总数===经理
     * @param studentName
     * @param managerId
     * @param periodNo
     * @param sql
     * @return
     * @Author cbb
     */
    List<Map<String,Object>> selectAllStuTotalsWithManager(@Param("studentName") String studentName,
                                                           @Param("managerId") int managerId,
                                                           @Param("periodNo") int periodNo,
                                                           @Param("sql") String sql
                                                           );

    /**
     * 获取分页后的数据===经理
     * @param studentName
     * @param managerId
     * @param periodNo
     * @param sql
     * @param pageIndex
     * @param pageSize
     * @return
     * @Author cbb
     */
    List<Map<String,Object>> selectAllStuBypageWithManager(@Param("studentName") String studentName,
                                                           @Param("managerId") int managerId,
                                                           @Param("periodNo") int periodNo,
                                                           @Param("sql") String sql,
                                                           @Param("pageIndex") int pageIndex,
                                                           @Param("pageSize") int pageSize);

    /**
     * 获取动态的行转列SQL语句===经理
     * @return
     * @Author cbb
     */
    List<String> getSequenceWithManager();

    boolean batchdelete(@Param("managerIds") List<Integer> managerIds);
}
