package com.pagamentos.utils;

import java.util.Currency;

public class Utils {

    boolean isValueValid() {
        try {
            Currency.getInstance(this.toString());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
