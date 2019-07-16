package com.github.design.mediator;

import java.util.Date;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/16 15:04
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}
