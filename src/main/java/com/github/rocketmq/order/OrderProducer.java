package com.github.rocketmq.order;

import io.netty.handler.codec.spdy.SpdyVersion;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/15 15:54
 */
public class OrderProducer {

    //指定namesrv地址
    private static String NAMESRV_ADDRESS = "192.168.1.155:9876";


    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1. 创建DefaultMQProducer
        DefaultMQProducer producer = new DefaultMQProducer("rocketmq-order-producer");
        //2. 设置Namesrv地址
        producer.setNamesrvAddr(NAMESRV_ADDRESS);
        //3. 开启DefaultMQProducer
        producer.start();


        for (int i = 0; i < 5; i++) {
            //4. 创建消息Message
            Message message = new Message("reduceStock","stock","Keys",("Now is reducing stock." + i).getBytes());

            //5. 发送消息
            //第1个参数：发送的消息信息
            //第2个参数：选中指定的消息队列对象（会将所有的消息队列传入进来）
            //第3个参数：指定消息队列的下标
            SendResult result = producer.send(message,
                    new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                            //获取队列的下标
                            Integer index  = (Integer) o;
                            return list.get(index);
                        }
                    },1);
            System.out.println(result);
        }


        //6. 关闭DefaultMQProducer
        producer.shutdown();
    }
}
