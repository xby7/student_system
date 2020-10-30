package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Manager;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface IManagerMapper extends BaseMapper<Manager> {
    List<Map<String,Object>> selectAllstu();

}
