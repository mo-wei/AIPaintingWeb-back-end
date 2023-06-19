package com.example.yunpiyuanpan.controller;

import com.example.yunpiyuanpan.service.AIPaitingService;
import com.example.yunpiyuanpan.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.create.table.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/AIPainting")
@Api("绘画接口")
public class AIPaintingController {

    @Autowired
    private AIPaitingService aiPaitingService;


    @GetMapping("/sendImage")
    public void sendImage(String description){
        String str = description.replace(" ", "_");
        System.out.println(str);
        aiPaitingService.AIPaiting(str);
    }

    @GetMapping("/checkFileExists")
    public boolean checkFileExists(@RequestParam(value = "path")String path) {
        File file = new File(path);
        System.out.println(file.exists());
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping("/sendPaitingIndex")
    public String sendPaitingIndex()
    {
        return aiPaitingService.GetIndex() + ".jpg";
    }

}
