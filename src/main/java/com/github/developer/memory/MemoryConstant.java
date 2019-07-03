package com.github.developer.memory;

import java.time.format.DateTimeFormatter;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/2 16:58
 */
public interface MemoryConstant {
    /**
     * 文件路径
     */
    String FILE_PATH = "C:\\Users\\Ninee\\Desktop\\utils\\src\\test\\java\\com\\github\\developer\\memory\\1.txt";
    /**
     * 日期格式化器
     */
    DateTimeFormatter DATE_TIME_FORMATTER= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 制表符
     */
    String TAB_CHAR = "\t";
    /**
     * 制表符
     */
    String FILE_MODE = "rw";
    /**
     * 系统换行符
     */
    String LINE_SEPARATOR = System.getProperty("line.separator");
    /**
     * 复习间隔，单位分钟
     */
    int[] REVIEW_INTERVAL = new int[]{5, 30, 720, 1440};
}
