package com.kazma.contorller;

import com.kazma.entity.DeviceInfo;
import com.kazma.entity.InvokeResult;
import com.kazma.entity.Operator;
import com.kazma.sevice.MainService;
import com.kazma.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 80002526 on 2018/5/17.
 */
@Controller
@RequestMapping(value = "/main")
public class MainContorller {

    @Autowired
    @Qualifier("mainService")
    private MainService mainService;

    @RequestMapping("/test")
    public @ResponseBody String test(){
        return "ok";
    }

    @RequestMapping("/insertOpt")
    public @ResponseBody String insertOpt(@RequestParam(value = "paramJson", required = false)  String paramJson){
        Operator operator = JsonUtil.getFromJson(paramJson, Operator.class);
        InvokeResult iv = new InvokeResult();
        mainService.insertOperator(iv, operator);

        return "ok";
    }
}
