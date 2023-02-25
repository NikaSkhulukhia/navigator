package com.solvd.navigator.util;

public enum Planets {
	EARTH(6371);
	
	final int radius;

	private Planets(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
	
	
	
}
