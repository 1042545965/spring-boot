package com.project.springboot.bean;



import java.io.Serializable;

public class Department implements Serializable{
//    @TableId("id")
    private Integer id;
//    @TableField("departmentName")
    private String departmentName;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
