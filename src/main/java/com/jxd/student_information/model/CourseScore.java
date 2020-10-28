package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class CourseScore {

    private Integer score_id;
    private Integer course_id;
    private Integer student_id;
    private Integer score;

    public CourseScore() {
    }

    public CourseScore(Integer score_id, Integer course_id, Integer student_id, Integer score) {
        this.score_id = score_id;
        this.course_id = course_id;
        this.student_id = student_id;
        this.score = score;
    }

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
