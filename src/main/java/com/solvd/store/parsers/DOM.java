package com.solvd.store.parsers;

import com.solvd.store.models.Age;
import com.solvd.store.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Переделать. Код типо рабочий. Должно быть по-другому.

public class DOM {
    private static final Logger LOGGER = LogManager.getLogger(DOM.class);
    public void getDrivers() {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/data/xmlmodel.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element clientsElement = (Element) document.getElementsByTagName("clients").item(0);
            String surname = clientsElement.getAttribute("surname");
            String name = clientsElement.getAttribute("name");
            String age = clientsElement.getAttribute("age");
            NodeList clientNodeList = document.getElementsByTagName("client");
            List<Client> clients = new ArrayList<>();
            for (int i = 0; i < clientNodeList.getLength(); i++) {
                if (clientNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element clientElement = (Element) clientNodeList.item(i);
                    Client client = new Client();
                    Age clientAge = new Age();
                    NodeList childNodes = clientElement.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        if(childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNodes.item(j);
                            switch (childElement.getNodeName()) {
                                case "name" -> {
                                    client.setName(childElement.getTextContent());
                                }
                                case "surname" -> {
                                    client.setSurname(childElement.getTextContent());
                                }
                                case "age" -> {
                                    client.setAge(clientAge);
                                }
                            }
                        }
                    }
                    clients.add(client);
                }
            }
            clients.forEach(LOGGER::info);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
