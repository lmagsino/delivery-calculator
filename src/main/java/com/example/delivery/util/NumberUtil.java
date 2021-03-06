package com.example.delivery.util;

public class NumberUtil {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;

        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
