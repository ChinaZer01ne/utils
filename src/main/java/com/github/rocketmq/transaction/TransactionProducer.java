package com.github.rocketmq.transaction;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/16 9:29
 */
public class TransactionProducer {


    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.1.155:9876";

    public static void main(String[] args) throws MQClientException {

        //1. 创建TransactionMQProducer
        TransactionMQProducer transactionMQProducer = new TransactionMQProducer("rocketmq-transaction-consumer");
        //2. 设置Namesrv地址
        transactionMQProducer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 设置事务监听
        transactionMQProducer.setTransactionListener(new TransactionListener() {

            private ConcurrentMap<String,Integer> localTrans = new ConcurrentHashMap<>();
            /**
             * 执行本地事务
             * */
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                //事务ID
                String transactionId = message.getTransactionId();

                //0：执行中，状态未知；1：执行成功；2：执行失败
                localTrans.put(transactionId,0);

                //业务执行，service，处理本地事务

                try {
                    System.out.println("正在执行本地事务。。。" + transactionId);
                    Thread.sleep(61000);
                    //执行成功
                    localTrans.put(transactionId,1);
                    System.out.println("本地事务执行成功！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //执行失败
                    localTrans.put(transactionId,2);
                    System.out.println("本地事务执行失败！");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }

                return LocalTransactionState.COMMIT_MESSAGE;
            }
            /**
             * 消息回查
             * */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                //获取对应的事务ID
                String transactionId = messageExt.getTransactionId();
                //获取对应的事务ID执行状态
                Integer status = localTrans.get(transactionId);

                System.out.println("消息回查：transactionId : " + transactionId + ", status：" + status);
                switch (status){
                    case 0:
                        return LocalTransactionState.UNKNOW;
                    case 1:
                        return LocalTransactionState.COMMIT_MESSAGE;
                    case 2:
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    default:
                        return LocalTransactionState.UNKNOW;
                }
            }
        });

        //4. 设置线程池
        transactionMQProducer.setExecutorService(new ThreadPoolExecutor(2,
                5,
                100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        }));

        //4. 开启DefaultMQProducer
        transactionMQProducer.start();


        //5. 创建消息Message
        Message message = new Message("reduceStock","stock","Keys",("Now is reducing stock transaction message.").getBytes());

        //6. 发送消息
        SendResult result = transactionMQProducer.sendMessageInTransaction(message,"transaction");
        System.out.println(result);

        //7. 关闭DefaultMQProducer
        transactionMQProducer.shutdown();
    }
}
