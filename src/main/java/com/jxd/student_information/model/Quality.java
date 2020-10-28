package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class Quality {

    private Integer quality_id;

    private String quality_name;

    public Quality() {
    }

    public Quality(Integer quality_id, String quality_name) {
        this.quality_id = quality_id;
        this.quality_name = quality_name;
    }

    public Integer getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(Integer quality_id) {
        this.quality_id = quality_id;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }
}
