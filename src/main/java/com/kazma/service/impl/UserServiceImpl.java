package com.kazma.service.impl;

import com.kazma.dao.UserDao;
import com.kazma.entity.*;
import com.kazma.service.UserService;
import com.kazma.util.Check;
import com.kazma.util.JsonUtil;
import com.kazma.util.MD5;
import com.kazma.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisUtils redisUtils;


    @Override
    public void regUser(String pwd, String loginName, InvokeResult iv) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(MD5.createPwd(pwd));
        userDao.regUser(user);
    }

    @Override
    public void login(String pwd, String loginName, InvokeResult iv) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(MD5.createPwd(pwd));
        user =  userDao.login(user);

        if (Check.NULL.NuNObj(user)) {
            iv.constuctResultUseGivenParam(-99, "用户名或者密码错误");
            return;
        }

        String token = MD5.createToken(user.getUserId() + "");
        iv.putValue("user", user);
        iv.putValue("token", token);
        UserSession userSession = new UserSession();
        userSession.setMenuPermission(user.getMenuPermission());
        userSession.setResPermission(user.getResPermission());
        userSession.setUserId(user.getUserId());

        redisUtils.setStringWithExpired("TOKEN" + token, JsonUtil.toJson(userSession), 12 * 3600);

    }

    @Override
    public void fillUser(User user, String token, InvokeResult iv) {
        String userSessionStr = redisUtils.getUserSession(token);
        UserSession userSession = JsonUtil.getFromJson(userSessionStr, UserSession.class);
        user.setUserId(userSession.getUserId());
        int sucsess = userDao.fillUser(user);
        if (sucsess != 1) {
            iv.constuctResultUseGivenParam(-99, "更新失败");
            return;
        }

        User userForRetrun = userDao.getUserById(user.getUserId());
        iv.putValue("user", userForRetrun);
    }

    @Override
    public void getDepartments(InvokeResult iv) {
        List<Department> departmentList = userDao.getDepartments();
        iv.putValue("departmentList", departmentList);
    }

    @Override
    public void addMenu(Menu menu, InvokeResult iv) {
        userDao.addMenu(menu);
    }

    @Override
    public void getTopMenus(InvokeResult iv) {
        List<Menu> menuList = userDao.getTopMenus();
        iv.putValue("menuList", menuList);
    }
}
