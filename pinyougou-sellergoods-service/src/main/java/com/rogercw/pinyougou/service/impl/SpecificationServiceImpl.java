package com.rogercw.pinyougou.service.impl;
import java.util.List;

import com.rogercw.pinyougou.custom.SpecificationCustom;
import com.rogercw.pinyougou.mapper.SpecificationOptionMapper;
import com.rogercw.pinyougou.pojo.SpecificationOption;
import com.rogercw.pinyougou.pojo.SpecificationOptionExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rogercw.pinyougou.mapper.SpecificationMapper;
import com.rogercw.pinyougou.pojo.Specification;
import com.rogercw.pinyougou.pojo.SpecificationExample;
import com.rogercw.pinyougou.pojo.SpecificationExample.Criteria;
import com.rogercw.pinyougou.service.SpecificationService;

import com.rogercw.page.PageResult;

/**
 * @Author: rogercw
 * @Version 1.0
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationMapper specificationMapper;
	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Specification> findAll() {
		return specificationMapper.selectByExample(null);
	}


	/**
	 * 增加
	 */
	@Override
	public void add(SpecificationCustom specificationCustom) {
		//1:插入规格数据
		specificationMapper.insert(specificationCustom.getSpecification());
		//获取插入后的id值
		long id=specificationCustom.getSpecification().getId();
		//2:循环插入规格选项
		for (SpecificationOption option:specificationCustom.getSpecificationOptionList()){
			option.setSpecId(id);
			specificationOptionMapper.insert(option);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(SpecificationCustom specificationCustom){
		//1:更新规格信息
		specificationMapper.updateByPrimaryKey(specificationCustom.getSpecification());
		//2:删除原有规格选项信息
		SpecificationOptionExample example=new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria=example.createCriteria();
		criteria.andSpecIdEqualTo(specificationCustom.getSpecification().getId());
		specificationOptionMapper.deleteByExample(example);
		//3:插入修改后的规格选项信息
		for (SpecificationOption option:specificationCustom.getSpecificationOptionList()){
			option.setSpecId(specificationCustom.getSpecification().getId());
			specificationOptionMapper.insert(option);
		}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 *
	 */
	@Override
	public SpecificationCustom findOne(Long id){
		SpecificationCustom specificationCustom=new SpecificationCustom();
		//1:查询规格信息
		specificationCustom.setSpecification(specificationMapper.selectByPrimaryKey(id));
		//2:查询当前规格对应的规格属性信息
		SpecificationOptionExample example=new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria=example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<SpecificationOption> options=specificationOptionMapper.selectByExample(example);
		specificationCustom.setSpecificationOptionList(options);
		return specificationCustom;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			//1:删除规格信息
			specificationMapper.deleteByPrimaryKey(id);
			//2:删除规格选项信息
			SpecificationOptionExample example=new SpecificationOptionExample();
			SpecificationOptionExample.Criteria criteria=example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
		}		
	}
	
	
		@Override
	public PageResult findPage(Specification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SpecificationExample example=new SpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
				if(StringUtils.isNotBlank(specification.getSpecName())){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<Specification> page= (Page<Specification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getResult(),page.getTotal());
	}
	
}
