package com.xiao.learn.test.service;

import com.xiao.learn.test.entity.StudentEntity;

import java.util.List;

/**
 * @author xzy
 * @date 2019-12-24 11:09
 * 说明：对学生信息表的操作
 */
public interface StudentService {
    /**
     * get all records in the student table
     *
     * @return All records in the student table
     */
    List<StudentEntity> findAll();

    /**
     * Insert a new record, or update a record
     *
     * @param student - Record to insert or update
     * @return Inserted data or changed data
     */
    StudentEntity update(StudentEntity student);
}
