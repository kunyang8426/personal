package com.kazma.contorller;

import com.kazma.entity.*;
import com.kazma.service.UserService;
import com.kazma.util.Check;
import com.kazma.util.GsonHashMap;
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

    @RequestMapping("/addMenu")
    public @ResponseBody
    String addMenu(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Menu menu = JsonUtil.getFromJson(paramJson, Menu.class);

        userService.addMenu(menu, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/getMenus")
    public @ResponseBody
    String showTopMenu(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        GsonHashMap paramMap = JsonUtil.getFromJson(paramJson, GsonHashMap.class);
        //type 0:全部或者不传 1:父 2:子
        Integer type = paramMap.optInt("type");

        userService.getMenus(type, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/addResource")
    public @ResponseBody
    String addResource(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        Resource resource = JsonUtil.getFromJson(paramJson, Resource.class);

        userService.addResource(resource, iv);


        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/getPermissionTree")
    public @ResponseBody
    String getPermissionTree(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        DeviceInfo deviceInfo = JsonUtil.getFromJson(deviceJson, DeviceInfo.class);
        String token = deviceInfo.getToken();


        userService.getPermissionTree(token, iv);

        return JsonUtil.toJson(iv);
    }


}
