package com.xiao.systemlog.test.serviceimpl;

import com.xiao.systemlog.test.entity.SystemDataOperationLogEntity;
import com.xiao.systemlog.test.repository.SystemDataOperationLogRepository;
import com.xiao.systemlog.test.service.SystemDataOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzy
 * @date 2019-12-25 15:46
 * 说明：系统数据操作日志
 */
@Service
public class SystemDataOperationLogServiceImpl implements SystemDataOperationLogService {

    private SystemDataOperationLogRepository systemDataOperationLogRepository;

    @Autowired
    public void dependenceInject(SystemDataOperationLogRepository systemDataOperationLogRepository) {
        this.systemDataOperationLogRepository = systemDataOperationLogRepository;
    }

    /**
     * 插入一条数据变更操作记录
     *
     * @param systemDataOperationLog - 系统数据变更操作记录
     */
    @Override
    public SystemDataOperationLogEntity insert(SystemDataOperationLogEntity systemDataOperationLog) {
        return systemDataOperationLogRepository.save(systemDataOperationLog);
    }

    /**
     * 获取所有系统数据操作记录
     *
     * @return 所有系统数据操作记录
     */
    @Override
    public List<SystemDataOperationLogEntity> findAll() {
        return systemDataOperationLogRepository.findAll();
    }
}
