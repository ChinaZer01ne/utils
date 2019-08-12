package com.github.web.transaction.chain.entity;

import lombok.Data;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/9 16:22
 */
@Data
public class Order {
    private Long id;
    private Long customerId;
    private String title;
    private Integer amount;
}
