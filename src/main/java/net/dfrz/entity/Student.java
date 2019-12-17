package net.dfrz.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String stuID;

    private String name;

    private Date birthday;

    private String sex;

    private static final long serialVersionUID = 1L;

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID == null ? null : stuID.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}