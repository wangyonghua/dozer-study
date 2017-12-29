package com.dozerstudy.demo.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Validated
public class Student {
    //在需要校验的字段上指定约束条件
    @NotBlank
    private String name;
    @Min(3)
    private int age;
    @NotBlank
    private String classess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassess() {
        return classess;
    }

    public void setClassess(String classess) {
        this.classess = classess;
    }

}