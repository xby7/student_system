package com.jxd.student_information.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.student_information.model.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService extends IService<Menu> {
    List<Map<String, Object>> queryMenuInfo(String userId);
}
