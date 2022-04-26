package com.repository;

import com.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class SqlUserDao implements UserDao{
    Connection connection =  SqlConnection.getConnection();

    public SqlUserDao() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insert(User user) {
        try(PreparedStatement preparedStatement =connection.prepareStatement("INSER INTO USERS (NAME) VALUES (?)")){
            preparedStatement.setString(1,user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try(PreparedStatement preparedStatement =connection.prepareStatement("UPDATE USERS SET NAME = ? WHERE ID = ?")){
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setString(2,user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try(PreparedStatement preparedStatement =connection.prepareStatement("DELETE FROM USERS WHERE ID = ?")){
            preparedStatement.setLong(1,user.getId());
            preparedStatement.setString(2,user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        try(PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM USERS WHERE ID = ?")){
            preparedStatement.setLong(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
