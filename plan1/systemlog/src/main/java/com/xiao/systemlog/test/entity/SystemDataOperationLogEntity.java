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
 * @date 2019-12-25 14:54
 * 说明：系统数据操作日志记录
 */
@Entity
@Table(name = "system_dataoperation_log")
@Data
@EntityListeners(AuditingEntityListener.class)
public class SystemDataOperationLogEntity {

    @Id
    @GeneratedValue(generator = "genericGenerator")
    @GenericGenerator(name = "genericGenerator", strategy = "uuid")
    private String id;

    /**
     * 模块名
     */
    @Column(name = "moduleName")
    private String moduleName;

    /**
     * 操作发生在哪个类
     */
    @Column(name = "className")
    private String className;

    /**
     * 操作发生在哪个方法
     */
    @Column(name = "methodName")
    private String methodName;

    /**
     * 操作类型OperationType.XXX
     */
    @Column(name = "operation")
    private String operation;

    /**
     * 操作描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 操作前数据
     */
    @Column(name = "dataBefore")
    private String dataBefore;

    /**
     * 操作数据
     */
    @Column(name = "dataAfter")
    private String dataAfter;

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

    public SystemDataOperationLogEntity() {
    }
}
