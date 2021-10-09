package com.backend.file.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件信息对象
 * @author Evening'Wind
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    /**
     * 模型相对路径
     */
    private String modelRelatePath;
    /**
     * 模型revit版本号
     */
    private String revitVersion;
    /**
     * 模型大小
     */
    private String modelSize;
    /**
     * 最后时间
     */
    private String lastVisitTime;

}
