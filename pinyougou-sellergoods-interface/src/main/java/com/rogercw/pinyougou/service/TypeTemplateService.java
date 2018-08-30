package com.rogercw.pinyougou.service;
import java.util.List;
import com.rogercw.pinyougou.pojo.Template;

import com.rogercw.page.PageResult;
/**
 * @Author: rogercw
 * @Version 1.0
 */
public interface TypeTemplateService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Template> findAll();

	
	/**
	 * 增加
	*/
	public void add(Template typeTemplate);
	
	
	/**
	 * 修改
	 */
	public void update(Template typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Template findOne(Long id);
	
	
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
	public PageResult findPage(Template typeTemplate, int pageNum, int pageSize);
	
}
