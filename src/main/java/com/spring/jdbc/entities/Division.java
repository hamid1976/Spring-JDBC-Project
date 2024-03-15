package com.spring.jdbc.entities;

public class Division {
    private String divisionName;
    private String provincName;

    public Division(){
        super();
    }

    public Division(String divisionName, String provincName) {
        super();
        this.divisionName = divisionName;
        this.provincName = provincName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getProvincName() {
        return provincName;
    }

    public void setProvincName(String provincName) {
        this.provincName = provincName;
    }

    @Override
    public String toString() {
        return  divisionName + "\t\t"+provincName ;
    }
}
