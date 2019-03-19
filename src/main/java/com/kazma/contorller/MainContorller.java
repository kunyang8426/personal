package com.kazma.contorller;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.Material;
import com.kazma.entity.Operator;
import com.kazma.service.MainService;
import com.kazma.util.JsonUtil;
import com.kazma.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 80002526 on 2018/5/17.
 */
@Controller
@RequestMapping(value = "/main")
public class MainContorller {

    @Autowired
    @Qualifier("mainService")
    private MainService mainService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public @ResponseBody String test(){
        return "ok";
    }

    @RequestMapping("/insertOpt")
    public @ResponseBody String insertOpt(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        Operator operator = JsonUtil.getFromJson(paramJson, Operator.class);
        InvokeResult iv = new InvokeResult();
        mainService.insertOperator(iv, operator);

        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/insertMaterial")
    public @ResponseBody String insertMaterial(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        Material material = JsonUtil.getFromJson(paramJson, Material.class);
        InvokeResult iv = new InvokeResult();
        mainService.insertMaterial(iv, material);

        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/getMaterials")
    public @ResponseBody String getMaterials(@RequestParam(value = "paramJson", required = false) String paramJson, @RequestParam(value = "deviceJson", required = false)  String deviceJson){
        InvokeResult iv = new InvokeResult();
        mainService.getMaterials(iv);

        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/setRedisKey")
    public @ResponseBody String setRedisKey(String key, String value){
        InvokeResult iv = new InvokeResult();
        redisUtils.setString(key, value);

        return JsonUtil.toJson(iv);
    }
}
