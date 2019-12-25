package com.xiao.systemlog.test.service;

import com.xiao.systemlog.test.entity.SystemDataOperationLogEntity;

import java.util.List;

/**
 * @author xzy
 * @date 2019-12-25 15:28
 * 说明：系统数据操作日志表支持的操作
 */
public interface SystemDataOperationLogService {

    /**
     * 插入一条数据变更操作记录
     *
     * @param systemDataOperationLog - 系统数据变更操作记录
     */
    SystemDataOperationLogEntity insert(SystemDataOperationLogEntity systemDataOperationLog);

    /**
     * 获取所有系统数据操作记录
     *
     * @return 所有系统数据操作记录
     */
    List<SystemDataOperationLogEntity> findAll();
}
