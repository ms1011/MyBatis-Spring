package com.ohgiraffers.transactional.section01.annotation;

public class OrderMenuDTO {

    private int menuCode;       // 고른 메뉴 번호
    private int orderAmount;    // 고른 메뉴의 갯수

    public OrderMenuDTO() {
    }

    public OrderMenuDTO(int menuCode, int orderAmount) {
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenuDTO{" +
                "menuCode=" + menuCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
