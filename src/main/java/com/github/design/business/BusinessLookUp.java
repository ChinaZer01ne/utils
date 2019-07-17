package com.github.design.business;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 14:23
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType){
        if(serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}
