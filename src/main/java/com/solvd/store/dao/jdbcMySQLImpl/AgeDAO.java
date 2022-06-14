package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.IAgeDAO;
import com.solvd.store.models.Age;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgeDAO implements IAgeDAO {

    private final static Logger LOGGER = LogManager.getLogger(AgeDAO.class);
    private final static String GET_AGE_BY_ID = "SELECT * FROM age where id = ?";
    private final static String INSERT_AGE = "INSERT INTO age(age) VALUES (?)";
    private final static String UPDATE_AGE = "UPDATE age SET age = ? WHERE  id = ?";
    private final static String DELETE_AGE_BY_ID = "DELETE FROM age WHERE id = ?";

    @Override
    public Age getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Age age = new Age();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_AGE_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            age.setId(resultSet.getLong("id"));
            age.setAge(resultSet.getInt("age"));
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return age;
    }

    @Override
    public void saveEntity(Age entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_AGE);
            statement.setInt(1, entity.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Creation error", e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Age entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_AGE);
            statement.setInt(1, entity.getAge());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update error", e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_AGE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete from the data base error", e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
