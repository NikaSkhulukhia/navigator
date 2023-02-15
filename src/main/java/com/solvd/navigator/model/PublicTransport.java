package com.solvd.navigator.model;

public class PublicTransport {
    private Long idPublicTransport;
    private int publicTransportNumber;
    private double averageSpeed;

    public PublicTransport(){}

    public PublicTransport(int publicTransportNumber, double averageSpeed){
        this.publicTransportNumber=publicTransportNumber;
        this.averageSpeed=averageSpeed;
    }

    public PublicTransport(Long idPublicTransport, int publicTransportNumber,double averageSpeed){
        this.idPublicTransport=idPublicTransport;
        this.publicTransportNumber=publicTransportNumber;
        this.averageSpeed=averageSpeed;
    }

    public Long getIdPublicTransport() {
        return idPublicTransport;
    }

    public void setIdPublicTransport(Long idPublicTransport) {
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
    public String toString() {
        return "PublicTransport{" +
                "idPublicTransport=" + idPublicTransport +
                ", publicTransportNumber='" + publicTransportNumber + '\'' +
                ", averageSpeed='" + averageSpeed + '\'' +
                '}';
    }

}
