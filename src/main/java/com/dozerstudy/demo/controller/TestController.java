//package com.dozerstudy.demo.controller;
//
//import com.dozerstudy.demo.model.Student;
//import com.dozerstudy.demo.publish.Send;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(name = "/api")
//public class TestController {
//
//    @Autowired
//    private Send send;
//
//    @RequestMapping("/test")
//    public Student test(@RequestBody Student student) {
//        send.sendMsg("wang");
//        return null;
//    }
//}
