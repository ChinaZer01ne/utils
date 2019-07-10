package com.github.web.service.impl;

import com.github.web.mapper.BigDecimalMapper;
import com.github.web.service.BigDecimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author peach
 * @since 2019/7/10 下午7:27
 */
@Service
public class BigDecimalServiceImpl implements BigDecimalService {

    @Autowired
    private BigDecimalMapper bigDecimalMapper;


    @Override
    public BigDecimal get() {

        BigDecimal bigDecimal = bigDecimalMapper.selectBigDecimal();

        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(100000));

        System.out.println(multiply);

        return multiply;
    }

    @Override
    public BigDecimal receiver(BigDecimal num) {

        //BigDecimal value = new BigDecimal(1.1);
        BigDecimal multiply = num.multiply(new BigDecimal(100000));

        System.out.println(multiply);

        return multiply;
    }
}
