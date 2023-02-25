package com.solvd.navigator.dao;

import com.solvd.navigator.model.Street;

import java.sql.SQLException;
import java.util.List;

public interface IStreetDao extends IBaseDao<Street> {
    List<Street> selectStreetsByCity(int cityId) throws SQLException;
}
