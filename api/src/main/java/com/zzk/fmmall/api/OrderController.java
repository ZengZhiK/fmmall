package com.zzk.fmmall.api;


import com.github.wxpay.sdk.WXPay;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.config.AppPayConfig;
import com.zzk.fmmall.entity.Order;
import com.zzk.fmmall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 订单  前端控制器
 * </p>
 *
 * @author zzk
 * @since 2022-02-07
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @LogPrint(description = "订单添加接口")
    @ApiOperation("订单添加接口")
    @PostMapping("/add")
    public AjaxResult add(String cids, @RequestBody Order order) {
        AjaxResult resultVO = null;
        try {
            Map<String, String> orderInfo = orderService.addOrder(cids, order);
            if (orderInfo != null) {
                String orderId = orderInfo.get("orderId");
                //设置当前订单信息
                HashMap<String, String> data = new HashMap<>();
                data.put("body", orderInfo.get("productNames"));  //商品描述
                data.put("out_trade_no", orderId);               //使用当前用户订单的编号作为当前支付交易的交易号
                data.put("fee_type", "CNY");                     //支付币种
                //data.put("total_fee",order.getActualAmount()*100+"");          //支付金额
                data.put("total_fee", "1");
                data.put("trade_type", "NATIVE");                //交易类型
                data.put("notify_url", " http://r72559.natappfree.cc/pay/callback");           //设置支付完成时的回调方法接口

                //发送请求，获取响应
                //微信支付：申请支付连接
                WXPay wxPay = new WXPay(new AppPayConfig());
                Map<String, String> resp = wxPay.unifiedOrder(data);
                orderInfo.put("payUrl", resp.get("code_url"));
                //orderInfo中包含：订单编号，购买的商品名称，支付链接
                resultVO = AjaxResult.success("提交订单成功！", orderInfo);
            } else {
                resultVO = AjaxResult.error("提交订单失败！");
            }
        } catch (Exception e) {
            resultVO = AjaxResult.error("提交订单失败！");
        }
        return resultVO;
    }
}

