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
import com.solvd.navigator.model.PublicTransport;
import com.solvd.navigator.model.Street;
import com.solvd.navigator.model.StreetLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicTransportService {
    private static final Logger LOGGER = LogManager.getLogger(PublicTransportService.class);
    private List<Integer> pathIds;
    private Map<Integer, Integer> addressForBusChange;

    public PublicTransportService() {
    }

    private  String addressForBusChangeToString() throws SQLException {
        String result = "";
        IPublicTransportDao publicTransport = new PublicTransportImpl();
        IStreetLocationDao streetLocation = new StreetLocationImpl();
        IStreetDao street = new StreetImpl();

        for (Map.Entry<Integer,Integer> entry : addressForBusChange.entrySet()) {
            StreetLocation addressObj = streetLocation.selectEntityById(entry.getKey());
            Street addressStreetObj = street.selectEntityById(addressObj.getIdStreet());
            PublicTransport busObj = publicTransport.selectEntityById(entry.getValue());
            String addressStr = addressObj.getStreetNumber() + ", " + addressStreetObj.getName();
            int busNumber = busObj.getPublicTransportNumber();
            result += "At the station: " + addressStr + " take the bus #: " + busNumber + " ---> ";
        }
        return result;
    }

    public String getBusUsagePlan() throws SQLException {
        // TODO pathIds must be set to this class object from another class or method.
        pathIds = new ArrayList<>();
        pathIds.add(3);
        pathIds.add(2);
        pathIds.add(4);
        pathIds.add(1);

        IPublicTransportDirectionsDao publicTransportDirections = new PublicTransportDirectionsImpl();
        addressForBusChange = new HashMap<>();
        String result = "";
        String res2 = "";
        int currentBusId = 0;
        for(int i = 0; i < pathIds.size() - 1; i++) {
            int currentStationId = pathIds.get(i);
            res2 += "    ----   " + currentStationId + "    ----    ";
            int nextStationId = pathIds.get(i+1);
            List<Integer> currentStationBusIds = publicTransportDirections.selectAllBusIdsByLocationId(currentStationId);
            List<Integer> nextStationBusIds = publicTransportDirections.selectAllBusIdsByLocationId(nextStationId);
            if (currentBusId != 0 && currentStationBusIds.contains(currentBusId)
                    && nextStationBusIds.contains(currentBusId)) {
                // თუ მიმდინარე ბასი გვაქვს
                // შემოწმდეს ეს ბასი თუ არის მიმდინარე ადრესის ბასებში და ასევე შემდეგი ადრესის ბასებში.
                // თუ არის ორივეში გადავიდეთ შემდეგ ციკლზე, CONTINUE
                continue;
            }

            for (int currentStationBusId : currentStationBusIds) {
                // გადავყვეთ მიმდინარე ადრესის ბასებს
                    // ამოვიღოთ ბასი
                    // შევამოწმოთ ეს ბასი თუ არის შემდეგი ადრესის ბასებში
                    // თუ არის
                        // მიმდინარე ბასი გახდეს ეს ბასი
                        // რესალტში ჩავწეროთ მიმდინარე ადრესსზე curentStationId ჩაჯექით ბასში 'მიმდინარე ბასი'
                if (nextStationBusIds.contains(currentStationBusId)) {
                    currentBusId = currentStationBusId;
                    addressForBusChange.put(currentStationId, currentBusId);
                    //result += addressForBusChangeToString();
                    result += "At the station: " + currentStationId + " take the bus: " + currentBusId + " ---> ";
                }
            }
        }
        LOGGER.info(" current station ids: " + res2);
        return result;
    }

    public List<Integer> getPathIds() {
        return pathIds;
    }

    public void setPathIds(List<Integer> pathIds) {
        this.pathIds = pathIds;
    }
}
