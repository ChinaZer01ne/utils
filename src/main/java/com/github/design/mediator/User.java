package com.github.design.mediator;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:05
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
