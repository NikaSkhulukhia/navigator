package com.solvd.navigator.model;

public class City {
    private Long idCity;
    private String name;

    public City(){}

    public City(String name){
        this.name=name;
    }

    public Long getId() {
        return idCity;
    }

    public void setId(Long id) {
        this.idCity = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "City{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                '}';
    }
}
