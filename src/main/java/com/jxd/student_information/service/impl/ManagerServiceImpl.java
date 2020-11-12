package com.jxd.student_information.service.impl;

import com.jxd.student_information.mapper.IManagerMapper;
import com.jxd.student_information.model.Manager;
import com.jxd.student_information.service.IManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<IManagerMapper, Manager> implements IManagerService {

    @Autowired
    IManagerMapper managerMapper;

    @Override
    public List<Map<String, Object>> getAllManagerWithDept_name(String managerName) {
        return managerMapper.selectAllManagerWithDept_name(managerName);
    }

    @Override
    public List<Map<String, Object>> getAllManagerWithDept_nameByPage(int pageSize, int currentPage, String managerName) {
        int pageStart = (currentPage - 1) * pageSize;
        return managerMapper.selectAllManagerWithDept_nameByPage(pageStart, pageSize, managerName);
    }

    @Override
    public boolean addManager(String role, String password, String managerName, String deptName) {
        return managerMapper.insertManager(role,password,managerName, deptName);
    }

    @Override
    public boolean updateManagerById(int managerId, String managerName, String deptName) {
        return managerMapper.updateManagerById(managerId,managerName,deptName);
    }

    /*获取分页后的数据===经理(cbb)*/
    @Override
    public List<Map<String, Object>> getAllStuWithManagerByPage(String studentName, int managerId, int periodNo,
                                                                int curPage, int pageSize) {
        //获取动态拼接sql
        List<String> dynamicSequence = managerMapper.getSequenceWithManager();
        //手动与固定列拼接
        String sql = "SELECT s.student_id,student_name,sex,graduate_school,native_place,score,quality_name," +
                "eod.overall_score dept,evaluation_form_dept,eos.overall_score school,evaluation_form_school," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM student s" +
                " LEFT JOIN dept d ON s.dept_no = d.dept_no" +
                " LEFT JOIN manager m ON m.dept_no = d.dept_no" +
                " LEFT JOIN quality_score qs ON qs.student_id = s.student_id" +
                " LEFT JOIN quality q ON q.quality_id = qs.quality_id" +
                " LEFT JOIN evaluation_of_dept eod ON eod.student_id = s.student_id" +
                " LEFT JOIN evaluation_of_school eos ON eos.student_id = s.student_id";
        int pageIndex = (curPage - 1) * pageSize;
        return managerMapper.selectAllStuBypageWithManager(studentName,managerId,periodNo,sql,pageIndex,pageSize);
    }

    /*获取总数===经理(cbb)*/
    @Override
    public List<Map<String, Object>> getAllStuTotalsWithManager(String studentName, int managerId, int periodNo) {
        //获取动态拼接sql
        List<String> dynamicSequence = managerMapper.getSequenceWithManager();
        //手动与固定列拼接
        String sql = "SELECT s.student_id,student_name,sex,graduate_school,native_place,score,quality_name," +
                "eod.overall_score dept,evaluation_form_dept,eos.overall_score school,evaluation_form_school," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM student s" +
                " LEFT JOIN dept d ON s.dept_no = d.dept_no" +
                " LEFT JOIN manager m ON m.dept_no = d.dept_no" +
                " LEFT JOIN quality_score qs ON qs.student_id = s.student_id" +
                " LEFT JOIN quality q ON q.quality_id = qs.quality_id" +
                " LEFT JOIN evaluation_of_dept eod ON eod.student_id = s.student_id" +
                " LEFT JOIN evaluation_of_school eos ON eos.student_id = s.student_id";

        return managerMapper.selectAllStuTotalsWithManager(studentName,managerId,periodNo,sql);
    }

    @Override
    public boolean batchdelete(List<Integer> managerIds) {
        return managerMapper.batchdelete(managerIds);
    }

}
