package com.xiao.systemlog.common.annotation;

import java.lang.annotation.*;

/**
 * @author xzy
 * @date 2019-12-24 17:04
 * 说明：数据变更日志
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLog {
    /**
     * 所属系统模块
     * example - 用户管理、设备管理、部门管理
     */
    String moduleName();

    /**
     * 操作类型
     * example - OperationType.INSERT、OperationType.DELETE、OperationType.UPDATE
     */
    OperationType operationType();

    /**
     * 操作详细描述
     * example - "根据id删除某个用户信息"、"添加一条用户信息"
     */
    String description();
}
