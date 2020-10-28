package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class Student {

    private Integer student_id;

    private String student_name;

    private String sex;

    private String folk;

    private String birthday;

    private String native_place;

    private String marital_status;

    private String id_number;

    private String graduate_school;

    private String major;

    private String img_path;

    private String remark;

    private Integer class_no;

    private Integer dept_no;

    private Integer isdeleted;

    public Student() {
    }

    public Student(Integer student_id, String student_name, String sex, String folk, String birthday,
                   String native_place, String marital_status, String id_number,
                   String graduate_school, String major, String img_path, String remark,
                   Integer class_no, Integer dept_no, Integer isdeleted) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.sex = sex;
        this.folk = folk;
        this.birthday = birthday;
        this.native_place = native_place;
        this.marital_status = marital_status;
        this.id_number = id_number;
        this.graduate_school = graduate_school;
        this.major = major;
        this.img_path = img_path;
        this.remark = remark;
        this.class_no = class_no;
        this.dept_no = dept_no;
        this.isdeleted = isdeleted;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFolk() {
        return folk;
    }

    public void setFolk(String folk) {
        this.folk = folk;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getClass_no() {
        return class_no;
    }

    public void setClass_no(Integer class_no) {
        this.class_no = class_no;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }
}
