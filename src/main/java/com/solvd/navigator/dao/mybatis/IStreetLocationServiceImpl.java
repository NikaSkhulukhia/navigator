package com.solvd.navigator.dao.mybatis;

import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.model.StreetLocation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class IStreetLocationServiceImpl implements IStreetLocationDao {
    private static final Logger LOGGER = LogManager.getLogger(IStreetServiceImpl.class);
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory;
    StreetLocation streetLocation;

    @Override
    public void insertEntity(StreetLocation entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
            try {
                iStreetLocationDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public StreetLocation selectEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
            streetLocation = iStreetLocationDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return streetLocation;
    }

    @Override
    public List<StreetLocation> selectAllEntity() throws SQLException {
        List<StreetLocation> streetLocationList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
                streetLocationList = iStreetLocationDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
        return streetLocationList;
    }

    @Override
    public void updateEntity(StreetLocation entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
            try {
                iStreetLocationDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
            try {
                iStreetLocationDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                sqlSession.rollback();
                LOGGER.error("SQLException", e);
            }
        }
    }
}
