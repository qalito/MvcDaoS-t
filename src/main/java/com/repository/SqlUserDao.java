package com.repository;

import com.entity.User;
import java.sql.*;
import java.util.ArrayList;

public class SqlUserDao implements UserDao {
    private Connection connection = SqlConnection.getInstance().getConnection();
    //final переменные запросы
    private static final String INSERT_QUERY ="INSERT INTO USERS (NAME) VALUES (?);";
    private static final String UPDATE_QUERY ="UPDATE USERS SET NAME = ? WHERE ID = ?;";
    private static final String DELETE_QUERY="DELETE FROM USERS WHERE ID = ?;";
    private static final String SELECT_QUERY="SELECT * FROM USERS WHERE ID = ?;";

    @Override
    public boolean insert(User user) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
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
        try (PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
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
