package com.zzk.fmmall.api;


import cn.hutool.json.JSONUtil;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
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
    @LogPrint(description = "购物车展示接口")
    @GetMapping("/list")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true)
    public AjaxResult list(@RequestParam("userId") Integer userId) {
        log.info("Request Args   : {}", JSONUtil.toJsonStr(
                new HashMap<String, Integer>() {{
                    put("userId", userId);
                }}));
        return AjaxResult.success();
    }
}

