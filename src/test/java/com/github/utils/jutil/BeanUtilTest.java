package com.github.utils.jutil;

import lombok.Data;
import org.junit.Test;

import static com.github.utils.jutils.BeanCopyUtil.copyIgnoreNull;

public class BeanUtilTest {
    @Test
    public void test() {


        B b = new B();
        //BeanUtils.copyProperties(new A(),b);
        copyIgnoreNull(new A(),b);
        System.out.println(b.getUsername());
        System.out.println(b.getAge());
        //BeanCopyUtil.reflectField(new Student("ethan",1));
    }

}
@Data
class A{
    private String username = "123";
    private Integer age ;

}
@Data
class B{
    private String username;
    private Integer age = 2;

}
