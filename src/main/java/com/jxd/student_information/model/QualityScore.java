package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class QualityScore {

    private Integer score_id;

    private Integer quality_id;

    private Integer student_id;

    private Integer score;

    public QualityScore() {
    }

    public QualityScore(Integer score_id, Integer quality_id, Integer student_id, Integer score) {
        this.score_id = score_id;
        this.quality_id = quality_id;
        this.student_id = student_id;
        this.score = score;
    }

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public Integer getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(Integer quality_id) {
        this.quality_id = quality_id;
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
