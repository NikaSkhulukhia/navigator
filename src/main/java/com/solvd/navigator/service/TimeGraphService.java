package com.solvd.navigator.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.navigator.dao.ICarDao;
import com.solvd.navigator.dao.IDirectionsDao;
import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.CarImpl;
import com.solvd.navigator.dao.mybatis.DirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.model.Car;
import com.solvd.navigator.model.Directions;
import com.solvd.navigator.model.PublicTransport;
import com.solvd.navigator.model.StreetLocation;
import com.solvd.navigator.util.Planets;

public class TimeGraphService {
	private static final Logger LOGGER = LogManager.getLogger(TimeGraphService.class);

	IDirectionsDao directionsInstance = new DirectionsImpl();
	IStreetLocationDao streetLocation = new StreetLocationImpl();
	ICarDao carInstance = new CarImpl();
	IPublicTransportDao busInstance = new PublicTransportImpl();

	HashMap<StreetLocation, Integer> streetIndexMap = new HashMap<>();
	double distance;

	public HashMap<StreetLocation, Integer> getDirections() throws SQLException {
		List<Directions> directionsTable = directionsInstance.selectAllEntity();
		List<StreetLocation> streetLocations = streetLocation.selectAllEntity();

		for (int i = 0; i < streetLocations.size(); i++) {
			streetIndexMap.put(streetLocations.get(i), i);
		}

		HashMap<Integer, List<Integer>> neighbours = new HashMap<>();
		for (Directions directions : directionsTable) {
			int idStreetLocation1 = directions.getIdStreetLocation1();
			int idStreetLocation2 = directions.getIdStreetLocation2();
			int index1 = streetIndexMap.get(streetLocation.getStreetLocationByID(idStreetLocation1));
			int index2 = streetIndexMap.get(streetLocation.getStreetLocationByID(idStreetLocation2));

			List<Integer> neighbours1 = neighbours.getOrDefault(index1, new ArrayList<>());
			List<Integer> neighbours2 = neighbours.getOrDefault(index2, new ArrayList<>());

			neighbours1.add(index2);
			neighbours2.add(index1);

			neighbours.put(index1, neighbours1);
			neighbours.put(index2, neighbours2);
		}

		return streetIndexMap;
	}

	public double getDistanceByCoordinates(int startStreetID, int endStreetID) {
		
		try {
			// Get street locations from database by ID
			StreetLocation startLocation = streetLocation.getStreetLocationByID(startStreetID);
			StreetLocation endLocation = streetLocation.getStreetLocationByID(endStreetID);

			// List<StreetLocation> streetLocationTable = streetLocation.selectAllEntity();

			double latitude1 = Math.toRadians(startLocation.getxCoordinate());
			double longitude1 = Math.toRadians(startLocation.getyCoordinate());
			double latitude2 = Math.toRadians(endLocation.getxCoordinate());
			double longitude2 = Math.toRadians(endLocation.getyCoordinate());

			double dlon = longitude2 - longitude1;
			double dlat = latitude2 - latitude1;
			double a = Math.pow(Math.sin(dlat / 2), 2)
					+ Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(dlon / 2), 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			distance = Planets.EARTH.getRadius() * c;

		} catch (SQLException e) {
			LOGGER.error("SQL exception occured");
		}
		return distance;
	}

	public double calculateTimeByCar(int startStreetID, int endStreetID, int idCar) throws SQLException {
		// choose car from database
		Car car = carInstance.selectEntityById(idCar);
		// get average speed of chosen car
		double carSpeed = car.getAverageSpeed();

		// get distance
		double distance = getDistanceByCoordinates(startStreetID, endStreetID);

		// calculate time
		double time = distance / carSpeed;

		// result
		return time;
	}

	public double calculateTimeByBus(int startStreetID, int endStreetID, int idPublicTransport) throws SQLException {
		// choose bus from database
		PublicTransport bus = busInstance.selectEntityById(idPublicTransport);
		// get average speed of chosen bus
		double busSpeed = bus.getAverageSpeed();

		// get distance
		double distance = getDistanceByCoordinates(startStreetID, endStreetID);

		// calculate time
		double time = distance / busSpeed;

		return time;
	}
	
	// Davamrgvalot shedegi. Usasruloba davamatot
	public double[][] initializeTimeMatrix(String transportType) throws SQLException {
	    List<StreetLocation> streetLocations = streetLocation.selectAllEntity();

	    // Create a map to store the index of each street location in the time matrix
	    Map<Integer, Integer> streetIndexMap1 = new HashMap<>();
	    for (int i = 0; i < streetLocations.size(); i++) {
	        streetIndexMap1.put(streetLocations.get(i).getIdStreetLocation(), i);
	    }

	    // Create a 2D array to store the time matrix
	    double[][] timeMatrix = new double[6][6];

	    // Initialize all elements of the time matrix to infinity
	    for (int i = 0; i < timeMatrix.length; i++) {
	        Arrays.fill(timeMatrix[i], Double.POSITIVE_INFINITY);
	    }

	    // Iterate through the directions and calculate the time between each pair of connected streets
	    List<Directions> directionsTable = directionsInstance.selectAllEntity();
	    for (Directions directions : directionsTable) {
	        int idStreetLocation1 = directions.getIdStreetLocation1();
	        int idStreetLocation2 = directions.getIdStreetLocation2();
	        int index1 = streetIndexMap1.get(idStreetLocation1);
	        int index2 = streetIndexMap1.get(idStreetLocation2);

	        StreetLocation streetLocation1 = streetLocation.getStreetLocationByID(idStreetLocation1);
	        StreetLocation streetLocation2 = streetLocation.getStreetLocationByID(idStreetLocation2);

	        double distance = calculateDistance(streetLocation1.getxCoordinate(), streetLocation1.getyCoordinate(),
	                streetLocation2.getxCoordinate(), streetLocation2.getyCoordinate());

	        double speed = 0;
	        if (transportType.equals("car")) {
	            Car car = carInstance.selectEntityById(1); // select a default car
	            speed = car.getAverageSpeed();
	        } else if (transportType.equals("bus")) {
	            PublicTransport bus = busInstance.selectEntityById(1); // select a default bus
	            speed = bus.getAverageSpeed();
	        }

	        double time = (distance /(speed/60));

	        if (index1 < 6 && index2 < 6) { // only populate cells within the 6x6 matrix
	            if(directions.isTrafficLight() == false) { //traffic light logic
	                time += 2;
	            } else {
	                time = Double.POSITIVE_INFINITY;
	            }
	            // Set time for indexes and round them to  0.00 format 
	            timeMatrix[index1][index2] = Math.round(time * 100.0) / 100.0;
	            timeMatrix[index2][index1] = Math.round(time * 100.0) / 100.0;
	        }
	    }

	    // Set the diagonal elements of the time matrix to 0
	    for (int i = 0; i < 6; i++) {
	        timeMatrix[i][i] = 0;
	    }

	    return timeMatrix;
	}
	
	
	
	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    return Planets.EARTH.getRadius() * c;
	}
}
