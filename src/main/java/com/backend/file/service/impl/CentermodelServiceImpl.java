package com.backend.file.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.backend.file.config.OSSConfig;
import com.backend.file.mapper.project.CentermodelMapper;
import com.backend.file.pojo.Centermodel;
import com.backend.file.pojo.Centralmodelcolddatastoreinfo;
import com.backend.file.pojo.FileInfo;
import com.backend.file.service.ICentermodelService;
import com.backend.file.utils.OSSUtil;
import com.backend.file.utils.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 中心模型表，项目下面的模型 服务实现类
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Slf4j
@Service
public class CentermodelServiceImpl implements ICentermodelService {
    @Autowired
    private CentermodelMapper centermodelMapper;

    @Override
    public boolean centerModelHot2ColdInfo(List<FileInfo> fileInfos) throws ParseException {
        // 1.获取模型的相对路径集合
        List<String> modelRelatePaths = fileInfos.stream().map(FileInfo::getModelRelatePath).collect(Collectors.toList());
        log.info("获取模型的相对路径集合:{}", JSONObject.toJSONString(modelRelatePaths));
        Map<String, FileInfo> fileInfoMap = fileInfos.stream().collect(Collectors.toMap(FileInfo::getModelRelatePath, Function.identity()));
        // 根据模型相对路径集合查询模型信息集合 Arrays.asList("/1a69c4249df643bb1568104443359_2020.rvt","/2eab5391f65c40141569384067371_61.rvt")
        List<Centermodel> centerModels = centermodelMapper.findCenterModelByModelRelatePaths(modelRelatePaths);
        log.info("根据模型相对路径集合查询模型信息集合:{}", JSONObject.toJSONString(centerModels));
        // 2.模型冷存储信息集合
        List<Centralmodelcolddatastoreinfo> storeInfos = new ArrayList<>();
        for (Centermodel modelInfo : centerModels) {
            FileInfo fileInfo = fileInfoMap.get(modelInfo.getModelRelatePath());
            //热转冷对象
            Centralmodelcolddatastoreinfo storeInfo = new Centralmodelcolddatastoreinfo();
            storeInfo.setModelId(modelInfo.getModelId());
            storeInfo.setTeamId(modelInfo.getTeamId());
            storeInfo.setProjectId(modelInfo.getProjectId());
            storeInfo.setBucket(OSSConfig.BUCKET_NAME);
            storeInfo.setStorageServiceType("Aliyun");
            String prefix = StrUtil.isPrefix(modelInfo.getModelRelatePath(), "/");
            storeInfo.setModelColdFileKey("xt_rs_model/frozen"+prefix+".wa.zip");
            storeInfo.setFingerprint4File(OSSUtil.getETag(OSSConfig.BUCKET_NAME,storeInfo.getModelColdFileKey()));
            storeInfo.setModelLastVersion(modelInfo.getModelLastVersion());
            storeInfo.setSize(Long.valueOf(fileInfo.getModelSize()));
            storeInfo.setModelServerDomain(modelInfo.getModelServerDomain());
            storeInfo.setRevitVersion(fileInfo.getRevitVersion());
            storeInfos.add(storeInfo);
        }
        log.info("模型冷存储信息集合:{}", JSONObject.toJSONString(storeInfos));
        // 3.保存日志信息
        return false;
    }
}
