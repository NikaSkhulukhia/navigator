package com.solvd.navigator.service;

import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.dao.mybatis.PublicTransportDirectionsImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicTransportService {
    private int idPublicTransport;
    private int publicTransportNumber;
    private List<Integer> pathIds;

    public String getBusUsagePlan() throws SQLException {
        // TODO
        pathIds = new ArrayList<>();
        pathIds.add(3);
        pathIds.add(2);
        pathIds.add(4);
        pathIds.add(1);

        IPublicTransportDirectionsDao publicTransportDirections = new PublicTransportDirectionsImpl();

        String result = "";
        int currentBusId = 0;
        for(int i = 0; i < pathIds.size() - 2; i++) {
            int currentStationId = pathIds.get(i);
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
                    result += "At the station: " + currentStationId + " take the bus: " + currentBusId + " ---> ";
                }
            }
        }
        return result;
    }
}
