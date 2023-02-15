package com.solvd.navigator.model;

public class Directions {
    private Long idDirections;
    private Long idStreetLocation1;
    private Long getIdStreetLocation2;
    private boolean trafficLight;

    public Directions(){}

    public Directions(Long idStreetLocation1, Long getIdStreetLocation2, boolean trafficLight) {
        this.idStreetLocation1 = idStreetLocation1;
        this.getIdStreetLocation2 = getIdStreetLocation2;
        this.trafficLight = trafficLight;
    }

    public Directions(Long idDirections, Long idStreetLocation1, Long getIdStreetLocation2, boolean trafficLight) {
        this.idDirections = idDirections;
        this.idStreetLocation1 = idStreetLocation1;
        this.getIdStreetLocation2 = getIdStreetLocation2;
        this.trafficLight = trafficLight;
    }

    public Long getIdDirections() {
        return idDirections;
    }

    public void setIdDirections(Long idDirections) {
        this.idDirections = idDirections;
    }

    public Long getIdStreetLocation1() {
        return idStreetLocation1;
    }

    public void setIdStreetLocation1(Long idStreetLocation1) {
        this.idStreetLocation1 = idStreetLocation1;
    }

    public Long getGetIdStreetLocation2() {
        return getIdStreetLocation2;
    }

    public void setGetIdStreetLocation2(Long getIdStreetLocation2) {
        this.getIdStreetLocation2 = getIdStreetLocation2;
    }

    public boolean isTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(boolean trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "idDirections=" + idDirections +
                ", idStreetLocation1='" + idStreetLocation1 + '\'' +
                ", getIdStreetLocation2='" + getIdStreetLocation2 + '\'' +
                ", trafficLight=" + trafficLight +
                '}';
    }
}
