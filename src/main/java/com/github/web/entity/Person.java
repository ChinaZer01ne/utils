package com.github.web.entity;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/19 17:33
 * @Version 1.0
 */
public class Person {
    @Field
    private Long id;
    @Field
    private String name;
    @Field
    private Date birthday;
    @Field
    private String description;
    @Field
    private String personName;
    @Field
    private String person_name;

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

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
