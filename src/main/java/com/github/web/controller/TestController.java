package com.github.web.controller;

import com.github.web.aop.CustomizedAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String test(){
        return "ok";
    }
}
