package com.spring.jdbc.entities;

public class City {
    private String cityName;
    private String divisonName;
    private String longitude;
    private String latitude;

    public City(){
        super();
    }

    public City(String cityName, String divisonName, String longitude, String latitude) {
        super();
        this.cityName = cityName;
        this.divisonName = divisonName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDivisonName() {
        return divisonName;
    }

    public void setDivisonName(String divisonName) {
        this.divisonName = divisonName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return
                 cityName + "\t"
                + divisonName +"\t"
                + longitude + "\t"
                + latitude ;

    }
}
