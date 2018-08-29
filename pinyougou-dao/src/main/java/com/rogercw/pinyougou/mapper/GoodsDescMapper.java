package com.rogercw.pinyougou.mapper;

import com.rogercw.pinyougou.pojo.GoodsDesc;
import com.rogercw.pinyougou.pojo.GoodsDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDescMapper {
    long countByExample(GoodsDescExample example);

    int deleteByExample(GoodsDescExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    List<GoodsDesc> selectByExample(GoodsDescExample example);

    GoodsDesc selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") GoodsDesc record, @Param("example") GoodsDescExample example);

    int updateByExample(@Param("record") GoodsDesc record, @Param("example") GoodsDescExample example);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);
}