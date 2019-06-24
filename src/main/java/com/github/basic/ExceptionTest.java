package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/24 10:05
 */
public class ExceptionTest {


    public static void main(String[] args) {

        testError();

        //UnCheckedException，不需要try-catch或者抛出，但一旦出现异常，程序就会停止
        try {
            testUnCheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //CheckedException必须try-catch或者抛出
        try {
            testCheckedException();
        } catch (CheckedException e) {
            e.printStackTrace();
        }

    }
    /**
     * 对于一个CheckedException，要么向上抛出，要么捕获
     */
    public static void testCheckedException() throws CheckedException {
        throw new CheckedException();
    }
    /**
     * 对于一个UnCheckedException，不需要处理
     */
    public static void testUnCheckedException() {
        throw new UnCheckedException();
    }

    private static void testError(){
        throw new StackOverflowError();
    }
}

/**
 * 继承自Exception，就是一个CheckedException
 */
class CheckedException extends Exception{
    public CheckedException() {
        super();
    }

    public CheckedException(String message) {
        super(message);
    }
}
/**
 * 继承自RuntimeException，就是一个UnCheckedException
 */
class UnCheckedException extends RuntimeException{
    public UnCheckedException() {
        super();
    }

    public UnCheckedException(String message) {
        super(message);
    }
}
