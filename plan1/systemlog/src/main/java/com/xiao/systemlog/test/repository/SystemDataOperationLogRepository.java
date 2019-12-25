package com.xiao.systemlog.test.repository;

import com.xiao.systemlog.test.entity.SystemDataOperationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xzy
 * @date 2019-12-25 15:22
 * 说明：系统数据操作日志
 */
public interface SystemDataOperationLogRepository extends JpaRepository<SystemDataOperationLogEntity, String> {
}
