package com.jxd.student_information.mapper;

import com.jxd.student_information.model.Quality;
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
public interface IQualityMapper extends BaseMapper<Quality> {

    /**
     * 获取全部的品质名称===经理
     * @return
     * @Author cbb
     */
    List<Map<String,Object>> selectAllQualityName();

}
