package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Site {

    @SerializedName("Date")
    public Date date;
    @SerializedName("PreviousDate")
    public Date previousDate;
    @SerializedName("PreviousURL")
    public String previousURL;
    @SerializedName("Timestamp")
    public Date timestamp;
    @SerializedName("Valute")
    private Map<String, Currency> currency;
}
