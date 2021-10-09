package com.backend.file.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 中心模型表，项目下面的模型
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Centermodel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String modelId;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * revit模型id,revit返回的模型id
     */
    private String modelId4Revit;

    /**
     * 创建方式,(1：新建模型，2：现有模型转换 3:复用 4:团队自定义云样板 5:内置云样板)
     */
    private Integer addType;

    /**
     * 模型文件名称（包含扩展名称）
     */
    private String modelFileName;

    /**
     * 源模型名称，包含扩展名
     */
    private String sourceModelName;

    /**
     * 模型相对路径
     */
    private String modelRelatePath;

    /**
     * 团队主键id（隔离字段）
     */
    private String teamId;

    /**
     * 项目主键id（隔离字段）
     */
    private String projectId;

    /**
     * Host服务器地址，实际存放中心模型的服务器节点。      
     */
    private String modelServerDomain;

    /**
     * 是否在revit创建成功,0:未创建，1:已创建2:创建失败
     */
    private Integer hasCreated4Revit;

    /**
     * 创建人用户id
     */
    private String addUserId;

    /**
     * 创建人用户名称
     */
    private String addUserName;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 是否删除,0:未删除，1删除
     */
    private Integer isDeleted;

    /**
     * 加密key,长度8.生成规则，uuid前八位
     */
    private String encryptKey;

    /**
     * 模型服务器硬件码
     */
    private String modelServerHardwareCode;

    /**
     * ****模型服务器类型,1：客户自己部署的服务器，2：红瓦云模型服务器，3:大赛项目云模型服务器 ，默认为客户自己部署的服务器
     */
    private Integer modelServerType;

    /**
     * 模型当前大小 单位字节 普通模型分块文件的大小 中心模型 模型本身的大小 不是增量副本的文件大小,对应datasize
     */
    private Long currentSize;

    /**
     * 当前大小更新时间
     */
    private Date currentSizeUpdateTime;

    /**
     * 模型类型 中心模型 HWCenterModel   普通模型 HWOrdinaryModel 默认中心模型
     */
    private String modelType;

    /**
     * 文件所在空间(七牛 阿里云空间名)
     */
    private String bucket;

    /**
     * 文件所在服务器类型：QiNiu七牛存储，HongwaLocal集中式MooseFS文件存储系统，Aliyun阿里云等
     */
    private String storageServiceType;

    /**
     * 模型最新版本
     */
    private Long modelLastVersion;

    /**
     * 负责人userId
     */
    private String dutyUserId;

    /**
     * 负责人截至时间
     */
    private Date dutyLastTime;

    /**
     * 模型所属分组id
     */
    private String groupId;

    /**
     * 模型描述
     */
    private String modelDescription;

    /**
     * 模型完成时间
     */
    private Date finishTime;

    /**
     * 模型完成操作人id
     */
    private String finishUserId;

    /**
     * 模型缩略图key
     */
    private String key4Thumbnail;

    /**
     * 模型缩略图存储空间
     */
    private String bucketThumbnail;

    /**
     * 模型缩略图存储服务器类型:QiNiu七牛存储，HongwaLocal集中式MooseFS文件存储系统，Aliyun阿里云等
     */
    private String storageServiceThumbnail;

    /**
     * 模型最后同步人中心模型：最后同步人 普通模型 最后上传人
     */
    private String lastModelUpdateUserId;

    /**
     * 模型最后同步人名
     */
    private String lastModelUpdateUserName;

    /**
     * 模型最后同步人的硬件码
     */
    private String lastModelUpdateUserHardwareCode;

    /**
     * 模型创建最新快照版本是否完成，目前只会在中心模型的创建快照时用到  0未完成 1已完成
     */
    private Boolean createLastSnapshotDone;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 是否加入回收站 默认为0 未加入，1 :已加入
     */
    private Integer addRecycleBin;

    /**
     * 加入回收站的人员id 
     */
    private String isRecycleBinUserId;

    /**
     * 加入回收站的人员名称
     */
    private String isRecycleBinUserName;

    /**
     * 添加到回收站时间
     */
    private Date addRecycleBinTime;

    /**
     * 彻底删除人id 
     */
    private String isDeletedUserId;

    /**
     * 恢复人员ID
     */
    private String recoverUserId;

    /**
     * 恢复时间
     */
    private Date recoverDatetime;

    /**
     * 冷热数据状态 hot：热数据   cold：冷数据   冷转热cold2hot，热转冷：hot2cold
     */
    private String hotColdState;


}
