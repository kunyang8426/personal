package com.kazma.contorller;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.Operator;
import com.kazma.util.CommonUtil;
import com.kazma.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/common")
public class CommonService {


    @RequestMapping("/uploadImg")
    public @ResponseBody
    String uploadImg(String name,  MultipartFile pic){
        InvokeResult iv = new InvokeResult();
        try {
            String picUrl = CommonUtil.uploadImg(name, pic);
            iv.putValueAndReturn("picUrl" , picUrl);
        } catch (Exception e) {
            iv.constuctResultUseGivenParam(-1, e.getMessage());
        }

        return JsonUtil.toJson(iv);
    }
}
