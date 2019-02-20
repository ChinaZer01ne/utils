package com.github.utils.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/20 13:19
 * @Version 1.0
 */
@Configuration
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }





    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    /**
     * 方式一
     * 增加字符串转日期的功能
     */

    @PostConstruct
    public void initEditableAvlidation() {

        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if(initializer.getConversionService()!=null) {
            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();

            genericConversionService.addConverter(new DateConverter());

        }

    }
    /**
     * 方式二
     * */
    //@Bean
    //public ConversionService getConversionService(DateConverter dateConverter){
    //    ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
    //
    //    Set<Converter> converters = new HashSet<Converter>();
    //
    //    converters.add(dateConverter);
    //
    //    factoryBean.setConverters(converters);
    //
    //    return factoryBean.getObject();
    //}

}
