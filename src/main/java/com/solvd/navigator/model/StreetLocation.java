package com.solvd.navigator.model;

import java.util.Objects;

public class StreetLocation {
	private int idStreetLocation;
	private int streetNumber;
	private double xCoordinate;
	private double yCoordinate;
	private int idStreet;

	public StreetLocation() {
	}

	public StreetLocation(int streetNumber, double xCoordinate, double yCoordinate, int idStreet) {
		this.streetNumber = streetNumber;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.idStreet = idStreet;
	}

	public StreetLocation(int idStreetLocation, int streetNumber, double xCoordinate, double yCoordinate,
			int idStreet) {
		this.idStreetLocation = idStreetLocation;
		this.streetNumber = streetNumber;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.idStreet = idStreet;
	}

	public int getIdStreetLocation() {
		return idStreetLocation;
	}

	public void setIdStreetLocation(int idStreetLocation) {
		this.idStreetLocation = idStreetLocation;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getIdStreet() {
		return idStreet;
	}

	public void setIdStreet(int idStreet) {
		this.idStreet = idStreet;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StreetLocation that = (StreetLocation) o;
		return idStreetLocation == that.idStreetLocation && streetNumber == that.streetNumber
				&& Double.compare(that.xCoordinate, xCoordinate) == 0
				&& Double.compare(that.yCoordinate, yCoordinate) == 0 && idStreet == that.idStreet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStreetLocation, streetNumber, xCoordinate, yCoordinate, idStreet);
	}

	@Override
	public String toString() {
		return "StreetLocation{" + "idStreetLocation=" + idStreetLocation + ", streetNumber='" + streetNumber + '\''
				+ ", xCoordinate='" + xCoordinate + '\'' + ", yCoordinate=" + yCoordinate + ", idStreet='" + idStreet
				+ '\'' + '}';
	}
}
