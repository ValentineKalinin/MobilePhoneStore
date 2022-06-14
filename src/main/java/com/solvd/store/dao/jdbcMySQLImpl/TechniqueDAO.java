package com.solvd.store.dao.jdbcMySQLImpl;

import com.solvd.store.connection.ConnectionPool;
import com.solvd.store.dao.IBaseDAO;
import com.solvd.store.dao.ITechniqueDAO;
import com.solvd.store.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TechniqueDAO implements ITechniqueDAO {
    private static final Logger LOGGER = LogManager.getLogger(TechniqueDAO.class);
    private static final String GET_TECHNIQUE_BY_ID = "SELECT * FROM technique WHERE id =?";
    private static final String INSERT_TECHNIQUE = "INSERT INTO technique(name, phoneStore_id, model_id, " +
            "year_id, price_id, country_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_TECHNIQUE = "UPDATE technique SET name = ?, phoneStore_id = ?, model_id = ?, " +
            "year_id = ?, price_id = ?, country_id = ? WHERE id IN(?)";
    private static final String DELETE_TECHNIQUE_BY_ID = "DELETE FROM technique WHERE id=?";
    private static final String GET_ALL_TECHNIQUE_BY_ID = "SELECT techniques.name, phoneStores.name, " +
            "prices.price, models.model, countries.country, years.year FROM techniques\n" +
            "JOIN models ON models.id = techniques.Models_id\n" +
            "JOIN prices ON prices.id = techniques.Prices_id\n" +
            "JOIN years ON years.id = techniques.Years_id\n" +
            "JOIN countries ON countries.id = techniques.Countries_id\n" +
            "JOIN phoneStores ON phoneStores.id = techniques.PhoneStores_id;";

    @Override
    public Technique getEntityById(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Technique technique = new Technique();
        PhoneStore store = new PhoneStore();
        Model model = new Model();
        Year year = new Year();
        Price price = new Price();
        Country country = new Country();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_TECHNIQUE_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            technique.setId(resultSet.getLong("id"));
            technique.setName(resultSet.getString("name"));
            store.setId(resultSet.getLong("phoneStore_id"));
            technique.setPhoneStore(store);
            model.setId(resultSet.getLong("model_id"));
            technique.setModel(model);
            year.setId(resultSet.getLong("year_id"));
            technique.setYear(year);
            price.setId(resultSet.getLong("price_id"));
            technique.setPrice(price);
            country.setId(resultSet.getLong("country_id"));
            technique.setCountry(country);
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return technique;
    }

    @Override
    public void saveEntity(Technique entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(INSERT_TECHNIQUE);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getPhoneStore().getId());
            statement.setLong(3, entity.getModel().getId());
            statement.setLong(4, entity.getYear().getId());
            statement.setLong(5, entity.getPrice().getId());
            statement.setLong(6, entity.getCountry().getId());
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
    public void updateEntity(Technique entity) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(UPDATE_TECHNIQUE);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getPhoneStore().getId());
            statement.setLong(3, entity.getModel().getId());
            statement.setLong(4, entity.getYear().getId());
            statement.setLong(5, entity.getPrice().getId());
            statement.setLong(6, entity.getCountry().getId());
            statement.setLong(7, entity.getId());
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
            statement = connection.prepareStatement(DELETE_TECHNIQUE_BY_ID);
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
    public Technique getAllTechniqueByOrderId(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Technique technique = new Technique();
        PhoneStore store = new PhoneStore();
        Model model = new Model();
        Year year = new Year();
        Price price = new Price();
        Country country = new Country();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(GET_ALL_TECHNIQUE_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            technique.setId(resultSet.getLong("id"));
            technique.setName(resultSet.getString("name"));
            store.setId(resultSet.getLong("phoneStore_id"));
            technique.setPhoneStore(store);
            model.setId(resultSet.getLong("model_id"));
            technique.setModel(model);
            year.setId(resultSet.getLong("year_id"));
            technique.setYear(year);
            price.setId(resultSet.getLong("price_id"));
            technique.setPrice(price);
            country.setId(resultSet.getLong("country_id"));
            technique.setCountry(country);
        } catch (SQLException e) {
            LOGGER.error("Request from the data base error", e);
        } finally {
            IBaseDAO.closeResultSet(resultSet);
            IBaseDAO.closePreparedStatement(statement);
            ConnectionPool.getInstance().releaseConnection(connection);
        }
        return technique;
    }
}
