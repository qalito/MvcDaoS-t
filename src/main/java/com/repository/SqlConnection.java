package com.repository;

import java.sql.*;

public class SqlConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basetest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1111";
    private static Connection connection = null;

    private SqlConnection(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (connection == null) {
            try {
                new SqlConnection(DriverManager.getConnection(URL, LOGIN, PASSWORD));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


}
