package com.github.solr;

import com.github.GithubApplication;
import com.github.web.entity.Person;
import org.apache.solr.client.solrj.SolrClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.Date;

/**
 * solr全文检索
 * @author Zer01ne
 * @date 2019/2/22 10:11
 * @version  1.0
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {GithubApplication.class})
//@TestPropertySource(locations = "classpath:application.properties")
//@WebAppConfiguration
@Service
public class SolrSearch {

    @Autowired
    private SolrTemplate solrTemplate;


    /**
     * 增
     */
    //@Test
    public void add(){
        Person person = new Person();
        person.setId(8L);
        person.setName("lion");
        person.setBirthday(new Date());
        person.setDescription("lion index test!");
        person.setPersonName("personName");
        person.setPerson_name("---");
        //添加BigDecimal类型的时候出现了异常，不清楚是怎么回事
        //tbItem.setPrice(new BigDecimal(3000.01));
        solrTemplate.saveBean("core1",person);
        solrTemplate.deleteByIds("core1",String.valueOf(1L));
        solrTemplate.commit("core1");
    }
    /**
     * 删
     */
    public void delete(){

    }
    /**
     * 改
     */
    public void update(){

    }
    /**
     * 查
     */
    public void select(){

    }
}
