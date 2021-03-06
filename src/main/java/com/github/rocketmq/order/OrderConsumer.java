package com.github.rocketmq.order;

import io.netty.util.CharsetUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/15 10:50
 */
public class OrderConsumer {

    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.1.155:9876";

    public static void main(String[] args) throws MQClientException {
        //1. 创建DefaultMQPushConsumer
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("rocketmq-order-consumer");
        //2. 设置namesrv地址
        pushConsumer.setNamesrvAddr(NAMESRV_ADDRESS);
        //设置消费顺序
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //3. 设置subscribe，这里是要读取的主题信息
        pushConsumer.subscribe("reduceStock",//指定要读取的消息主题
                "stock");//指定要读取的消息过滤信息,多个标签数据，则可以输入"tag1 || tag2 || tag3"
        //4. 创建消息监听MessageListener
        pushConsumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                //获取第一个消息
                MessageExt messageExt = list.get(0);
                //获取主题
                String topic = messageExt.getTopic();
                //获取标签
                String tags = messageExt.getTags();
                //5. 获取消息信息
                String message = new String(messageExt.getBody(),CharsetUtil.UTF_8);

                System.out.println("topic: " + topic + ", tags: " + tags + ", message: " + message);
                //6. 返回消息读取状态
                //消息消费成功
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        //启动消费监听
        pushConsumer.start();

    }
}
