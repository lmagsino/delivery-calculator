package com.example.delivery.service.impl;

import com.example.delivery.dto.DeliveryCostDto;
import com.example.delivery.enums.DeliveryRule;
import com.example.delivery.service.DeliveryCalculatorService;
import com.example.delivery.service.DeliveryRuleService;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Map;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final static String WEIGHT_FIELD = "weight";
    private final static String HEIGHT_FIELD = "height";
    private final static String WIDTH_FIELD = "width";
    private final static String LENGTH_FIELD = "length";
    private final static String VOUCHER_CODE = "voucherCode";

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private final DiscountService discountService;
    private final DeliveryRuleService deliveryRuleService;
    private final DeliveryCalculatorService deliveryCalculatorService;

    @Autowired
    public DeliveryServiceImpl(DiscountService discountService, DeliveryRuleService deliveryRuleService, DeliveryCalculatorService deliveryCalculatorService) {
        this.discountService = discountService;
        this.deliveryRuleService = deliveryRuleService;
        this.deliveryCalculatorService = deliveryCalculatorService;
    }

    @Override
    public DeliveryCostDto calculateCost(Map<String, String> params) {
        double weight = Double.parseDouble(params.get(WEIGHT_FIELD));
        double height = Double.parseDouble(params.get(HEIGHT_FIELD));
        double width = Double.parseDouble(params.get(WIDTH_FIELD));
        double length = Double.parseDouble(params.get(LENGTH_FIELD));

        double volume = getVolume(height, width, length);

        DeliveryRule rule = deliveryRuleService.getDeliveryRuleByWeightAndVolume(weight, volume);

        double cost = deliveryCalculatorService.getCost(rule, weight, volume);
        double totalCost = cost;

        if (cost > 0) {
            double discount = discountService.getDiscountPercentage(params.get(VOUCHER_CODE));
            totalCost = deliveryCalculatorService.getTotalCostWithDiscount(cost, discount);
        }

        DeliveryCostDto deliveryCostDto = new DeliveryCostDto();
        deliveryCostDto.setCost(Double.parseDouble(df.format(totalCost)));
        deliveryCostDto.setRuleName(rule);

        return deliveryCostDto;
    }

    private double getVolume(double height, double width, double length) {
        return (height * width * length);
    }

}
