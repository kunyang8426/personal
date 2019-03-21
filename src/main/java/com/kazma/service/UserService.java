package com.kazma.service;

import com.kazma.entity.InvokeResult;

public interface UserService {
    void regUser(String pwd, String loginName, InvokeResult iv);
}
