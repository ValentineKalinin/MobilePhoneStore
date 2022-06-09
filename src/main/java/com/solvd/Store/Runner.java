package com.solvd.Store;

import com.solvd.Store.parsers.DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {

//        ConnectionPool connectionPool = ConnectionPool.getInstance();
//        connectionPool.init();

        DOM dom = new DOM();
        dom.getDrivers();
    }
}
