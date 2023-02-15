package com.solvd.navigator.model;

public class Street {
    private Long idStreet;
    private String name;
    private Long idCity;

    public Street (String name, Long idCity){
        this.name=name;
        this.idCity=idCity;
    }

    public Street(Long idStreet, String name, Long idCity){
        this.idStreet=idStreet;
        this.name=name;
        this.idCity=idCity;
    }

    public Long getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(Long idStreet) {
        this.idStreet = idStreet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    @Override
    public String toString() {
        return "Street{" +
                "idStreet=" + idStreet +
                ", name='" + name + '\'' +
                ", idCity='" + idCity + '\'' +
                '}';
    }
}
