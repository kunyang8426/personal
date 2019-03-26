package com.kazma.service;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.Menu;
import com.kazma.entity.Resource;
import com.kazma.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    void regUser(String pwd, String loginName, InvokeResult iv);

    void login(String pwd, String loginName, InvokeResult iv);

    void fillUser(User user, String token, InvokeResult iv);

    void getDepartments(InvokeResult iv);

    void addMenu(Menu menu, InvokeResult iv);

    void getMenus(Integer type, InvokeResult iv);

    void addResource(Resource resource, InvokeResult iv);

    void getPermissionTree(String token, InvokeResult iv);
}
