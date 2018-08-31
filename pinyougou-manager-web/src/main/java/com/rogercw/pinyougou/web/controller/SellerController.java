package com.rogercw.pinyougou.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rogercw.page.PageResult;
import com.rogercw.pinyougou.pojo.Seller;
import com.rogercw.pinyougou.service.SellerService;
import com.rogercw.result.ResponseMsg;
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

    @RequestMapping("/findOne")
    public Seller findOne(String id){
        return sellerService.findOne(id);
    }

    @RequestMapping("/delete")
    public ResponseMsg delete(String[] ids){
        try {
            sellerService.delete(ids);
            return new ResponseMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"删除失败");
        }
    }


    @RequestMapping("/updateStatus")
    public ResponseMsg updateStatus(String sellerId,String status){
        try {
            sellerService.updateStatus(sellerId,status);
            return new ResponseMsg(true,"更新状态成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"更新状态失败");
        }
    }
}
