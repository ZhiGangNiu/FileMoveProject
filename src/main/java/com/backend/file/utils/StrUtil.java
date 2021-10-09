package com.backend.file.utils;

public class StrUtil {

    /**
     * 判断字符串前缀
     *
     * @param str    字符串
     * @param symbol 前缀符号
     * @return
     */
    public static String isPrefix(String str, String symbol) {
        if (!str.startsWith(symbol)) {
            return symbol + str;
        }
        return str;
    }

}
