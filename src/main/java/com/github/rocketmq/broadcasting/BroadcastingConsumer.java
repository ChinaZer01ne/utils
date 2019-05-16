package com.github.rocketmq.broadcasting;

import io.netty.util.CharsetUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/16 10:32
 */
public class BroadcastingConsumer {
    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.1.155:9876";

    public static void main(String[] args) throws MQClientException {
        //1. 创建DefaultMQPushConsumer
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("rocketmq-consumer");
        //2. 设置namesrv地址
        pushConsumer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 设置subscribe，这里是要读取的主题信息
        pushConsumer.subscribe("broadcasting",
                "broadcasting");
        //默认为集群消费模式，集群消费模式只有一个消费者能消费消息，广播消费模式则每个消费者都能消费消息
        pushConsumer.setMessageModel(MessageModel.BROADCASTING);

        //指定一次拉取条数
        pushConsumer.setConsumeMessageBatchMaxSize(2);

        //4. 创建消息监听MessageListener
        pushConsumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                for (MessageExt messageExt :
                        list) {
                    //获取主题
                    String topic = messageExt.getTopic();
                    //获取标签
                    String tags = messageExt.getTags();
                    //5. 获取消息信息
                    String message = new String(messageExt.getBody(), CharsetUtil.UTF_8);

                    System.out.println("topic: " + topic + ", tags: " + tags + ", message: " + message);
                }


                //6. 返回消息读取状态
                //消息消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //启动消费监听
        pushConsumer.start();

    }
}
