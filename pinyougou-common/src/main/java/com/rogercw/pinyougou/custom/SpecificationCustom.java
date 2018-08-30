package com.rogercw.pinyougou.custom;

import com.rogercw.pinyougou.pojo.Specification;
import com.rogercw.pinyougou.pojo.SpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: rogercw
 * @Date: 2018/8/30 17:41
 * @Version 1.0
 */
public class SpecificationCustom implements Serializable {

    private Specification specification;
    private List<SpecificationOption> specificationOptionList;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
