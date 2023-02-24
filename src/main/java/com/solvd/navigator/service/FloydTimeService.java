package com.solvd.navigator.service;

public class FloydTimeService {
	 // graph - initial distances graph
    private double[][] graph;
    private double[][] dist;
    private int[][] next;
    private int startIndex;
    private int endIndex;

    public FloydTimeService() {
    }

    public void floydWarshall() {
        int n = graph.length;
        dist = new double[n][n];
        next = new int[n][n];

        // Initialize dist and next matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != 0) {
                    next[i][j] = j;
                }
            }
        }

        // Compute the shortest paths and update next matrix
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != 0 && dist[k][j] != 0
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

    public String resultDistAndPath (String res, boolean fromTime, boolean fromDist){
        res += "from address " + startIndex + " to address " + endIndex + " is " + dist[startIndex][endIndex];
        if (fromTime) res += " minutes";
        if (fromDist) res += " KM";
        if (dist[startIndex][endIndex] != Double.POSITIVE_INFINITY) {
            res += ", and the path is [" + startIndex;
            int current = startIndex;
            while (current != endIndex) {
                current = next[current][endIndex];
                res += " -> " + current;
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
}
