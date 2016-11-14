package com.rentme.rentme.Models;

/**
 * Created by kejuntong on 16-11-13.
 */
public class RentalItem {

    String price;
    String region;

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

    public void setPrice(String price){
        this.price = price;
    }
    public void setRegion(String region){
        this.region = region;
    }

}
