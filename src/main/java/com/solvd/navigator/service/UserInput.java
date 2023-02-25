package com.solvd.navigator.service;

import com.solvd.navigator.dao.ICityDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.CityImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.model.City;
import com.solvd.navigator.model.Street;
import com.solvd.navigator.model.StreetLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static final Logger LOGGER = LogManager.getLogger(UserInput.class);
    private int startAddressId;
    private int endAddressId;

    ////////////////    Scanner     /////////
    static Scanner scanner = new Scanner(System.in);


    public void input() throws SQLException {
        ////////////////    User select a transport ///////////

        int vehicleNum;
        LOGGER.info("Do you want to travel by bus(1) or car(2)?");
        while (true) {
            while (!scanner.hasNextInt()) {
                LOGGER.info("Invalid input. Please enter a number between 1 and 2.");
                scanner.next();
            }
            vehicleNum = scanner.nextInt();

            if (vehicleNum == 1) {
                LOGGER.info("You have chosen to travel by bus.");
                break;
            } else if (vehicleNum == 2) {
                LOGGER.info("You have chosen to travel by car.");
                break;
            } else {
                LOGGER.info("Invalid input. Please enter a number between 1 and 2.");
            }
        }


        ////////////////////    City verified     //////////////

        ICityDao cityImpl = new CityImpl();
        IStreetDao streetImpl = new StreetImpl();

        ////////////////////    User select a start city   //////////////

        System.out.println("Select a city for the starting address:");
        LOGGER.info("1. Batumi");
        LOGGER.info("2. Tbilisi");
        LOGGER.info("3. Kutaisi");
        int startCityChoice = scanner.nextInt();
        City startCity = null;

        while (startCity == null) {
            switch (startCityChoice) {
                case 1:
                    startCity = cityImpl.selectEntityById(1);
                    break;
                case 2:
                    startCity = cityImpl.selectEntityById(2);
                    break;
                case 3:
                    startCity = cityImpl.selectEntityById(3);
                    break;
                default:
                    LOGGER.info("Invalid input. Please enter a number between 1 and 3.");
                    startCityChoice = scanner.nextInt();
                    break;
            }
        }


        ////////////////////    User select a start street   //////////////

        List<Street> startStreets = streetImpl.selectStreetsByCity(startCity.getId());
        LOGGER.info("Streets in " + startCity.getName() + ":");

        for (int i = 0; i < startStreets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, startStreets.get(i).getName());
        }

        LOGGER.info("Enter the number of the starting street: ");
        int startStreetNumber = scanner.nextInt();
        Street startStreet = startStreets.get(startStreetNumber - 1);

        int startStreetId = startStreet.getIdStreet();

        ////////////////////    User select a start street number  //////////////

        IStreetLocationDao streetLocationDao = new StreetLocationImpl();

        List<StreetLocation> streetNumbers = streetLocationDao.selectAllStreetNumbers(startStreetId);
        System.out.println("Select a street number:");
        for (int i = 0; i < streetNumbers.size(); i++) {
            StreetLocation streetLocation = streetNumbers.get(i);
            int selectedStreetNumber = streetLocation.getStreetNumber();
            System.out.println(i + 1 + ". " + selectedStreetNumber);
        }


        LOGGER.info("Enter the number of the starting street: ");
        int startAddressNumber = scanner.nextInt();
        StreetLocation startAddress = streetNumbers.get(startAddressNumber - 1);

        startAddressId = startAddress.getIdStreetLocation();

        ////////////////////    User select a end city   //////////////

        LOGGER.info("Select a city for the ending address:");
        LOGGER.info("1. Batumi");
        LOGGER.info("2. Tbilisi");
        LOGGER.info("3. Kutaisi");
        int endCityChoice = scanner.nextInt();
        City endCity = null;

        while (endCity == null) {
            switch (endCityChoice) {
                case 1:
                    endCity = cityImpl.selectEntityById(1);
                    break;
                case 2:
                    endCity = cityImpl.selectEntityById(2);
                    break;
                case 3:
                    endCity = cityImpl.selectEntityById(3);
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                    endCityChoice = scanner.nextInt();
                    break;
            }
        }


        ////////////////////    User select a end street   //////////////

        List<Street> endStreets = streetImpl.selectStreetsByCity(endCity.getId());
        LOGGER.info("Streets in " + endCity.getName() + ":");

        for (int i = 0; i < endStreets.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, endStreets.get(i).getName());
        }

        LOGGER.info("Enter the number of the ending street: ");
        int endStreetNumber = scanner.nextInt();
        Street endStreet = endStreets.get(endStreetNumber - 1);

        int endStreetId = endStreet.getIdStreet();

        ////////////////////    User select a end street number  //////////////

        List<StreetLocation> streetNumbersEnd = streetLocationDao.selectAllStreetNumbers(endStreetId);
        System.out.println("Select a street number:");

        for (int i = 0; i < streetNumbersEnd.size(); i++) {
            StreetLocation streetLocation = streetNumbersEnd.get(i);
            int selectedStreetNumber = streetLocation.getStreetNumber();
            System.out.println(i + 1 + ". " + selectedStreetNumber);
        }

        LOGGER.info("Enter the number of the ending street: ");
        int endAddressNumber = scanner.nextInt();
        StreetLocation endAddress = streetNumbers.get(endAddressNumber - 1);

        endAddressId = endAddress.getIdStreetLocation();

        ////////////////////    Final result   //////////////

        LOGGER.info("Starting address: " + startAddress.getStreetNumber() + ", " + startStreet.getName() + ", " + startCity.getName());
        LOGGER.info("Ending address: " + endAddress.getStreetNumber() + ", " + endStreet.getName() + ", " + endCity.getName());

    }

    public int getStartAddressId() {
        return startAddressId;
    }

    public int getEndAddressId() {
        return endAddressId;
    }
}

