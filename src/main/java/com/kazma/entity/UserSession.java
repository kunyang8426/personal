package com.kazma.entity;

public class UserSession {
    private Integer userId;
    private String resPermission;
    private String menuPermission;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getResPermission() {
        return resPermission;
    }

    public void setResPermission(String resPermission) {
        this.resPermission = resPermission;
    }

    public String getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission;
    }
}
