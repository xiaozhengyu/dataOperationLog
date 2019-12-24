package com.xiao.systemlog;

import com.xiao.systemlog.common.test.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SystemlogApplicationTests {

    @Autowired
    StudentRepository repository;

    @Test
    void contextLoads() {
        System.out.println("-----------------------");
        Object object = repository.findAll();
        System.out.println("\"-----------------------\"");
    }

}
