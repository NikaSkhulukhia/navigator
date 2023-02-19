package com.solvd.navigator.dao.mybatis;

import com.solvd.navigator.dao.IPublicTransportDirectionsDao;
import com.solvd.navigator.model.PublicTransportDirections;
import com.solvd.navigator.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PublicTransportDirectionsDao implements IPublicTransportDirectionsDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
    private static final Logger LOGGER = LogManager.getLogger(PublicTransportDirectionsDao.class);
    PublicTransportDirections publicTransportDirections;
    @Override
    public void insertEntity(PublicTransportDirections entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPublicTransportDirectionsDao iPublicTransportDirectionsDao = sqlSession.getMapper(IPublicTransportDirectionsDao.class);
            try {
                iPublicTransportDirectionsDao.insertEntity(entity);
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
    public PublicTransportDirections selectEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPublicTransportDirectionsDao iPublicTransportDirectionsDao = sqlSession.getMapper(IPublicTransportDirectionsDao.class);
            publicTransportDirections = iPublicTransportDirectionsDao.selectEntityById(id);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return publicTransportDirections;
    }

    @Override
    public List<PublicTransportDirections> selectAllEntity() throws SQLException {
        List<PublicTransportDirections> publicTransportDirectionsList = null;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            try {
                IPublicTransportDirectionsDao iPublicTransportDirectionsDao = sqlSession.getMapper(IPublicTransportDirectionsDao.class);
                publicTransportDirectionsList = iPublicTransportDirectionsDao.selectAllEntity();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }finally {
                sqlSession.rollback();
                sqlSession.close();
            }
        }
        return publicTransportDirectionsList;
    }

    @Override
    public void updateEntity(PublicTransportDirections entity) throws SQLException {
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPublicTransportDirectionsDao iPublicTransportDirectionsDao = sqlSession.getMapper(IPublicTransportDirectionsDao.class);
            try {
                iPublicTransportDirectionsDao.updateEntity(entity);
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
            IPublicTransportDirectionsDao iPublicTransportDirectionsDao = sqlSession.getMapper(IPublicTransportDirectionsDao.class);
            try {
                iPublicTransportDirectionsDao.deleteEntity(id);
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
