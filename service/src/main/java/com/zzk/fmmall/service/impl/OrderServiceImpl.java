package com.zzk.fmmall.service.impl;

import com.zzk.fmmall.dao.OrderItemDAO;
import com.zzk.fmmall.dao.ProductSkuDAO;
import com.zzk.fmmall.dao.ShoppingCartDAO;
import com.zzk.fmmall.entity.Order;
import com.zzk.fmmall.dao.OrderDAO;
import com.zzk.fmmall.entity.OrderItem;
import com.zzk.fmmall.entity.ProductSku;
import com.zzk.fmmall.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzk.fmmall.vo.resp.ShoppingCartVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 订单  服务实现类
 * </p>
 *
 * @author zzk
 * @since 2022-02-07
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDAO, Order> implements OrderService {
    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    private ProductSkuDAO productSkuDAO;

    @Override
    public Map<String, String> addOrder(String cids, Order order) {
        log.info("add order begin...");
        Map<String, String> map = new HashMap<>();

        //1.校验库存：根据cids查询当前订单中关联的购物车记录详情（包括库存）
        String[] arr = cids.split(",");
        List<Integer> cidsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            cidsList.add(Integer.parseInt(arr[i]));
        }
        List<ShoppingCartVo> list = shoppingCartDAO.selectShopcartByCids(cidsList);

        boolean flag = true;
        String untitled = "";
        for (ShoppingCartVo sc : list) {
            if (Integer.parseInt(sc.getCartNum()) > sc.getSkuStock()) {
                flag = false;
            }
            //获取所有商品名称，以,分割拼接成字符串
            untitled = untitled + sc.getProductName() + ",";
        }

        if (flag) {
            log.info("product stock is OK...");
            //2.保存订单
            order.setUntitled(untitled);
            order.setCreateTime(LocalDateTime.now());
            order.setStatus("1");
            //生成订单编号
            String orderId = UUID.randomUUID().toString().replace("-", "");
            order.setOrderId(orderId);
            orderDAO.insert(order);

            //3.生成商品快照
            for (ShoppingCartVo sc : list) {
                int cnum = Integer.parseInt(sc.getCartNum());
                String itemId = System.currentTimeMillis() + "" + (new Random().nextInt(89999) + 10000);
                OrderItem orderItem = new OrderItem(itemId, orderId, sc.getProductId(), sc.getProductName(), sc.getProductImg(), sc.getSkuId(), sc.getSkuName(), new BigDecimal(sc.getSellPrice()), cnum, new BigDecimal(sc.getSellPrice() * cnum), LocalDateTime.now(), LocalDateTime.now(), 0);
                orderItemDAO.insert(orderItem);
                //增加商品销量
            }

            //4.扣减库存：根据套餐ID修改套餐库存量
            for (ShoppingCartVo sc : list) {
                String skuId = sc.getSkuId();
                int newStock = sc.getSkuStock() - Integer.parseInt(sc.getCartNum());

                ProductSku productSku = new ProductSku();
                productSku.setSkuId(skuId);
                productSku.setStock(newStock);
                productSkuDAO.updateById(productSku);
            }

            //5.删除购物车：当购物车中的记录购买成功之后，购物车中对应做删除操作
            for (int cid : cidsList) {
                shoppingCartDAO.deleteById(cid);
            }

            log.info("add order finished...");
            map.put("orderId", orderId);
            map.put("productNames", untitled);
            return map;
        } else {
            //表示库存不足
            return null;
        }
    }

    @Override
    public boolean updateOrderStatus(String orderId, String status) {
        Order orders = new Order();
        orders.setOrderId(orderId).setStatus(status);
        int i = orderDAO.updateById(orders);
        return i > 0;
    }
}
