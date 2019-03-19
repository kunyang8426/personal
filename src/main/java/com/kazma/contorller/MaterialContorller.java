package com.kazma.contorller;

import com.kazma.entity.InvokeResult;
import com.kazma.entity.MaterialBase;
import com.kazma.service.MaterialService;
import com.kazma.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/material")
public class MaterialContorller {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("/insertMaterialBase")
    public @ResponseBody
    String insertMaterialBase(@RequestParam(value = "paramJson", required = false)  String paramJson){
        MaterialBase materialBase = JsonUtil.getFromJson(paramJson, MaterialBase.class);
        InvokeResult iv = new InvokeResult();
        materialService.insertMaterialBase(iv, materialBase);

        return JsonUtil.toJson(iv);
    }

    @RequestMapping("/selectMaterialBase")
    public @ResponseBody
    String selectMaterialBase(@RequestParam(value = "paramJson", required = false)  String paramJson){
        InvokeResult iv = new InvokeResult();
        materialService.selectMaterialBase(iv);

        return JsonUtil.toJson(iv);
    }
}

