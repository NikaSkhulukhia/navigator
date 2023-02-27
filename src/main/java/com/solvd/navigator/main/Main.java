package com.solvd.navigator.main;

import com.solvd.navigator.dao.ICarDao;
import com.solvd.navigator.dao.ICityDao;
import com.solvd.navigator.dao.IDirectionsDao;
import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.CarImpl;
import com.solvd.navigator.dao.mybatis.CityImpl;
import com.solvd.navigator.dao.mybatis.DirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportDirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.service.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

		int startIndex = 0;
		int endIndex = 0;
        double[][] timeMatrix = null;
        double[][] distMatrix = null;
        UserInput userInput = null;

        TimeGraphService tg = new TimeGraphService();
        DistanceGraphService dg = new DistanceGraphService();


        try {
            timeMatrix = tg.initializeTimeMatrix("car");
            distMatrix = dg.initializeDistanceMatrix();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            userInput = new UserInput();
            userInput.input();
			startIndex = userInput.getStartAddressId();
			endIndex = userInput.getEndAddressId();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }


        // //////////
        for(int i = 0; i < timeMatrix.length; i++) {
            String nextrow = "";
            for(int j = 0; j < timeMatrix.length; j++) {
                nextrow += timeMatrix[i][j] + "  ";
            }
//            LOGGER.error( "timeMatrix : " + nextrow);
        }
//        LOGGER.error( "");
        for(int i = 0; i < distMatrix.length; i++) {
            String nextrow = "";
            for(int j = 0; j < distMatrix.length; j++) {
                nextrow += distMatrix[i][j] + "  ";
            }
//            LOGGER.error( "timeMatrix : " + nextrow);
        }
//        LOGGER.error("");


        ICarDao carInst = new CarImpl();
        IStreetLocationDao streetLocation = new StreetLocationImpl();
        ICityDao city = new CityImpl();
        IDirectionsDao directions = new DirectionsImpl();
        IPublicTransportDao publicTransport = new PublicTransportImpl();
        IPublicTransportDirectionsDao publicTransportDirections = new PublicTransportDirectionsImpl();
        IStreetDao street = new StreetImpl();

        FloydTimeService fs = new FloydTimeService();
        PublicTransportService pServ = new PublicTransportService();
        fs.setGraph(distMatrix);
        fs.setStartIndex(startIndex);
        fs.setEndIndex(endIndex);
        fs.floydWarshall();
        try {
            System.out.println(fs.distRes());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        // public transport service
        if (userInput.getVehicleNum() == 1) {
            pServ.setPathIds(fs.getPathIds());
            try {
                String changePlan = pServ.getBusUsagePlan();
                System.out.println(changePlan);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }

        FloydTimeService fsTime1 = new FloydTimeService();
        PublicTransportService pServ1 = new PublicTransportService();
        fsTime1.setGraph(timeMatrix);
        fsTime1.setStartIndex(startIndex);
        fsTime1.setEndIndex(endIndex);
        fsTime1.floydWarshall();
        try {
            System.out.println(fsTime1.timeRes());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        // public transport service
        if (userInput.getVehicleNum() == 1) {
            pServ1.setPathIds(fsTime1.getPathIds());
            try {
                String changePlan = pServ1.getBusUsagePlan();
                System.out.println(changePlan);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }

    }
}