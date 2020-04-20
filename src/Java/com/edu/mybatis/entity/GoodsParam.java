package com.edu.mybatis.entity;

public class GoodsParam {
    private Integer gpId;
    private String gpParamName;
    private String gpParamValue;
    private Integer goodsId;
    private Integer gpOrder;

    public GoodsParam() {
    }

    @Override
    public String toString() {
        return "GoodsParam{" +
                "gpId=" + gpId +
                ", gpIparamName='" + gpParamName + '\'' +
                ", gpParamValue='" + gpParamValue + '\'' +
                ", goodsId=" + goodsId +
                ", gpOrder=" + gpOrder +
                '}';
    }

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public String getGpIparamName() {
        return gpParamName;
    }

    public void setGpIparamName(String gpIparamName) {
        this.gpParamName = gpIparamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Integer gpOrder) {
        this.gpOrder = gpOrder;
    }

    public GoodsParam(Integer gpId, String gpIparamName, String gpParamValue, Integer goodsId, Integer gpOrder) {
        this.gpId = gpId;
        this.gpParamName = gpIparamName;
        this.gpParamValue = gpParamValue;
        this.goodsId = goodsId;
        this.gpOrder = gpOrder;
    }
}
