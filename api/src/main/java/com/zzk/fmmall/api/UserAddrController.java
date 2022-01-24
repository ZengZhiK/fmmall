package com.zzk.fmmall.api;


import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.service.UserAddrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户地址  前端控制器
 * </p>
 *
 * @author zzk
 * @since 2022-01-24
 */
@Slf4j
@Api(tags = "收货地址管理")
@CrossOrigin
@RestController
@RequestMapping("/useraddr")
public class UserAddrController {
    @Autowired
    private UserAddrService userAddrService;

    @LogPrint(description = "收货地址查询接口")
    @ApiOperation("收货地址查询接口")
    @ApiImplicitParam(dataType = "int", name = "userId", value = "用户ID", required = true)
    @GetMapping("/list")
    public AjaxResult listAddr(Integer userId) {
        return userAddrService.listAddrsByUid(userId);
    }
}

