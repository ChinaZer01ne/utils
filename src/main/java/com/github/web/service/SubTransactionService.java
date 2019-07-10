package com.github.web.service;

import com.github.web.entity.Transaction;

/**
 * @author peach
 * @since 2019/7/9 下午8:35
 */
public interface SubTransactionService {
    /**
     * 查
     * @param id :
     * @return com.github.web.entity.Transaction
     * @throws
     */
    Transaction get(Integer id);
    /**
     * 添加
     * @param transaction :
     * @return int
     * @throws
     */
    int add(Transaction transaction);
    /**
     * 更新
     * @param transaction :
     * @return int
     * @throws
     */
    int update(Transaction transaction);
    /**
     * 删除
     * @param id :
     * @return int
     * @throws
     */
    int delete(Integer id);
}
