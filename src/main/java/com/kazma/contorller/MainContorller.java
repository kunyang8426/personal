package com.kazma.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 80002526 on 2018/5/17.
 */
@Controller
@RequestMapping(value = "/main")
public class MainContorller {
    @RequestMapping("/test")
    public @ResponseBody String test(){
        return "ok";
    }
}
