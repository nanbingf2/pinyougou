package com.rogercw.pinyougou.web.controller;
import java.util.List;

import com.rogercw.pinyougou.custom.SpecificationCustom;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.rogercw.pinyougou.pojo.Specification;
import com.rogercw.pinyougou.service.SpecificationService;

import com.rogercw.page.PageResult;
import com.rogercw.result.ResponseMsg;
/**
 * @Author: rogercw
 * @Date: 2018/7/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    @RequestMapping("/findAll")
    public List<Specification> findAll(){
        return specificationService.findAll();
    }

    @RequestMapping("/save")
    public ResponseMsg save(@RequestBody SpecificationCustom specificationCustom){
        if (specificationCustom.getSpecification().getId()==null){
            //新增
            try {
                specificationService.add(specificationCustom);
                return new ResponseMsg(true,"保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMsg(false,"保存失败");
            }
        }else{
            //修改
            try {
                specificationService.update(specificationCustom);
                return new ResponseMsg(true,"保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMsg(false,"保存失败");
            }
        }
    }

    @RequestMapping("findOne")
    public SpecificationCustom findOne(Long id){
        return specificationService.findOne(id);
    }

    @RequestMapping("/delete")
    public ResponseMsg delete(Long[] ids){
        try {
            specificationService.delete(ids);
            return new ResponseMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"删除失败");
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody Specification specification,int page,int rows){
        return specificationService.findPage(specification,page,rows);
    }

}
