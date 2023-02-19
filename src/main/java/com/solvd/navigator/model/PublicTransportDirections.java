package com.solvd.navigator.model;

import java.util.Objects;

public class PublicTransportDirections {
    private int idPublicTransportDirections;
    private int idPublicTransport;
    private int idStreetLocation;

    public PublicTransportDirections(){}


    public PublicTransportDirections(int idPublicTransportDirections, int idPublicTransport, int idStreetLocation){
        this.idPublicTransportDirections=idPublicTransportDirections;
        this.idPublicTransport=idPublicTransport;
        this.idStreetLocation=idStreetLocation;
    }

    public PublicTransportDirections(int idPublicTransport, int idStreetLocation){
        this.idPublicTransport=idPublicTransport;
        this.idStreetLocation=idStreetLocation;
    }

    public int getIdPublicTransportDirections() {
        return idPublicTransportDirections;
    }

    public void setIdPublicTransportDirections(int idPublicTransportDirections) {
        this.idPublicTransportDirections = idPublicTransportDirections;
    }

    public int getIdPublicTransport() {
        return idPublicTransport;
    }

    public void setIdPublicTransport(int idPublicTransport) {
        this.idPublicTransport = idPublicTransport;
    }

    public int getIdStreetLocation() {
        return idStreetLocation;
    }

    public void setIdStreetLocation(int idStreetLocation) {
        this.idStreetLocation = idStreetLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicTransportDirections that = (PublicTransportDirections) o;
        return idPublicTransportDirections == that.idPublicTransportDirections && idPublicTransport == that.idPublicTransport && idStreetLocation == that.idStreetLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublicTransportDirections, idPublicTransport, idStreetLocation);
    }

    public String toString() {
        return "PublicTransportDirections{" +
                "id=" + idPublicTransportDirections +
                ", Name='" + idPublicTransport + '\'' +
                ", SurName='" + idStreetLocation + '\'' +
                '}';
    }
}

