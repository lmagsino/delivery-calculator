package com.example.delivery.dto;

import com.example.delivery.enums.DeliveryRule;

public class DeliveryCostDto {
    private DeliveryRule ruleName;
    private double cost;

    public DeliveryRule getRuleName() {
        return ruleName;
    }

    public void setRuleName(DeliveryRule ruleName) {
        this.ruleName = ruleName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
