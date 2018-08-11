package com.fsi.ticket.wechat_pay2.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;



@Controller
public class SampleController extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleController.class);
    }


//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        System.out.println("xxxxxxxxxxxxx");
//        return "Hello 22!";
//    }
//
//
//    //这里指定是条状的jsp界面
//    @RequestMapping(value = "/index")
//    public String index(Model model) {
//        model.addAttribute("appId","12345");
//        model.addAttribute("sb", "this is my fries测试不是好领导了副经理看fjldj 1123123");
//        return "/index";
//    }
//
//
//    @RequestMapping(value = "json")
//    @ResponseBody
//    public Map<String, Object> mytest() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Ryan");
//        map.put("age", "3");
//        map.put("sex", "man");
//        return map;
//    }
}

