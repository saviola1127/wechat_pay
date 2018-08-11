package com.fsi.ticket.wechat_pay2.controller;

import com.fsi.ticket.wechat_pay2.services.SportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sportinfo")
public class SportInfoController {
    @Autowired
    SportInfoService sportInfoService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Object getAllSportInfo(){
        System.out.println("=========================================");
        System.out.println("getAllSportInfo");
        return sportInfoService.getAllSportInfo();
    }

}
