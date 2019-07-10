package com.github.web.service;

import java.math.BigDecimal;

public interface BigDecimalService {

    /**
     * 从数据库读取BigDecimal
     * @return java.math.BigDecimal
     * @throws
     */
    BigDecimal get();
    /**
     * 从前端接收BigDecimal
     * @param num :
     * @return java.math.BigDecimal
     * @throws
     */
    BigDecimal receiver(BigDecimal num);
}
