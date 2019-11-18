package com.github.web.controller;

import com.github.web.aop.CustomizedAnnotation;
import com.github.web.entity.ParameterEntity;
import com.github.web.interceptor.ParameterWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 13:47
 */

@RestController
public class TestController {




    //@CustomizedAnnotation
    //@RequestMapping("test")
    @PostMapping("test")
    public String test(@RequestParam("test") String test,@ParameterWrapper @RequestBody ParameterEntity entity){
        System.out.println(entity.getGroupId());
        System.out.println(entity.getCompanyId());
        System.out.println(entity.getUserId());
        return "ok， groupId = " + entity.getGroupId() + ", companyId = " + entity.getCompanyId() + ", userId = " + entity.getUserId();
    }

    @PostMapping("test2")
    public String test(ParameterEntity entity){
        System.out.println(entity.getSex());
        System.out.println(entity.getAge());

        return "ok， sex = " + entity.getSex() + "age = " + entity.getAge();
    }

    @PostMapping("test3")
    public String test(@RequestParam("file") MultipartFile file){

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());

        //for (ParameterEntity entity : entitys) {
        //    System.out.println(entity);
        //}
        //return "ok， sex = " + entitys.get(0).getSex() + "age = " + entitys.get(0).getAge();
        return null;
    }

}
