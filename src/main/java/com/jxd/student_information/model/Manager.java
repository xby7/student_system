package com.jxd.student_information.model;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-28
 */
public class Manager {

    private Integer manager_id;

    private String manager_name;

    private Integer dept_no;

    public Manager() {
    }

    public Manager(Integer manager_id, String manager_name, Integer dept_no) {
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.dept_no = dept_no;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }
}
