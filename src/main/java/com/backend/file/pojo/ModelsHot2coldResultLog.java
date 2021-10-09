package com.backend.file.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 批量迁移非活跃模型到冷存储上的报告
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ModelsHot2coldResultLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 云模型服务器ID，唯一标识
     */
    private String cloudModelServerID;

    /**
     * 云模型服务器主机名
     */
    private String cloudModelServerName;

    /**
     * 模型服务器域名
     */
    private String cloudModelServerDomain;

    /**
     * 云模型服务器的版本号，对应Revit Server 的版本号
     */
    private Integer cloudModelServerVersion;

    /**
     * 批量迁移的开始时间，距离距离1970年的毫秒数。注意保持到数据库要存储成datetime。
     */
    private Date startTime;

    /**
     * 批量迁移的完成时间，距离距离1970年的毫秒数。注意保持到数据库要存储成datetime。
     */
    private Date endTime;

    /**
     * 迁移总共耗时，单位毫秒
     */
    private Long milliseconds2Migrate;

    /**
     * 迁移走的非活跃模型总数量
     */
    private Long modelTotalAmount2Migrate;

    /**
     * 迁移走的非活跃模型存档文件总大小，单位字节
     */
    private Long modelArchiveFileTotalBytes2Migrate;

    /**
     * 迁移失败的模型数量
     */
    private Long modelFailureAmount2Migrate;


}
