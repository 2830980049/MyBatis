package com.edu.mybatis.Dto;

import com.edu.mybatis.entity.Category;
import com.edu.mybatis.entity.Goods;

public class GoodsDTO {
    // Data Transfer Object 数据传送对象
    private Goods goods = new Goods();
    private Category category = new Category();
    private String test;

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "goods=" + goods +
                ", category=" + category +
                ", test='" + test + '\'' +
                '}';
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public GoodsDTO() {
    }

    public GoodsDTO(Goods goods, Category category, String test) {
        this.goods = goods;
        this.category = category;
        this.test = test;
    }
}
