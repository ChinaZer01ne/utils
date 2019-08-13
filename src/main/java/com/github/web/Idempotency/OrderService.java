package com.github.web.Idempotency;

/**
 * 幂等性方法的实现
 * @author peach
 * @since 2019/8/9 下午9:29
 */
public class OrderService {
    /**
     * 方法一：根据业务对象创建唯一ID
     *
    //用于存放已经处理的ID
    Map distributedMap;

    @Transactional
    public void ticketOrder(BuyTicketDTO dto){
        // 创建or获取数据的唯一ID
        String uuid = createUUID(dto);
        // 也可以在调用之前给实体绑定了个业务id，此时获取数据的唯一ID
        // String uuid = dto.getBussnissID();
        if (!distributedMap.containsKey(uuid)){
            // 本服务还没有处理这个操作
            Order order = createOrder(dto);
        }
        // 然后继续其他操作
        userService.charge(dto);
    }
    */

    /**
     * 方法二：一个业务问题，在数据库层面实现
     * 通过调用调节限定，只有第一次支付的时候才会扣余额，被重复调用的时候就不会重复扣费
     *
     * UPDATE user SET deposit = deposit - ‘value’， pauStatus = ‘PAID’ WHERE orderId = ‘orderId’ AND payStatus = ‘UNPAID’
     *
     *
     * */
}
