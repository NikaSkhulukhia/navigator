package com.solvd.navigator.dao;

import com.solvd.navigator.model.StreetLocation;

import java.sql.SQLException;
import java.util.List;

public interface IStreetLocationDao extends IBaseDao<StreetLocation> {
    Integer selectStreetNumberById(int id) throws SQLException;
    List<StreetLocation> selectAllStreetNumbers(int id) throws SQLException;
    List<Integer> selectStreetNumbersByStreetName(String streetName) throws SQLException;
}

