package com.github.rocketmq.broadcasting;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/16 10:31
 */
public class BroadcastingProducer {

    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.1.155:9876";


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1. 创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("rocketmq-broadcasting-producer");
        //2. 设置Namesrv地址
        producer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 开启DefaultMQProducer
        producer.start();
        //4. 创建消息Message
        List<Message> messages = new ArrayList<Message>();
        for (int i = 0; i <10 ; i++) {

            Message message = new Message("broadcasting","broadcasting","Keys" + i,("Now is broadcasting" + i).getBytes());

            messages.add(message);
        }
        //5. 发送消息
        SendResult result = producer.send(messages);
        System.out.println(result);
        //6. 关闭DefaultMQProducer
        producer.shutdown();
    }
}
