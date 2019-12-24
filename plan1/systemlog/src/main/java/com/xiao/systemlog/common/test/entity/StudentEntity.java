package com.xiao.systemlog.common.test.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author xzy
 * @date 2019-12-24 10:54
 * 说明：学生表
 */
@Data
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(generator = "genericGenerator")
    @GenericGenerator(name = "genericGenerator", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String sex;

    @Column
    private Integer age;

    public StudentEntity() {
    }
}
