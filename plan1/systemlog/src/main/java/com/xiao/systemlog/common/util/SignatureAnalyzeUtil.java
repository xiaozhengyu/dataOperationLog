package com.xiao.systemlog.common.util;

import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xzy
 * @date 2019-12-26 11:15
 * 说明：Signature类解析工具类
 */
public class SignatureAnalyzeUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(SignatureAnalyzeUtil.class);

    /**
     * 解析Signature类实例中包含的信息
     *
     * @param signature -
     */
    public static Map<String, Object> signatureAnalyze(Signature signature) {
        Map<String, Object> analysisResults = new LinkedHashMap<>();
        /**
         * shortString - 此签名的缩写字符串表示形式
         * string -
         * longString - 此签名的扩展字符串表示形式
         * name - 此签名的标识符部分。如果是方法的签名，这个标识符为方法的名字。
         * modifiers - 此签名上的修饰符返回结果为一个int值。
         *           （可以通过Modifier.toString(int)方法查询，查询到的结果为“public”、“protect”等。）
         * declaringType - 声明此成员的类、接口或切面
         * declaringTypeName - 声明类型的全限定名称
         */
        String shortString = signature.toShortString();
        String string = signature.toString();
        String longString = signature.toLongString();
        String name = signature.getName();
        Integer modifiers = signature.getModifiers();
        //继续解析
        Class declaringType = signature.getDeclaringType();
        String declaringTypeName = signature.getDeclaringTypeName();
        analysisResults.put("shortString", shortString);
        analysisResults.put("string", string);
        analysisResults.put("longString", longString);
        analysisResults.put("name", name);
        analysisResults.put("modifiers", Modifier.toString(modifiers));
        analysisResults.put("declaringType", declaringType);
        analysisResults.put("declaringTypeName", declaringTypeName);
        return analysisResults;
    }

}
