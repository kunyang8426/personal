package com.kazma.service.impl;

import com.kazma.dao.UserDao;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.User;
import com.kazma.service.UserService;
import com.kazma.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void regUser(String pwd, String loginName, InvokeResult iv) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(MD5.createPwd(pwd));
        userDao.regUser(user);
    }
}
