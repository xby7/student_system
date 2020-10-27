package com.jxd.emp.config;

/**
 * @ClassName Person
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/23
 * @Version 1.0
 */

public class Person {

    private String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
