package com.edu.mybatis.entity;

public class GoodsCover {
    private Integer gcId;
    private Integer goodsId;
    private String gcPicUrl;
    private String gcThumbUrl;
    private Integer gcOrder;

    public GoodsCover() {
    }

    @Override
    public String toString() {
        return "GoodsCover{" +
                "gcId=" + gcId +
                ", goodsId=" + goodsId +
                ", gcPicUrl='" + gcPicUrl + '\'' +
                ", gcThumbUrl='" + gcThumbUrl + '\'' +
                ", gcOrder=" + gcOrder +
                '}';
    }

    public Integer getGcId() {
        return gcId;
    }

    public void setGcId(Integer gcId) {
        this.gcId = gcId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGcPicUrl() {
        return gcPicUrl;
    }

    public void setGcPicUrl(String gcPicUrl) {
        this.gcPicUrl = gcPicUrl;
    }

    public String getGcThumbUrl() {
        return gcThumbUrl;
    }

    public void setGcThumbUrl(String gcThumbUrl) {
        this.gcThumbUrl = gcThumbUrl;
    }

    public Integer getGcOrder() {
        return gcOrder;
    }

    public void setGcOrder(Integer gcOrder) {
        this.gcOrder = gcOrder;
    }

    public GoodsCover(Integer gcId, Integer goodsId, String gcPicUrl, String gcThumbUrl, Integer gcOrder) {
        this.gcId = gcId;
        this.goodsId = goodsId;
        this.gcPicUrl = gcPicUrl;
        this.gcThumbUrl = gcThumbUrl;
        this.gcOrder = gcOrder;
    }
}
