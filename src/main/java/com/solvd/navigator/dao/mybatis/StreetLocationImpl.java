package com.solvd.navigator.dao.mybatis;

import com.solvd.navigator.dao.IStreetLocationDao;
import com.solvd.navigator.model.StreetLocation;
import com.solvd.navigator.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class StreetLocationImpl implements IStreetLocationDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(StreetImpl.class);

	StreetLocation streetLocation;

	@Override
	public void insertEntity(StreetLocation entity) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
			try {
				iStreetLocationDao.insertEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			} finally {
				sqlSession.rollback();
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
			IStreetLocationDao iStreetLocationDao = sqlSession.getMapper(IStreetLocationDao.class);
			try {
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
				LOGGER.error("SQLException", e);
			} finally {
				sqlSession.rollback();
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
				LOGGER.error("SQLException", e);
			} finally {
				sqlSession.rollback();
			}
		}
	}
}
