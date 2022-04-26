package com.service;

import com.entity.User;
import com.repository.SqlUserDao;
import com.repository.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao dao = new SqlUserDao();

    @Override
    public void insert(String name) {
        if (name.equals(null)) {
        } else {
            User user = new User();
            user.setName(name);
            dao.insert(user);
        }
    }

    @Override
    public void delete(long id) {
        User user = new User();
        user.setId(id);
        dao.delete(user);
    }

    @Override
    public String getUser(long id) {
        User user = dao.getById(id);
        System.out.println("User equals" + user.equals(null));
        if (user.equals(new User())) {
            return null;
        } else {
            return dao.getById(id).toString();
        }
    }
}
