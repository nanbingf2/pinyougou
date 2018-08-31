package com.rogercw.pinyougou.web.controller;
import java.util.List;

import com.rogercw.pinyougou.service.TypeTemplateService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.rogercw.pinyougou.pojo.Template;

import com.rogercw.page.PageResult;
import com.rogercw.result.ResponseMsg;
/**
 * @Author: rogercw
 * @Date: 2018/7/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/findAll")
    public List<Template> findAll(){
        return typeTemplateService.findAll();
    }

    @RequestMapping("/save")
    public ResponseMsg save(@RequestBody Template typeTemplate){
        if (typeTemplate.getId()==null){
            //新增
            try {
                typeTemplateService.add(typeTemplate);
                return new ResponseMsg(true,"保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMsg(false,"保存失败");
            }
        }else{
            //修改
            try {
                typeTemplateService.update(typeTemplate);
                return new ResponseMsg(true,"保存成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseMsg(false,"保存失败");
            }
        }
    }

    @RequestMapping("findOne")
    public Template findOne(Long id){
        return typeTemplateService.findOne(id);
    }

    @RequestMapping("/delete")
    public ResponseMsg delete(Long[] ids){
        try {
            typeTemplateService.delete(ids);
            return new ResponseMsg(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(false,"删除失败");
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody Template typeTemplate,int page,int rows){
        return typeTemplateService.findPage(typeTemplate,page,rows);
    }

}
