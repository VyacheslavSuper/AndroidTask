package com.example.myapplication.services;

import com.example.myapplication.Properties;
import com.example.myapplication.controller.ControllerSite;
import com.example.myapplication.models.Currency;
import com.example.myapplication.models.Site;

import java.util.Map;
import java.util.Timer;

public class InfoService {

    public static Map<String, Currency> infoFromSite(){
        Site site = ControllerSite.getInfoFromSite(Properties.URL_SITE);
        return site.getCurrency();
    }
}
