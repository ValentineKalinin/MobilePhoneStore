package com.solvd.store.parsers;

import com.solvd.store.models.PhoneStore;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JAXB {
    private static final Logger LOGGER = LogManager.getLogger(JAXB.class);

    public static void marshal(PhoneStore phoneStore) throws JAXBException, IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(PhoneStore.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(phoneStore, new File(System.getProperty("user.dir") + "/src/main/resources/data/testJaxb.xml"));
        } catch (JAXBException e){
            LOGGER.info(e);
        }
    }
    public static PhoneStore unmarshall() throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(PhoneStore.class);
        return (PhoneStore) context.createUnmarshaller()
                .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/data/testJaxb.xml"));
    }
}
