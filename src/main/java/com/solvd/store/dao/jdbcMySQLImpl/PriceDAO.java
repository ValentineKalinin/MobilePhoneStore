package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.IPriceDAO;
import com.solvd.store.models.Price;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceDAO implements IPriceDAO {

    private final static Logger LOGGER = LogManager.getLogger(PriceDAO.class);
    private final static String GET_PRICE_BY_ID = "SELECT * FROM price where id = ?";
    private final static String INSERT_PRICE = "INSERT INTO price(price) VALUES (?)";
    private final static String UPDATE_PRICE = "UPDATE price SET price = ? WHERE  id = ?";
    private final static String DELETE_PRICE_BY_ID = "DELETE FROM price WHERE id = ?";

    @Override
    public Price getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Price price = new Price();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_PRICE_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            price.setId(resultSet.getLong("id"));
            price.setPrice(resultSet.getInt("price"));
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
        return price;
    }

    @Override
    public void saveEntity(Price entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_PRICE);
            statement.setDouble(1, entity.getPrice());
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
    public void updateEntity(Price entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_PRICE);
            statement.setDouble(1, entity.getPrice());
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
            statement = connection.prepareStatement(DELETE_PRICE_BY_ID);
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
