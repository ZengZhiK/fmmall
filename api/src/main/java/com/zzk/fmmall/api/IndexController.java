package com.zzk.fmmall.api;


import cn.hutool.json.JSONUtil;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.service.IndexImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 * 首页数据展示  前端控制器
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
@Slf4j
@Api(tags = "首页管理")
@CrossOrigin
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexImgService indexImgService;

    @LogPrint(description = "轮播图查询接口")
    @GetMapping("/carousels")
    public AjaxResult listCarousels() {
        return indexImgService.listCarousels();
    }
}

