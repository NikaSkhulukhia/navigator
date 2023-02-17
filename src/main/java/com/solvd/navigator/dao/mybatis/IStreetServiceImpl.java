package com.solvd.navigator.dao.mybatis;

import com.solvd.navigator.dao.IStreetDao;
import com.solvd.navigator.model.Street;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class IStreetServiceImpl implements IStreetDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(IStreetServiceImpl.class);
    Street street;

    @Override
    public void insertEntity(Street entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetDao iStreetDao = sqlSession.getMapper(IStreetDao.class);
            try {
                iStreetDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
            }
        }
    }

    @Override
    public Street selectEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetDao iStreetDao = sqlSession.getMapper(IStreetDao.class);
            street = iStreetDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return street;
    }

    @Override
    public List<Street> selectAllEntity() throws SQLException {
        List<Street> streetList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                IStreetDao iStreetDao = sqlSession.getMapper(IStreetDao.class);
                streetList = iStreetDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
        return streetList;
    }

    @Override
    public void updateEntity(Street entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetDao iStreetDao = sqlSession.getMapper(IStreetDao.class);
            try {
                iStreetDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
            }
        }
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IStreetDao iStreetDao = sqlSession.getMapper(IStreetDao.class);
            try {
                iStreetDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
            }
        }
    }
}
