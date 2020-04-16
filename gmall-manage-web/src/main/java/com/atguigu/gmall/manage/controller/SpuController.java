package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos=   spuService.spuList(catalog3Id);
        System.out.println("1");
        return pmsProductInfos;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public List<PmsProductInfo> saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){


        System.out.println("1");
        return null;
    }


    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){

        //将图片上传到分布式的存储

        //将图片的存储返回给页面

        System.out.println("1");
        return null;
    }






}
