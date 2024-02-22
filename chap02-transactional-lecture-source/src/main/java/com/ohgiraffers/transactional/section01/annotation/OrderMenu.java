package com.ohgiraffers.transactional.section01.annotation;

public class OrderMenu {
    private int menuCode;
    private int orderCode;
    private int orderAmount;

    public OrderMenu() {
    }

    public OrderMenu(int menuCode, int orderCode, int orderAmount) {
        this.menuCode = menuCode;
        this.orderCode = orderCode;
        this.orderAmount = orderAmount;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "menuCode=" + menuCode +
                ", orderCode=" + orderCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
