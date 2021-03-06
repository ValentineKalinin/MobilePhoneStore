package com.solvd.store.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Вынесли общие функции и закрывающие методы в отдельный интерфейс
// Можем имплементать его вместо остальных интерфейсов, если не нужны доп методы в DAO

public interface IBaseDAO <T>{

    Logger LOGGER = LogManager.getLogger(IBaseDAO.class);
    T getEntityById (Long id);
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(Long id);

    static void closeResultSet(ResultSet resultSet) {
        try {
            DbUtils.close(resultSet);
        } catch (SQLException e) {
            LOGGER.info("ResultSet closure error", e);
        }
    }

    static void closePreparedStatement(PreparedStatement statement) {
        try {
            DbUtils.close(statement);
        } catch (SQLException e) {
            LOGGER.info("PreparedStatement closure error", e);
        }
    }
}