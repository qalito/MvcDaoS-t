package com.repository;

import com.entity.Word;

public interface Dao {
    void insert(Word word);
    Word get(long id);
}
