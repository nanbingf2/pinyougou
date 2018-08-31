package com.rogercw.pinyougou.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rogercw.page.PageResult;
import com.rogercw.pinyougou.pojo.Seller;
import com.rogercw.pinyougou.service.SellerService;
import com.rogercw.result.ResponseMsg;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/29 23:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    @RequestMapping("/findAll")
    public List<Seller> findAll(){
        return sellerService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows,@RequestBody Seller seller){
        return sellerService.findPage(seller,page, rows);
    }

    @RequestMapping("/save")
    public ResponseMsg save(@RequestBody Seller seller){
        try {
            sellerService.update(seller);
            return new ResponseMsg(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"保存失败");
        }
    }

    @RequestMapping("/findOne")
    public Seller findOne(){
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        return sellerService.findOne(username);
    }


    @RequestMapping("/register")
    public ResponseMsg register(@RequestBody Seller seller){
        Seller sel=sellerService.findOne(seller.getSellerId());
        if (sel!=null){
            return new ResponseMsg(false,"该账号已被注册,请重新申请");
        }
        //密码进行BCrypt加密
        BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String password=passwordEncoder .encode(seller.getPassword());
        seller.setPassword(password);
        seller.setStatus("0");//设置未审核状态
        seller.setCreateTime(new Date());
        try {
            sellerService.add(seller);
            return new ResponseMsg(true,"注册申请成功,请等待后台审核");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"申请失败,请再次申请");
        }
    }


    @RequestMapping("/updatePassword")
    public ResponseMsg updatePassword(String password,String newPassword){
        Seller seller = this.findOne();
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //将原密码域加密码后的密码进行匹配
        if (!passwordEncoder.matches(password,seller.getPassword())){
            return new ResponseMsg(false,"原密码错误");
        }
        try {
            String pwd=passwordEncoder.encode(newPassword);
            seller.setPassword(pwd);
            sellerService.update(seller);
            return new ResponseMsg(true,"修改密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"修改密码失败");
        }
    }
}