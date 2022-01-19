package com.zzk.fmmall.api;


import com.zzk.fmmall.ajax.AjaxResult;
import com.zzk.fmmall.annotation.LogPrint;
import com.zzk.fmmall.service.ProductCommentService;
import com.zzk.fmmall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 前端控制器
 * </p>
 *
 * @author zzk
 * @since 2022-01-15
 */
@Api(tags = "商品管理")
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCommentService productCommentService;

    @LogPrint(description = "商品基本信息查询接口")
    @ApiOperation("商品基本信息查询接口")
    @ApiImplicitParam(name = "productId", value = "商品Id", required = true, paramType = "path")
    @GetMapping("/basic-info/{productId}")
    public AjaxResult listRecommendProducts(@PathVariable String productId) {
        return productService.getProductBasicInfo(productId);
    }

    @LogPrint(description = "商品参数信息查询接口")
    @ApiOperation("商品参数信息查询接口")
    @ApiImplicitParam(name = "productId", value = "商品Id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/detail-params/{productId}")
    public AjaxResult getProductParams(@PathVariable String productId) {
        return productService.getProductParamsInfo(productId);
    }

    @LogPrint(description = "商品评论查询接口")
    @ApiOperation("商品评论查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品Id", dataType = "String", required = true, paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "int", required = true, paramType = "query")
    })
    @GetMapping("/detail-comments/{productId}")
    public AjaxResult getProductComments(@PathVariable String productId, @RequestParam("pageNum") int pageNum, @RequestParam("limit") int limit) {
        return productCommentService.listCommentsByProductId(productId, pageNum, limit);
    }
}

