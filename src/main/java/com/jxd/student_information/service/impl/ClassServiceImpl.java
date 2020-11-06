package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IClassMapper;
import com.jxd.student_information.model.Class;
import com.jxd.student_information.service.IClassService;
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
public class ClassServiceImpl extends ServiceImpl<IClassMapper, Class> implements IClassService {

    @Autowired
    IClassMapper classMapper;

    @Override
    public List<Map<String, Object>> getAllClassWithTeacher_name() {
        return classMapper.selectAllClassWithTeacher_name();
    }

    @Override
    public List<Map<String, Object>> getAllClassWithTeacher_nameByPage(int pageSize, int currentPage) {
        int pageStart = (currentPage - 1) * pageSize;
        return classMapper.selectAllClassWithTeacher_nameByPage(pageStart, pageSize);
    }

    @Override
    public boolean addClass(int teacherId) {
        return classMapper.insertClass(teacherId);
    }

    @Override
    public boolean updateClassById(int classNo, int teacherId) {
        return classMapper.updateClassById(classNo,teacherId);
    }
}
