package com.edu.mybatis.entity;

import java.util.List;

public class Goods {
    private Integer goodsId;
    private String title;
    private String subTitle;
    private Float originalCost;
    private Float currentPrice;
    private Float discount;
    private Integer isFreeDelivery;
    private Integer categoryId;
    private List<GoodsDetail> goodsDetailList;

    public Goods(Integer goodsId, String title, String subTitle, Float originalCost, Float currentPrice, Float discount, Integer isFreeDelivery, Integer categoryId, List<GoodsDetail> goodsDetailList) {
        this.goodsId = goodsId;
        this.title = title;
        this.subTitle = subTitle;
        this.originalCost = originalCost;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.isFreeDelivery = isFreeDelivery;
        this.categoryId = categoryId;
        this.goodsDetailList = goodsDetailList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalCost=" + originalCost +
                ", currentPrice=" + currentPrice +
                ", discount=" + discount +
                ", isFreeDelivery=" + isFreeDelivery +
                ", categoryId=" + categoryId +
                ", goodsDetailList=" + goodsDetailList +
                '}';
    }

    public List<GoodsDetail> getGoodsDetailList() {
        return goodsDetailList;
    }

    public void setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
        this.goodsDetailList = goodsDetailList;
    }

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Float getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Float originalCost) {
        this.originalCost = originalCost;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getIsFreeDelivery() {
        return isFreeDelivery;
    }

    public void setIsFreeDelivery(Integer isFreeDelivery) {
        this.isFreeDelivery = isFreeDelivery;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Goods(Integer goodsId, String title, String subTitle, Float originalCost, Float currentPrice, Float discount, Integer isFreeDelivery, Integer categoryId) {
        this.goodsId = goodsId;
        this.title = title;
        this.subTitle = subTitle;
        this.originalCost = originalCost;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.isFreeDelivery = isFreeDelivery;
        this.categoryId = categoryId;
    }
}
