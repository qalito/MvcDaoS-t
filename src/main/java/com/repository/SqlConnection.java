package com.repository;

import java.sql.*;

public class SqlConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basetest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1111";
    private static SqlConnection instance = null;
    private static Connection connection = null;

    private SqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SqlConnection getInstance() {
        if (instance == null) {
            instance = new SqlConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


}
