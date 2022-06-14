package com.solvd.store.parsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.store.models.PhoneStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON {
    private static final Logger LOGGER = LogManager.getLogger(JSON.class);
    private static final File file = new File(System.getProperty("user.dir") + "/src/main/resources/jacksontest.json");

    public static void serialize(PhoneStore phoneStore) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            //String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serviceStation);
            List<PhoneStore> serviceStations = new ArrayList<>();
            serviceStations.add(phoneStore);
            objectMapper.writeValue(file, serviceStations);
            LOGGER.info("Serialization succesfull to: " + file.getPath());
        } catch (JsonProcessingException e) {
            LOGGER.info("JsonProcessingException", e);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public static void deserialize() {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, PhoneStore.class);
        try {
            List<PhoneStore> serviceStations = objectMapper.readValue(file, type);
            LOGGER.info("Successfully deserialized from: " + file.getPath());
            LOGGER.info(serviceStations);
        } catch (IOException e) {
            LOGGER.info("Error", e);
        }
    }
}