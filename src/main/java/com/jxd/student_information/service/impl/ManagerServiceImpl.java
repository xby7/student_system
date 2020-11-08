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
        String sql = "SELECT e.student_id,student_name,manager_id,score,quality_name,e.overall_score dept," +
                "evaluation_form_dept,eos.overall_score school,q_period,e_period,isdeleted," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM(" +
                " SELECT d.student_id,student_name,manager_id,score,quality_name,overall_score," +
                "evaluation_form_dept,d.period_no q_period,eod.period_no e_period,isdeleted" +
                " FROM(" +
                " SELECT c.student_id,student_name,manager_id,score,quality_name,period_no,isdeleted" +
                " FROM(" +
                " SELECT b.student_id,student_name,manager_id,score,quality_id,period_no,isdeleted" +
                " FROM(" +
                " SELECT student_id,student_name,manager_id,isdeleted" +
                " FROM(" +
                " SELECT student_id, student_name, d.dept_no,isdeleted FROM student s LEFT JOIN dept d ON d.dept_no = s.dept_no ) a" +
                " LEFT JOIN manager m ON a.dept_no = m.dept_no ) b" +
                " LEFT JOIN quality_score qs ON qs.student_id = b.student_id ) c" +
                " LEFT JOIN quality q ON q.quality_id = c.quality_id ) d" +
                " LEFT JOIN evaluation_of_dept eod ON eod.student_id = d.student_id ) e" +
                " LEFT JOIN evaluation_of_school eos ON eos.student_id = e.student_id ";
        int pageIndex = (curPage - 1) * pageSize;
        return managerMapper.selectAllStuBypageWithManager(studentName,managerId,periodNo,sql,pageIndex,pageSize);
    }

    /*获取总数===经理(cbb)*/
    @Override
    public List<Map<String, Object>> getAllStuTotalsWithManager(String studentName, int managerId, int periodNo) {
        //获取动态拼接sql
        List<String> dynamicSequence = managerMapper.getSequenceWithManager();
        //手动与固定列拼接
        String sql = "SELECT e.student_id,student_name,manager_id,score,quality_name,e.overall_score dept," +
                "evaluation_form_dept,eos.overall_score school,q_period,e_period,isdeleted," +
                dynamicSequence.get(dynamicSequence.size() - 1) +
                " FROM(" +
                " SELECT d.student_id,student_name,manager_id,score,quality_name,overall_score," +
                "evaluation_form_dept,d.period_no q_period,eod.period_no e_period,isdeleted" +
                " FROM(" +
                " SELECT c.student_id,student_name,manager_id,score,quality_name,period_no,isdeleted" +
                " FROM(" +
                " SELECT b.student_id,student_name,manager_id,score,quality_id,period_no,isdeleted" +
                " FROM(" +
                " SELECT student_id,student_name,manager_id,isdeleted" +
                " FROM(" +
                " SELECT student_id, student_name, d.dept_no,isdeleted FROM student s LEFT JOIN dept d ON d.dept_no = s.dept_no ) a" +
                " LEFT JOIN manager m ON a.dept_no = m.dept_no ) b" +
                " LEFT JOIN quality_score qs ON qs.student_id = b.student_id ) c" +
                " LEFT JOIN quality q ON q.quality_id = c.quality_id ) d" +
                " LEFT JOIN evaluation_of_dept eod ON eod.student_id = d.student_id ) e" +
                " LEFT JOIN evaluation_of_school eos ON eos.student_id = e.student_id ";
        return managerMapper.selectAllStuTotalsWithManager(studentName,managerId,periodNo,sql);
    }

}
