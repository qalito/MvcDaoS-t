package com.repository;

import java.sql.*;

public class SqlConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basetest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1111";
    private static Connection connection = null;

    SqlConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = (Connection) new SqlConnection(DriverManager.getConnection(URL, LOGIN, PASSWORD));
        }
        return connection;
    }


}
