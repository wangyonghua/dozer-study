package com.dozerstudy.demo.controller;

import com.dozerstudy.demo.model.Student;
import com.dozerstudy.demo.publish.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api")
public class TestController {

    @Autowired
    private Sender send;

    @RequestMapping("/test")
    public Student test(@RequestBody Student student) {
        send.send("wang");
        return null;
    }
}
