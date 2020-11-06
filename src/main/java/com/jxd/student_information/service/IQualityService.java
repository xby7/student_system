package com.jxd.student_information.service;

import com.jxd.student_information.model.Quality;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public interface IQualityService extends IService<Quality> {

    //获取全部的品质名称===经理(cbb)
    List<Map<String,Object>> getAllQualityName();

}
