package com.github.design.business;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 14:22
 */
public class EJBService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
