package com.rogercw.pinyougou.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rogercw.page.PageResult;
import com.rogercw.pinyougou.pojo.Brand;
import com.rogercw.pinyougou.service.BrandService;
import com.rogercw.result.ResponseMsg;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/29 23:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int rows,@RequestBody Brand brand){
        return brandService.findPage(page, rows,brand);
    }


    @RequestMapping("/save")
    public ResponseMsg save(@RequestBody Brand brand){
        try {
            if (brand.getId()==null){
                //新增
                brandService.add(brand);
            }else{
                brandService.update(brand);
            }
            return new ResponseMsg(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"保存失败");
        }
    }

    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        return brandService.findOne(id);
    }

    @RequestMapping("/delete")
    public ResponseMsg delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new ResponseMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"删除失败");
        }
    }

}
