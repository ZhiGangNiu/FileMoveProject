package com.backend.file.service;

import com.backend.file.pojo.FileInfo;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 中心模型表，项目下面的模型 服务类
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
public interface ICentermodelService{

    boolean centerModelHot2ColdInfo(List<FileInfo> fileInfos) throws ParseException;
}
