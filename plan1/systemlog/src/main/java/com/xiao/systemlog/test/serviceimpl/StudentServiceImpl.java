package com.xiao.systemlog.test.serviceimpl;

import com.xiao.systemlog.common.annotation.DataLog;
import com.xiao.systemlog.common.annotation.OperationType;
import com.xiao.systemlog.test.entity.StudentEntity;
import com.xiao.systemlog.test.repository.StudentRepository;
import com.xiao.systemlog.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xzy
 * @date 2019-12-24 11:09
 * 说明：对学生信息表的操作的具体实现
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void dependenceInject(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * get all records in the student table
     *
     * @return All records in the student table
     */
    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Insert a new record, or update a record
     *
     * @param student - Record to insert or update
     * @return Inserted data or changed data
     */
    @Override
    @DataLog(moduleName = "学生信息管理", operationType = OperationType.INSERT, description = "插入一条学生信息")
    public StudentEntity update(StudentEntity student) {
        return studentRepository.save(student);
    }

    /**
     * Delete a record in the table by record id
     *
     * @param id - record id
     */
    @Override
    @DataLog(moduleName = "学生信息管理", operationType = OperationType.DELETE, description = "根据id删除一条学生信息")
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
