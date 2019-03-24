package com.kazma.dao;

import com.kazma.entity.Department;
import com.kazma.entity.Menu;
import com.kazma.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void regUser(User user);

    User login(User user);

    int fillUser(User user);


    User getUserById(Integer userId);

    List<Department> getDepartments();

    void addMenu(Menu menu);

    List<Menu> getTopMenus();
}
