package com.solvd.navigator.model;

public class StreetLocation {
    private Long idStreetLocation;
    private int streetNumber;
    private double xCoordinate;
    private double yCoordinate;
    private Long idStreet;

    public StreetLocation(){}

    public StreetLocation(int streetNumber, double xCoordinate, double yCoordinate, Long idStreet){
        this.streetNumber=streetNumber;
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        this.idStreet=idStreet;
    }

    public StreetLocation(Long idStreetLocation, int streetNumber, double xCoordinate, double yCoordinate, Long idStreet){
        this.idStreetLocation=idStreetLocation;
        this.streetNumber=streetNumber;
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
        this.idStreet=idStreet;
    }

    public Long getIdStreetLocation() {
        return idStreetLocation;
    }

    public void setIdStreetLocation(Long idStreetLocation) {
        this.idStreetLocation = idStreetLocation;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Long getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(Long idStreet) {
        this.idStreet = idStreet;
    }

    @Override
    public String toString() {
        return "StreetLocation{" +
                "idStreetLocation=" + idStreetLocation +
                ", streetNumber='" + streetNumber + '\'' +
                ", xCoordinate='" + xCoordinate + '\'' +
                ", yCoordinate=" + yCoordinate +
                ", idStreet='" + idStreet + '\'' +
                '}';
    }
}
