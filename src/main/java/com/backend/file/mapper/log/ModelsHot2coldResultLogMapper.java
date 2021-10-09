package com.backend.file.mapper.log;

import com.backend.file.pojo.ModelsHot2coldResultLog;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * <p>
 * 批量迁移非活跃模型到冷存储上的报告 Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Mapper
public interface ModelsHot2coldResultLogMapper extends BaseMapper<ModelsHot2coldResultLog> {

}
