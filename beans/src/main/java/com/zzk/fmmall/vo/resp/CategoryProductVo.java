package com.zzk.fmmall.vo.resp;

import lombok.Data;

import java.util.List;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author zzk
 * @since 2022-01-13
 */
@Data
public class CategoryProductVo {
    /**
     * 主键 分类id主键
     */
    private Integer categoryId;

    /**
     * 分类名称 分类名称
     */
    private String categoryName;

    /**
     * 分类层级 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     */
    private Integer categoryLevel;

    /**
     * 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    private Integer parentId;

    /**
     * 图标 logo
     */
    private String categoryIcon;

    /**
     * 口号
     */
    private String categorySlogan;

    /**
     * 分类图
     */
    private String categoryPic;

    /**
     * 背景颜色
     */
    private String categoryBgColor;

    /**
     * 子级分类
     */
    List<ProductVo> products;
}
