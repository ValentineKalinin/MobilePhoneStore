package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.IWorkersPositionDAO;
import com.solvd.store.models.WorkersPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkersPositionDAO implements IWorkersPositionDAO {

    private final static Logger LOGGER = LogManager.getLogger(WorkersPositionDAO.class);
    private final static String GET_POSITION_BY_ID = "SELECT * FROM position where id = ?";
    private final static String INSERT_POSITION = "INSERT INTO position(position) VALUES (?)";
    private final static String UPDATE_POSITION = "UPDATE age SET position = ? WHERE id = ?";
    private final static String DELETE_POSITION_BY_ID = "DELETE FROM position WHERE id = ?";

    @Override
    public WorkersPosition getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        WorkersPosition position = new WorkersPosition();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_POSITION_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            position.setId(resultSet.getLong("id"));
            position.setPosition(resultSet.getString("position"));
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
        return position;
    }

    @Override
    public void saveEntity(WorkersPosition entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_POSITION);
            statement.setString(1, entity.getPosition());
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
    public void updateEntity(WorkersPosition entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_POSITION);
            statement.setString(1, entity.getPosition());
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
            statement = connection.prepareStatement(DELETE_POSITION_BY_ID);
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