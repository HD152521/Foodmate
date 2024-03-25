package com.seong.foodmate.foodmate.vo;

import lombok.Data;

@Data
public class PostContentVO {
    private String post_id;
    private String menu;
    private String orderTime;
    private int deliveryFee;

    public String getPost_id() {
        return this.post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getMenu() {
        return this.menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }       

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getDeliveryFee() {
        return this.deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "PostContentVO [post_id=" + post_id + ", menu=" + menu + ", orderTime=" + orderTime + ", deliveryFee="
                + deliveryFee + "]";
    }
    

    
}
