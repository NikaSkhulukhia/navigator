package com.solvd.navigator.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import com.solvd.navigator.dao.ICityDao;
import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.model.City;

import com.solvd.navigator.model.Street;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.navigator.util.MyBatisUtil;

public class CityImpl implements ICityDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(CityImpl.class);
    City city;

    @Override
    public City selectEntityById(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICityDao cityDao = sqlSession.getMapper(ICityDao.class);
            city = cityDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return city;
    }

    @Override
    public List<City> selectAllEntity() {
        List<City> cityList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                ICityDao cityDao = sqlSession.getMapper(ICityDao.class);
                cityList = cityDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
        return cityList;
    }

    @Override
    public void insertEntity(City entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICityDao cityDao = sqlSession.getMapper(ICityDao.class);
            try {
                cityDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void updateEntity(City entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICityDao cityDao = sqlSession.getMapper(ICityDao.class);
            try {
                cityDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void deleteEntity(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICityDao cityDao = sqlSession.getMapper(ICityDao.class);
            try {
                cityDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

}

