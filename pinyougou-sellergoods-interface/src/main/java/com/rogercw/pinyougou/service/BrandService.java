package com.rogercw.pinyougou.service;

import com.rogercw.page.PageResult;
import com.rogercw.pinyougou.pojo.Brand;

import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/29 23:13
 * @Version 1.0
 */
public interface BrandService {

    /**
     * 查询所有品牌信息
     * @return
     */
    List<Brand> findAll();

    /**
     * 分页、过滤查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(int pageNum,int pageSize,Brand brand);

    /**
     * 添加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据id查询单个品牌信息
     * @param id
     * @return
     */
    Brand findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void delete(Long[] ids);
}
