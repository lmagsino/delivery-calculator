package com.example.delivery.service;

import com.example.delivery.enums.DeliveryRule;

public interface DeliveryCalculatorService {
    double getCost(DeliveryRule rule, double weight, double volume);
    double getTotalCostWithDiscount(double cost, double discount);
}
