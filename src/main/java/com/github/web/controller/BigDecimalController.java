package com.github.web.controller;

import com.github.web.common.Result;
import com.github.web.service.BigDecimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 *
 *  经过测试，我们不用担心前端传过来的或者从数据库查出来的 {@link java.math.BigDecimal},是否是用字符串参数的构造方法构造的
 * 事实证明，他们确实是，仔细想想。前端和数据库本身显示或存储的就是字符串类型。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/10 17:35
 */
@RestController
@RequestMapping("/type")
public class BigDecimalController {

    @Autowired
    private BigDecimalService bigDecimalService;

    @GetMapping("/get")
    public Result get(){
        return Result.success(bigDecimalService.get());
    }

    @PostMapping("/receiver")
    public Result receiver(BigDecimal num){
        return Result.success(bigDecimalService.receiver(num));
    }
}
