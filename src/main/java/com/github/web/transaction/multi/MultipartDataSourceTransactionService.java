package com.github.web.transaction.multi;

/**
 * 多数据源的事务：MQ + 数据库
 */
public interface MultipartDataSourceTransactionService {

    void saveAndSend(String msg);
    void saveAndSendInCode(String msg);

    String read();

    void convertAndSend(String s, String msg);
}
