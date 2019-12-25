package com.xiao.systemlog.common.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xzy
 * @date 2019-12-24 11:16
 * 说明：为@CreateBy、@LostModifyBy、@CreateDate、@LostModifyDate提供支持。
 * 实现AuditorAware接口，告诉JPA当前用户是谁。
 */
@Service
public class MyAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin");
    }
}
