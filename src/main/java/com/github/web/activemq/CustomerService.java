package com.github.web.activemq;

public interface CustomerService {
     void handle(String msg);
     void handleInCode(String msg);
}
