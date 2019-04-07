package com.github.web.controller;



import com.github.solr.SolrSearch;
import com.github.web.entity.Person;
import com.github.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Zer01ne
 * @date 2019/1/15 16:20
 * @version 1.0
 */
@Controller
public class ControllerTest {


    @PostMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello...");
        return "/test";
    }

    @GetMapping(value = "/index")
    public String redirect(){
        System.out.println("run...");

        return "test2";
    }

    @ResponseBody
    @RequestMapping("/Serializable")
    public Person serializable(String name, Date birthday){
        Person person = new Person();
        person.setName(name);
        person.setBirthday(birthday);
        System.out.println("当前时间" + new Date());
        return person;
    }

    @ResponseBody
    @RequestMapping("/Serializable2")
    public Person serializable2(@RequestBody Person person){

        return person;
    }


    @Autowired
    private PersonService personService;

    @ResponseBody
    @GetMapping("/person")
    public Person get(Integer id){

        return personService.findById(id);
    }

    @ResponseBody
    @PostMapping("/add")
    public String add(@RequestBody Person person){
        personService.add(person);
        return "OK";
    }

    @Autowired
    private SolrSearch solrSearch;
    @GetMapping("/add")
    public String searchTest(){
        solrSearch.add();
        return "OK";
    }

}
