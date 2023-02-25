package com.solvd.navigator.service;

import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.dao.mybatis.PublicTransportDirectionsImpl;
import com.solvd.navigator.dao.mybatis.PublicTransportImpl;
import com.solvd.navigator.dao.mybatis.StreetImpl;
import com.solvd.navigator.dao.mybatis.StreetLocationImpl;
import com.solvd.navigator.model.PublicTransport;
import com.solvd.navigator.model.Street;
import com.solvd.navigator.model.StreetLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicTransportService {
    private static final Logger LOGGER = LogManager.getLogger(PublicTransportService.class);
    private List<Integer> pathIds; // best path stations ids, needs to be set from floyd service class

    public PublicTransportService() {
        pathIds = new ArrayList<>();
    }

    public String getBusUsagePlan() throws SQLException {
        IPublicTransportDirectionsDao publicTransportDirections = new PublicTransportDirectionsImpl();
        IPublicTransportDao publicTransport = new PublicTransportImpl();
        IStreetLocationDao streetLocation = new StreetLocationImpl();
        IStreetDao street = new StreetImpl();
        String result = "";
        int currentBusId = 0;
        for(int i = 0; i < pathIds.size() - 1; i++) {
            int currentStationId = pathIds.get(i);
            int nextStationId = pathIds.get(i+1);
            List<Integer> currentStationBusIds = publicTransportDirections.selectAllBusIdsByLocationId(currentStationId);
            List<Integer> nextStationBusIds = publicTransportDirections.selectAllBusIdsByLocationId(nextStationId);
            if (currentBusId != 0 && currentStationBusIds.contains(currentBusId) && nextStationBusIds.contains(currentBusId)) {
                continue;
            }

            for (int currentStationBusId : currentStationBusIds) {
                if (nextStationBusIds.contains(currentStationBusId)) {
                    currentBusId = currentStationBusId;
                    StreetLocation addressObj = streetLocation.selectEntityById(currentStationId);
                    Street addressStreetObj = street.selectEntityById(addressObj.getIdStreet());
                    PublicTransport busObj = publicTransport.selectEntityById(currentBusId);
                    String addressStr = addressObj.getStreetNumber() + ", " + addressStreetObj.getName();
                    int busNumber = busObj.getPublicTransportNumber();
                    result += "At the station: " + addressStr + " take the bus #: " + busNumber + " ---> ";
                    break;
                }
            }
        }
        return result;
    }

    public List<Integer> getPathIds() {
        return pathIds;
    }

    public void setPathIds(List<Integer> pathIds) {
        this.pathIds = pathIds;
    }
}
