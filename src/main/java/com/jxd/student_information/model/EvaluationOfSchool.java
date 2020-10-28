package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class EvaluationOfSchool {

    private Integer student_id;

    private Integer class_no;

    private String teacher_name;

    private Integer overall_score;

    private String evaluation_form_school;

    public EvaluationOfSchool() {
    }

    public EvaluationOfSchool(Integer student_id, Integer class_no, String teacher_name,
                              Integer overall_score, String evaluation_form_school) {
        this.student_id = student_id;
        this.class_no = class_no;
        this.teacher_name = teacher_name;
        this.overall_score = overall_score;
        this.evaluation_form_school = evaluation_form_school;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getClass_no() {
        return class_no;
    }

    public void setClass_no(Integer class_no) {
        this.class_no = class_no;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Integer getOverall_score() {
        return overall_score;
    }

    public void setOverall_score(Integer overall_score) {
        this.overall_score = overall_score;
    }

    public String getEvaluation_form_school() {
        return evaluation_form_school;
    }

    public void setEvaluation_form_school(String evaluation_form_school) {
        this.evaluation_form_school = evaluation_form_school;
    }
}
