package com.imooc.miaosha.domain;

import javax.persistence.*;

@Entity
@Table(name = "miaosha_order")
public class MiaoshaOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long  orderId;
    private Long goodsId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}