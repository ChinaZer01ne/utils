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
    @PostMapping("/addWithRequired")
    public Result addWithRequired(Transaction transaction){
        return Result.success(transactionService.addWithRequired(transaction));
    }
    /**
     * 更新
     * @param transaction :
     * @return com.github.web.common.Result
     * @throws
     */
    @PutMapping("/updateWithSupports")
    public Result updateWithSupports(Transaction transaction){
        return Result.success(transactionService.updateWithSupports(transaction));
    }
    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/deleteWithMandatory")
    public Result deleteWithMandatory(Integer id){
        return Result.success(transactionService.deleteWithMandatory(id));
    }

    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/deleteWithNotSupported")
    public Result deleteWithNotSupported(Integer id){
        return Result.success(transactionService.deleteWithNotSupported(id));
    }
    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/deleteWithRequiresNew")
    public Result deleteWithRequiresNew(Integer id){
        return Result.success(transactionService.deleteWithRequiresNew(id));
    }
    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/deleteWithNested")
    public Result deleteWithNested(Integer id){
        return Result.success(transactionService.deleteWithNested(id));
    }
    /**
     * 删除
     * @param id :
     * @return com.github.web.common.Result
     * @throws
     */
    @DeleteMapping("/deleteWithNever")
    public Result deleteWithNever(Integer id){
        return Result.success(transactionService.deleteWithNever(id));
    }
    @GetMapping("/test")
    public String test(){
        return "json test";
    }
}
