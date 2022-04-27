package com.service;


public interface UserService {
    String insert(String name);

    String delete(long id);

    String getUser(long id);

    String update(long id, String name);
}
