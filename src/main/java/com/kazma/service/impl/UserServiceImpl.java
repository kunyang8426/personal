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
import sun.nio.cs.ext.ISCII91;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

        String token = redisUtils.setUserSession(user);
        List<Menu> userPermissionTreeForMe = getUserPermissionTreeForMe(token);

        iv.putValue("user", user);
        iv.putValue("token", token);
        iv.putValue("userPermissionTree", userPermissionTreeForMe);

    }

    @Override
    public void fillUser(User user, String token, InvokeResult iv) {
        UserSession userSession =  redisUtils.getUserSession(token);
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
    public void getMenus(Integer type, InvokeResult iv) {
        List<Menu> menuList = userDao.getMenus(type, 1);
        iv.putValue("menuList", menuList);
    }

    @Override
    public void addResource(Resource resource, InvokeResult iv) {
        userDao.addResource(resource);
    }

    @Override
    public void getPermissionTree(String token, InvokeResult iv) {
        UserSession userSession = redisUtils.getUserSession(token);
        int isAdmin = userSession.getIsAdmin();
        iv.putValue("permissionTree", getPermissionTreeForMe(0,isAdmin));
    }

    public List<Menu>  getPermissionTreeForMe(int menuType, int isAdmin){
        List<Menu> menus = userDao.getMenus(menuType, isAdmin);
        List<Resource> resources = userDao.getResources(isAdmin);
        List<Menu> permissionTree =new ArrayList<>();

        for (Menu menu : menus){
            if (menu.getParentId() == 0) {
                permissionTree.add(menu);
            }

            for (Menu childMenu : menus ) {
                if (childMenu.getParentId().equals(menu.getMenuId())) {
                    if (menu.getChildMenus() == null) {
                        menu.setChildMenus(new ArrayList<Menu>());
                    }
                    menu.getChildMenus().add(childMenu);
                    for (Resource resource : resources) {
                        if (resource.getMenuId().equals(childMenu.getMenuId())) {
                            if (childMenu.getResources() == null) {
                                childMenu.setResources(new ArrayList<Resource>());
                            }
                            childMenu.getResources().add(resource);
                        }
                    }
                }
            }
        }

        return permissionTree;
    }

    public List<Menu>  getUserPermissionTreeForMe(String token) {
        UserSession userSession = redisUtils.getUserSession(token);
        Integer isAdmin = userSession.getIsAdmin();
        List<Menu> menus = userDao.getMenus(0, isAdmin);
        List<Resource> resources = userDao.getResources(isAdmin);
        List<Menu> userPermissionTree =new ArrayList<>();
        String menuPermission = userSession.getMenuPermission();
        String resPermission = userSession.getResPermission();
        if (Check.NULL.NuNStr(menuPermission) || Check.NULL.NuNStr(resPermission)) {
            return null;
        }

        List<String> menuIdList = Arrays.asList(menuPermission.split(","));
        List<String> resIdList = Arrays.asList(resPermission.split(","));

        for (Menu menu : menus){
            if (!menuIdList.contains(menu.getMenuId() + "")) {
                continue;
            }

            if (menu.getParentId() == 0 ) {
                userPermissionTree.add(menu);
            }

            for (Menu childMenu : menus ) {
                if (childMenu.getParentId().equals(menu.getMenuId())) {
                    if (menu.getChildMenus() == null) {
                        menu.setChildMenus(new ArrayList<Menu>());
                    }
                    menu.getChildMenus().add(childMenu);
                    for (Resource resource : resources) {
                        if (resIdList.contains(resource.getResourceId() + "")) {
                            if (resource.getMenuId().equals(childMenu.getMenuId())) {
                                if (childMenu.getResources() == null) {
                                    childMenu.setResources(new ArrayList<Resource>());
                                }
                                childMenu.getResources().add(resource);
                            }
                        }
                    }
                }
            }
        }

        return userPermissionTree;
    }

}
