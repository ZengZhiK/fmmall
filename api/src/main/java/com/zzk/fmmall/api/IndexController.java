package com.zzk.fmmall.api;


import cn.hutool.json.JSONUtil;
import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.service.CategoryService;
import com.zzk.fmmall.service.IndexImgService;
import com.zzk.fmmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @LogPrint(description = "轮播图查询接口")
    @ApiOperation("轮播图查询接口")
    @GetMapping("/carousels")
    public AjaxResult listCarousels() {
        return indexImgService.listCarousels();
    }

    @LogPrint(description = "分类列表查询接口")
    @ApiOperation("分类列表查询接口")
    @GetMapping("/categories")
    public AjaxResult listCategories() {
        return categoryService.listCategories();
    }

    @LogPrint(description = "新品推荐查询接口")
    @ApiOperation("新品推荐查询接口")
    @GetMapping("/recommend-products")
    public AjaxResult listRecommendProducts() {
        return productService.listRecommendProducts();
    }
}

