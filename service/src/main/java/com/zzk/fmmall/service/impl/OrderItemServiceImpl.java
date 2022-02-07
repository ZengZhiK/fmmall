package com.zzk.fmmall.service.impl;

import com.zzk.fmmall.entity.OrderItem;
import com.zzk.fmmall.dao.OrderItemDAO;
import com.zzk.fmmall.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单项/快照  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-02-07
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDAO, OrderItem> implements OrderItemService {

}
