package com.example.myapplication.controller;

import com.example.myapplication.models.Currency;
import com.example.myapplication.models.Site;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static com.example.myapplication.controller.ControllerSite.getInfoFromSite;

public class ControllerSiteTest extends TestCase {
    @Test
    public void testGetInfoFromSite() {
        Site site = getInfoFromSite("https://www.cbr-xml-daily.ru/daily_json.js");
        assertNotNull(site);
        assertNotNull(site.getCurrency());
        assertFalse(site.getCurrency().isEmpty());
        for (Currency cur : site.getCurrency().values()) {
            assertNotNull(cur.getId());
            assertNotNull(cur.getCharCode());
            assertNotNull(cur.getNominal());
            assertNotNull(cur.getNumCode());
            assertNotNull(cur.getValue());
            assertNotNull(cur.getPrevious());
            assertNotNull(cur.getName());
        }
    }
}