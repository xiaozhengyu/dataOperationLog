package com.xiao.systemlog.common.test.repository;


import com.xiao.systemlog.common.test.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xzy
 * @date 2019-12-24 11:06
 * 说明：
 */
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
}
