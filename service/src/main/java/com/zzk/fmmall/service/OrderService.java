package com.zzk.fmmall.service;

import com.zzk.fmmall.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 订单  服务类
 * </p>
 *
 * @author zzk
 * @since 2022-02-07
 */
public interface OrderService extends IService<Order> {
    /**
     * 添加订单
     *
     * @param cids
     * @param order
     * @return
     */
    Map<String, String> addOrder(String cids, Order order);

    /**
     * 更新订单状态
     *
     * @param orderId
     * @param status
     * @return
     */
    boolean updateOrderStatus(String orderId, String status);
}
