package com.example.delivery.service;

import com.example.delivery.enums.DeliveryRule;

public interface DeliveryRuleService {
    DeliveryRule getDeliveryRuleByWeightAndVolume(double weight, double volume);
}
