package com.zzk.fmmall.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author zzk
 * @create 2021-12-31 11:08
 */
@Data
@ApiModel("用户登录Vo")
public class UserLoginVo {
    @ApiModelProperty(value = "账号", required = true)
    @Length(min = 8, max = 20, message = "账号长度必须为8-20给字符！")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @Length(min = 6, max = 16, message = "密码长度必须为6-16给字符！")
    private String password;
}
