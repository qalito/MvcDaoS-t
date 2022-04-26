package com.repository;

import com.entity.Word;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlDao implements Dao {
    Connection connection =  SqlConnection.getConnection();
    public SqlDao() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insert(Word word) {

    }

    @Override
    public Word get(long id) {
        return null;
    }
}
