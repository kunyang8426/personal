package com.kazma.service;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.Menu;
import com.kazma.entity.User;

public interface UserService {
    void regUser(String pwd, String loginName, InvokeResult iv);

    void login(String pwd, String loginName, InvokeResult iv);

    void fillUser(User user, String token, InvokeResult iv);

    void getDepartments(InvokeResult iv);

    void addMenu(Menu menu, InvokeResult iv);

    void getTopMenus(InvokeResult iv);
}
