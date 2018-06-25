package com.kazma.entity;

/**
 * Created by 80002526 on 2018/6/25.
 */
public class Operator {
    private Integer operatorId;
    private String operatorName;
    private String loginName;
    private String loginPwd;
    private String jobNum;
    private String telephone;
    private Integer operatorStatus;
    private String email;
    private Integer operatorType;
    private Integer operatorDepartment;
    private String role;
    private String permission;

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getOperatorStatus() {
        return operatorStatus;
    }

    public void setOperatorStatus(Integer operatorStatus) {
        this.operatorStatus = operatorStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public Integer getOperatorDepartment() {
        return operatorDepartment;
    }

    public void setOperatorDepartment(Integer operatorDepartment) {
        this.operatorDepartment = operatorDepartment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
