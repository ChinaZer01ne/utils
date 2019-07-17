package com.github.design.business;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 14:23
 */
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        this.businessService  = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}
