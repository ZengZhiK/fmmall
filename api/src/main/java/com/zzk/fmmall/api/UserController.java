package com.zzk.fmmall.api;


import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.config.JwtTokenConfig;
import com.zzk.fmmall.service.UserService;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.utils.JwtTokenUtils;
import com.zzk.fmmall.vo.req.UserLoginVo;
import com.zzk.fmmall.vo.req.UserRegisterVo;
import com.zzk.fmmall.vo.resp.UserLoginRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户  前端控制器
 * </p>
 *
 * @author zzk
 * @since 2021-12-22
 */
@Api(tags = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenConfig jwtTokenConfig;

    @LogPrint(description = "用户注册接口")
    @ApiOperation("用户注册接口")
    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Valid UserRegisterVo userRegisterVo) {
        userService.doRegister(userRegisterVo);
        return AjaxResult.success("注册成功！");
    }

    @LogPrint(description = "用户登录接口")
    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Valid UserLoginVo userLoginVo) {
        UserLoginRespVo loginUser = userService.doLogin(userLoginVo);

        String token = JwtTokenUtils.getAccessToken(jwtTokenConfig.getIssuer(),
                loginUser.getUserId().toString(), null,
                jwtTokenConfig.getAccessTokenExpireTime(),
                jwtTokenConfig.getSecretKey());

        return AjaxResult.success(token, loginUser);
    }

}

