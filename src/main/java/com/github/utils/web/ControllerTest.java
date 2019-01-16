package com.github.utils.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
}
