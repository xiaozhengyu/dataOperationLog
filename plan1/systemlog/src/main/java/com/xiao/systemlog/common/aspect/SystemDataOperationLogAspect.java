package com.xiao.systemlog.common.aspect;

import com.xiao.systemlog.common.annotation.DataLog;
import com.xiao.systemlog.common.annotation.OperationType;
import com.xiao.systemlog.common.util.JoinPointAnalyzeUtil;
import com.xiao.systemlog.test.entity.SystemDataOperationLogEntity;
import com.xiao.systemlog.test.service.SystemDataOperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xzy
 * @date 2019-12-25 16:48
 * 说明：记录系统数据变更的切面
 */
@Aspect
@Component
public class SystemDataOperationLogAspect {

    private SystemDataOperationLogService systemDataOperationLogService;

    @Autowired
    public void dependenceInject(SystemDataOperationLogService systemDataOperationLogService) {
        this.systemDataOperationLogService = systemDataOperationLogService;
    }

    /**
     * 切点
     */
    @Pointcut(value = "@annotation(com.xiao.systemlog.common.annotation.DataLog)")
    public void dataOperation() {
    }

    @Around("dataOperation() && @annotation(dataLog)")
    public void aroundDataOperation(ProceedingJoinPoint proceedingJoinPoint, DataLog dataLog) {
        SystemDataOperationLogEntity systemDataOperationLog = new SystemDataOperationLogEntity();
        try {
            /**
             * 被@DataLog注解标注的方法执行前先执行下面的代码
             */
            System.out.println("before data operation.");
            beforeDataOperation(proceedingJoinPoint, dataLog, systemDataOperationLog);
            /**
             * 执行被@DataLog标注的方法
             */
            proceedingJoinPoint.proceed();
            /**
             * 被@DataLog标注的方法执行完以后执行下面的代码
             */
            System.out.println("after data operation.");
            afterDataOperation(proceedingJoinPoint, systemDataOperationLog);
            systemDataOperationLogService.insert(systemDataOperationLog);
        } catch (Throwable t) {
            /**
             * 被标注的方法执行出错以后执行下面的代码
             */
            t.printStackTrace();
            System.out.println("data operation failed!");
        }
    }

    /**
     * 在被标注的方法执行前保存一些信息
     *
     * @param proceedingJoinPoint    - 包含被标注方法的信息
     * @param dataLog                - 注解
     * @param systemDataOperationLog - 数据操作记录
     */
    public void beforeDataOperation(ProceedingJoinPoint proceedingJoinPoint, DataLog dataLog, SystemDataOperationLogEntity systemDataOperationLog) {
        //模块名
        String moduleName = dataLog.moduleName();
        systemDataOperationLog.setModuleName(moduleName);
        //操作类型
        OperationType operationType = dataLog.operationType();
        systemDataOperationLog.setOperation(operationType.name());
        //操作描述
        String description = dataLog.description();
        systemDataOperationLog.setDescription(description);
        //方法所在类
        Signature signature = proceedingJoinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        systemDataOperationLog.setClassName(className);
        //方法全限定名
        String methodName = signature.getName();
        systemDataOperationLog.setMethodName(methodName);
        //操作前数据
        String dataBefore = getArguments(proceedingJoinPoint.getArgs());
        systemDataOperationLog.setDataBefore(dataBefore);
    }


    /**
     * 在被标注的方法执行后保存一些信息
     *
     * @param proceedingJoinPoint    - 包含被标注方法的信息
     * @param systemDataOperationLog - 数据操作记录
     */
    public void afterDataOperation(ProceedingJoinPoint proceedingJoinPoint, SystemDataOperationLogEntity systemDataOperationLog) {
        //操作后数据
        String dataAfter = getArguments(proceedingJoinPoint.getArgs());
        systemDataOperationLog.setDataAfter(dataAfter);
    }

    /**
     * 获取参数信息
     *
     * @param args - 参数
     * @return - 字符串形式的参数信息
     */
    private String getArguments(Object[] args) {
        StringBuilder arguments = new StringBuilder();
        //获取传入目标方法的参数
        for (int i = 0; i < args.length; i++) {
            arguments.append("arg").append(i + 1).append(":").append(args[i]).append(",");
        }
        return arguments.toString();
    }
}
