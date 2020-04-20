package com.edu.mybatis.entity;

public class GoodsDetail {
    private Integer gdId;
    private Integer goodsId;
    private String gdPicUrl;
    private Integer gdOrder;

    public GoodsDetail() {
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "gdId=" + gdId +
                ", goodsId=" + goodsId +
                ", gdPicUrl='" + gdPicUrl + '\'' +
                ", gdOrder=" + gdOrder +
                '}';
    }

    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGdPicUrl() {
        return gdPicUrl;
    }

    public void setGdPicUrl(String gdPicUrl) {
        this.gdPicUrl = gdPicUrl;
    }

    public Integer getGdOrder() {
        return gdOrder;
    }

    public void setGdOrder(Integer gdOrder) {
        this.gdOrder = gdOrder;
    }

    public GoodsDetail(Integer gdId, Integer goodsId, String gdPicUrl, Integer gdOrder) {
        this.gdId = gdId;
        this.goodsId = goodsId;
        this.gdPicUrl = gdPicUrl;
        this.gdOrder = gdOrder;
    }
}
