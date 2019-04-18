package com.github.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/18 10:45
 */
public class MyTest3 {
    public void test() {
        try {

            InputStream in = new FileInputStream("test.txt");
            ServerSocket socket = new ServerSocket(9999);
            socket.accept();
        }catch (FileNotFoundException e) {

        }catch (IOException e){

        }catch (Exception e){

        }finally {
            System.out.println("finally");
        }
    }
}
