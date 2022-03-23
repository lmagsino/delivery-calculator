package com.example.delivery.service.impl;

import com.example.delivery.enums.DeliveryRule;
import com.example.delivery.service.DeliveryRuleService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryRuleServiceImpl implements DeliveryRuleService {

    private static final int REJECTED_WEIGHT = 50;
    private static final int HEAVY_WEIGHT = 10;
    private static final int SMALL_WEIGHT = 1500;
    private static final int MEDIUM_WEIGHT = 2500;

    @Override
    public DeliveryRule getDeliveryRuleByWeightAndVolume(double weight, double volume) {
        if (weight > REJECTED_WEIGHT) {
            return DeliveryRule.REJECT;
        } else if (weight > HEAVY_WEIGHT) {
            return DeliveryRule.HEAVY;
        }

        return getDeliveryRuleByVolume(volume);
    }

    private DeliveryRule getDeliveryRuleByVolume(double volume) {
        DeliveryRule rule;

        if (volume < SMALL_WEIGHT) {
            rule = DeliveryRule.SMALL;
        } else if (volume < MEDIUM_WEIGHT) {
            rule = DeliveryRule.MEDIUM;
        } else {
            rule = DeliveryRule.LARGE;
        }

        return rule;
    }
}
