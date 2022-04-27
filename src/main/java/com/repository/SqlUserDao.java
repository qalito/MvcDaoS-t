package com.repository;

import com.entity.User;
import com.service.UserService;

import java.sql.*;
import java.util.ArrayList;

public class SqlUserDao implements UserDao {
    private Connection connection = SqlConnection.getInstance().getConnection();


    @Override
    public boolean insert(User user) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (NAME) VALUES (?);")) {
            statement.setString(1, user.getName());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE USERS SET NAME = ? WHERE ID = ?")) {
            statement.setString(1, user.getName());
            statement.setLong(2, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?;")) {
            statement.setLong(1, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
