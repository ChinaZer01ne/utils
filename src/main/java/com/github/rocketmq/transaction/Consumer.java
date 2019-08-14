package com.github.rocketmq.transaction;

import io.netty.util.CharsetUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/15 10:50
 */
public class Consumer {

    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.2.105:9876";

    public static void main(String[] args) throws MQClientException {
        //1. 创建DefaultMQPushConsumer
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("rocketmq-consumer");
        //2. 设置namesrv地址
        pushConsumer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 设置subscribe，这里是要读取的主题信息
        pushConsumer.subscribe("createOrder",//指定要读取的消息主题
                "order");//指定要读取的消息过滤信息,多个标签数据，则可以输入"tag1 || tag2 || tag3"
        //4. 创建消息监听MessageListener
        pushConsumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {


                //获取第一个消息
                MessageExt messageExt = list.get(0);
                //获取主题
                String topic = messageExt.getTopic();
                //获取标签
                String tags = messageExt.getTags();
                //5. 获取消息信息
                String message = new String(messageExt.getBody(),CharsetUtil.UTF_8);
                // 业务操作 TODO
                System.out.println("topic: " + topic + ", tags: " + tags + ", message: " + message);
                //6. 返回消息读取状态
                //消息消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //启动消费监听
        pushConsumer.start();

    }
}
