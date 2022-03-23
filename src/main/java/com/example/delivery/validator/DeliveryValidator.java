package com.example.delivery.validator;

import com.example.delivery.util.NumberUtil;

import java.util.Map;

public class DeliveryValidator {

    static String[] FIELDS = {"weight", "height", "length", "width"};

    public static boolean isValid(Map<String, String> params) {
        if (params == null) return false;

        for (String param : FIELDS) {
            String value = params.get(param);
            if (!NumberUtil.isNumeric(value)) return false;
        }

        return true;
    }






}
