package com.example.myapplication.services;

import com.example.myapplication.Database;
import com.example.myapplication.models.Currency;

public class ExchangeServices {

    public static double exchangeRubToCurrency(Currency currency, double rub) {
        if (currency == null) {
            throw new RuntimeException();
        }
        return rub / currency.getValue() * currency.getNominal();
    }
}
