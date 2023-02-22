package com.solvd.navigator.model;

import java.util.Objects;

public class Street {
	private int idStreet;
	private String name;
	private int idCity;

	public Street() {
		super();
	}

	public Street(String name, int idCity) {
		this.name = name;
		this.idCity = idCity;
	}

	public Street(int idStreet, String name, int idCity) {
		this.idStreet = idStreet;
		this.name = name;
		this.idCity = idCity;
	}

	public int getIdStreet() {
		return idStreet;
	}

	public void setIdStreet(int idStreet) {
		this.idStreet = idStreet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Street street = (Street) o;
		return idStreet == street.idStreet && idCity == street.idCity && Objects.equals(name, street.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStreet, name, idCity);
	}

	@Override
	public String toString() {
		return "Street{" + "idStreet=" + idStreet + ", name='" + name + '\'' + ", idCity='" + idCity + '\'' + '}';
	}
}
