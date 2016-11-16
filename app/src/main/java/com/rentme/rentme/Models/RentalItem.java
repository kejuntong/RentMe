package com.rentme.rentme.Models;

import java.util.ArrayList;

/**
 * Created by kejuntong on 16-11-13.
 */
public class RentalItem {

    String key;

    String av_time;
    String description;
    String location;
    String price;
    String region;

    Integer photo_number;

    // for testing
    public RentalItem(){

    }

    public RentalItem(String price, String region){
        this.price = price;
        this.region = region;
    }

    public String getPrice(){
        return this.price;
    }
    public String getRegion(){
        return this.region;
    }
    public String getAv_time(){
        return this.av_time;
    }
    public String getDescription(){
        return this.description;
    }
    public String getLocation(){
        return this.location;
    }
    public Integer getPhoto_number(){
        return this.photo_number;
    }


    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }

}
