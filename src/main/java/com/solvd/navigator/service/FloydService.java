package com.solvd.navigator.service;

import java.util.ArrayList;
import java.util.List;

public class FloydService {

	// graph - initial distances graph
	private int[][] graph;
	private int[][] dist;
	private int[][] next;
	private int startIndex;
	private int endIndex;
	List<Integer> pathIds;

	public FloydService() {
	}

	public void floydWarshall() {
		int n = graph.length;
		dist = new int[n][n];
		next = new int[n][n];
		pathIds = new ArrayList<>();

		// Initialize dist and next matrices
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = graph[i][j];
				if (graph[i][j] != Integer.MAX_VALUE) {
					next[i][j] = j;
				}
			}
		}

		// Compute the shortest paths and update next matrix
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
							&& dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
	}

	public String timeRes() {
		String res = "";
		res += "best path by time ";
		res = resultDistAndPath(res, true, false);
		return res;
	}

	public String distRes() {
		String res = "";
		res += "best path by distance ";
		res = resultDistAndPath(res, false, true);
		return res;
	}

	public String resultDistAndPath(String res, boolean fromTime, boolean fromDist) {
		res += "from address " + startIndex + " to address " + endIndex + " is " + dist[startIndex][endIndex];
		if (fromTime)
			res += " minutes";
		if (fromDist)
			res += " KM";
		if (dist[startIndex][endIndex] != Integer.MAX_VALUE) {
			res += ", and the path is [" + startIndex;
			pathIds.add(startIndex);
			int current = startIndex;
			while (current != endIndex) {
				current = next[current][endIndex];
				res += " -> " + current;
				pathIds.add(current);
			}
			res += "]";
		}
		return res;
	}

	public int[][] getGraph() {
		return graph;
	}

	public void setGraph(int[][] graph) {
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

	public int[][] getDist() {
		return dist;
	}

	public int[][] getNext() {
		return next;
	}

	public List<Integer> getPathIds() {
		return pathIds;
	}
}
