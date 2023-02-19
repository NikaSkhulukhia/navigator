package com.solvd.navigator.dao.mybatis;


import com.solvd.navigator.dao.IDirectionsDao;
import com.solvd.navigator.dao.IPublicTransportDao;
import com.solvd.navigator.model.PublicTransport;
import com.solvd.navigator.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PublicTransportImpl implements IPublicTransportDao{
        private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
        private static final Logger LOGGER = LogManager.getLogger(com.solvd.navigator.dao.mybatis.DirectionsImpl.class);
        PublicTransport publicTransport;
        @Override
        public void insertEntity(PublicTransport entity) throws SQLException {
            try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
                IPublicTransportDao iPublicTransportDao = sqlSession.getMapper(IPublicTransportDao.class);
                try {
                    iPublicTransportDao.insertEntity(entity);
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
        public PublicTransport selectEntityById(int id) throws SQLException {
            try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
                IPublicTransportDao iPublicTransportDao = sqlSession.getMapper(IPublicTransportDao.class);
                publicTransport = iPublicTransportDao.selectEntityById(id);
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
            return publicTransport;
        }

        @Override
        public List<PublicTransport> selectAllEntity() throws SQLException {
            List<PublicTransport> publicTransportList = null;
            try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
                try {
                    IPublicTransportDao iPublicTransportDao = sqlSession.getMapper(IPublicTransportDao.class);
                    publicTransportList = iPublicTransportDao.selectAllEntity();
                } catch (SQLException e) {
                    LOGGER.error("SQLException", e);
                }finally {
                    sqlSession.rollback();
                    sqlSession.close();
                }
            }
            return publicTransportList;
        }

        @Override
        public void updateEntity(PublicTransport entity) throws SQLException {
            try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
                IPublicTransportDao iPublicTransportDao = sqlSession.getMapper(IPublicTransportDao.class);
                try {
                    iPublicTransportDao.updateEntity(entity);
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
