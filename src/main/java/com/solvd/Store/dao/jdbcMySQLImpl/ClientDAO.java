package com.solvd.Store.dao.jdbcMySQLImpl;
import com.solvd.Store.connection.ConnectionPool;
import com.solvd.Store.dao.IBaseDAO;
import com.solvd.Store.dao.IClientDAO;
import com.solvd.Store.models.Age;
import com.solvd.Store.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO implements IClientDAO {

    private final static Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private static final String GET_CLIENT_BY_ID ="SELECT * FROM clients where id =?";
    private final static String INSERT_CLIENTS = "INSERT INTO clients(name, surname, age_id) values (?, ?, ?)";
    private final static String UPDATE_CLIENTS = "UPDATE clients SET name = ? , surname = ? , age_id = ? WHERE id in (?)";
    private final static String DELETE_CLIENTS_BY_ID = "DELETE FROM clients WHERE id=?";
    private final static String GET_CLIENTS_BY_ORDER_ID ="SELECT clients.id, clients.name, clients.surname from clients " +
            "INNER JOIN order " +
            "ON order.clientsId = clients.id " +
            "WHERE order.id IN (?)";
    @Override
    public Client getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = new Client();
        Age age = new Age();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_CLIENT_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            client.setSurname(resultSet.getString("surname"));
            age.setId(resultSet.getLong("age_id"));
            client.setAge(age);
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return client;
    }

    @Override
    public void saveEntity(Client entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_CLIENTS);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setLong(3, entity.getAge().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Creation error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    @Override
    public void updateEntity(Client entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_CLIENTS);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setLong(3, entity.getAge().getId());
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
            statement = connection.prepareStatement(DELETE_CLIENTS_BY_ID);
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
    public Client getClientByOrderId(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = new Client();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_CLIENTS_BY_ORDER_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            client.setSurname(resultSet.getString("surname"));
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return client;
    }
}
