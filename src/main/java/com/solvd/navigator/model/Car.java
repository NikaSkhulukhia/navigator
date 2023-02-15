package com.solvd.navigator.model;

public class Car {
    private Long idCar;
    private double averageSpeed;
    private String make;
    private String model;
    private Long productionYear;
    private String bodyType;

    public Car(){}

    public Car(double averageSpeed, String make, String model,Long productionYear, String bodyType ){
        this.averageSpeed=averageSpeed;
        this.make=make;
        this.model=model;
        this.productionYear=productionYear;
        this.bodyType=bodyType;
    }

    public Car(Long idCar, double averageSpeed, String make, String model,Long productionYear, String bodyType ){
        this.idCar=idCar;
        this.averageSpeed=averageSpeed;
        this.make=make;
        this.model=model;
        this.productionYear=productionYear;
        this.bodyType=bodyType;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Long productionYear) {
        this.productionYear = productionYear;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", averageSpeed='" + averageSpeed + '\'' +
                ", make='" + make + '\'' +
                ", model=" + model +
                ", productionYear='" + productionYear + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }

}
