package com.github.utils.web;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/15 16:20
 * @Version 1.0
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

        return "test";
    }

    @ResponseBody
    @RequestMapping("/Serializable")
    public Person serializable(String name,Date birthday){
        Person person = new Person();
        person.setName(name);
        person.setBirthday(birthday);
        System.err.println(System.currentTimeMillis());
        return person;
    }

    @ResponseBody
    @RequestMapping("/Serializable2")
    public Person serializable2(@RequestBody Person person){

        return person;
    }
}
