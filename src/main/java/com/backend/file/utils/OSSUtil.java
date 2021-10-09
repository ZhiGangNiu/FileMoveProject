package com.backend.file.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.backend.file.config.OSSConfig;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

@Slf4j
public class OSSUtil {

    static OSS ossClient = new OSSClientBuilder().build(OSSConfig.END_POIND, OSSConfig.ACCESS_KEY_ID, OSSConfig.ACCESS_KEY_SECRET);
    // static OSS ossClient = new OSSClientBuilder().build("oss-cn-shanghai.aliyuncs.com", "LTAI5tBdmNMQGcbRuV483YSc", "F3rSLqWeGqtz1m4AqzXm0QHo4qHN9N");

    /**
     * 获取文件的指纹
     */
    public static String getETag(String bucketName, String Key4File) throws ParseException {
        // 获取文件的部分元信息。
        ObjectMetadata objectMetadata = ossClient.getObjectMetadata(bucketName, Key4File);
        String contentMD5 = objectMetadata.getContentMD5();
        System.out.println(contentMD5);

        return contentMD5;
    }

    /**
     * 关闭OSSClient。
     */
    public static void shutdown() {
        ossClient.shutdown();
    }
}
 