package com.github.web.controller;

import com.github.web.aop.CustomizedAnnotation;
import com.github.web.entity.ParameterEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 13:47
 */

@RestController
public class TestController {

    @CustomizedAnnotation
    @RequestMapping("test")
    public String test(@RequestParam("test") String test, @RequestBody ParameterEntity entity){
        System.out.println(entity.getGroupId());
        System.out.println(entity.getCompanyId());
        System.out.println(entity.getUserId());
        return "ok， groupId = " + entity.getGroupId() + ", companyId = " + entity.getCompanyId() + ", userId = " + entity.getUserId();
    }
}
