package com.rogercw.pinyougou.mapper;

import com.rogercw.pinyougou.pojo.Template;
import com.rogercw.pinyougou.pojo.TemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TemplateMapper {
    long countByExample(TemplateExample example);

    int deleteByExample(TemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Template record);

    int insertSelective(Template record);

    List<Template> selectByExample(TemplateExample example);

    Template selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateExample example);

    int updateByExample(@Param("record") Template record, @Param("example") TemplateExample example);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);
}