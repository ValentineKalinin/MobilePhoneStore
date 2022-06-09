package com.solvd.Store;

import com.solvd.Store.connection.ConnectionPool;
import com.solvd.Store.models.PhoneStore;
import com.solvd.Store.models.StoreAddress;
import com.solvd.Store.models.StoresSquare;
import com.solvd.Store.parsers.DOM;
import com.solvd.Store.parsers.JAXB;
import com.solvd.Store.parsers.JSON;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {

        // 1. Con Pool
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.init();
        connectionPool.getConnection();
        connectionPool.getConnection();
        connectionPool.getConnection();
        connectionPool.releaseConnection(connectionPool.getConnection());

        // 2. DOM
        DOM dom = new DOM();
        dom.getDrivers();

        PhoneStore phoneStore = new PhoneStore();
        phoneStore.setId(1L);
        phoneStore.setName("Parameter");
        StoresSquare storesSquare1 = new StoresSquare();
        storesSquare1.setSquare(22.4);
        phoneStore.setStoresSquare(storesSquare1);
        StoreAddress storeAddress1 = new StoreAddress();
        storeAddress1.setAddress("Nemiga street 5");
        phoneStore.setStoreAddress(storeAddress1);

        PhoneStore phoneStore2 = new PhoneStore();
        phoneStore2.setId(2L);
        phoneStore2.setName("Gorizont");
        StoresSquare storesSquare2 = new StoresSquare();
        storesSquare2.setSquare(22.4);
        phoneStore2.setStoresSquare(storesSquare2);
        StoreAddress storeAddress2 = new StoreAddress();
        storeAddress2.setAddress("Nemiga street 5");
        phoneStore2.setStoreAddress(storeAddress2);

        // 3. JAXB
        try {
            JAXB.marshal(phoneStore);
            PhoneStore store1 = JAXB.unmarshall();
            System.out.println(store1);
            JAXB.marshal(phoneStore2);
            PhoneStore store2 = JAXB.unmarshall();
            System.out.println(store2);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

         //4. JackSon
        JSON.serialize(phoneStore);
        JSON.serialize(phoneStore2);
        JSON.deserialize();
    }
}
