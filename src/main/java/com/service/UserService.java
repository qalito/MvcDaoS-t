package com.service;


public interface UserService {
    void insert(String name);

    void delete(long id);

    String getUser(long id);
}
