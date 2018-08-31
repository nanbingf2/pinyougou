package com.rogercw.pinyougou.service;
import java.util.List;
import java.util.Map;

import com.rogercw.pinyougou.custom.SpecificationCustom;
import com.rogercw.pinyougou.pojo.Specification;

import com.rogercw.page.PageResult;
/**
 * @Author: rogercw
 * @Version 1.0
 */
public interface SpecificationService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Specification> findAll();

	
	/**
	 * 增加
	*/
	public void add(SpecificationCustom specificationCustom);
	
	
	/**
	 * 修改
	 */
	public void update(SpecificationCustom specificationCustom);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public SpecificationCustom findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Specification specification, int pageNum, int pageSize);

	/**
	 * 查询规格列表
	 * @return
	 */
	List<Map> selectOptionList();
	
}
