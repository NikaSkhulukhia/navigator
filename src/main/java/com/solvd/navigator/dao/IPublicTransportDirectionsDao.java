package com.solvd.navigator.dao;

import com.solvd.navigator.model.PublicTransportDirections;

import java.sql.SQLException;
import java.util.List;

public interface IPublicTransportDirectionsDao extends IBaseDao<PublicTransportDirections> {
    List<Integer> selectAllBusIdsByLocationId(int locationId) throws SQLException;
}
