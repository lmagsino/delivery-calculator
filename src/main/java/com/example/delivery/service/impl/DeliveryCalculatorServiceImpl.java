package com.example.delivery.service.impl;

import com.example.delivery.enums.DeliveryRule;
import com.example.delivery.service.DeliveryCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryCalculatorServiceImpl implements DeliveryCalculatorService {

    private static final double DEFAULT_RATE = 0.0;
    private static final double HEAVY_RATE = 20;
    private static final double SMALL_RATE = 0.03;
    private static final double MEDIUM_RATE = 0.04;
    private static final double LARGE_RATE = 0.05;

    @Override
    public double getCost(DeliveryRule rule, double weight, double volume) {
        double cost;

        switch (rule) {
            case REJECT:
                cost = DEFAULT_RATE;
                break;
            case HEAVY:
                cost = HEAVY_RATE * weight;
                break;
            case SMALL:
                cost = SMALL_RATE * volume;
                break;
            case MEDIUM:
                cost = MEDIUM_RATE * volume;
                break;
            default:
                cost= LARGE_RATE * volume;
        }

        return cost;
    }

    @Override
    public double getTotalCostWithDiscount(double cost, double discount) {
        if (discount == 0) return cost;

        double discountAmount = cost * (discount/100);
        return cost - discountAmount;
    }
}
