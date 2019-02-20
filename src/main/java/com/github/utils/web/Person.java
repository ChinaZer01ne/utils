package com.github.utils.web;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/19 17:33
 * @Version 1.0
 */
public class Person {
    private Long id;
    private String name;
    private Date birthday;
    private String description;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
