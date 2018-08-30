package com.rogercw.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rogercw.page.PageResult;
import com.rogercw.pinyougou.mapper.BrandMapper;
import com.rogercw.pinyougou.pojo.Brand;
import com.rogercw.pinyougou.pojo.BrandExample;
import com.rogercw.pinyougou.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/29 23:13
 * @Version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize,Brand brand) {
        PageHelper.startPage(pageNum,pageSize);
        BrandExample brandExample=new BrandExample();
        BrandExample.Criteria criteria=brandExample.createCriteria();
        //过滤
        if (brand!=null){
            if(StringUtils.isNotBlank(brand.getName())){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (StringUtils.isNotBlank(brand.getFirstChar())){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        Page<Brand> pageList = (Page<Brand>) brandMapper.selectByExample(brandExample);
        PageResult result=new PageResult(pageList.getResult(),pageList.getTotal());
        return result;
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public Brand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }
}
