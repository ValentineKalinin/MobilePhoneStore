package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.IBaseDAO;
import com.solvd.store.dao.IWorkerDAO;
import com.solvd.store.models.PhoneStore;
import com.solvd.store.models.Worker;
import com.solvd.store.models.WorkersExperience;
import com.solvd.store.models.WorkersPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDAO implements IWorkerDAO {

    private static final Logger LOGGER = LogManager.getLogger(IWorkerDAO.class);
    private static final String GET_WORKER_BY_ID = "SELECT * FROM worker WHERE id =?";
    private static final String INSERT_WORKER = "INSERT INTO worker(name, surname, WorkersExperience_id," +
            " WorkersPosition_id, PhoneStores_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_WORKER = "UPDATE worker SET name = ?, surname = ?, WorkersExperience_id = ?, " +
            "WorkersPosition_id = ?, PhoneStores_id = ? WHERE id IN(?)";
    private static final String DELETE_WORKER_BY_ID = "DELETE FROM worker WHERE id=?";

    @Override
    public Worker getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Worker worker = new Worker();
        WorkersExperience experience = new WorkersExperience();
        WorkersPosition position = new WorkersPosition();
        PhoneStore store = new PhoneStore();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_WORKER_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            worker.setId(resultSet.getLong("id"));
            worker.setName(resultSet.getString("name"));
            worker.setSurname(resultSet.getString("surname"));
            experience.setId(resultSet.getLong("workersExperience_id"));
            worker.setWorkersExperience(experience);
            position.setId(resultSet.getLong("workersPosition_id"));
            worker.setWorkersPosition(position);
            store.setId(resultSet.getLong("phoneStore_id"));
            worker.setPhoneStore(store);
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return worker;
    }

    @Override
    public void saveEntity(Worker entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT_WORKER);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setLong(3, entity.getWorkersExperience().getId());
            statement.setLong(4, entity.getWorkersPosition().getId());
            statement.setLong(5, entity.getPhoneStore().getId());
            statement.executeUpdate();
            //connection.commit();
        } catch (SQLException e) {
            LOGGER.error("Creation error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Worker entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE_WORKER);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setLong(3, entity.getWorkersExperience().getId());
            statement.setLong(4, entity.getWorkersPosition().getId());
            statement.setLong(5, entity.getPhoneStore().getId());
            statement.setLong(6, entity.getId());
            statement.executeUpdate();
            //connection.commit();
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
            statement = connection.prepareStatement(DELETE_WORKER_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete from the data base error", e);
        } finally {
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
    }
}
