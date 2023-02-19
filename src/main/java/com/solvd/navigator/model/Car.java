package com.solvd.navigator.model;

import java.util.Objects;

public class Car {
    private int idCar;
    private double averageSpeed;
    private String make;
    private String model;
    private int productionYear;
    private String bodyType;

    public Car(){}

    public Car(double averageSpeed, String make, String model,int productionYear, String bodyType ){
        this.averageSpeed=averageSpeed;
        this.make=make;
        this.model=model;
        this.productionYear=productionYear;
        this.bodyType=bodyType;
    }

    public Car(int idCar, double averageSpeed, String make, String model,int productionYear, String bodyType ){
        this.idCar=idCar;
        this.averageSpeed=averageSpeed;
        this.make=make;
        this.model=model;
        this.productionYear=productionYear;
        this.bodyType=bodyType;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return idCar == car.idCar && Double.compare(car.averageSpeed, averageSpeed) == 0 && productionYear == car.productionYear && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(bodyType, car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCar, averageSpeed, make, model, productionYear, bodyType);
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
