package com.kazma.dao;

import com.kazma.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    void regUser(User user);
}
