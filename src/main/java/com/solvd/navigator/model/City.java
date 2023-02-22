package com.solvd.navigator.model;

import java.util.Objects;

public class City {
	private int idCity;
	private String name;

	public City() {
	}

	public City(int idCity, String name) {
		super();
		this.idCity = idCity;
		this.name = name;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public City(String name) {
		this.name = name;
	}

	public int getId() {
		return idCity;
	}

	public void setId(int id) {
		this.idCity = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		City city = (City) o;
		return idCity == city.idCity && Objects.equals(name, city.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCity, name);
	}

	public String toString() {
		return "City{" + "idCity=" + idCity + ", name='" + name + '\'' + '}';
	}
}
