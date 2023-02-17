package com.solvd.navigator.dao.mybatis;

import com.solvd.navigator.dao.IDirectionsDao;
import com.solvd.navigator.model.Directions;
import com.solvd.navigator.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class DirectionsImpl implements IDirectionsDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(DirectionsImpl.class);
    Directions directions;
    @Override
    public void insertEntity(Directions entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDirectionsDao iDirectionsDao = sqlSession.getMapper(IDirectionsDao.class);
            try {
                iDirectionsDao.insertEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
                sqlSession.close();
            }
        }
    }

    @Override
    public Directions selectEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDirectionsDao iDirectionsDao = sqlSession.getMapper(IDirectionsDao.class);
            directions = iDirectionsDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return directions;
    }

    @Override
    public List<Directions> selectAllEntity() throws SQLException {
        List<Directions> directionsList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                IDirectionsDao iDirectionsDao = sqlSession.getMapper(IDirectionsDao.class);
                directionsList = iDirectionsDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }finally {
                sqlSession.rollback();
                sqlSession.close();
            }
        }
        return directionsList;
    }

    @Override
    public void updateEntity(Directions entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDirectionsDao iDirectionsDao = sqlSession.getMapper(IDirectionsDao.class);
            try {
                iDirectionsDao.updateEntity(entity);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
                sqlSession.close();
            }
        }

    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IDirectionsDao iDirectionsDao = sqlSession.getMapper(IDirectionsDao.class);
            try {
                iDirectionsDao.deleteEntity(id);
                sqlSession.commit();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            } finally {
                sqlSession.rollback();
                sqlSession.close();
            }
        }
    }
}
