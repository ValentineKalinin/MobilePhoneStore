package com.solvd.Store.dao.jdbcMySQLImpl;

import com.solvd.Store.connection.ConnectionPool;
import com.solvd.Store.dao.IBaseDAO;
import com.solvd.Store.dao.IPhoneStoreDAO;
import com.solvd.Store.models.PhoneStore;
import com.solvd.Store.models.StoreAddress;
import com.solvd.Store.models.StoresSquare;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneStoreDAO implements IPhoneStoreDAO {

    private final static Logger LOGGER = LogManager.getLogger(PhoneStoreDAO.class);
    private static final String GET_STORE_BY_ID ="SELECT * FROM phoneStore where id =?";
    private final static String INSERT_STORE = "INSERT INTO phoneStore(name, storeAddress_id, storesSquare_id) values (?, ?, ?)";
    private final static String UPDATE_STORE = "UPDATE phoneStore SET name = ?, storeAddress_id = ?, storesSquare_id = ? WHERE id in (?)";
    private final static String DELETE_STORE_BY_ID = "DELETE FROM phoneStore WHERE id=?";
    private final static String GET_STORE_BY_ORDER_ID ="SELECT phoneStore.id, phoneStore.name, phoneStore.storeAddress_id, phoneStore.storesSquare_id from phoneStore " +
            "INNER JOIN order " +
            "ON order.phoneStore_id = phoneStore.id " +
            "WHERE order.id IN (?)";
    @Override
    public PhoneStore getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PhoneStore phoneStore = new PhoneStore();
        StoreAddress storeAddress = new StoreAddress();
        StoresSquare storesSquare = new StoresSquare();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_STORE_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            phoneStore.setId(resultSet.getLong("id"));
            phoneStore.setName(resultSet.getString("name"));
            storeAddress.setId(resultSet.getLong("storeAddress_id"));
            phoneStore.setStoreAddress(storeAddress);
            storesSquare.setId(resultSet.getLong("storesSquare_id"));
            phoneStore.setStoresSquare(storesSquare);
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return phoneStore;
    }

    @Override
    public void saveEntity(PhoneStore entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_STORE);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getStoreAddress().getId());
            statement.setLong(3, entity.getStoresSquare().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Creation error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(PhoneStore entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_STORE);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getStoreAddress().getId());
            statement.setLong(3, entity.getStoresSquare().getId());
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_STORE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete from the data base error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public PhoneStore getStoreByOrderId(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PhoneStore phoneStore = new PhoneStore();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_STORE_BY_ORDER_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            phoneStore.setId(resultSet.getLong("id"));
            phoneStore.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return phoneStore;
    }
}
