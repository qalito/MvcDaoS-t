package com.repository;

import com.entity.User;

import java.util.ArrayList;

public interface UserDao {
    boolean insert(User user);

    boolean update(User user);

    boolean delete(User user);

    User getById(long id);

    ArrayList<User> getAll();
}
