package com.github.developer.memory;

import java.time.LocalDateTime;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/2 15:42
 */
public class MemoryRecord {
    /**
     * 编号
     * */
    private Integer id;
    /**
     * 记忆内容
     * */
    private String item;
    /**
     * 复习次数
     * */
    private Integer reviewCount;
    /**
     * 存储时间
     * */
    private LocalDateTime localDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
