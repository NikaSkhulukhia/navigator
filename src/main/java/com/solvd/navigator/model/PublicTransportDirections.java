package com.solvd.navigator.model;

public class PublicTransportDirections {
    private Long idPublicTransportDirections;
    private Long idPublicTransport;
    private Long idStreetLocation;

    public PublicTransportDirections(){}


    public PublicTransportDirections(Long idPublicTransportDirections, Long idPublicTransport, Long idStreetLocation){
        this.idPublicTransportDirections=idPublicTransportDirections;
        this.idPublicTransport=idPublicTransport;
        this.idStreetLocation=idStreetLocation;
    }

    public PublicTransportDirections(Long idPublicTransport, Long idStreetLocation){
        this.idPublicTransport=idPublicTransport;
        this.idStreetLocation=idStreetLocation;
    }

    public Long getIdPublicTransportDirections() {
        return idPublicTransportDirections;
    }

    public void setIdPublicTransportDirections(Long idPublicTransportDirections) {
        this.idPublicTransportDirections = idPublicTransportDirections;
    }

    public Long getIdPublicTransport() {
        return idPublicTransport;
    }

    public void setIdPublicTransport(Long idPublicTransport) {
        this.idPublicTransport = idPublicTransport;
    }

    public Long getIdStreetLocation() {
        return idStreetLocation;
    }

    public void setIdStreetLocation(Long idStreetLocation) {
        this.idStreetLocation = idStreetLocation;
    }

    public String toString() {
        return "PublicTransportDirections{" +
                "id=" + idPublicTransportDirections +
                ", Name='" + idPublicTransport + '\'' +
                ", SurName='" + idStreetLocation + '\'' +
                '}';
    }
}

