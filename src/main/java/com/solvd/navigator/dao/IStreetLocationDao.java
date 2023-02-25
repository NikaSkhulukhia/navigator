package com.solvd.navigator.dao;

import java.sql.SQLException;

import com.solvd.navigator.model.StreetLocation;

public interface IStreetLocationDao extends IBaseDao<StreetLocation> {

	StreetLocation getStreetLocationByID(int id) throws SQLException;
}
