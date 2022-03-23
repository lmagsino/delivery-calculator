package com.example.delivery.service.impl;

import com.example.delivery.dto.VoucherDto;
import com.example.delivery.service.DiscountService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscountServiceImpl implements DiscountService {

    private static final double DEFAULT_DISCOUNT = 0;
    private static final String VOUCHER_URL = "https://mynt-exam.mocklab.io/voucher/";

    @Override
    public double getDiscountPercentage(String voucherCode) {
        if (voucherCode == null) return DEFAULT_DISCOUNT;

        String url = VOUCHER_URL + voucherCode + "?key=apikey";
        RestTemplate restTemplate = new RestTemplate();

        VoucherDto voucher = null;
        double discount = 0;

        try {
            voucher = restTemplate.getForObject(url, VoucherDto.class);
            discount = voucher.getDiscount();
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), "Invalid code");
        }

        return discount;
    }
}
