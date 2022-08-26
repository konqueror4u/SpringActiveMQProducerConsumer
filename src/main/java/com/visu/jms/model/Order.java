package com.visu.jms.model;

import java.io.Serializable;

public class Order implements Serializable {
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    private String orderNumber;
}
