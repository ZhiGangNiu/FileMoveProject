package com.backend.file.mapper.project;

import com.backend.file.pojo.Centermodel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * <p>
 * 中心模型表，项目下面的模型 Mapper 接口
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Mapper
public interface CentermodelMapper extends BaseMapper<Centermodel> {

    /**
     * 根据模型相对路径查询模型信息
     * @param modelRelatePaths
     * @return
     */
    List<Centermodel> findCenterModelByModelRelatePaths(@Param("modelRelatePaths") List<String> modelRelatePaths);

}
