package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @SerializedName("ID")
    private String id;
    @SerializedName("NumCode")
    private String numCode;
    @SerializedName("CharCode")
    private String charCode;
    @SerializedName("Nominal")
    private Integer nominal;
    @SerializedName("Name")
    private String name;
    @SerializedName("Value")
    private Float value;
    @SerializedName("Previous")
    private Float previous;
}
