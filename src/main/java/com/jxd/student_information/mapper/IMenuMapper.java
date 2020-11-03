package com.jxd.student_information.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.student_information.model.Menu;

import java.util.List;
import java.util.Map;


public interface IMenuMapper extends BaseMapper<Menu> {

    List<Map<String, Object>> queryMenuInfo(String userId);

}
