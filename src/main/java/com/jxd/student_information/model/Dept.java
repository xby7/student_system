package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class Dept {

    private Integer dept_no;
    private String dept_name;

    public Dept() {
    }

    public Dept(Integer dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
