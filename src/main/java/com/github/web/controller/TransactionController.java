package com.github.web.controller;

import com.github.web.common.Result;
import com.github.web.entity.Transaction;
import com.github.web.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author peach
 * @since 2019/7/9 下午8:31
 */
@RestController
@RequestMapping("/tx")
public class TransactionController {

    @Resource
    private TransactionService transactionService;
    /**
     * 查
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @GetMapping("/get")
    public Result get(Integer id){
        return Result.success(transactionService.get(id));
    }
    /**
     * 添加
     * @param transaction :
     * @return com.github.web.common.Result
     * @throws
     */
    @PostMapping("/add")
    public Result add(Transaction transaction){
        return Result.success(transactionService.add(transaction));
    }
    /**
     * 更新
     * @param transaction :
     * @return com.github.web.common.Result
     * @throws
     */
    @PutMapping("/update")
    public Result update(Transaction transaction){
        return Result.success(transactionService.update(transaction));
    }
    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return Result.success(transactionService.delete(id));
    }

    @GetMapping("/test")
    public String test(){
        return "json test";
    }
}
