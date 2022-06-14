package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.ICountryDAO;
import com.solvd.store.models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO implements ICountryDAO {

    private final static Logger LOGGER = LogManager.getLogger(ModelDAO.class);
    private final static String GET_COUNTRY_BY_ID = "SELECT * FROM country where id = ?";
    private final static String INSERT_COUNTRY = "INSERT INTO country(country) VALUES (?)";
    private final static String UPDATE_COUNTRY = "UPDATE country SET country = ? WHERE  id = ?";
    private final static String DELETE_COUNTRY_BY_ID = "DELETE FROM country WHERE id = ?";

    @Override
    public Country getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Country country = new Country();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_COUNTRY_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            country.setId(resultSet.getLong("id"));
            country.setCountry(resultSet.getString("country"));
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
        return country;
    }

    @Override
    public void saveEntity(Country entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_COUNTRY);
            statement.setString(1, entity.getCountry());
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
    public void updateEntity(Country entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_COUNTRY);
            statement.setString(1, entity.getCountry());
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
            statement = connection.prepareStatement(DELETE_COUNTRY_BY_ID);
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

