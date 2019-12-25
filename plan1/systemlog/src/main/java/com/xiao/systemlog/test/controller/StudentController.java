package com.xiao.systemlog.test.controller;

import com.xiao.systemlog.common.message.Message;
import com.xiao.systemlog.common.message.MessageBox;
import com.xiao.systemlog.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzy
 * @date 2019-12-24 11:10
 * 说明：
 */
@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void dependenceInject(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("findAll")
    public Message findAll() {
        return MessageBox.ok(studentService.findAll());
    }
}
