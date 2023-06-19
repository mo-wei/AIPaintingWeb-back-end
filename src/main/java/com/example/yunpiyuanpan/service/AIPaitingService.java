package com.example.yunpiyuanpan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AIPaitingService {

    private int fileIndex = 0;


    //调用AI绘画python脚本生成资料摘要
    //AI绘画
    public void AIPaiting(String description){
        try {
            Process process = Runtime.getRuntime()
                    .exec("C:/AIDrawingWeb/Anaconda/envs/draw/python" + " " + "C:/AIDrawingWeb/stable-diffusion-main/demo.py"
                    +" " + "--filename" + " " + fileIndex + " " +
                    "--prompt" + " " + description);
            System.out.println(description);
        } catch (IOException e) {
            System.out.println("调用AI绘画模型并读取时出错" + e.getMessage());
        }
    }

    public int GetIndex(){
        return fileIndex - 1;
    }

}
