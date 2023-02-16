package com.solvd.navigator.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T> {

        void insertEntity(T entity) throws SQLException;

        T selectEntityById(int id) throws SQLException;

        List<T> selectAllEntity() throws SQLException;

        void updateEntity(T entity) throws SQLException;

        void deleteEntity(int id) throws SQLException;
    }

