package com.xiao.systemlog.common.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.hibernate.engine.spi.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xzy
 * @date 2019-12-26 10:02
 * 说明：JoinPoint解析工具类
 */
public class JoinPointAnalyzeUtil {
    /**
     * 将数据输出到控制台，便于日志保存
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(JoinPointAnalyzeUtil.class);

    /**
     * 系统的解析JoinPoint
     *
     * @param joinPoint - 切点信息
     */
    public static Map<String, Object> joinPointAnalyze(JoinPoint joinPoint) {
        LOGGER.info("begin joinPointAnalyze()");
        Map<String, Object> joinPointAnalysisResults = new LinkedHashMap<>();
        /**
         * 获取传入被代理方法的参数
         */
        Object[] methodArguments = joinPoint.getArgs();
        /**
         * 获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
         */
        Signature signature = joinPoint.getSignature();
        Map<String, Object> signatureAnalysisResult = SignatureAnalyzeUtil.signatureAnalyze(signature);
        /**
         * 获取被代理对象
         */
        Object proxyObjectTarget = joinPoint.getTarget();
        /**
         * 获取代理对象
         */
        Object proxyObjectThis = joinPoint.getThis();
        /**
         *
         */
        String kind = joinPoint.getKind();
        /**
         *
         */
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        /**
         *
         */
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        return joinPointAnalysisResults;
    }
}
