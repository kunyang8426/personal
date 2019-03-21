package com.kazma.contorller;

import com.kazma.entity.DeviceInfo;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.MaterialBase;
import com.kazma.entity.User;
import com.kazma.service.UserService;
import com.kazma.util.Check;
import com.kazma.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserContorller {
    @Autowired
    private UserService userService;

    @RequestMapping("/regUser")
    public @ResponseBody
    String regUser(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Map<String, String> params = JsonUtil.outboxOneLevelMap(paramJson);
        String pwd = params.get("pwd");
        String loginName = params.get("loginName");

        if (Check.NULL.NuNStr(pwd) || Check.NULL.NuNStr(loginName)) {
            iv.constuctResultUseGivenParam(-99, "账号或者密码不能为空");
            return JsonUtil.toJson(iv);
        }
        userService.regUser(pwd ,loginName, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/login")
    public @ResponseBody
    String login(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Map<String, String> params = JsonUtil.outboxOneLevelMap(paramJson);
        String pwd = params.get("pwd");
        String loginName = params.get("loginName");

        if (Check.NULL.NuNStr(pwd) || Check.NULL.NuNStr(loginName)) {
            iv.constuctResultUseGivenParam(-99, "账号或者密码不能为空");
            return JsonUtil.toJson(iv);
        }
        userService.login(pwd ,loginName, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/fillUser")
    public @ResponseBody
    String fillUser(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Map<String, String> params = JsonUtil.outboxOneLevelMap(paramJson);
        DeviceInfo deviceInfo = JsonUtil.getGson().fromJson(deviceJson, DeviceInfo.class);
        User user = JsonUtil.getGson().fromJson(paramJson, User.class);

        String token = deviceInfo.getToken();

        if (Check.NULL.NuNStr(token)) {
            iv.constuctResultUseGivenParam(-99, "请登录");
            return JsonUtil.toJson(iv);
        }
        userService.fillUser(user, token, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/getDepartments")
    public @ResponseBody
    String getDepartments(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        userService.getDepartments(iv);


        return JsonUtil.toJson(iv);
    }
}
