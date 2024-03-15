package com.spring.jdbc.entities;

public class Province {
    private String provinceName;
    private String countryName;

    public Province(){
        super();
    }

    public Province(String provinceName, String countryName) {
        super();
        this.provinceName = provinceName;
        this.countryName = countryName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return provinceName + "\t\t\t" + countryName ;
    }
}
