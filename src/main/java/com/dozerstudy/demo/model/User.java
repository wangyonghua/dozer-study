package com.dozerstudy.demo.model;

import com.dozerstudy.demo.config.ListNotHasNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

public class User {

    //其他参数 .......

    /**
     * 所拥有的书籍列表
     */
    @NotEmpty(message = "所拥有书籍不能为空")
    @ListNotHasNull(message = "List 中不能含有null元素")
    @Valid
    private List<Book> books;
    //getter setter 方法.......
}