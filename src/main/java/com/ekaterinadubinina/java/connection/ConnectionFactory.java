package com.ekaterinadubinina.java.connection;

import java.nio.file.ProviderNotFoundException;
import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/note";
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
        if (connection == null) {
            throw new ProviderNotFoundException();
        } else {
            return connection;
        }
    }
}

