package com.repository;

import com.entity.User;

import java.util.ArrayList;

public interface UserDao {
    void insert(User user);

    void update(User user);

    void delete(User user);

    User getById(long id);

    ArrayList<User> getAll();
}
