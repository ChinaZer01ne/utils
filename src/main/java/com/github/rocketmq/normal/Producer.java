package com.github.rocketmq.normal;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/15 10:17
 */
public class Producer {


    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.2.105:9876";


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1. 创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("rocketmq-producer");
        //2. 设置Namesrv地址
        producer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 开启DefaultMQProducer
        producer.start();
        //4. 创建消息Message
        Message message = new Message("createOrder","order","Keys","Now is creating first order.".getBytes());
        // 设置消息延迟消费
        //message.setDelayTimeLevel(1);
        //5.1 同步发送消息
        SendResult result = producer.send(message);
        // 可以设置到消息发送到指定队列
        //SendResult result = producer.send(message, new MessageQueueSelector() {
        //    @Override
        //    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
        //        Integer queueNum = (Integer)o;
        //        return list.get(queueNum);
        //    }
        //},2);
        System.out.println(result);
        //6. 关闭DefaultMQProducer
        producer.shutdown();
        //5.2 异步发送消息，不能关闭producer
        //producer.send(message, new SendCallback() {
        //    @Override
        //    public void onSuccess(SendResult sendResult) {
        //        System.out.println(sendResult.getMsgId() + " " + sendResult.getSendStatus());
        //    }
        //
        //    @Override
        //    public void onException(Throwable throwable) {
        //        //根据业务补偿或其他处理
        //        System.out.println(throwable.getMessage());
        //    }
        //});

    }
}
