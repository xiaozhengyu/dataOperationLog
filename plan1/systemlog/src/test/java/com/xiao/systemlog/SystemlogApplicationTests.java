package com.xiao.systemlog;

import com.xiao.systemlog.test.entity.SystemDataOperationLogEntity;
import com.xiao.systemlog.test.repository.*;
import com.xiao.systemlog.test.service.SystemDataOperationLogService;
import com.xiao.systemlog.test.serviceimpl.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SystemlogApplicationTests {

    @Autowired
    SystemDataOperationLogRepository repository;
    @Autowired
    SystemDataOperationLogService service;

    @Test
    void contextLoads() {
        System.out.println("-----------------------");
        SystemDataOperationLogEntity systemDataOperationLog = new SystemDataOperationLogEntity();
        systemDataOperationLog.setModuleName("用户管理模块");
        systemDataOperationLog.setMethodName("xxx.xxx.xxx.userServiceImpl.insert");
        systemDataOperationLog.setDescription("插入一条用户信息");
        service.insert(systemDataOperationLog);
        Object object = repository.findAll();
        System.out.println("\"-----------------------\"");
    }

}
