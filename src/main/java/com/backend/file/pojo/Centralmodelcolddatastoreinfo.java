package com.backend.file.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 中心模型冷存储信息表
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Centralmodelcolddatastoreinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 模型id
     */
    private String modelId;

    /**
     * 团队id
     */
    private String teamId;

    /**
     * 项目id
     */
    private String projectId;

    /**
     * 文件所在空间(七牛 阿里云空间名)
     */
    private String bucket;

    /**
     * 文件所在服务器类型：QiNiu七牛存储，HongwaLocal集中式MooseFS文件存储系统，Aliyun阿里云等
     */
    private String storageServiceType;

    /**
     * 模型冷数据压缩包key
     */
    private String modelColdFileKey;

    /**
     * 模型冷数据压缩包指纹
     */
    private String fingerprint4File;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 上次模型所在的模型服务器地址
     */
    private String modelServerDomain;

    /**
     * 模型最新版本
     */
    private Long modelLastVersion;

    /**
     * revit版本
     */
    private String revitVersion;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除字段 0未删除 1删除
     */
    private Integer isDeleted;

    /**
     * 删除时间
     */
    private Date deleteTime;


}
