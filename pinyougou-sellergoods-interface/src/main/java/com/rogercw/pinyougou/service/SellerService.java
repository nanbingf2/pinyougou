package com.rogercw.pinyougou.service;
import java.util.List;
import com.rogercw.pinyougou.pojo.Seller;

import com.rogercw.page.PageResult;
/**
 * @Author: rogercw
 * @Version 1.0
 */
public interface SellerService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Seller> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Seller seller);
	
	
	/**
	 * 修改
	 */
	public void update(Seller seller);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Seller findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Seller seller, int pageNum, int pageSize);


	/**
	 * 更新商家状态
	 * @param status
	 */
	void updateStatus(String sellerId,String status);
}
