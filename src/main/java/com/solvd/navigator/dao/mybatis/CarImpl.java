package com.solvd.navigator.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import com.solvd.navigator.dao.ICarDao;
import com.solvd.navigator.model.Car;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.navigator.util.MyBatisUtil;

public class CarImpl implements ICarDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(CarImpl.class);
    Car car;

    @Override
    public Car selectEntityById(int id) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICarDao carDao = sqlSession.getMapper(ICarDao.class);
            city = carDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return city;
    }

    @Override
    public List<Car> selectAllEntity() {
        List<Car> carList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                ICarDao carDao = sqlSession.getMapper(ICarDao.class);
                carList = carDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
        return carList;
    }

    @Override
    public void insertEntity(Car entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICarDao carDao = sqlSession.getMapper(ICarDao.class);
            try {
                carDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);

            }
        }
    }

    @Override
    public void updateEntity(Car entity) {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICarDao carDao = sqlSession.getMapper(ICarDao.class);
            try {
                carDao.updateEntity(entity);
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
            ICarDao carDao = sqlSession.getMapper(ICarDao.class);
            try {
                carDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }
}
