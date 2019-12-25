package com.xiao.systemlog;

import com.xiao.systemlog.common.annotation.DataLog;
import com.xiao.systemlog.common.annotation.OperationType;

import java.lang.reflect.Method;

/**
 * @author xzy
 * @date 2019-12-25 14:38
 * 说明：主方法
 */
public class Main {

    /**
     * 根据id删除用户信息
     *
     * @param id - 用户id
     */
    @DataLog(moduleName = "用户管理模块",
            methodName = "com.xiao.systemlog.Main.deleteById",
            operation = OperationType.DELETE,
            description = "根据id删除用户信息")
    public void deleteById(String id) {
    }

    public static void main(String[] args) {
        try {
            Method method = Main.class.getMethod("deleteById", String.class);
            if (method.isAnnotationPresent(DataLog.class)) {
                DataLog dataLog = method.getAnnotation(DataLog.class);
                System.out.println("moduleName = " + dataLog.moduleName());
                System.out.println("methodName = " + dataLog.methodName());
                System.out.println("operation = " + dataLog.operation());
                System.out.println("description = " + dataLog.description());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
