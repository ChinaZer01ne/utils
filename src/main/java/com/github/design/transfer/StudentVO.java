package com.github.design.transfer;

/**
 *
 * 创建传输对象。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/17 15:07
 */
public class StudentVO {
    private String name;
    private int rollNo;

    StudentVO(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
