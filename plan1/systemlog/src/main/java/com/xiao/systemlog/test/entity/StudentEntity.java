package com.xiao.systemlog.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xzy
 * @date 2019-12-24 10:54
 * 说明：学生表
 */
@Data
@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class StudentEntity {

    @Id
    @GeneratedValue(generator = "genericGenerator")
    @GenericGenerator(name = "genericGenerator", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(updatable = false, name = "createBy")
    @CreatedBy
    private String createBy;

    @Column(updatable = false, name = "createDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @CreatedDate
    private Date createDate;

    @Column(name = "lastModifyBy")
    @LastModifiedBy
    private String lastModifyBy;

    @Column(name = "lastModifyDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private Date lastModifyDate;

    public StudentEntity() {
    }
}
