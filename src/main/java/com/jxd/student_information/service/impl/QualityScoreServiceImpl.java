package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IQualityScoreMapper;
import com.jxd.student_information.model.QualityScore;
import com.jxd.student_information.service.IQualityScoreService;
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
public class QualityScoreServiceImpl extends ServiceImpl<IQualityScoreMapper, QualityScore> implements IQualityScoreService {
    @Autowired
    private IQualityScoreMapper qualityScoreMapper;

    /*获取学生的品质分数信息===经理(cbb)*/
    @Override
    public List<Map<String, Object>> getScoreWithManagerByStudentId(int studentId,int periodOn) {
        return qualityScoreMapper.selectScoreWithManagerByStudentId(studentId,periodOn);
    }

    /*批量更新单个学生的所有品质分数===经理(cbb)*/
    @Override
    public boolean updateStuScoreWithManager(List<QualityScore> qualityScores) {
        return qualityScoreMapper.updateStuScoreWithManager(qualityScores);
    }
}
