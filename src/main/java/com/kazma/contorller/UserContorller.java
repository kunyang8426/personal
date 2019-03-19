package com.kazma.contorller;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.MaterialBase;
import com.kazma.service.UserService;
import com.kazma.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

public class UserContorller {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public @ResponseBody
    String insertMaterialBase(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Map<String, String> params = JsonUtil.outboxOneLevelMap(paramJson);
        params.get("");



        return JsonUtil.toJson(iv);
    }

}
