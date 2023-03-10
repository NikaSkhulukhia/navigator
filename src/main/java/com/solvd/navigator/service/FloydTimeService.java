package com.solvd.navigator.service;

import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.PublicTransportDirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.main.Main;
import com.solvd.navigator.model.Street;
import com.solvd.navigator.model.StreetLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FloydTimeService {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	// graph - initial distances graph
	private double[][] graph;
	private double[][] dist;
	private int[][] next;
	private int startIndex;
	private int endIndex;
	List<Integer> pathIds;


	public FloydTimeService() {
	}

	public void floydWarshall() {
		int n = graph.length;
		dist = new double[n][n];
		next = new int[n][n];
		pathIds = new ArrayList<>();


		// Initialize dist and next matrices
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = graph[i][j];
				if (graph[i][j] != Double.POSITIVE_INFINITY) {
					next[i][j] = j+1;
				}
				else next[i][j] = -1;

			}
		}

		for(int i = 0; i < n; i++) {
			String nextrow = "";
		  for(int j = 0; j < n; j++) {
			  nextrow += next[i][j] + "  ";
		  }
//			LOGGER.error( "next : " + nextrow);
		}
//		LOGGER.error( "");
//		LOGGER.error( "");


		for(int i = 0; i < n; i++) {
			String nextrow = "";
			for(int j = 0; j < n; j++) {
				nextrow += dist[i][j] + "  ";
			}
//			LOGGER.error( "dist : " + nextrow);
		}


		// Compute the shortest paths and update next matrix
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] != Double.POSITIVE_INFINITY && dist[k][j] != Double.POSITIVE_INFINITY
							&& dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}

		for(int i = 0; i < n; i++) {
			String nextrow = "";
			for(int j = 0; j < n; j++) {
				nextrow += next[i][j] + "  ";
			}
//			LOGGER.error( " final next : " + nextrow);
		}
//		LOGGER.error( "");
//		LOGGER.error( "");
	}

	public String timeRes() throws SQLException {
		String res = "";
		res += "best path by time ";
		res = resultDistAndPath(res, true, false);
		return res;
	}

	public String distRes() throws SQLException {
		String res = "";
		res += "best path by distance ";
		res = resultDistAndPath(res, false, true);
		return res;
	}

	public String resultDistAndPath(String res, boolean fromTime, boolean fromDist) throws SQLException {
		IStreetLocationDao streetLocation = new StreetLocationImpl();
		IStreetDao street = new StreetImpl();

		StreetLocation addressObjStart = streetLocation.selectEntityById(startIndex);
		Street addressStreetObjStart = street.selectEntityById(addressObjStart.getIdStreet());
		String addressStrStart = addressObjStart.getStreetNumber() + ", " + addressStreetObjStart.getName();

		StreetLocation addressObjEnd = streetLocation.selectEntityById(endIndex);
		Street addressStreetObjEnd = street.selectEntityById(addressObjEnd.getIdStreet());
		String addressStrEnd = addressObjEnd.getStreetNumber() + ", " + addressStreetObjEnd.getName();

		res += "from address " + addressStrStart + " to address " + addressStrEnd + " is " + dist[startIndex][endIndex];
		if (fromTime)
			res += " minutes";
		if (fromDist)
			res += " KM";
		if (dist[startIndex][endIndex] != Double.POSITIVE_INFINITY) {
			res += ", and the path is [" + addressStrStart;
			pathIds.add(startIndex);
			int current = startIndex;
			while (current != endIndex) {
				current = next[current][endIndex];
				StreetLocation addressObjCurrent = streetLocation.selectEntityById(current);
				Street addressStreetObjCurrent = street.selectEntityById(addressObjCurrent.getIdStreet());
				String addressStrCurrent = addressObjCurrent.getStreetNumber() + ", " + addressStreetObjCurrent.getName();
				res += " -> " + addressStrCurrent;
				pathIds.add(current);
			}
			res += "]";
		}
		return res;
	}

	public double[][] getGraph() {
		return graph;
	}

	public void setGraph(double[][] graph) {
		this.graph = graph;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public double[][] getDist() {
		return dist;
	}

	public int[][] getNext() {
		return next;
	}

	public List<Integer> getPathIds() {
		return pathIds;
	}
}
