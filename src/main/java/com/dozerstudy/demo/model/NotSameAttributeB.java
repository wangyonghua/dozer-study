package com.dozerstudy.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class NotSameAttributeB {
    private long id;
    private String value;

    private Date date;

    @Override
    public String toString() {
        return "NotSameAttributeB{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", date=" + date +
                '}';
    }
}