package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IQualityMapper;
import com.jxd.student_information.model.Quality;
import com.jxd.student_information.service.IQualityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class QualityServiceImpl extends ServiceImpl<IQualityMapper, Quality> implements IQualityService {
    @Autowired IQualityMapper qualityMapper;

    //获取全部的品质名称===经理(cbb)
    @Override
    public List<Map<String, Object>> getAllQualityName() {
        return qualityMapper.selectAllQualityName();
    }
}
