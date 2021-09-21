package com.example.myapplication.controller;

import com.example.myapplication.models.Site;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ControllerSite {
    private static final Gson gson = new Gson();

    public static Site getInfoFromSite(String site) {
        try {
            URL url = new URL(site);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current = "";

            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            in.close();
            Site result = gson.fromJson(urlString, Site.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
