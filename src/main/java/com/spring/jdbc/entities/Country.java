package com.spring.jdbc.entities;

public class Country {
    private String countryName;

    public Country(){
        super();
    }

    public Country(String countryName) {
        super();
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return  countryName;
    }
}
