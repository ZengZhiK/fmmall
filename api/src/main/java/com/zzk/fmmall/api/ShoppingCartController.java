package com.zzk.fmmall.api;


import cn.hutool.json.JSONUtil;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.service.ShoppingCartService;
import com.zzk.fmmall.vo.req.ShoppingCartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 购物车  前端控制器
 * </p>
 *
 * @author zzk
 * @since 2022-01-03
 */
@Slf4j
@Api(tags = "购物车管理")
@CrossOrigin
@RestController
@RequestMapping("/shopcart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @LogPrint(description = "添加购物车接口")
    @ApiOperation("添加购物车接口")
    @PostMapping("/add")
    public AjaxResult addShoppingCart(@RequestBody ShoppingCartVo shoppingCartVo) {
        return shoppingCartService.addShoppingCart(shoppingCartVo);
    }

    @LogPrint(description = "购物车展示接口")
    @ApiOperation("购物车展示接口")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("userId") Integer userId) {
        log.info("Request Args   : {}", JSONUtil.toJsonStr(
                new HashMap<String, Integer>() {{
                    put("userId", userId);
                }}));
        return shoppingCartService.listShoppingCartsByUserId(userId);
    }

    @LogPrint(description = "购物车提交查询接口")
    @ApiOperation("购物车提交查询接口")
    @ApiImplicitParam(dataType = "String", name = "cids", value = "选择的购物车记录的id", required = true)
    @GetMapping("/listbycids")
    public AjaxResult listByCids(String cids) {
        return shoppingCartService.listShoppingCartsByCids(cids);
    }
}

