package com.solvd.navigator.model;

import java.util.Objects;

public class Directions {
	private int idDirections;
	private int idStreetLocation1;
	private int idStreetLocation2;
	private boolean trafficLight;

	public Directions() {
	}

	public Directions(int idStreetLocation1, int idStreetLocation2, boolean trafficLight) {
		this.idStreetLocation1 = idStreetLocation1;
		this.idStreetLocation2 = idStreetLocation2;
		this.trafficLight = trafficLight;
	}

	public Directions(int idDirections, int idStreetLocation1, int idStreetLocation2, boolean trafficLight) {
		this.idDirections = idDirections;
		this.idStreetLocation1 = idStreetLocation1;
		this.idStreetLocation2 = idStreetLocation2;
		this.trafficLight = trafficLight;
	}

	public int getIdDirections() {
		return idDirections;
	}

	public void setIdDirections(int idDirections) {
		this.idDirections = idDirections;
	}

	public int getIdStreetLocation1() {
		return idStreetLocation1;
	}

	public void setIdStreetLocation1(int idStreetLocation1) {
		this.idStreetLocation1 = idStreetLocation1;
	}

	public int getIdStreetLocation2() {
		return idStreetLocation2;
	}

	public void setIdStreetLocation2(int idStreetLocation2) {
		this.idStreetLocation2 = idStreetLocation2;
	}

	public boolean isTrafficLight() {
		return trafficLight;
	}

	public void setTrafficLight(boolean trafficLight) {
		this.trafficLight = trafficLight;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Directions that = (Directions) o;
		return idDirections == that.idDirections && idStreetLocation1 == that.idStreetLocation1
				&& idStreetLocation2 == that.idStreetLocation2 && trafficLight == that.trafficLight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDirections, idStreetLocation1, idStreetLocation2, trafficLight);
	}

	@Override
	public String toString() {
		return "Directions{" + "idDirections=" + idDirections + ", idStreetLocation1='" + idStreetLocation1 + '\''
				+ ", idStreetLocation2='" + idStreetLocation2 + '\'' + ", trafficLight=" + trafficLight + '}';
	}
}
