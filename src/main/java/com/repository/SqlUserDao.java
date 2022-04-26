package com.repository;

import com.entity.User;
import com.service.UserService;

import java.sql.*;
import java.util.ArrayList;

public class SqlUserDao implements UserDao {
    private Connection connection = SqlConnection.getConnection();


    @Override
    public void insert(User user) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (NAME) VALUES (?);")) {
            statement.setString(1, user.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE USERS SET NAME = ? WHERE ID = ?")) {
            statement.setLong(1, user.getId());
            statement.setString(2, user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?;")) {
            statement.setLong(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS WHERE ID = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
