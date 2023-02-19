package com.solvd.navigator.model;

import java.util.Objects;

public class PublicTransport {
    private int idPublicTransport;
    private int publicTransportNumber;
    private double averageSpeed;

    public PublicTransport(){}

    public PublicTransport(int publicTransportNumber, double averageSpeed){
        this.publicTransportNumber=publicTransportNumber;
        this.averageSpeed=averageSpeed;
    }

    public PublicTransport(int idPublicTransport, int publicTransportNumber,double averageSpeed){
        this.idPublicTransport=idPublicTransport;
        this.publicTransportNumber=publicTransportNumber;
        this.averageSpeed=averageSpeed;
    }

    public int getIdPublicTransport() {
        return idPublicTransport;
    }

    public void setIdPublicTransport(int idPublicTransport) {
        this.idPublicTransport = idPublicTransport;
    }

    public int getPublicTransportNumber() {
        return publicTransportNumber;
    }

    public void setPublicTransportNumber(int publicTransportNumber) {
        this.publicTransportNumber = publicTransportNumber;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicTransport that = (PublicTransport) o;
        return idPublicTransport == that.idPublicTransport && publicTransportNumber == that.publicTransportNumber && Double.compare(that.averageSpeed, averageSpeed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublicTransport, publicTransportNumber, averageSpeed);
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "idPublicTransport=" + idPublicTransport +
                ", publicTransportNumber='" + publicTransportNumber + '\'' +
                ", averageSpeed='" + averageSpeed + '\'' +
                '}';
    }

}
