package com.backend.file.controller;


import com.backend.file.pojo.FileInfo;
import com.backend.file.service.ICentermodelService;
import com.backend.file.utils.OSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 中心模型表，项目下面的模型 前端控制器
 * </p>
 *
 * @author Zero
 * @since 2021-10-09
 */
@Slf4j
@RestController
@RequestMapping("/centermodel")
public class CentermodelController implements ApplicationRunner {

    @Autowired
    private ICentermodelService iCentermodelService;

    @Override
    public void run(ApplicationArguments args) {
        log.info("中心模型热转冷数据补充程序【开始】执行.......");
        List<FileInfo> fileInfos = new ArrayList<>();
        try {
            iCentermodelService.centerModelHot2ColdInfo(fileInfos);
        } catch (ParseException e) {
            e.printStackTrace();
            log.info("中心模型热转冷数据补充程序发生异常：{}", e.getMessage());
        }finally {
            OSSUtil.shutdown();
        }
        log.info("中心模型热转冷数据补充程序【结束】执行.......");
    }
}