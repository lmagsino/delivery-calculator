package com.example.delivery.service;

import com.example.delivery.dto.DeliveryCostDto;

import java.util.Map;

public interface DeliveryService {
    DeliveryCostDto calculateCost(Map<String, String> params);
}
