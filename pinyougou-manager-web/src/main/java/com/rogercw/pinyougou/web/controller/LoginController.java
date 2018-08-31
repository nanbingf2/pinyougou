package com.rogercw.pinyougou.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: rogercw
 * @Date: 2018/8/31 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/getLoginName")
    public Map<String,String> getLoginName(){
        Map map=new HashMap();
        String loginName=SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("loginName",loginName);
        return map;
    }
}
