package com.kazma.dao;

import com.kazma.entity.*;
import org.apache.ibatis.annotations.Param;
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

    List<Menu> getMenus(@Param("type") Integer type, @Param("isAdmin")Integer isAdmin);

    void addResource(Resource resource);

    List<Resource> getResources(@Param("isAdmin") Integer isAdmin);

    List<Role> getRoles();

    List<Role> getRoleByRoleIds(@Param("roleIds") List<Integer> roleIds);
}
