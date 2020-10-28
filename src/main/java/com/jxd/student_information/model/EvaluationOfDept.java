package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class EvaluationOfDept {

    private Integer student_id;

    private String dept_name;

    private String job;

    private String manager_name;

    private Integer overall_score;

    private String evaluation_form_dept;

    private Integer period_no;

    public EvaluationOfDept() {
    }

    public EvaluationOfDept(Integer student_id, String dept_name, String job, String manager_name,
                            Integer overall_score, String evaluation_form_dept, Integer period_no) {
        this.student_id = student_id;
        this.dept_name = dept_name;
        this.job = job;
        this.manager_name = manager_name;
        this.overall_score = overall_score;
        this.evaluation_form_dept = evaluation_form_dept;
        this.period_no = period_no;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public Integer getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(Integer overall_score) {
        this.overall_score = overall_score;
    }

    public String getEvaluation_form_dept() {
        return evaluation_form_dept;
    }

    public void setEvaluation_form_dept(String evaluation_form_dept) {
        this.evaluation_form_dept = evaluation_form_dept;
    }

    public Integer getPeriod_no() {
        return period_no;
    }

    public void setPeriod_no(Integer period_no) {
        this.period_no = period_no;
    }
}
