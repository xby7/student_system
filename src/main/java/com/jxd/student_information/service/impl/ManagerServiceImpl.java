package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IManagerMapper;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<IManagerMapper, Manager> implements IManagerService {

}
