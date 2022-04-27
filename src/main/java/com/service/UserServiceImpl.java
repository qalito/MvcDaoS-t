package com.service;

import com.entity.User;
import com.repository.SqlUserDao;
import com.repository.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao dao = new SqlUserDao();

    @Override
    public String insert(String name) {
            User user = new User();
            user.setName(name);
            if (dao.insert(user)) {
                return "User add in system!";
            } else {
                return "Error with insert user!";
            }
    }
    @Override
    public String delete(long id) {
        User user = new User();
        user.setId(id);
        if (dao.delete(user)){
            return "User delete!";
        } else {
            return "Error with delete user!";
        }
    }

    @Override
    public String getUser(long id) {
        User user = dao.getById(id);
        if (user.equals(new User())) {
            return  "User not found!";
        } else {
            return dao.getById(id).toString();
        }
    }

    @Override
    public String update(long id, String name) {
        if (name == null || id == 0) {
            return "User name or id is null!";
        }
        else {
            User user = new User();
            user.setId(id);
            user.setName(name);
            if (dao.update(user)){
                return "User update!";
            } else {
                return "Error with update user!";
            }
        }
    }
}
